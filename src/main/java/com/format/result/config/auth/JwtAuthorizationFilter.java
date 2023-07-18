package com.format.result.config.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.format.result.model.UserAuth;
import com.format.result.repository.UserAuthRepository;



public class JwtAuthorizationFilter extends BasicAuthenticationFilter
{

    private UserAuthRepository userAuthRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserAuthRepository userAuthRepository) {
        super(authenticationManager);
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("::: request.getRequestURI() "+request.getRequestURI());

    
        
        String                  tokenContents                   = request.getHeader("Authorization");

        if( tokenContents == null )
        {
            chain.doFilter(request, response);
            return;
        }

        tokenContents = tokenContents.replace("Bearer ", "");

        System.out.println(" TOKEN CONTENTS : "+tokenContents);

        
        UserAuth                userAuth                        = userAuthRepository.findByUserEmail(
                                                                                 JWT.require(
                                                                                    Algorithm.HMAC512("securityTestKey") )
                                                                                    .build()
                                                                                    .verify(tokenContents)
                                                                                    .getClaim("userEmail")
                                                                                    .asString());

        PrincipalDetails        principal                       = new PrincipalDetails(userAuth);
        Authentication          authentication                  = new UsernamePasswordAuthenticationToken(principal, null ,principal.getAuthorities());

        System.out.println(" ::::: USER ROLE "+principal.getAuthorities()+"::::: ");
      
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    
    
    
}
