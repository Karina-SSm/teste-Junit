package org.generation.teste.contato;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.generation.teste.model.ContatoModel;
import org.generation.teste.repository.ContatoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContatosRepositoryIntegrationTest {
	@Autowired
	private ContatoRepository contatoRepository;

	@Before(value = "")
	public void start() {
		ContatoModel contato = new ContatoModel("Chefe", "0y", "9xxxxxxx9");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);

		contato = new ContatoModel("Novo Chefe", "0y", "8xxxxxxx8");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);

		contato = new ContatoModel("chefe Mais Antigo", "0y", "7xxxxxxx7");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);

		contato = new ContatoModel("Amigo", "0z", "5xxxxxxx5");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
	}

	@Test
	public void findByNomeRetornaContato() throws Exception {

		ContatoModel contato = contatoRepository.findFirstByNome("Chefe");

		Assert.assertTrue(contato.getNome().equals("Chefe"));
	}

	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContato() {

		List<ContatoModel> contatos = contatoRepository.findAllByNomeIgnoreCaseContaining("chefe");

		Assert.assertEquals(3, contatos.size());
	}

	@After(value = "")
	public void end() {
		contatoRepository.deleteAll();
	}


}
