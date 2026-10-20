package org.example.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.model.*;

/**
 * Guarda, na memória, todos os objetos cadastrados nas telas.
 * Como as listas são "static", todas as abas enxergam as mesmas listas
 * (por exemplo, o Manequim escolhe uma Roupa cadastrada na aba Roupa).
 * Os dados somem quando o programa é fechado.
 */
public final class Repositorio {

    private Repositorio() {
    }

    public static final ObservableList<Loja> lojas = FXCollections.observableArrayList();
    public static final ObservableList<Roupa> roupas = FXCollections.observableArrayList();
    public static final ObservableList<Manequim> manequins = FXCollections.observableArrayList();
    public static final ObservableList<Bicicleta> bicicletas = FXCollections.observableArrayList();
    public static final ObservableList<Ciclista> ciclistas = FXCollections.observableArrayList();
    public static final ObservableList<Trilha> trilhas = FXCollections.observableArrayList();
    public static final ObservableList<MascaraAfricana> mascaras = FXCollections.observableArrayList();
    public static final ObservableList<Artesao> artesaos = FXCollections.observableArrayList();
    public static final ObservableList<Exposicao> exposicoes = FXCollections.observableArrayList();
    public static final ObservableList<Penteado> penteados = FXCollections.observableArrayList();
    public static final ObservableList<Rosto> rostos = FXCollections.observableArrayList();
    public static final ObservableList<Cabeleireiro> cabeleireiros = FXCollections.observableArrayList();
}
