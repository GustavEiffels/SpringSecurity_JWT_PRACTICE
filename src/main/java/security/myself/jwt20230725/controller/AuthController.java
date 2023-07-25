package security.myself.jwt20230725.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import security.myself.jwt20230725.model.UserAuth;
import security.myself.jwt20230725.repository.UserRepository;
import security.myself.jwt20230725.service.AuthService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController  
{   
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public @ResponseBody String done(UserAuth userAuth)
    {
        try {
            log.info("userAuth : {} ",userAuth);
            authService.authTestMethod(userAuth);
            return "DONE";
        } catch (Exception e) {
            // TODO: handle exception
            return e.getLocalizedMessage();

        }  
    } 

    @PostMapping("/join")
    public String joinMethod(JoinDto joinDto)
    {
        try {
            UserAuth userAuth = new UserAuth();
            userAuth.setLoginId(joinDto.getId());
            userAuth.setLoginPassword(passwordEncoder.encode(joinDto.getPassword()));
            log.info(" getID : {}",joinDto.getId());
            
            userRepository.save(userAuth);

            return "JOIN DONE";
        } catch (Exception e) {
            
            return e.getLocalizedMessage();
        }
    }

    @GetMapping("/fail")
    public @ResponseBody String faile()  { return "fail"; }


    @GetMapping("/success")
    public @ResponseBody String success() { return "success"; }
}

