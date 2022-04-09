package net.idrok.shopping.controller;

import net.idrok.shopping.dto.UserDTO;
import net.idrok.shopping.entity.User;
import net.idrok.shopping.security.JwtUtil;
import net.idrok.shopping.security.Token;
import net.idrok.shopping.security.UserSpecial;
import net.idrok.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {



    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/auth")
    public Token auth(@RequestBody UserSpecial userSpecial){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userSpecial.getUsername(), userSpecial.getPassword()));
        System.out.println();
        User u = userService.getByLogin(userSpecial.getUsername()).get();
        String token = jwtUtil.generateToken(u.getLogin(), u.getRole().toString());
        return new Token(token);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody User user){

      return new UserDTO( userService.create(user));

    }
}

