package br.edu.ifma.adocaoanimais.view.componentes;

import br.edu.ifma.adocaoanimais.model.Animal;
import br.edu.ifma.adocaoanimais.view.DetalhesAnimal;
import br.edu.ifma.adocaoanimais.view.TelaEdicao;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CelulaAnimal extends ListCell<Animal> {

    Label nome = new Label();
    Label dados = new Label();
    Label status = new Label();
    VBox informacoes = new VBox(5, nome, dados, status);

    Button editar = new Button("Editar");
    Button excluir = new Button("Excluir");
    HBox linha = new HBox(15, informacoes, editar, excluir); 
    

    public CelulaAnimal(ObservableList<Animal> animais) {
        nome.getStyleClass().add("animal-name");
        dados.getStyleClass().add("animal-data");

        HBox.setHgrow(informacoes, Priority.ALWAYS);
        linha.setAlignment(Pos.CENTER_LEFT);
        linha.setPadding(new Insets(12));

        editar.getStyleClass().add("edit-button");
        editar.setOnAction(e -> { 
            if (getItem() != null) { 
                new TelaEdicao(getItem(), () -> { 
                    updateItem(getItem(), false); 
                }); 
            } }
        );
        excluir.getStyleClass().add("delete-button");
        excluir.setOnAction(e -> animais.remove(getItem()));
        
        linha.setOnMouseClicked(e -> {
            if (getItem() != null) {
                DetalhesAnimal.abrir(getItem());
            }
        });
    }

    @Override
    protected void updateItem(Animal animal, boolean empty) {
        super.updateItem(animal, empty);
        if (empty || animal == null) {
            setGraphic(null);
            return;
        }

        nome.setText(animal.getNome());
        dados.setText(
            animal.getEspecie() + "  •  " +
            animal.getFaixaEtaria() + "  •  " +
            animal.getSexo() + "  •  " +
            animal.getPorte()
        );
        status.setText(animal.getStatus());

        status.getStyleClass().removeAll("status-disponivel", "status-adotado");
        status.getStyleClass().add(
            animal.getStatus().equals("Disponível")
                ? "status-disponivel"
                : "status-adotado"
        );

        setGraphic(linha);
        setPadding(new Insets(4));
    }

}
