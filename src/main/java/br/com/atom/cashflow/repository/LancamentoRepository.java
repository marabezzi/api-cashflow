package br.com.atom.cashflow.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atom.cashflow.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByDataBetween(LocalDate inicio, LocalDate fim);
}