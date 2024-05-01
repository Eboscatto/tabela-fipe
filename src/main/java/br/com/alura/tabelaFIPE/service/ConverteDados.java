package br.com.alura.tabelaFIPE.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.List;

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

    // Obter uma lista genérica de dados usando o genericType,
    // seja veiculos, motos ou caminhão.
    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        try {
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
