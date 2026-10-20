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
 * CONTROLLER da tela ciclista.fxml: recebe os cliques, lê os campos,
 * chama o Model (Ciclista) e mostra o resultado na View.
 */
public class CiclistaController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no ciclista.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtMinutos;
    @FXML private TextField txtDescanso;
    @FXML private ComboBox<Bicicleta> cbBicicleta;
    @FXML private ListView<Ciclista> lvCiclista;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Ciclista> itens = Repositorio.ciclistas;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvCiclista.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvCiclista.setOnMouseEntered(e -> lvCiclista.refresh());
        cbBicicleta.setItems(Repositorio.bicicletas);
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String nome = Entrada.lerTexto(txtNome.getText(), "Nome");
            int idade = Entrada.lerInteiro(txtIdade.getText(), "Idade");
            if (idade < 0) {
                throw new IllegalArgumentException("A idade não pode ser negativa.");
            }
            Ciclista obj = new Ciclista(nome, idade);
            itens.add(obj);
            txtNome.clear();
            txtIdade.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void pedalar() {
        Ciclista obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int minutos = Entrada.lerInteiro(txtMinutos.getText(), "Minutos");
            if (minutos <= 0) {
                throw new IllegalArgumentException("Os minutos devem ser maiores que 0.");
            }
            lblMensagem.setText(obj.pedalar(cbBicicleta.getValue(), minutos));
            txtMinutos.clear();
            lvCiclista.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void beberAgua() {
        Ciclista obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.beberAgua());
            lvCiclista.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void descansar() {
        Ciclista obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            int minutos = Entrada.lerInteiro(txtDescanso.getText(), "Minutos de descanso");
            lblMensagem.setText(obj.descansar(minutos));
            txtDescanso.clear();
            lvCiclista.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Ciclista selecionado() {
        Ciclista obj = lvCiclista.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
