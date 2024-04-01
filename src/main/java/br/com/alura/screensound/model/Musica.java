package br.com.alura.screensound.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "musicas")
@Data
@NoArgsConstructor
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    private Artista artista;

    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }
}
