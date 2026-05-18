package br.com.atom.cashflow.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.atom.cashflow.dto.LancamentoRequest;
import br.com.atom.cashflow.dto.LancamentoResponse;
import br.com.atom.cashflow.model.Lancamento;
import br.com.atom.cashflow.model.TipoLancamento;
import br.com.atom.cashflow.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class LancamentoService {
    private final LancamentoRepository repository;

    public LancamentoResponse criar(LancamentoRequest request) {
        Lancamento l = new Lancamento();
        l.setDescricao(request.getDescricao());
        l.setValor(request.getValor());
        l.setTipo(request.getTipo());
        l.setData(request.getData());
        return LancamentoResponse.from(repository.save(l));
    }

    public List<LancamentoResponse> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repository.findByDataBetween(inicio, fim)
                .stream().map(LancamentoResponse::from).toList();
    }

    public BigDecimal saldoPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repository.findByDataBetween(inicio, fim)
                .stream()
                .map(l -> l.getTipo() == TipoLancamento.RECEITA 
                        ? l.getValor() : l.getValor().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}