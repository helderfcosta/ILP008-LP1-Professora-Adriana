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
 * CONTROLLER da tela artesao.fxml: recebe os cliques, lê os campos,
 * chama o Model (Artesao) e mostra o resultado na View.
 */
public class ArtesaoController {

    // Estes nomes precisam ser IGUAIS aos fx:id definidos no artesao.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtEtnia;
    @FXML private TextField txtAnos;
    @FXML private TextField txtMaterialNovo;
    @FXML private ListView<Artesao> lvArtesao;
    @FXML private Label lblMensagem;

    // Lista compartilhada com as outras abas (fica guardada na classe Repositorio)
    private final ObservableList<Artesao> itens = Repositorio.artesaos;

    // Roda sozinho quando a tela é carregada
    @FXML
    private void initialize() {
        lvArtesao.setItems(itens);
        // Outras abas podem alterar o objeto; ao passar o mouse a lista atualiza o texto
        lvArtesao.setOnMouseEntered(e -> lvArtesao.refresh());
    }

    // Os métodos abaixo são chamados pelos botões (onAction="#nomeDoMetodo" no FXML)
    @FXML
    private void cadastrar() {
        try {
            String nome = Entrada.lerTexto(txtNome.getText(), "Nome");
            String etnia = Entrada.lerTexto(txtEtnia.getText(), "Etnia");
            int anos = Entrada.lerInteiro(txtAnos.getText(), "Anos de ofício");
            if (anos < 0) {
                throw new IllegalArgumentException("Os anos de ofício não podem ser negativos.");
            }
            Artesao obj = new Artesao(nome, etnia, anos);
            itens.add(obj);
            txtNome.clear();
            txtEtnia.clear();
            txtAnos.clear();
            lblMensagem.setText("Cadastrado: " + obj);
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void esculpir() {
        Artesao obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            String material = Entrada.lerTexto(txtMaterialNovo.getText(), "Material");
            int ano = Year.now().getValue();
            MascaraAfricana mascara = obj.esculpir(material, ano);
            Repositorio.mascaras.add(mascara);   // aparece na aba Máscara
            lblMensagem.setText("Máscara criada (veja a aba Máscara): " + mascara.descrever(ano));
            txtMaterialNovo.clear();
            lvArtesao.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void classificarNivel() {
        Artesao obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText("Nível: " + obj.classificarNivel());
            lvArtesao.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    @FXML
    private void apresentar() {
        Artesao obj = selecionado();
        if (obj == null) {
            return;
        }
        try {
            lblMensagem.setText(obj.apresentar());
            lvArtesao.refresh();   // atualiza o texto mostrado na lista
        } catch (IllegalArgumentException e) {
            lblMensagem.setText(e.getMessage());
        }
    }

    // Devolve o item escolhido na lista (ou avisa se não escolheu nenhum)
    private Artesao selecionado() {
        Artesao obj = lvArtesao.getSelectionModel().getSelectedItem();
        if (obj == null) {
            lblMensagem.setText("Selecione um item na lista.");
        }
        return obj;
    }
}
