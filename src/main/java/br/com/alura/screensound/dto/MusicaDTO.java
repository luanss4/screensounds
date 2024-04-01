package br.com.alura.screensound.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// representa a classe Musica, para transferência de dados
@Data
@NoArgsConstructor
public class MusicaDTO {
    private Long id;
    private String nome;
    private String artista;
}
