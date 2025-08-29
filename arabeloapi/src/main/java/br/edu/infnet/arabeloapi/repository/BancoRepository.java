package br.edu.infnet.arabeloapi.repository;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Integer> {
}
