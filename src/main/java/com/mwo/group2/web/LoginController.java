package com.mwo.group2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
 
    @RequestMapping(value = "/enter")
    public String login() {
        return "login.html";
    }



}
