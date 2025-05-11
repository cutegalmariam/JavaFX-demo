package org.example.demo2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MiniDashboard extends Application {

    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showMainMenu();
        this.primaryStage.show();

    }

    private void showMainMenu() {
        Button profileButton = new Button("Profile");
        Button settingsButton = new Button("Settings");

        profileButton.setOnAction(e -> showProfileScene());
        settingsButton.setOnAction(e -> showSettingsScene());

        HBox menuButtons = new HBox(30, profileButton, settingsButton);
        menuButtons.setAlignment(Pos.CENTER);

        Scene scene = new Scene(menuButtons, 400, 250);
        primaryStage.setScene(scene);

    }

    private void showSettingsScene() {
        BorderPane settingsPane = new BorderPane();
        Label title = new Label("Settings");
        BorderPane.setAlignment(title, Pos.CENTER);
        settingsPane.setTop(title);

        VBox centerBox = new VBox(10, new Label("notifications: on"), new Label("dark mode: off"));
        centerBox.setAlignment(Pos.CENTER);
        settingsPane.setCenter(centerBox);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showMainMenu());
        BorderPane.setAlignment(backButton, Pos.CENTER);
        settingsPane.setBottom(backButton);
        Scene scene = new Scene(settingsPane, 400, 250);
        primaryStage.setScene(scene);

    }

    private void showProfileScene() {
        BorderPane profilePane = new BorderPane();
        Label title = new Label("Profile Page");
        BorderPane.setAlignment(title, Pos.CENTER);
        profilePane.setTop(title);

        VBox centerBox = new VBox(10, new Label("Name: Mariam"), new Label("role: Java Teacher"));
        centerBox.setAlignment(Pos.CENTER);
        profilePane.setCenter(centerBox);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showMainMenu());

        BorderPane.setAlignment(backButton, Pos.CENTER);
        profilePane.setBottom(backButton);
        Scene scene = new Scene(profilePane, 400, 250);
        primaryStage.setScene(scene);

    }

    public static void main(String[] args) {
        launch();
    }
}
