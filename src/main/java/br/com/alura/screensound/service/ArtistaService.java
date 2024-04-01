package br.com.alura.screensound.service;

import br.com.alura.screensound.dto.ArtistaDTO;
import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.repository.ArtistaRepository;
import br.com.alura.screensound.util.GenericConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;
    GenericConverter converter = new GenericConverter();

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }
//    listar todos os artistas
    public List<ArtistaDTO> listarArtistas() {
        return artistaRepository.findAll().stream().map(artista -> converter.convert(artista, ArtistaDTO.class)).collect(Collectors.toList());
    }
}
