package com.format.result.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.format.result.model.UserAuth;
import com.format.result.model.dto.Join;
import com.format.result.repository.UserAuthRepository;
import com.format.result.service.UserAuthService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PathController 
{
    private final UserAuthService       userAuthService;
    private final UserAuthRepository    userAuthRepository;

    @PostMapping("/join")
    public String joinProc(Join join)
    {

        userAuthService.createUserAuthObject(join);

        return "redirect:/loginPage.html";
    }    

    @GetMapping("/forward/loginPage")
    public String forwardingLoginPage() { return "loginPage.html";}

    @PostMapping("/findUser")
    public void userAuthRepositoryTest()
    {
        System.out.println("FIND USER TEST");
        try {
            UserAuth user = userAuthRepository.findByUserEmail("user");

            if(user == null )
            {
                System.out.println("user is null");
            }
            else
            {
                System.out.println(user.getUserEmail());
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    } 

    
}
