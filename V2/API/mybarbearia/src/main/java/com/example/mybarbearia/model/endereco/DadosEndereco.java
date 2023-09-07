package com.example.mybarbearia.model.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "Logradouro é obrigatório")
        String logradouro,
        @NotBlank(message = "Bairro é obrigatório")
        String bairro,
        @NotBlank(message = "CEP é obrigatório")
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank(message = "Cidade é obrigatório")
        String cidade,
        @NotBlank(message = "Número é obrigatório")
        String numero,
        String complemento,
        @NotBlank(message = "UF é obrigatório")
        @Pattern(regexp = "[A-Z]{2}", message = "A UF deve ser composta por duas letras maiúsculas")
        String uf
) {
}
