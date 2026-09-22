package br.edu.ifma.adocaoanimais.view;
import br.edu.ifma.adocaoanimais.model.Animal;
import br.edu.ifma.adocaoanimais.view.componentes.CelulaAnimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaPrincipal extends BorderPane {
	private final ObservableList<Animal> animais = FXCollections.observableArrayList(
	        new Animal("Rex", "Cachorro", "Adulto (1-7 anos)", "Macho", "Médio", "Disponível"),
	        new Animal("Luna", "Gato", "Jovem (6 meses-1 ano)", "Fêmea", "Pequeno", "Disponível")
	    );

	    Button homeButton = new Button("Home");
	    Button animaisButton = new Button("Animais");
	    Button cadastrarButton = new Button("Cadastrar");

	    public TelaPrincipal() {
	        criarNavbar();
	        mostrarHome();
	    }

	    private void criarNavbar() {
	        Label logo = new Label("🐾 Adoção Pet");
	        logo.getStyleClass().add("logo");
	        configurarBotaoMenu(homeButton);
	        configurarBotaoMenu(animaisButton);
	        configurarBotaoMenu(cadastrarButton);

	        homeButton.setOnAction(e -> mostrarHome());
	        animaisButton.setOnAction(e -> mostrarListaAnimais());
	        cadastrarButton.setOnAction(e -> mostrarCadastro());

	        HBox navbar = new HBox(20);
	        navbar.setPadding(new Insets(12, 20, 12, 20));
	        navbar.setAlignment(Pos.CENTER_LEFT);
	        navbar.getChildren().addAll(logo, homeButton, animaisButton, cadastrarButton);

	        navbar.getStyleClass().add("navbar");
	        setTop(navbar);
	    }

	    private void configurarBotaoMenu(Button button) {
	        button.getStyleClass().add("menu-button");
	        button.setAlignment(Pos.CENTER);
	    }

	    private void mostrarHome() {
	        Home home = new Home(this::mostrarListaAnimais);
	        setCenter(home);
	    }

	    private void mostrarListaAnimais() {
	        Label titulo = new Label("Animais");
	        titulo.getStyleClass().add("page-title");

	        ListView<Animal> listView = new ListView<>(animais);
	        listView.setCellFactory(lv -> new CelulaAnimal(animais));

	        VBox conteudo = new VBox(15, titulo, listView);
	        conteudo.setPadding(new Insets(20));

	        setCenter(conteudo);
	    }

	    private void mostrarCadastro() {
	        TelaCadastro.abrir(animais);
	    }
	   
	}
