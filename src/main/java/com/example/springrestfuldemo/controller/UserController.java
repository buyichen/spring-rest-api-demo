package com.example.springrestfuldemo.controller;

import com.example.springrestfuldemo.entities.User;
import com.example.springrestfuldemo.service.UserService;
import org.apache.el.util.ReflectionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("usersystem")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(
                (List<User>) userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if(userService.getUserById(user.getUser_id()) != null){
            System.out.println("The user have already existed");
            return null;
        }
        User saveUser = userService.addUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long id, @RequestBody User updateData){
        User updatedUser = userService.updateUserById(id, updateData);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("user/{id}")
    public ResponseEntity<User> patchUpdatedById(@PathVariable("id") Long id, @RequestBody Map<String, Object> updateData){
        User user = userService.getUserById(id);

        updateData.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, v);
        });
        User updatedUser = userService.addUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        ResponseEntity responseEntity;
        User deleteUser = userService.deleteUserById(id);
        responseEntity = new ResponseEntity<User>(deleteUser, HttpStatus.OK);
        return responseEntity;
    }








}
