package br.edu.ifma.adocaoanimais.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
public class Home extends VBox{
	public Home(Runnable mostrarList) {

        setSpacing(18);

        setPadding(new Insets(40));
        getStyleClass().add("content");
        Label titulo = new Label("Bem-vindo ao Adoção Pet!");
        titulo.getStyleClass().add("page-title");
        Label texto = new Label(
            "Sistema para gerenciamento de animais disponíveis para adoção."
        );

        texto.getStyleClass().add("description");
        Button verAnimais = new Button("Ver animais disponíveis");
        verAnimais.getStyleClass().add("primary-button");
        verAnimais.setOnAction(e -> mostrarList.run());

        getChildren().addAll(titulo, texto,verAnimais);
    }
}

	

