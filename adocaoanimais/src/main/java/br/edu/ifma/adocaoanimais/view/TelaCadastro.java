package br.edu.ifma.adocaoanimais.view;

import br.edu.ifma.adocaoanimais.model.Animal;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastro {

    public TelaCadastro(ObservableList<Animal> animais) {
        Stage janela = new Stage();
        janela.setTitle("Cadastrar Animal");

        Label titulo = new Label("Cadastrar Animal");
        titulo.getStyleClass().add("window-title");

        
        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(12);

        TextField nome = new TextField();
        adicionarCampo(formulario, "Nome:", nome, 0);

        ComboBox<String> especie = new ComboBox<>();
        especie.getItems().addAll("Cachorro", "Gato");
        adicionarCampo(formulario, "Espécie:", especie, 1);

        TextField idade = new TextField();
        adicionarCampo(formulario, "Idade:", idade, 2);

        ComboBox<String> sexo = new ComboBox<>();
        sexo.getItems().addAll("Macho", "Fêmea");
        adicionarCampo(formulario, "Sexo:", sexo, 3);

        ComboBox<String> porte = new ComboBox<>();
        porte.getItems().addAll("Pequeno", "Médio", "Grande");
        adicionarCampo(formulario, "Porte:", porte, 4);

        ComboBox<String> status = new ComboBox<>();
        status.getItems().addAll("Disponível", "Adotado");
        status.setValue("Disponível");
        adicionarCampo(formulario, "Status:", status, 5);

        Button salvar = new Button("Salvar");
        salvar.getStyleClass().add("primary-button");

        salvar.setOnAction(e -> {
            Animal novo = new Animal(
                nome.getText(),
                especie.getValue(),
                Integer.parseInt(idade.getText()),
                sexo.getValue(),
                porte.getValue(),
                status.getValue()
            );
            animais.add(novo);
            janela.close();
        });

        HBox botoes = new HBox(salvar);
        botoes.setAlignment(Pos.CENTER_RIGHT);

        VBox form = new VBox(20, titulo, formulario, botoes);
        form.setPadding(new Insets(25));
        form.getStyleClass().add("dialog-root");

       
        Scene scene = new Scene(form, 480, 440);
        scene.getStylesheets().add(
            getClass().getResource("/estiloCad.css").toExternalForm()
        );

        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    private void adicionarCampo(GridPane grid,String texto,javafx.scene.Node campo,
        int linha) {

        Label label = new Label(texto);
        label.getStyleClass().add("form-label");

        grid.add(label, 0, linha);
        grid.add(campo, 1, linha);
        campo.setStyle("-fx-pref-width: 280px;");
    }
}