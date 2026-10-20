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
 * CONTROLLER da tela loja.fxml: recebe os cliques, lê os campos,
 * chama o Model (Loja) e mostra o resultado na View.
 */
public class LojaController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no loja.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtCidade;
    @FXML private TextField txtEstoque;
    @FXML private TextField txtReceber;
    @FXML private TextField txtVender;
    @FXML private ListView<Loja> lvLoja;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Loja> itens = Repositorio.lojas;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvLoja.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvLoja.setOnMouseEntered(e -> lvLoja.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String nome = Entrada.lerTexto(txtNome.getText(), "Nome");
            String cidade = Entrada.lerTexto(txtCidade.getText(), "Cidade");
            int estoque = Entrada.lerInteiro(txtEstoque.getText(), "Estoque inicial");
            if (estoque < 0) {
                throw new IllegalArgumentException("O estoque não pode ser negativo.");
            }
            Loja obj = new Loja(nome, cidade, estoque);
            itens.add(obj);
            txtNome.clear();
            txtCidade.clear();
            txtEstoque.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void receberPecas() {
        Loja obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int quantidade = Entrada.lerInteiro(txtReceber.getText(), "Quantidade a receber");
            lblMensagem.setText(obj.receberPecas(quantidade));
            txtReceber.clear();
            lvLoja.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void venderPecas() {
        Loja obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int quantidade = Entrada.lerInteiro(txtVender.getText(), "Quantidade a vender");
            lblMensagem.setText(obj.venderPecas(quantidade));
            txtVender.clear();
            lvLoja.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void exibirSituacao() {
        Loja obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.exibirSituacao());
            lvLoja.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Loja selecionado() {
        Loja obj = lvLoja.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
