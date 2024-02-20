package br.com.alura.BuscaFIPE.utils;


import br.com.alura.BuscaFIPE.controller.MainController;
import br.com.alura.BuscaFIPE.model.DadosAno;
import br.com.alura.BuscaFIPE.model.DadosFinais;
import br.com.alura.BuscaFIPE.model.DadosMarca;
import br.com.alura.BuscaFIPE.model.DadosModelo;
import br.com.alura.BuscaFIPE.service.ConsumoApi;
import br.com.alura.BuscaFIPE.service.ConverteDados;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;


public class Listener {
    public void listenerOpcao(ChoiceBox<String> select_opcao,
                                     ChoiceBox<String> select_marca,
                                     ChoiceBox<String> select_modelo,
                                     ChoiceBox<String> select_ano,
                                     ConsumoApi consumoApi,
                                     Busca buscador,
                                     ConverteDados converteDados,
                                     String URL_PRINCIAL) {
        select_opcao.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (!select_marca.getItems().isEmpty()) {
                    select_marca.getItems().clear();
                    select_modelo.getItems().clear();
                    select_ano.getItems().clear();
                    select_modelo.setDisable(true);
                    select_ano.setDisable(true);
                }
                var json =  consumoApi.obertDados(buscador.buscarMarca(select_opcao, URL_PRINCIAL));
                var marcas = converteDados.converteListaDado(json, DadosMarca.class);
                select_marca.getItems().clear();
                select_modelo.getItems().clear();
                select_ano.getItems().clear();
                for (DadosMarca marca: marcas) {
                    String fatoraItem = marca.codigo() + " - " + marca.nome();
                    select_marca.getItems().add(fatoraItem);
                }
                FXCollections.sort(select_marca.getItems());
                listenerMarca(select_marca, select_opcao, select_modelo, select_ano, consumoApi, buscador, converteDados, URL_PRINCIAL);
            }
        });
    }
    public void listenerMarca(ChoiceBox<String> select_marca,
                              ChoiceBox<String> select_opcao,
                              ChoiceBox<String> select_modelo,
                              ChoiceBox<String> select_ano,
                              ConsumoApi consumoApi,
                              Busca buscador,
                              ConverteDados converteDados,
                              String URL_PRINCIAL) {
        select_marca.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                var json = consumoApi.obertDados(buscador.buscarModelo(select_marca, buscador.buscarMarca(select_opcao, URL_PRINCIAL)));
                String teste = buscador.buscarModelo(select_marca, buscador.buscarMarca(select_opcao, URL_PRINCIAL));
                System.out.println(teste);
                select_modelo.getItems().clear();
                select_ano.getItems().clear();
                var modelos = converteDados.converteDado(json, DadosModelo.class);
                select_modelo.getItems().clear();
                modelos.modelos().forEach(modelo -> select_modelo.getItems().add(modelo.codigo() + " - " + modelo.nome()));
                FXCollections.sort(select_modelo.getItems());
            }
            listenerModelo(select_modelo, select_ano, select_marca, select_opcao, consumoApi, buscador, converteDados, URL_PRINCIAL);
        });
    }
    public void listenerModelo(ChoiceBox<String> select_modelo,
                               ChoiceBox<String> select_ano,
                               ChoiceBox<String> select_marca,
                               ChoiceBox<String> select_opcao,
                               ConsumoApi consumoApi,
                               Busca buscador,
                               ConverteDados converteDados,
                               String URL_PRINCIAL ) {
        select_modelo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                var json = consumoApi.obertDados(buscador.buscarAno(select_modelo, buscador.buscarModelo(select_marca, buscador.buscarMarca(select_opcao, URL_PRINCIAL))));
                var ano = converteDados.converteListaDado(json, DadosAno.class);
                select_ano.getItems().clear();
                for (DadosAno anos: ano) {
                    String fatoraItem = anos.codigo() +" - " + anos.nome();
                    select_ano.getItems().add(fatoraItem);
                }
                FXCollections.sort(select_ano.getItems());
                listenerAno(select_ano, select_modelo, select_marca, select_opcao, consumoApi, buscador, converteDados, URL_PRINCIAL);
            }
        });
    }
    public void listenerAno(ChoiceBox<String> select_ano,
                            ChoiceBox<String> select_modelo,
                            ChoiceBox<String> select_marca,
                            ChoiceBox<String> select_opcao,
                            ConsumoApi consumoApi,
                            Busca buscador,
                            ConverteDados converteDados,
                            String URL_PRINCIAL) {
        select_ano.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                var json = consumoApi.obertDados(buscador.resultadoFinal(select_ano, buscador.buscarAno(select_modelo, buscador.buscarModelo(select_marca, buscador.buscarMarca(select_opcao, URL_PRINCIAL)))));
                var resultado = converteDados.converteDado(json, DadosFinais.class);
                MainController.resultado = resultado;

            }
        });
    }
}
