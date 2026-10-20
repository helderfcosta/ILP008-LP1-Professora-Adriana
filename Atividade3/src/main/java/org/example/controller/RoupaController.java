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
 * CONTROLLER da tela roupa.fxml: recebe os cliques, lê os campos,
 * chama o Model (Roupa) e mostra o resultado na View.
 */
public class RoupaController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no roupa.fxml
    @FXML private TextField txtTipo;
    @FXML private TextField txtTamanho;
    @FXML private TextField txtPreco;
    @FXML private TextField txtDesconto;
    @FXML private TextField txtParcelas;
    @FXML private ListView<Roupa> lvRoupa;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Roupa> itens = Repositorio.roupas;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvRoupa.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvRoupa.setOnMouseEntered(e -> lvRoupa.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String tipo = Entrada.lerTexto(txtTipo.getText(), "Tipo");
            String tamanho = Entrada.lerTexto(txtTamanho.getText(), "Tamanho");
            double preco = Entrada.lerDouble(txtPreco.getText(), "Preço");
            if (preco < 0) {
                throw new IllegalArgumentException("O preço não pode ser negativo.");
            }
            Roupa obj = new Roupa(tipo, tamanho, preco);
            itens.add(obj);
            txtTipo.clear();
            txtTamanho.clear();
            txtPreco.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void aplicarDesconto() {
        Roupa obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            double percentual = Entrada.lerDouble(txtDesconto.getText(), "Desconto (%)");
            lblMensagem.setText(obj.aplicarDesconto(percentual));
            txtDesconto.clear();
            lvRoupa.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void calcularParcela() {
        Roupa obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int parcelas = Entrada.lerInteiro(txtParcelas.getText(), "Parcelas");
            if (parcelas <= 0) {
                throw new IllegalArgumentException("A quantidade de parcelas deve ser maior que 0.");
            }
            lblMensagem.setText(String.format("%dx de R$ %.2f", parcelas, obj.calcularParcela(parcelas)));
            txtParcelas.clear();
            lvRoupa.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void exibirEtiqueta() {
        Roupa obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText("Etiqueta: " + obj.exibirEtiqueta());
            lvRoupa.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Roupa selecionado() {
        Roupa obj = lvRoupa.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
