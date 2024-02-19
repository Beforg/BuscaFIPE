package br.com.alura.BuscaFIPE.controller;


import br.com.alura.BuscaFIPE.model.DadosFinais;
import br.com.alura.BuscaFIPE.service.ConsumoApi;
import br.com.alura.BuscaFIPE.service.ConverteDados;
import br.com.alura.BuscaFIPE.utils.Busca;
import br.com.alura.BuscaFIPE.utils.Listener;
import br.com.alura.BuscaFIPE.utils.SetBox;
import br.com.alura.BuscaFIPE.utils.VerificaBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ChoiceBox<String> select_marca;
    @FXML
    private ChoiceBox<String> select_modelo;
    @FXML
    private ChoiceBox<String> select_opcao;
    @FXML
    private ChoiceBox<String> select_ano;
    @FXML
    public Label label_refVeiculo;
    @FXML
    public Label label_valor;
    @FXML
    public Label label_codigo;
    @FXML
    public Label label_ano;
    @FXML
    public Label label_mes;
    @FXML
    public Label label_combustivel;;
    @FXML
    public Label label_marca;
    @FXML
    public Label label_sigla;
    @FXML
    public Label label_modelo;

    ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados converteDados = new ConverteDados();
    Busca buscador = new Busca();
    Listener listener = new Listener();
    public static DadosFinais resultado;
    private final String URL_PRINCIAL = "https://parallelum.com.br/fipe/api/v1/";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VerificaBox.verificaBox(select_opcao, select_marca, select_modelo, select_ano);
        SetBox.setOpcaoBox(select_opcao);
        buscador.selectModelo(select_modelo, select_ano);
        buscador.selectOpcao(select_opcao, select_marca);
        buscador.selectMarca(select_marca, select_modelo);
        listener.listenerOpcao(select_opcao, select_marca, select_modelo, select_ano, consumoApi, buscador, converteDados, URL_PRINCIAL);

    }
    public void busca() {
    Busca.setBusca(
            label_refVeiculo,
            label_valor,
            label_codigo,
            label_ano,
            label_mes,
            label_combustivel,
            label_marca,
            label_sigla,
            label_modelo,
            resultado);
    }
    public void limpa(){
        SetBox.clearResult(
                select_marca,
                select_modelo,
                select_ano,
                select_opcao,
                label_refVeiculo,
                label_valor,
                label_codigo,
                label_ano,
                label_mes,
                label_combustivel,
                label_marca,
                label_sigla,
                label_modelo
        );
    }
}
