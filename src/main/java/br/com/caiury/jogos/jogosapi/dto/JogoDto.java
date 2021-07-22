package br.com.caiury.jogos.jogosapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.enums.Plataforma;

public class JogoDto {

	private Long id;

	private String titulo;

	private String estudio;

	private Plataforma plataforma;

	private BigDecimal preco;

	private LocalDate horaCriacao;
	
	public JogoDto() {
		
	}
	
	public JogoDto(Jogo jogo) {
		this.id= jogo.getId();
		this.titulo= jogo.getTitulo();
		this.estudio= jogo.getEstudio();
		this.plataforma = jogo.getPlataforma();
		this.preco= jogo.getPreco();
		this.horaCriacao = jogo.getHoraCriacao();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getEstudio() {
		return estudio;
	}


	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}


	public Plataforma getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public LocalDate getHoraCriacao() {
		return horaCriacao;
	}


	public void setHoraCriacao(LocalDate horaCriacao) {
		this.horaCriacao = horaCriacao;
	}


	public Jogo converter() {
		
		return new Jogo(id, titulo, estudio, plataforma, preco, horaCriacao);
	}

	public static List<JogoDto> converterTodos(List<Jogo> jogos) {
		
		return jogos.stream().map(JogoDto::new).collect(Collectors.toList());
	}


	
	

}
