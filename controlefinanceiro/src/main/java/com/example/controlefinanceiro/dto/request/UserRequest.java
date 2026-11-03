package com.example.controlefinanceiro.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(example = "{\"nome\": \"John Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\"}")
public record UserRequest(
    @NotBlank @Size(max = 100) String name,
    @NotBlank @Size(max = 100) String email,
    @NotBlank @Size(min = 6, max = 100) String password
) {

}
