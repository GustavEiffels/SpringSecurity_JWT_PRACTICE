package security.myself.jwt20230725.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import security.myself.jwt20230725.model.UserAuth;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService 
{
    private final AuthenticationManager authenticationManager;
    

    public void authTestMethod(UserAuth userAuth)
    {
        log.info("userAuth : {}", userAuth);
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuth.getLoginId(), userAuth.getPassword()));
        log.info("auth : {}",auth);
    }
}
