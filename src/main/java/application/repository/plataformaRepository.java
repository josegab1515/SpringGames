package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Plataforma;

public interface plataformaRepository extends CrudRepository<Plataforma, Long>{
    public Plataforma findByNome(String nome);
}
