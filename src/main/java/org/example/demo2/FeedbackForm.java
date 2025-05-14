package org.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FeedbackForm extends Application {
    ListView<String> submittedList = new ListView<>();
    @Override
    public void start(Stage stage) throws Exception {
        TextArea feedbackArea = new TextArea();
        feedbackArea.setPromptText("Enter your feedback...");

        feedbackArea.setPrefRowCount(4);

        CheckBox sportsBox = new CheckBox("Sports");
        CheckBox musicBox = new CheckBox("Music");
        CheckBox codingBox = new CheckBox("Coding");

        HBox interestBox = new HBox(10, sportsBox, musicBox, codingBox);

        RadioButton maleButton = new RadioButton("Male");
        RadioButton femaleButton = new RadioButton("female");
        RadioButton otherButton = new RadioButton("other");

        ToggleGroup genderGroup = new ToggleGroup();
        maleButton.setToggleGroup(genderGroup);
        femaleButton.setToggleGroup(genderGroup);
        otherButton.setToggleGroup(genderGroup);

        VBox genderBox = new VBox(10, maleButton, femaleButton, otherButton);

        ComboBox<String> countryBox = new ComboBox<>();
        countryBox.getItems().addAll("USA", "Georgia", "Japan");
        countryBox.setPromptText("choose country");


        Button submitButton = new Button("submit");
        submitButton.setOnAction(e -> {
            StringBuilder result = new StringBuilder("Feedback: \n");
            result.append("Text: ").append(feedbackArea.getText()).append("\n");
            result.append("Interests: ");
            if(sportsBox.isSelected()) result.append("Sports");
            if(musicBox.isSelected()) result.append("Music");
            if(codingBox.isSelected()) result.append("Coding");
            result.append("\n");

            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            if(selectedGender != null) {
                result.append("gender: ").append(selectedGender.getText()).append("\n");
            }

            String country = countryBox.getValue();
            if(country != null){
                result.append("Country: ").append(country).append("\n");
            }

            submittedList.getItems().add(result.toString());
            feedbackArea.clear();
            sportsBox.setSelected(false);
            codingBox.setSelected(false);
            musicBox.setSelected(false);
            genderGroup.selectToggle(null);
            countryBox.setValue(null);

        });

        VBox layout = new VBox(15, new Label("enter feedback:"), feedbackArea,
                new Label("Interests:"), interestBox, new Label("Select Gender:"), genderBox,
                new Label("Select Country:"), countryBox, submitButton,
                submittedList);

        layout.setPadding(new Insets(20));
        Scene scene = new Scene(layout, 500, 600);
        stage.setScene(scene);
        stage.show();

    }
}
