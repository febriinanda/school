package com.nanda.school.controller;

import com.nanda.school.model.UserRegistrationRequest;
import com.nanda.school.model.WebResponse;
import com.nanda.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> register(@RequestBody UserRegistrationRequest request){
        userService.register(request);
        return WebResponse.<String>builder().data("OK").messages("@"+request.getUsername()+" registration is success").build();
    }
}
