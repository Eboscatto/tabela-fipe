package br.com.alura.tabelaFIPE.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}