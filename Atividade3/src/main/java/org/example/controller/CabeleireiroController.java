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
 * CONTROLLER da tela cabeleireiro.fxml: recebe os cliques, lê os campos,
 * chama o Model (Cabeleireiro) e mostra o resultado na View.
 */
public class CabeleireiroController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no cabeleireiro.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtSalao;
    @FXML private TextField txtPrecoBase;
    @FXML private TextField txtCorte;
    @FXML private ComboBox<Penteado> cbPenteado;
    @FXML private ListView<Cabeleireiro> lvCabeleireiro;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Cabeleireiro> itens = Repositorio.cabeleireiros;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvCabeleireiro.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvCabeleireiro.setOnMouseEntered(e -> lvCabeleireiro.refresh());
        cbPenteado.setItems(Repositorio.penteados);
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String nome = Entrada.lerTexto(txtNome.getText(), "Nome");
            String salao = Entrada.lerTexto(txtSalao.getText(), "Salão");
            double precoBase = Entrada.lerDouble(txtPrecoBase.getText(), "Preço base");
            if (precoBase < 0) {
                throw new IllegalArgumentException("O preço base não pode ser negativo.");
            }
            Cabeleireiro obj = new Cabeleireiro(nome, salao, precoBase);
            itens.add(obj);
            txtNome.clear();
            txtSalao.clear();
            txtPrecoBase.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void atender() {
        Cabeleireiro obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            double cm = Entrada.lerDouble(txtCorte.getText(), "Cortar (cm)");
            lblMensagem.setText(obj.atender(cbPenteado.getValue(), cm));
            txtCorte.clear();
            lvCabeleireiro.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void calcularPreco() {
        Cabeleireiro obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            Penteado penteado = cbPenteado.getValue();
            if (penteado == null) {
                throw new IllegalArgumentException("Escolha um penteado.");
            }
            lblMensagem.setText(String.format("Preço do atendimento: R$ %.2f", obj.calcularPreco(penteado)));
            lvCabeleireiro.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void apresentar() {
        Cabeleireiro obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.apresentar());
            lvCabeleireiro.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Cabeleireiro selecionado() {
        Cabeleireiro obj = lvCabeleireiro.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
