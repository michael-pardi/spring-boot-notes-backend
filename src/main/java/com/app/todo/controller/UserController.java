package com.app.todo.controller;

import com.app.todo.model.UserInfo;
import com.app.todo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserInfoService userService;

    @GetMapping("/user")
    public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
        List<UserInfo> userInfos = userService.getAllActiveUserInfo();
        if (userInfos == null || userInfos.isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus. NO_CONTENT);
        }
        return userInfos;
    }

    @PostMapping("/user/create")
    public UserInfo addUser(@Valid @RequestBody UserInfo userRecord) {
        return userService.addUser(userRecord);
    }

    @PutMapping("/user/{id}")
    public UserInfo updateUser(@Valid @RequestBody UserInfo userRecord, @PathVariable Integer id) {
        return userService.updateUser(id, userRecord);
    }

    @PutMapping("/user/changePassword/{id}")
    public UserInfo updateUserPassword(@Valid @RequestBody UserInfo userRecord, @PathVariable Integer id) {
        return userService.updatePassword(id, userRecord);
    }

    @PutMapping("/user/changeRole/{id}")
    public UserInfo updateUserRole(@Valid @RequestBody UserInfo userRecord, @PathVariable Integer id) {
        return userService.updateRole(id, userRecord);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@Valid @PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserInfo> getUserById(@Valid @PathVariable Integer id) {
        UserInfo userInfo = userService.getUserInfoById(id);
        if (userInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }
}