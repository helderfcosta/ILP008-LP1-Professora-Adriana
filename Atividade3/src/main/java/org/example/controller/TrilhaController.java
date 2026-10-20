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
 * CONTROLLER da tela trilha.fxml: recebe os cliques, lê os campos,
 * chama o Model (Trilha) e mostra o resultado na View.
 */
public class TrilhaController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no trilha.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtExtensao;
    @FXML private TextField txtDificuldade;
    @FXML private TextField txtVelocidade;
    @FXML private ListView<Trilha> lvTrilha;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Trilha> itens = Repositorio.trilhas;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvTrilha.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvTrilha.setOnMouseEntered(e -> lvTrilha.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String nome = Entrada.lerTexto(txtNome.getText(), "Nome");
            double extensao = Entrada.lerDouble(txtExtensao.getText(), "Extensão (km)");
            int dificuldade = Entrada.lerInteiro(txtDificuldade.getText(), "Dificuldade");
            if (extensao <= 0) {
                throw new IllegalArgumentException("A extensão deve ser maior que 0.");
            }
            Trilha obj = new Trilha(nome, extensao, dificuldade);
            itens.add(obj);
            txtNome.clear();
            txtExtensao.clear();
            txtDificuldade.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void calcularTempo() {
        Trilha obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            double velocidade = Entrada.lerDouble(txtVelocidade.getText(), "Velocidade (km/h)");
            if (velocidade <= 0) {
                throw new IllegalArgumentException("A velocidade deve ser maior que 0.");
            }
            lblMensagem.setText(String.format("Tempo estimado: %.2f h", obj.calcularTempo(velocidade)));
            txtVelocidade.clear();
            lvTrilha.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void classificar() {
        Trilha obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText("Classificação: " + obj.classificar());
            lvTrilha.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void descrever() {
        Trilha obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.descrever());
            lvTrilha.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Trilha selecionado() {
        Trilha obj = lvTrilha.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
