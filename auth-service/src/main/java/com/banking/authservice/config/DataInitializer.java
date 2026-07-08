package com.banking.authservice.config;

import com.banking.authservice.entity.Roles;
import com.banking.authservice.entity.User;
import com.banking.authservice.repository.RoleRepository;
import com.banking.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private void createRoleIfNotExists(String name, String description) {
        roleRepository.findByName(name)
                .orElseGet(() ->
                        roleRepository.save(
                                Roles.builder()
                                        .name(name)
                                        .description(description)
                                        .build()
                        )
                );
    }



    @Bean
    CommandLineRunner initDatabase() {

        return args -> {

            createRoleIfNotExists("SUPER_ADMIN", "Super Administrator");
            createRoleIfNotExists("ADMIN", "Administrator");
            createRoleIfNotExists("CUSTOMER", "Customer");
            createRoleIfNotExists("AUDITOR", "Auditor");
            createRoleIfNotExists("SUPPORT", "Support");

            if (!userRepository.existsByEmail("superadmin@bank.com")) {

                Roles superAdminRole = roleRepository.findByName("SUPER_ADMIN")
                        .orElseThrow(() ->
                                new RuntimeException("Role SUPER_ADMIN tidak ditemukan"));

                User superAdmin = User.builder()
                        .email("superadmin@bank.com")
                        .password(passwordEncoder.encode("Admin123!"))
                        .fullName("Super Admin")
                        .active(true)
                        .build();

                superAdmin.getRoles().add(superAdminRole);

                userRepository.save(superAdmin);

                System.out.println("===== SUPER ADMIN CREATED =====");

            } else {

                System.out.println("===== SUPER ADMIN ALREADY EXISTS =====");

            }

        };
    }
}