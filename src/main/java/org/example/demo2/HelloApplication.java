package org.example.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button button = new Button("Click me!");
        button.setOnAction(e -> {
            System.out.println("button clicked!");
        });

        StackPane root = new StackPane();

        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("My JavaFX app!");
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}