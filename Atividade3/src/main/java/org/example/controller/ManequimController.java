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
 * CONTROLLER da tela manequim.fxml: recebe os cliques, lê os campos,
 * chama o Model (Manequim) e mostra o resultado na View.
 */
public class ManequimController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no manequim.fxml
    @FXML private TextField txtAltura;
    @FXML private TextField txtGraus;
    @FXML private ComboBox<Roupa> cbRoupa;
    @FXML private ListView<Manequim> lvManequim;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Manequim> itens = Repositorio.manequins;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvManequim.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvManequim.setOnMouseEntered(e -> lvManequim.refresh());
        cbRoupa.setItems(Repositorio.roupas);
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            double altura = Entrada.lerDouble(txtAltura.getText(), "Altura (cm)");
            if (altura <= 0) {
                throw new IllegalArgumentException("A altura deve ser maior que 0.");
            }
            Manequim obj = new Manequim(altura);
            itens.add(obj);
            txtAltura.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void vestir() {
        Manequim obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.vestir(cbRoupa.getValue()));
            lvManequim.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void despir() {
        Manequim obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.despir());
            lvManequim.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void girar() {
        Manequim obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int graus = Entrada.lerInteiro(txtGraus.getText(), "Graus");
            lblMensagem.setText(obj.girar(graus));
            txtGraus.clear();
            lvManequim.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Manequim selecionado() {
        Manequim obj = lvManequim.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
