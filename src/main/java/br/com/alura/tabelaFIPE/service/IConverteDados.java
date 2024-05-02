package br.com.alura.tabelaFIPE.service;

import java.util.List;

public interface IConverteDados {

    // Recebe um objeto veículo
    <T> T obterDados(String json, Class<T> classe);

    // Recebe uma lista de objeto veículo
    <T> List<T> obterLista(String json, Class<T> classe);
}