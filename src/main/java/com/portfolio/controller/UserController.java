package com.portfolio.controller;

import com.portfolio.dto.RegisterRequest;
import com.portfolio.dto.UserDto;
import com.portfolio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserDto> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDto register(@RequestBody RegisterRequest request) {
        return userService.register(request.getUsername(), request.getPassword());
    }
}