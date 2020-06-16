package com.sky.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author : wushikai
 * <p>
 * date : 2020-06-11
 */
public class FxHelloWorld extends Application {
    @Override
    public void start(Stage stage) {
        //  helloWorldForm(stage);
        loginForm(stage);

    }


    //stage> panel> button / label
    public void loginForm(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));


        Text title = new Text("Welcome to loginForm");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(title, 0, 0, 2, 1);

        Label labelUsername = new Label("Username:");
        gridPane.add(labelUsername, 0, 1);

        TextField textFieldUsername = new TextField();
        gridPane.add(textFieldUsername, 1, 1);

        Label labelPassword = new Label("Password:");
        gridPane.add(labelPassword, 0, 2);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);

        Button submit = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(submit);
        gridPane.add(hBox, 1, 4);

        Text msg = new Text();
        gridPane.add(msg, 1, 6);

        submit.setOnAction((ActionEvent e) -> {
                    msg.setFill(Color.FIREBRICK);
                    String username = textFieldUsername.getText();
                    String password = passwordField.getText();
                    if ("sky".equals(username) && "011490".equals(password)) {

                        msg.setText("Sign in success");
                    }else{
                        msg.setText("Sign in fail");

                    }
                }
        );

        Scene scene = new Scene(gridPane, 300, 275);
        stage.setScene(scene);
        stage.setTitle("JavaFx");
        scene.getStylesheets().add(FxHelloWorld.class.getResource("/fx/Login.css").toExternalForm());
        stage.show();
    }

    //stage>scene>button/input
    public void helloWorldForm(Stage stage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(btn);
        Scene scene = new Scene(stackPane, 300, 250);

        stage.setTitle("JavaFx");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        FxHelloWorld.launch(args);
    }
}
