package org.example.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreetApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label promptLabel = new Label("Enter your name:");
        TextField nameField = new TextField();
        Button submitButton = new Button("Submit");

        VBox inputLayout = new VBox(10, promptLabel, nameField, submitButton);
        Scene inputScene = new Scene(inputLayout, 300, 150);

        submitButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            Label greetingLabel = new Label("Hello "+name+"!");
            VBox greetingLayout = new VBox(10, greetingLabel);
            Scene greetingScene = new Scene(greetingLayout, 300, 150);
            stage.setScene(greetingScene);
        });

        stage.setScene(inputScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
