package br.com.caiury.jogos.jogosapi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.caiury.jogos.jogosapi.enums.Plataforma;

@Entity
public class Jogo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String estudio;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Plataforma plataforma;
	
	@Column(nullable = false)
	private BigDecimal preco;
	
	private LocalDate horaCriacao = LocalDate.now();

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

}
