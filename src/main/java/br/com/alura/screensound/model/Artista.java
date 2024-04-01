package br.com.alura.screensound.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "artistas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoArtista tipo;
    @ToString.Exclude
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public Artista(String nome, TipoArtista tipoArtista) {
        this.nome = nome;
        this.tipo = tipoArtista;
    }

    public void addMusica(Musica musica) {
        musica.setArtista(this);
        this.musicas.add(musica);
    }
}