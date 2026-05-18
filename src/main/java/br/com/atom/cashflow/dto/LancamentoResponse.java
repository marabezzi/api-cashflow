package br.com.atom.cashflow.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.atom.cashflow.model.Lancamento;
import br.com.atom.cashflow.model.TipoLancamento;
import lombok.Data;


@Data
public class LancamentoResponse {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private LocalDate data;

    public static LancamentoResponse from(Lancamento l) {
        LancamentoResponse r = new LancamentoResponse();
        r.id = l.getId();
        r.descricao = l.getDescricao();
        r.valor = l.getValor();
        r.tipo = l.getTipo();
        r.data = l.getData();
        return r;
    }
}