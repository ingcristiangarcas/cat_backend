package com.proof.cat.infraestructure.controller;

import com.proof.cat.aplication.service.UserService;
import com.proof.cat.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 👈 agrega esto si necesitas aceptar peticiones desde Angular
public class UserController {

    private final UserService userService;

    // ✅ LOGIN por POST con body JSON
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        // user.getUsername() y user.getPassword() vienen del JSON
        return userService.login(user.getUsername(), user.getPassword());
    }

    // ✅ REGISTER por POST con body JSON
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // el JSON debe contener { "username": "...", "password": "...", "email": "..." }
        return userService.register(user);
    }
}
