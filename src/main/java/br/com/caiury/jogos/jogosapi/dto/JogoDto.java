package br.com.caiury.jogos.jogosapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.caiury.jogos.jogosapi.entity.Jogo;
import br.com.caiury.jogos.jogosapi.enums.Plataforma;

public class JogoDto {

	private Long id;

	@NotNull @NotEmpty @Length(max = 22)
	private String titulo;

	@NotNull @NotEmpty
	private String estudio;

    @NotNull
	private Plataforma plataforma;

	@NotNull
	private BigDecimal preco;

	private LocalDateTime horaCriacao;
	
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


	public LocalDateTime getHoraCriacao() {
		return horaCriacao;
	}


	public void setHoraCriacao(LocalDateTime horaCriacao) {
		this.horaCriacao = horaCriacao;
	}


	public Jogo converter() {
		
		return new Jogo(id, titulo, estudio, plataforma, preco);
	}

	public static List<JogoDto> converterTodos(List<Jogo> jogos) {
		
		return jogos.stream().map(JogoDto::new).collect(Collectors.toList());
	}

	public Jogo atualizar(Jogo jogo) {
		jogo.setTitulo(titulo);
		jogo.setEstudio(estudio);
		jogo.setPlataforma(plataforma);
		jogo.setPreco(preco);
		return jogo;
	}


	
	

}
