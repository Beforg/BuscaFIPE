package br.com.alura.BuscaFIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAno(String nome, String codigo) {
}
