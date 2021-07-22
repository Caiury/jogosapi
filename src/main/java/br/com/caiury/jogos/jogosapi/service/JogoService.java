package br.com.caiury.jogos.jogosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.repository.JogoRepository;

@Service
public class JogoService {

	
	@Autowired
	JogoRepository jogoRepository;
	
	
	
	public void cadastrar(Jogo jogo) {
		jogoRepository.save(jogo);
	}
	
	
}
