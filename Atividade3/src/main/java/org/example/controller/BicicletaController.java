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
 * CONTROLLER da tela bicicleta.fxml: recebe os cliques, lê os campos,
 * chama o Model (Bicicleta) e mostra o resultado na View.
 */
public class BicicletaController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no bicicleta.fxml
    @FXML private TextField txtMarca;
    @FXML private TextField txtEsforco;
    @FXML private TextField txtMarcha;
    @FXML private ListView<Bicicleta> lvBicicleta;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Bicicleta> itens = Repositorio.bicicletas;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvBicicleta.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvBicicleta.setOnMouseEntered(e -> lvBicicleta.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String marca = Entrada.lerTexto(txtMarca.getText(), "Marca");
            Bicicleta obj = new Bicicleta(marca);
            itens.add(obj);
            txtMarca.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void pedalar() {
        Bicicleta obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            double esforco = Entrada.lerDouble(txtEsforco.getText(), "Esforço");
            lblMensagem.setText(obj.pedalar(esforco));
            txtEsforco.clear();
            lvBicicleta.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void frear() {
        Bicicleta obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.frear());
            lvBicicleta.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void trocarMarcha() {
        Bicicleta obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int marcha = Entrada.lerInteiro(txtMarcha.getText(), "Marcha");
            lblMensagem.setText(obj.trocarMarcha(marcha));
            txtMarcha.clear();
            lvBicicleta.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Bicicleta selecionado() {
        Bicicleta obj = lvBicicleta.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
