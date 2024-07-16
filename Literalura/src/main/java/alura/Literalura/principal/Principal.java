package alura.Literalura.principal;

import alura.Literalura.model.Autor;
import alura.Literalura.model.BuscaLivro;
import alura.Literalura.model.DadosLivro;
import alura.Literalura.model.Livro;
import alura.Literalura.service.ConsumoApi;
import alura.Literalura.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://gutendex.com/books";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() throws JsonProcessingException {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("|-------------------------------------|");
            System.out.println("|------------LiterAlura---------------|");
            System.out.println("|  Digite o número da opção escolhida |");
            System.out.println("|  1 - Buscar Livro pelo Titulo       |");
            System.out.println("|  2 - Listar Livros Pesquisados      |");
            System.out.println("|  3 - Listar Autores Pesquisados     |");
            System.out.println("|  4 - Listar Autores Vivos no Ano    |");
            System.out.println("|  5 - Listar Livros em Idioma        |");
            System.out.println("|  9 - Sair                           |");
            System.out.println("|_____________________________________|");

            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("|------------Buscar Livro pelo Título------------|");
                    System.out.println("|            Digite o Título do livro            |");
                    var nomeLivro = leitura.nextLine();
                    var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
                    DadosLivro dados = conversor.converterDados(json, DadosLivro.class);
                    BuscaLivro buscaLivro = conversor.converterDados(json, BuscaLivro.class);
                    if (buscaLivro.getCount() != 0) {
                        for (DadosLivro book : buscaLivro.getResults()) {
                            System.out.println("|------------------------------------------------------------------------------------------|");
                            System.out.println("ID: " + book.getId());
                            System.out.println("Título: " + book.getTitulo());
                            System.out.println("Idiomas: " + book.getIdiomas());
                            System.out.println("Número de Downloads: " + book.getNumeroDownloads());
                            System.out.println();
                        }
                        System.out.println("|-----------------------------------------Total de "+ buscaLivro.getCount() +" Livro(s) encontrado(s)-------------------------------------------------|");
                    }else{
                        System.out.println("|--------------Nenhum Livro encontrado!-------------|\n\n\n");
                    }
                    break;
                case 2:
                    System.out.println("Lista de Livros já Registrados");
                    break;
                case 3:
                    System.out.println("Lista de Autores já registrados");
                    break;
                case 4:
                    System.out.println("Lista de autores vivos em determinado ano");
                    break;
                case 5:
                    System.out.println("Lista de Livros em certa linguagem");
                    break;
                case 9:
                    System.out.println("Tchau");
                    break;
                default:
                    System.out.println("Escolha uma das alternativas válidas");
            }
        }
    }

}
