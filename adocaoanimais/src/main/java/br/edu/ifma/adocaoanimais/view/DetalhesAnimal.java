package br.edu.ifma.adocaoanimais.view;

import br.edu.ifma.adocaoanimais.model.Animal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DetalhesAnimal {

	public static void abrir(Animal animal) {
        DetalhesAnimal detalhes = new DetalhesAnimal(animal);
        detalhes.janela.show();
    }

	private final Stage janela;

	public DetalhesAnimal(Animal animal) {
        janela = new Stage();
        janela.setTitle("Detalhes do Animal");
        janela.initModality(Modality.APPLICATION_MODAL);

        Label nome = new Label(animal.getNome());
        nome.getStyleClass().add("details-name");

        HBox cabecalho = new HBox(nome);
        cabecalho.getStyleClass().add("details-header");

        VBox card = new VBox(14,
                criarLinha("Espécie", animal.getEspecie()),
                criarLinha("Faixa etária", animal.getFaixaEtaria()),
                criarLinha("Sexo", animal.getSexo()),
                criarLinha("Porte", animal.getPorte())
        );
        card.getStyleClass().add("details-card");

        Label status = new Label(animal.getStatus());
        status.getStyleClass().add(
                "Disponível".equals(animal.getStatus())
                        ? "status-disponivel"
                        : "status-adotado"
        );

        Button fechar = new Button("Fechar");
        fechar.getStyleClass().add("primary-button");
        fechar.setOnAction(e -> janela.close());


        VBox corpo = new VBox(16, card, status, fechar);
        corpo.setPadding(new Insets(20, 24, 24, 24));
        corpo.setAlignment(Pos.TOP_LEFT);

        VBox raiz = new VBox(cabecalho, corpo);
        raiz.getStyleClass().add("details-container");

        Scene cena = new Scene(raiz, 360, 400);
        cena.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        cena.getStylesheets().add(getClass().getResource("/estiloCad.css").toExternalForm());
        cena.getStylesheets().add(getClass().getResource("/detalhes.css").toExternalForm());

        janela.setScene(cena);
    }

    private HBox criarLinha(String rotulo, String valor) {
        Label r = new Label(rotulo.toUpperCase());
        r.getStyleClass().add("details-rotulo");
        r.setMinWidth(80);

        Label v = new Label(valor);
        v.getStyleClass().add("details-valor");

        HBox linha = new HBox(10, r, v);
        linha.setAlignment(Pos.CENTER_LEFT);
        return linha;
    }
}
