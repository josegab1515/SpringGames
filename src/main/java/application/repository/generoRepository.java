package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Genero;

public interface generoRepository extends CrudRepository<Genero, Long> {
    public Genero findByNome(String nome);
}
