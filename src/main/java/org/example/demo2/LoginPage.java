package org.example.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label userLabel = new Label("username: ");
        Label passLabel = new Label("password: ");
        Label messageLabel = new Label();

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if(username.equals("admin") && password.equals("1234")){
                messageLabel.setText("logged in!");
            }else {
                messageLabel.setText("invalid inputs!");
            }
        });

        GridPane grid = new GridPane();
        grid.add(userLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passLabel, 0,1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 1, 3);
        grid.setHgap(10);
        grid.setVgap(20);

        Scene scene = new Scene(grid, 300, 250);
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}
