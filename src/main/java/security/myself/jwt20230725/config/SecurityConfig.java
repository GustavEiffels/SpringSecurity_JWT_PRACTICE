package security.myself.jwt20230725.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import security.myself.jwt20230725.security.CustomLoginFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig 
{
    private final AuthenticationProvider authenticationProvider;
    private final CustomLoginFilter      loginFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                    .csrf().disable()
                    .formLogin().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                        .antMatchers("/admin/**").authenticated()
                        .anyRequest().permitAll()
                .and()
                    .authenticationProvider(authenticationProvider)
                    // .addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)
        
        .build();
    }
}
