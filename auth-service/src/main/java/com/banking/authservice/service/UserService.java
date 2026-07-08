package com.banking.authservice.service;

import com.banking.authservice.dto.LoginRequest;
import com.banking.authservice.dto.RegisterRequest;
import com.banking.authservice.dto.UserLoginResponse;
import com.banking.authservice.dto.UserRegisterResponse;
import com.banking.authservice.entity.Roles;
import com.banking.authservice.entity.User;
import com.banking.authservice.repository.RoleRepository;
import com.banking.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    @Transactional
    public UserRegisterResponse register(RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email Already Registered");
        }

        Roles customerRole = roleRepository.findByName("CUSTOMER")
                .orElseThrow(() -> new RuntimeException("Role not found"));


        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
                .fullName(registerRequest.getFullName())
                .phoneNumber(registerRequest.getPhoneNumber())
                .build();


        user.getRoles().add(customerRole);
        userRepository.save(user);

        return UserRegisterResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .roles(
                        user.getRoles()
                                .stream()
                                .map(Roles::getName)
                                .collect(Collectors.toSet())
                )
                .createdAt(user.getCreatedAt())
                .build();
    }

    public UserRegisterResponse getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return UserRegisterResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .roles(
                        user.getRoles()
                                .stream()
                                .map(Roles::getName)
                                .collect(Collectors.toSet())
                )
                .createdAt(user.getCreatedAt())
                .build();
    }

    @Transactional
    private void createRoleIfNotExists(String name, String description) {

        if (roleRepository.findByName(name).isEmpty()) {

            roleRepository.save(
                    Roles.builder()
                            .name(name)
                            .description(description)
                            .build()
            );

        }
    }

    @Transactional
    public void changeRole(UUID id, String roleName) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Roles role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().clear();

        user.getRoles().add(role);

        userRepository.save(user);
    }

    public UserLoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Password Do Not Match");
        }

        String accessToken = jwtService.generateAccessToken(user);

        String refreshToken = jwtService.generateRefreshToken(user);

        return UserLoginResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .roles(
                        user.getRoles()
                                .stream()
                                .map(Roles::getName)
                                .collect(Collectors.toSet())
                )
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .build();
    }
}
