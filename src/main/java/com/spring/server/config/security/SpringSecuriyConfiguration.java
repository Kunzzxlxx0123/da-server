package com.spring.server.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.server.config.security.oauth2.CustomOAuth2UserService;
import com.spring.server.config.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.spring.server.config.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.spring.server.config.security.oauth2.OAuth2AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SpringSecuriyConfiguration extends WebSecurityConfigurerAdapter{

	
	@Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    
    @Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
	
    
    @Bean
    TokenAuthenticationFilter tokenAuthenticationFilter() {
    	return new TokenAuthenticationFilter();
    }
    
    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(customUserDetailsService)
    		.passwordEncoder(passwordEncoder());
    }
    
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	// TODO Auto-generated method stub
    	return super.authenticationManagerBean();
    }
    
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.cors().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.csrf().disable()
			.formLogin().disable()
			.httpBasic().disable()
			.exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint()).and()
			.authorizeRequests()
				.antMatchers(
						"/auth/**",
						"/oauth2/**",
						"/api/**")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.oauth2Login()
			.authorizationEndpoint()
			.baseUri("/oauth2/authorize")
			.authorizationRequestRepository(cookieAuthorizationRequestRepository())
			.and()
			.redirectionEndpoint()
			.baseUri("/oauth2/callback/**")
			.and()
			.userInfoEndpoint()
			.userService(customOAuth2UserService)
			.and()
			.successHandler(oAuth2AuthenticationSuccessHandler)
			.failureHandler(oAuth2AuthenticationFailureHandler);
		
		
		http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
			
	}
	
}
