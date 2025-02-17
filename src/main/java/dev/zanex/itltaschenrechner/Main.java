package dev.zanex.itltaschenrechner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 390);

        stage.setTitle("Calculator - 1.0");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
    }

    public static void main(String[] args) {
        launch();
    }
}