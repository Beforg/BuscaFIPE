package br.com.alura.BuscaFIPE;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BuscaFipeApplication extends Application {

	private ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		String[] args = getParameters().getRaw().toArray(new String[0]);

		this.applicationContext = new SpringApplicationBuilder()
				.sources(BuscaFipeApplication.class)
				.run(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	@Override
	public void stop() throws Exception {
		this.applicationContext.close();
	}
}