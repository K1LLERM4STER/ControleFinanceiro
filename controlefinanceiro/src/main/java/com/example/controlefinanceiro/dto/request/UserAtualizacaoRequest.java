package com.example.controlefinanceiro.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(example = "{\"nome\": \"John Doe\", \"password\": \"password123\"}")
public record UserAtualizacaoRequest(
    @NotBlank @Size(min = 2, max = 100) String name,
    @NotBlank @Size(min = 6, max = 100) String password
) {
}
