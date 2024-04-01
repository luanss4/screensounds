package br.com.alura.screensound.controller;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

     private final ArtistaRepository artistaRepository;

    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @GetMapping
     public ResponseEntity<List<Artista>> listar() {
         return ResponseEntity.ok(artistaRepository.findAll());
     }

     @PostMapping
     public void cadastrar(@RequestBody Artista artista) {
         artistaRepository.save(artista);
     }

     @DeleteMapping("/{id}")
     public void deletar(@PathVariable Long id) {
         artistaRepository.deleteById(id);
     }

     @PutMapping("/{id}")
     public void atualizar(@PathVariable Long id, @RequestBody Artista artista) {
         artistaRepository.save(artista);
     }

     @GetMapping("/{id}")
     public Artista buscarPorId(@PathVariable Long id) {
         return artistaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
     }
}
