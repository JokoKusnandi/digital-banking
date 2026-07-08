package com.banking.authservice.controller;

import com.banking.authservice.dto.LoginRequest;
import com.banking.authservice.dto.RegisterRequest;
import com.banking.authservice.dto.UserLoginResponse;
import com.banking.authservice.dto.UserRegisterResponse;
import com.banking.authservice.dto.ChangeRoleRequest;
import com.banking.authservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisterResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return userService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserLoginResponse login(
            @Valid @RequestBody LoginRequest request
    ){
        return userService.login(request);
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PutMapping("/{id}/role")
    public ResponseEntity<Void> changeRole(
            @PathVariable UUID id,
            @RequestBody ChangeRoleRequest request){

        userService.changeRole(id, request.getRole());

        return ResponseEntity.ok().build();
    }


}
