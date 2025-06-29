package com.alertou.sboot_atom_produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDto {
    @NotBlank(message="nome não pode ser nulo.")
    @Size(max = 100,message = "nome não pode ter mais de 100 caracteres")
    private String nome;

    @Size(max = 255,message="descrição não pode ter mais de 255 caracteres")
    private String descricao;

    @NotNull(message="preco não pode ser  nulo ou vazio")
    @PositiveOrZero(message="preco não pode ser negativo")
    private Double preco;
}
