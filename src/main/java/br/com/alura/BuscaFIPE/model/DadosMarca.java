package br.com.alura.BuscaFIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarca(String codigo, String nome) {

}
