package br.edu.ifma.adocaoanimais.view;
import br.edu.ifma.adocaoanimais.model.Animal;
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


public class TelaEdicao {
    
    public TelaEdicao(Animal animal, Runnable atualizarLista) {
        Stage janela = new Stage();
        janela.setTitle("Editar Animal");

        Label titulo = new Label("Editar Animal");
        titulo.getStyleClass().add("window-title");

        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(12);

        TextField nome = new TextField(animal.getNome());
        adicionarCampo(formulario, "Nome:", nome, 0);

        ComboBox<String> especie = new ComboBox<>();
        especie.getItems().addAll("Cachorro", "Gato");
        especie.setValue(animal.getEspecie());
        adicionarCampo(formulario, "Espécie:", especie, 1);

        ComboBox<String> faixaEtaria = new ComboBox<>(); 
        faixaEtaria.getItems().addAll(
            "Filhote (0-5 meses)",
            "Jovem (6 meses-1 ano)",
            "Adulto (1-7 anos)"); 
        faixaEtaria.setValue(animal.getFaixaEtaria()); 
        adicionarCampo(formulario, "Faixa etária:", faixaEtaria, 2);

        ComboBox<String> sexo = new ComboBox<>();
        sexo.getItems().addAll("Macho", "Fêmea");
        sexo.setValue(animal.getSexo());
        adicionarCampo(formulario, "Sexo:", sexo, 3);

        ComboBox<String> porte = new ComboBox<>();
        porte.getItems().addAll("Pequeno", "Médio", "Grande");
        porte.setValue(animal.getPorte());
        adicionarCampo(formulario, "Porte:", porte, 4);

        ComboBox<String> status = new ComboBox<>();
        status.getItems().addAll("Disponível", "Adotado");
        status.setValue(animal.getStatus());
        adicionarCampo(formulario, "Status:", status, 5);

        Button salvar = new Button("Salvar alterações");
        salvar.getStyleClass().add("primary-button");
        
     
        salvar.setOnAction(e -> {
            animal.setNome(nome.getText());
            animal.setEspecie(especie.getValue());
            animal.setFaixaEtaria(faixaEtaria.getValue());
            animal.setSexo(sexo.getValue());
            animal.setPorte(porte.getValue());
            animal.setStatus(status.getValue());
        
        atualizarLista.run();
        janela.close();
    });

        Button cancelar = new Button("Cancelar");
        cancelar.getStyleClass().add("cancel-button");
        cancelar.setOnAction(e -> janela.close());

        HBox botoes = new HBox(10, cancelar, salvar);
        botoes.setAlignment(Pos.CENTER_RIGHT);

        VBox form = new VBox(20, titulo, formulario, botoes);
        form.setPadding(new Insets(25));
        form.getStyleClass().add("dialog-root");

        Scene scene = new Scene(form, 500, 440);
        scene.getStylesheets().add(
            getClass().getResource("/estiloCad.css").toExternalForm()
        );

        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    private void adicionarCampo(
        GridPane grid,
        String texto,
        javafx.scene.Node campo,
        int linha) {

        Label label = new Label(texto);
        label.getStyleClass().add("form-label");

        grid.add(label, 0, linha);
        grid.add(campo, 1, linha);
        campo.setStyle("-fx-pref-width: 280px;");
    }
}
