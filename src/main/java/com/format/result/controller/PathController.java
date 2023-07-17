package com.format.result.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.format.result.model.dto.Join;
import com.format.result.service.UserAuthService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PathController 
{
    private final UserAuthService userAuthService;

    @PostMapping("/join")
    public String joinProc(Join join)
    {

        userAuthService.createUserAuthObject(join);

        return "redirect:/loginPage.html";
    }    

    @GetMapping("/forward/loginPage")
    public String forwardingLoginPage() { return "loginPage.html";}

    
}
