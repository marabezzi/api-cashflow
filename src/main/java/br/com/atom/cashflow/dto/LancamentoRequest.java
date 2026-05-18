package br.com.atom.cashflow.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.atom.cashflow.model.TipoLancamento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LancamentoRequest {
    @NotBlank
    private String descricao;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal valor;

    @NotNull
    private TipoLancamento tipo;

    @NotNull
    private LocalDate data;
}