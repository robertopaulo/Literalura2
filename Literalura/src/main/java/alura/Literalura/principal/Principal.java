package alura.Literalura.principal;

import alura.Literalura.model.DadosLivro;
import alura.Literalura.service.ConsumoApi;
import alura.Literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://gutendex.com/books";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
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
                    System.out.println(dados);
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
