package com.example.controlefinanceiro.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(example = "{\"nome\": \"John Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\"}")
public record UserRequest(
    @NotBlank(message = "Name is required") @Size(max = 100, message = "Name must not exceed 100 characters long") String name,
    @NotBlank(message = "Email is required") @Size(max = 100, message = "Email must not exceed 100 characters long") @Email(message = "Email must be a valid email address") String email,
    @NotBlank(message = "Password is required") @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters long") String password
) {

}
