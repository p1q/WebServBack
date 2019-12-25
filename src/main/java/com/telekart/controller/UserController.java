package com.telekart.controller;

import exception.UserNotFoundException;
import com.telekart.domain.User;
import com.telekart.json.view.StatusChangeRequest;
import com.telekart.json.view.StatusChangeResponse;
import com.telekart.json.view.UserAdditionRequest;
import com.telekart.json.view.UserAdditionResponse;
import com.telekart.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(name = "id") long id) {
        return userService.getUser(id).orElseThrow(UserNotFoundException::new);
    }

    @PostMapping("/users")
    public UserAdditionResponse addUser(@RequestBody UserAdditionRequest requestedUser) {
        final User user = User.builder()
                .name(requestedUser.getName())
                .email(requestedUser.getEmail())
                .phoneNumber(requestedUser.getPhoneNumber())
                .build();
        return new UserAdditionResponse(userService.addUser(user).getId().orElseThrow(IllegalStateException::new));
    }

    @PutMapping("/users/{id}")
    public StatusChangeResponse updateStatus(@PathVariable(name = "id") long id, @RequestBody StatusChangeRequest body) {
        User user = getUser(id);
        User.Status previousStatus = user.getStatus();
        user.setStatus(body.getStatus());
        user = userService.update(user);
        return new StatusChangeResponse(user.getId().get(), previousStatus, user.getStatus());
    }
}
