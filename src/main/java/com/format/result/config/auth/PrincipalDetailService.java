package com.format.result.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.format.result.model.UserAuth;
import com.format.result.repository.UserAuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService
{
    private final UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException 
    {
        System.out.println(" ::: loadUserByUsername ::: ");
        UserAuth                    userAuth                    = userAuthRepository.findByUserEmail(userEmail);
        return new PrincipalDetails(userAuth);
    }

    
}
