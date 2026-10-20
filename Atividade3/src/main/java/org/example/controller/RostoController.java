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
 * CONTROLLER da tela rosto.fxml: recebe os cliques, lê os campos,
 * chama o Model (Rosto) e mostra o resultado na View.
 */
public class RostoController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no rosto.fxml
    @FXML private TextField txtFormato;
    @FXML private TextField txtTomDePele;
    @FXML private TextField txtExpressao;
    @FXML private ListView<Rosto> lvRosto;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Rosto> itens = Repositorio.rostos;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvRosto.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvRosto.setOnMouseEntered(e -> lvRosto.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String formato = Entrada.lerTexto(txtFormato.getText(), "Formato");
            String tomDePele = Entrada.lerTexto(txtTomDePele.getText(), "Tom de pele");
            Rosto obj = new Rosto(formato, tomDePele);
            itens.add(obj);
            txtFormato.clear();
            txtTomDePele.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void sorrir() {
        Rosto obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.sorrir());
            lvRosto.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void piscar() {
        Rosto obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.piscar());
            lvRosto.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void mudarExpressao() {
        Rosto obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            String expressao = Entrada.lerTexto(txtExpressao.getText(), "Nova expressão");
            lblMensagem.setText(obj.mudarExpressao(expressao));
            txtExpressao.clear();
            lvRosto.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Rosto selecionado() {
        Rosto obj = lvRosto.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
