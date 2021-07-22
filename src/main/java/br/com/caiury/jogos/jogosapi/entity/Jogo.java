package br.com.caiury.jogos.jogosapi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caiury.jogos.jogosapi.enums.Plataforma;

public class Jogo {

	private Long id;
	private String titulo;
	private String estudio;
	private Plataforma plataforma;
	private BigDecimal preco;
	private LocalDate horaCriacao = LocalDate.now();
}
