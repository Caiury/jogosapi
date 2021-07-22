package br.com.caiury.jogos.jogosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caiury.jogos.jogosapi.entity.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
