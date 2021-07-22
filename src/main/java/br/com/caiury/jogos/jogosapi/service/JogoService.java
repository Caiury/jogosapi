package br.com.caiury.jogos.jogosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiury.jogos.jogosapi.dto.JogoDto;
import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.repository.JogoRepository;

@Service
public class JogoService {

	@Autowired
	JogoRepository jogoRepository;

	public void cadastrar(JogoDto jogoDto) {
		Jogo jogo = jogoDto.converter();

		jogoRepository.save(jogo);

	}

	public List<JogoDto> listarTodos() {
		List<Jogo> jogos = jogoRepository.findAll();
		return JogoDto.converterTodos(jogos);
	}

	public JogoDto listarPorId(Long id) {
		Jogo jogo = jogoRepository.getById(id);
		return new JogoDto(jogo);
	}

	public void atualizar(JogoDto jogoDto, Long id) {

		Jogo jogo = jogoRepository.getById(id);

		jogo = jogoDto.atualizar(jogo);
		
		jogoRepository.save(jogo);

	}

}
