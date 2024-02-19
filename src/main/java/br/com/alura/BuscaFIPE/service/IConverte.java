package br.com.alura.BuscaFIPE.service;

import java.util.List;

public interface IConverte {
    <T> T converteDado(String json, Class<T> classe);

    <T> List<T> converteListaDado(String json, Class<T> classe);
}
