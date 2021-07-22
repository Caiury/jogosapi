package br.com.caiury.jogos.jogosapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiury.jogos.jogosapi.dto.JogoDto;
import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.service.JogoService;

@RestController
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	JogoService jogoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarJogo(@RequestBody JogoDto jogoDto) {
		jogoService.cadastrar(jogoDto);
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
	public void atualizar(@RequestBody JogoDto jogoDto,@PathVariable Long id) {
		
		jogoService.atualizar(jogoDto, id);
	}
}
