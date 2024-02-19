package br.com.alura.BuscaFIPE.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFinais(@JsonAlias("Valor") String valor,
                          @JsonAlias("Marca") String marca,
                          @JsonAlias("Modelo") String modelo,
                          @JsonAlias("AnoModelo") String anoModelo,
                          @JsonAlias("Combustivel") String combustivel,
                          @JsonAlias("CodigoFipe") String codigoFipe,
                          @JsonAlias("MesReferencia") String mesReferencia,
                          @JsonAlias("TipoVeiculo") String tipoVeiculo,
                          @JsonAlias("SiglaCombustivel") String siglaCombustivel) {
    }

