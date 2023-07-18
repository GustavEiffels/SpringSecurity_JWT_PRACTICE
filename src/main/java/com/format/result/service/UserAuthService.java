package com.format.result.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.format.result.model.UserAuth;
import com.format.result.model.dto.Join;
import com.format.result.repository.UserAuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthService 
{
    private final UserAuthRepository userAuthRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    public void createUserAuthObject(Join join)
    {
        UserAuth            userAuth        = new UserAuth();
        userAuth.setUserEmail(join.getEmail());
        userAuth.setUserRole("ROLE_USER");
        userAuth.setUserPassword(passwordEncoder.encode(join.getPassword()));
        userAuthRepository.save(userAuth);
    }
}
