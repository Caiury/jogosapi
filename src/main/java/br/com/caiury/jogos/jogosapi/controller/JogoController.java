package br.com.caiury.jogos.jogosapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.service.JogoService;

@RestController
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	JogoService jogoService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarJogo (@RequestBody Jogo jogo) {
		jogoService.cadastrar(jogo);
	}
}
