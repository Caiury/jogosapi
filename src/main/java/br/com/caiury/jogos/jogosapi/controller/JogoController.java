package br.com.caiury.jogos.jogosapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caiury.jogos.jogosapi.dto.JogoDto;
import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.repository.JogoRepository;
import br.com.caiury.jogos.jogosapi.service.JogoService;

@RestController
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	JogoService jogoService;
	@Autowired
	JogoRepository jogoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<JogoDto> cadastrarJogo(@RequestBody @Valid JogoDto jogoDto, UriComponentsBuilder uriBuilder) {

		Jogo jogo = jogoDto.converter();
		
		jogoRepository.save(jogo);
		
		URI uri = uriBuilder.path("/jogo/{id}").buildAndExpand(jogo.getId()).toUri();
		
	

		return ResponseEntity.created(uri).body(new JogoDto(jogo));
	}

	@GetMapping
	public List<JogoDto> listarTodosJogos() {

		return jogoService.listarTodos();

	}

	@GetMapping("/{id}")
	public JogoDto listaPorId(@PathVariable Long id) {

		return jogoService.listarPorId(id);
	}

	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@RequestBody @Valid JogoDto jogoDto, @PathVariable Long id) {

		jogoService.atualizar(jogoDto, id);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {

		jogoService.deletar(id);
	}

}
