package net.idrok.shopping.controller;

import net.idrok.shopping.security.UserSpecial;
import net.idrok.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AccountController {
    @Autowired
     UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserSpecial userSpecial){

        return "token qaytar";
    }
}
}
