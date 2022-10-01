package br.edu.ifms.lojapets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.lojapets.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
