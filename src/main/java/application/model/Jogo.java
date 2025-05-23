package application.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jogos")
@Getter
@Setter
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titulo;

    
    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_generos",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private Set<Genero> generos = new HashSet<Genero>();

    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_plataformas",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_plataforma")
    )
    private Set<Plataforma> plataformas = new HashSet<Plataforma>();

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModoJogo> modos = new ArrayList<>();

    
}
