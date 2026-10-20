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
 * CONTROLLER da tela exposicao.fxml: recebe os cliques, lê os campos,
 * chama o Model (Exposicao) e mostra o resultado na View.
 */
public class ExposicaoController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no exposicao.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtCapacidade;
    @FXML private ListView<Exposicao> lvExposicao;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Exposicao> itens = Repositorio.exposicoes;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvExposicao.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvExposicao.setOnMouseEntered(e -> lvExposicao.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String nome = Entrada.lerTexto(txtNome.getText(), "Nome");
            int capacidade = Entrada.lerInteiro(txtCapacidade.getText(), "Capacidade");
            if (capacidade < 1) {
                throw new IllegalArgumentException("A capacidade deve ser de pelo menos 1.");
            }
            Exposicao obj = new Exposicao(nome, capacidade);
            itens.add(obj);
            txtNome.clear();
            txtCapacidade.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void adicionarPeca() {
        Exposicao obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.adicionarPeca());
            lvExposicao.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void removerPeca() {
        Exposicao obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.removerPeca());
            lvExposicao.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void exibirOcupacao() {
        Exposicao obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.exibirOcupacao());
            lvExposicao.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Exposicao selecionado() {
        Exposicao obj = lvExposicao.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
