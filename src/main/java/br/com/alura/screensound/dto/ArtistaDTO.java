package br.com.alura.screensound.dto;
// classe que representa a entidade Artista, para transferência de dados

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class ArtistaDTO {
    private Long id;
    private String nome;
    private String tipo;
    private List<MusicaDTO> musicas;
}
