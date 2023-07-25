package jwt.security.othersversion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jwt.security.othersversion.security.filter.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig 
{
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AuthenticationFailureHandler authenticationFailureHandler;



    final String[] GET_WHITELIST = new String[]{
        "/",
        "/login",
        "/user/login-id/**",
        "/user/email/**",
        "/test"
    };

    final String[] POST_WHITELIST = new String[]{
            "/client-user"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return 
        
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .exceptionHandling()
                .authenticationEntryPoint(null)
                .accessDeniedHandler(null)
        .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, GET_WHITELIST).permitAll()
                .antMatchers(HttpMethod.POST, POST_WHITELIST).permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        .and()
            .formLogin().disable()
                .addFilterBefore(authenticationFilter(http), UsernamePasswordAuthenticationFilter.class)
                // .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        .build();
    } 
    

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public CustomAuthenticationFilter authenticationFilter(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(null));
        // 필터 URL 설정
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        // 인증 성공 핸들러
        customAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        // 인증 실패 핸들러
        // BeanFactory에 의해 모든 property가 설정되고 난 뒤 실행
        customAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        customAuthenticationFilter.afterPropertiesSet();
        return customAuthenticationFilter;
    }
    
}
