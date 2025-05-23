package application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import application.model.Jogo;

public interface jogoRepository extends CrudRepository<Jogo, Long>{
    public List<Jogo> findByTitulo(String titulo);
    
}