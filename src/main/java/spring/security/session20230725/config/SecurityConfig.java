package spring.security.session20230725.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        return 
        
            http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests(
                    (auth)->{
                                auth.antMatchers("/admin/**").authenticated()
                                    .anyRequest().permitAll();
                })
                .formLogin().successForwardUrl("/success")
            .and()
        .build();
    }
}
