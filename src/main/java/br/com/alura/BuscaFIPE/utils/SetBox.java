package br.com.alura.BuscaFIPE.utils;

import br.com.alura.BuscaFIPE.controller.MainController;
import br.com.alura.BuscaFIPE.model.Opcao;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class SetBox {
    public static void setOpcaoBox(ChoiceBox<String> choiceBox) {
        for (Opcao opcao: Opcao.values()) {
            choiceBox.getItems().add(opcao.toString());
        }
    }
    public static void clearResult(ChoiceBox<String> select_marca,
                                   ChoiceBox<String> select_modelo,
                                   ChoiceBox<String> select_ano,
                                   ChoiceBox<String> select_opcao,
                                   Label label_refVeiculo,
                                   Label label_valor,
                                   Label label_codigo,
                                   Label label_ano,
                                   Label label_mes,
                                   Label label_combustivel,
                                   Label label_marca,
                                   Label label_sigla,
                                   Label label_modelo) {
        select_marca.getItems().clear();
        select_modelo.getItems().clear();
        select_ano.getItems().clear();
        select_opcao.getSelectionModel().clearSelection();
        select_modelo.setDisable(true);
        select_ano.setDisable(true);
        label_ano.setText("");
        label_combustivel.setText("");
        label_codigo.setText("");
        label_marca.setText("");
        label_mes.setText("");
        label_modelo.setText("");
        label_refVeiculo.setText("");
        label_sigla.setText("");
        label_valor.setText("");
        MainController.resultado = null;
    }
}
