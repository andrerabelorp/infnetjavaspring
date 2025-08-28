package br.edu.infnet.arabeloapi.repository;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
