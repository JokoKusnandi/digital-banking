package com.banking.authservice.dto;

import com.banking.authservice.entity.OtpPurpose;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResendOtpRequest {

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Purpose is required")
    private OtpPurpose purpose;

}
