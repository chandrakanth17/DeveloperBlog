package com.appsdeveloperblog.app.ws.controller;

import com.appsdeveloperblog.app.ws.models.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.models.response.UserRest;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "Get User";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto cratedUser = userService.createUser(userDto);
        BeanUtils.copyProperties(cratedUser, returnValue);
        return returnValue;
    }

    @PutMapping
    public String updatedUser(){
        return "Update user";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete";
    }
}
