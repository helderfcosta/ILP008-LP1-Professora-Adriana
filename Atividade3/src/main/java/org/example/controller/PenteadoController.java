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
 * CONTROLLER da tela penteado.fxml: recebe os cliques, lê os campos,
 * chama o Model (Penteado) e mostra o resultado na View.
 */
public class PenteadoController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no penteado.fxml
    @FXML private TextField txtEstilo;
    @FXML private TextField txtComprimento;
    @FXML private TextField txtCor;
    @FXML private TextField txtCortar;
    @FXML private TextField txtCrescer;
    @FXML private TextField txtNovaCor;
    @FXML private ListView<Penteado> lvPenteado;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Penteado> itens = Repositorio.penteados;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvPenteado.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvPenteado.setOnMouseEntered(e -> lvPenteado.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String estilo = Entrada.lerTexto(txtEstilo.getText(), "Estilo");
            double comprimento = Entrada.lerDouble(txtComprimento.getText(), "Comprimento (cm)");
            String cor = Entrada.lerTexto(txtCor.getText(), "Cor");
            if (comprimento < 0) {
                throw new IllegalArgumentException("O comprimento não pode ser negativo.");
            }
            Penteado obj = new Penteado(estilo, comprimento, cor);
            itens.add(obj);
            txtEstilo.clear();
            txtComprimento.clear();
            txtCor.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void cortar() {
        Penteado obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            double cm = Entrada.lerDouble(txtCortar.getText(), "Cortar (cm)");
            lblMensagem.setText(obj.cortar(cm));
            txtCortar.clear();
            lvPenteado.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void crescer() {
        Penteado obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            double cm = Entrada.lerDouble(txtCrescer.getText(), "Crescer (cm)");
            lblMensagem.setText(obj.crescer(cm));
            txtCrescer.clear();
            lvPenteado.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void pintar() {
        Penteado obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            String novaCor = Entrada.lerTexto(txtNovaCor.getText(), "Nova cor");
            lblMensagem.setText(obj.pintar(novaCor));
            txtNovaCor.clear();
            lvPenteado.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Penteado selecionado() {
        Penteado obj = lvPenteado.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
