package com.format.result.config.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.format.result.model.UserAuth;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    private final AuthenticationManager manager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        
            System.out.println(" :::: attemptAuthentication :::: ");

            
            try 
            {
                ObjectMapper                                mapper                      = new ObjectMapper();
                UserAuth                                    userAuth                    = mapper.readValue(request.getInputStream(), UserAuth.class);
                UsernamePasswordAuthenticationToken         authToken                   = new UsernamePasswordAuthenticationToken(userAuth.getUserEmail(), userAuth.getUserPassword());
                
                System.out.println(" :::: UsernamePasswordAuthenticationToken :::: "+authToken);

                

                return manager.authenticate(authToken);


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
            

            try 
            {
                PrincipalDetails                    principalDetails    = (PrincipalDetails) authResult.getPrincipal();
                String                              jwtTokeString                       = JWT.create()
                                                                                                    .withSubject("securityTestKey")
                                                                                                    .withExpiresAt(new Date(System.currentTimeMillis()+60000*10))
                                                                                                    .withClaim("userEmail", principalDetails.getUsername())
                                                                                                    .withClaim("pid", String.valueOf(principalDetails.getUserAuth().getPid()))
                                                                                                    .sign(Algorithm.HMAC512("securityTestKey"));        
                System.out.println("JWTTOKEN  : " + jwtTokeString);
                response.addHeader("Authorization", "Bearer "+jwtTokeString);                
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }

    }

    

    
}
