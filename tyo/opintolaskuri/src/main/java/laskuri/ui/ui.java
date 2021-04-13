/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskuri.ui;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.layout.StackPane;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.geometry.Pos;

public class ui extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Studies");
//luodaan alkuikkunan asetukset
        BorderPane set = new BorderPane();

        VBox texts = new VBox();
        texts.setSpacing(20);
        TextField logName = new TextField();
        PasswordField pWord = new PasswordField();
        Label header = new Label("Study Calculator pro 3000");
        Label askPWord = new Label("Password");
        Label askLogin = new Label("Log in");
        Label erText = new Label("");
        texts.getChildren().addAll(header, askLogin, logName, askPWord, pWord, erText);

        HBox buttons = new HBox();
        buttons.setSpacing(20);
        Button logIn = new Button("Log in");
        Button createAcc = new Button("Create a new account");
        buttons.getChildren().add(logIn);
        buttons.getChildren().add(createAcc);

//luodaan uuskäyttäjäikkuna
        BorderPane createnewAcc = new BorderPane();

        VBox cAcTexts = new VBox();
        cAcTexts.setSpacing(20);
        TextField newName = new TextField();
        PasswordField newpWord = new PasswordField();
        Label nAheader = new Label("Creating an account");
        Label asknewPWord = new Label("Type your password");
        Label asknewLogin = new Label("Type your log in name");
       
        cAcTexts.getChildren().addAll(nAheader, asknewLogin, newName, asknewPWord, newpWord);

        HBox newaccbuttons = new HBox();
        buttons.setSpacing(20);
        
        newaccbuttons.getChildren().add(new Button("Create"));
        createnewAcc.setCenter(cAcTexts);
        createnewAcc.setBottom(newaccbuttons);
        Scene createAccWindow = new Scene(createnewAcc);
//luodaan tervetuloaikkuna
        Label welcomeText = new Label("Welcome!");

        StackPane welcomeSet = new StackPane();
        welcomeSet.setPrefSize(300, 180);
        welcomeSet.getChildren().add(welcomeText);
        welcomeSet.setAlignment(Pos.CENTER);

        Scene loggedInWindow = new Scene(welcomeSet);
//laitetaan nappi skulaa
        logIn.setOnAction((event) -> {
            if (!logName.getText().trim().equals("admin")) {
                erText.setText("This account does not exist.");
                return;
            }
            if (!pWord.getText().trim().equals("123")) {
                erText.setText("Unknown password.");
                return;
            }
            window.setScene(loggedInWindow);
        });
//laitetaa toka nappi skulaa
        createAcc.setOnAction((event) -> {
            
            window.setScene(createAccWindow);
        });
//roska käyntiin
        set.setCenter(texts);
        set.setBottom(buttons);
        Scene start = new Scene(set);
        window.setScene(start);

        window.show();
    }

    public static void main(String[] args) {
        launch(ui.class);
    }
}
