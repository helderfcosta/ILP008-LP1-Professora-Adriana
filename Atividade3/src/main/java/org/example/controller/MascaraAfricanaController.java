package org.example.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.model.*;
import org.example.util.Entrada;
import org.example.util.Repositorio;

import java.time.Year;

/**
 * CONTROLLER da tela mascaraafricana.fxml: recebe os cliques, lê os campos,
 * chama o Model (MascaraAfricana) e mostra o resultado na View.
 */
public class MascaraAfricanaController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no mascaraafricana.fxml
    @FXML private TextField txtEtnia;
    @FXML private TextField txtMaterial;
    @FXML private TextField txtAno;
    @FXML private ListView<MascaraAfricana> lvMascaraAfricana;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<MascaraAfricana> itens = Repositorio.mascaras;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvMascaraAfricana.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvMascaraAfricana.setOnMouseEntered(e -> lvMascaraAfricana.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String etnia = Entrada.lerTexto(txtEtnia.getText(), "Etnia");
            String material = Entrada.lerTexto(txtMaterial.getText(), "Material");
            int ano = Entrada.lerInteiro(txtAno.getText(), "Ano de criação");
            if (ano <= 0 || ano > Year.now().getValue()) {
                throw new IllegalArgumentException("Informe um ano de criação válido.");
            }
            MascaraAfricana obj = new MascaraAfricana(etnia, material, ano);
            itens.add(obj);
            txtEtnia.clear();
            txtMaterial.clear();
            txtAno.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void calcularIdade() {
        MascaraAfricana obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText("Idade da máscara: " + obj.calcularIdade(Year.now().getValue()) + " anos");
            lvMascaraAfricana.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void verificarAntiga() {
        MascaraAfricana obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.ehAntiga(Year.now().getValue()) ? "Sim, é uma peça antiga (100 anos ou mais)." : "Não, ainda não é uma peça antiga.");
            lvMascaraAfricana.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void descrever() {
        MascaraAfricana obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.descrever(Year.now().getValue()));
            lvMascaraAfricana.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private MascaraAfricana selecionado() {
        MascaraAfricana obj = lvMascaraAfricana.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
