package br.com.alura.tabelaFIPE.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper(); // Criar o ObjectMaper()

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe); // Retornar a conversão do Json para a classe que for determinada

        } catch(JsonProcessingException e) {
            throw new RuntimeException();

        }

    }
}
