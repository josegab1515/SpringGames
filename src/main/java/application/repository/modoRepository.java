package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.ModoJogo;

public interface modoRepository extends CrudRepository<ModoJogo, Long> {
    public ModoJogo findByNome(String nome);
}
