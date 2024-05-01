package br.com.alura.tabelaFIPE.principal;

import br.com.alura.tabelaFIPE.model.Dados;
import br.com.alura.tabelaFIPE.model.Modelos;
import br.com.alura.tabelaFIPE.service.ConsumoApi;
import br.com.alura.tabelaFIPE.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        int opcao = 0;

        while (opcao != 4) {
            System.out.println();
        var menu = """
                ***** Opções ****
                1 - Carro
                2 - Moto
                3 - Caminhão
                4 - Sair
                                
                Digite uma das opções para consultar:                               
                """;

        // Selecionar veículo
        System.out.print(menu);
        // var opcao = leitura.nextLine(); // Utilizar na opcao com if()

        // Buscar veículo selecionado usando o switch()
        String endereco = "";

            System.out.print("Opção: ");
            opcao = leitura.nextInt();
            leitura.nextLine();

            // Validar opção de saída
            if(opcao == 4) {
                System.out.print("""
                        Espero ter atendido todos os requisitos.
                        Sistema finalizado!""");
                break;
            }

            // Validar intervalo de opçoes
            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida, deve digitar uma opção válida.");
            }

            switch (opcao) {
                case 1:
                    endereco = URL_BASE + "carros/marcas";
                    System.out.println("Exbindo a consulta das marcas de carros:");
                    break;
                case 2:
                    endereco = URL_BASE + "motos/marcas";
                    System.out.println("Exibindo a consulta das marcas de motos:");
                    break;
                case 3:
                    endereco = URL_BASE + "caminhoes/marcas";
                    System.out.println("Exibindo a consulta das marcas de caminhões:");
                    break;
                default:
                    continue;
            }
            // Armazenar dados no formato json
            var json = consumo.obterDados(endereco);
            System.out.println(json);

            // Obter lista de marcas
            var marcas = conversor.obterLista(json, Dados.class);
            marcas.stream()
                    // Ordenar por ordem de código
                    .sorted(Comparator.comparing(Dados::codigo))
                    .forEach(System.out::println);

            // Fazer a escolha da marca
            System.out.println("Informe o código da marca para consulta:");
            var codigoMarca = leitura.nextLine().toLowerCase();

            // Alterar o enderço de busca para buscar pela marca e modelo
            endereco = endereco + "/" + codigoMarca + "/modelos";

            // Armazenar no json os dados recebidos
            json = consumo.obterDados(endereco);

            // Converter dados Json em classe
            var modeloLista = conversor.obterDados(json, Modelos.class);

            // Ordenar a lista por código e imprimir
            System.out.println("\nModelos dessa marca:");
            modeloLista.modelos().stream()
                    .sorted(Comparator.comparing(Dados::nome))
                    .forEach(System.out::println);
        }

        // Segunda opção é utilizar o if()

        /*
         String endereco;

        if (opcao.toLowerCase().contains("car")){
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        // Armazenar dados no formato json
        var json = consumo.obterDados(endereco);

        */

    }
}

