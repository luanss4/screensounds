package br.com.alura.screensound.principal;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private ArtistaRepository artistaRepository;

    @Autowired
    public Principal(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }


    public void exibeMenu() {
        var opcao = -1;

        while (opcao!= 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarArtistas() {
        System.out.println("Informe o nome do artista: ");
        var nome = leitura.nextLine();
        System.out.println("Informe o tipo do artista (SOLO, DUPLA, BANDA): ");
        var tipo = leitura.nextLine();
        var artista = new Artista(nome, TipoArtista.valueOf(tipo.toUpperCase()));
        artistaRepository.save(artista);
    }

    private void cadastrarMusicas() {
//        busca artista por nome
        System.out.println("Informe o nome do artista: ");
        var nomeArtista = leitura.nextLine();
        var artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
        if(artista.isPresent()){
            var artistaEncontrado = artista.get();
            System.out.println("Artista encontrado: " + artistaEncontrado.getNome());
            System.out.println("Informe o nome da música: ");
            var nome = leitura.nextLine();
            var musica = new Musica(nome, artistaEncontrado);
            artistaEncontrado.addMusica(musica);
            artistaRepository.save(artistaEncontrado);
        }
    }

    private void listarMusicas() {
        System.out.println("Informe o nome do artista: ");
        var nomeArtista = leitura.nextLine();
        var artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
        if(artista.isPresent()){
            var artistaEncontrado = artista.get();
            System.out.println("Músicas do artista: " + artistaEncontrado.getNome());
            artistaEncontrado.getMusicas().forEach(musica -> System.out.println(musica.getNome()));
        }
    }

    private void buscarMusicasPorArtista() {
    }

    private void pesquisarDadosDoArtista() {
    }
}

