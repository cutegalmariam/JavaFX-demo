package org.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ImageUplaoder extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        Button uploadButton = new Button("Upload Image");
        uploadButton.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.gif", "*.jpeg", "*.jpg"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if(selectedFile != null){
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        VBox layout = new VBox(10, uploadButton, imageView);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
