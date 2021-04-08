package org.generation.teste.repository;

import java.util.List;

import org.generation.teste.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long>{
	
	public ContatoModel findFirstByNome(String nome);
	public List<ContatoModel> findAllByNomeIgnoreCaseContaining(String nome);

}
