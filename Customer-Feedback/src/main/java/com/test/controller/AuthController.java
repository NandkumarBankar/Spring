package com.test.controller;

import com.test.domain.request.AuthRequest;
import com.test.domain.request.UserRequest;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.test.constants.UAMConstants.AUTHENTICATION_API;
import static com.test.constants.UAMConstants.UAM_API;


@RestController
@RequestMapping(UAM_API + AUTHENTICATION_API)
public class AuthController {


    @Autowired
    UserService userService;

    @PostMapping("/login")
    ResponseEntity<String> authentication(@RequestBody AuthRequest authRequest) {
        return new ResponseEntity<>(userService.userLogin(authRequest), HttpStatus.OK);
    }
}
