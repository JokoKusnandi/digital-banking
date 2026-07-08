package com.banking.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterRequest {
   @NotBlank
   @Email
   private String email;

   @NotBlank
   private String password;

   @NotBlank
   private String fullName;

   private String phoneNumber;
}
