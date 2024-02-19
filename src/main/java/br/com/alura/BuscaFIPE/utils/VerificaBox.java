package br.com.alura.BuscaFIPE.utils;

import javafx.scene.control.ChoiceBox;

public class VerificaBox {
    public static void verificaBox(ChoiceBox<String> choiceBox,
                                   ChoiceBox<String> choiceBoxMarca,
                                   ChoiceBox<String> choiceBoxModelo,
                                   ChoiceBox<String> choiceBoxAno) {

        if (choiceBox.getValue() == null) {
            choiceBoxMarca.setDisable(true);
            choiceBoxModelo.setDisable(true);
            choiceBoxAno.setDisable(true);
        }
    }
}
