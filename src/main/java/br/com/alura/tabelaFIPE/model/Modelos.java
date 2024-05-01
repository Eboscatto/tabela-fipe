package br.com.alura.tabelaFIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// Armazenar uma lista genérica de modelos de carros, motos ou caminhão
@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<Dados> modelos) {
}
