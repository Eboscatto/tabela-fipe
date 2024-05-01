package br.com.alura.tabelaFIPE.principal;

import br.com.alura.tabelaFIPE.service.ConsumoApi;

import java.util.Scanner;

public class SegunaOpcaoDeMenu {
    private Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();

    public void exibeSegundoMenu() {

        var menu = """
                ***** Opções ****
                Carro
                Moto
                Caminhão  
                                
                Digite uma das opções para consultar:                               
                """;

        // Selecionar veículo
        System.out.print(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("car")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }
        // Armazenar dados no formato json
        var json = consumo.obterDados(endereco);
        System.out.println(json);
    }
}

