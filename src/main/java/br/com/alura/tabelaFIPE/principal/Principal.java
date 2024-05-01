package br.com.alura.tabelaFIPE.principal;

import br.com.alura.tabelaFIPE.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    private ConsumoApi consumo = new ConsumoApi();

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
                    System.out.println("Exbindo a consulta de carros:");
                    break;
                case 2:
                    endereco = URL_BASE + "motos/marcas";
                    System.out.println("Exibindo a consulta de motos:");
                    break;
                case 3:
                    endereco = URL_BASE + "caminhoes/marcas";
                    System.out.println("Exibindo a consulta de caminhões:");
                    break;
                default:
                    continue;
            }
            // Armazenar dados no formato json
            var json = consumo.obterDados(endereco);
            System.out.println(json);
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

