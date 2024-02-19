package br.com.alura.BuscaFIPE.utils;
import br.com.alura.BuscaFIPE.model.DadosFinais;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


public class Busca {
    public void selectOpcao(ChoiceBox<String> select_opcao, ChoiceBox<String> select_marca) {
        select_opcao.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                select_marca.setDisable(false);
            }
        });
    }
    public void selectMarca(ChoiceBox<String> select_marca, ChoiceBox<String> select_modelo) {
        select_marca.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                select_modelo.setDisable(false);
            }
        });
    }
    public void selectModelo(ChoiceBox<String> select_modelo, ChoiceBox<String> select_ano) {
        select_modelo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                select_ano.setDisable(false);
            }
        });
    }

    public String buscarMarca(ChoiceBox<String> select_opcao, String URL_BASE) {
        String endereco;
        if (select_opcao.getValue() != null && select_opcao.getValue().equals("CARRO")) {
            endereco = URL_BASE + "carros/marcas";
            return endereco;
        } else if (select_opcao.getValue() != null && select_opcao.getValue().equals("MOTO")) {
            endereco = URL_BASE + "motos/marcas";
            return endereco;
        } else if (select_opcao.getValue() != null && select_opcao.getValue().equals("CAMINHAO")) {
            endereco = URL_BASE + "caminhoes/marcas";
            return endereco;
        }
        return null;
    }
    public String buscarModelo(ChoiceBox<String> select_marca, String enderecoOpcao) {
        String endereco;
        if (select_marca.getValue() != null) {
            endereco =(enderecoOpcao + "/" + select_marca.getValue().substring(0, 3) + "/modelos")
                    .replace(" ", "")
                    .replace("-", "");
            return endereco;
        }
        return null;
    }
    public String buscarAno(ChoiceBox<String> select_modelo, String enderecoModelo) {
            String endereco;
            if (select_modelo.getValue() != null) {
                endereco = (enderecoModelo + "/" + select_modelo.getValue().substring(0, 4) + "/anos")
                        .replace(" ", "");
                return endereco;
            }
            return null;
    }
    public String resultadoFinal(ChoiceBox<String> select_ano, String enderecoAno) {
        String endereco;
        if (select_ano.getValue() != null) {
            endereco = (enderecoAno + "/" + select_ano.getValue().substring(0, 6))
                    .replace(" ", "");
            return endereco;
        }
        return null;
    }
    public static void setBusca(Label label_refVeiculo,
                         Label label_valor,
                         Label label_codigo,
                         Label label_ano,
                         Label label_mes,
                         Label label_combustivel,
                         Label label_marca,
                         Label label_sigla,
                         Label label_modelo,
                         DadosFinais resultado){
        if (resultado == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao buscar dados");
            alert.setContentText("Por favor, tente novamente");
            alert.showAndWait();
        } else {
            label_ano.setText(resultado.anoModelo());
            label_combustivel.setText(resultado.combustivel());
            label_codigo.setText(resultado.codigoFipe());
            label_marca.setText(resultado.marca());
            label_mes.setText(resultado.mesReferencia());
            label_modelo.setText(resultado.modelo());
            label_refVeiculo.setText(resultado.tipoVeiculo());
            label_sigla.setText(resultado.siglaCombustivel());
            label_valor.setText(resultado.valor());
        }

    }
}
