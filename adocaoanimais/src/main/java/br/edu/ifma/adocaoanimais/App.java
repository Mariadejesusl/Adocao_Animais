package br.edu.ifma.adocaoanimais;

import br.edu.ifma.adocaoanimais.view.TelaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	@Override
    public void start(Stage palco) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();

        Scene scene = new Scene(telaPrincipal, 1000, 650);
        scene.getStylesheets().add(
            getClass().getResource("/style.css").toExternalForm()
        );

        palco.setTitle("Adoção Pet");
        palco.setScene(scene);
        palco.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}