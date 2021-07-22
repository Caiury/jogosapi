package br.com.caiury.jogos.jogosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caiury.jogos.jogosapi.entity.Jogo;
@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
