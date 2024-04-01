package br.com.alura.screensound.controller;

import br.com.alura.screensound.dto.ArtistaDTO;
import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.repository.ArtistaRepository;
import br.com.alura.screensound.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }
    @GetMapping
    public ResponseEntity<List<ArtistaDTO>> listarArtistas() {
        List<ArtistaDTO> artistas = artistaService.listarArtistas();
        return ResponseEntity.ok(artistas);
    }
}
