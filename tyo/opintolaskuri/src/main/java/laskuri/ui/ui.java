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
import laskuri.account;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ui extends Application {
VBox texts = new VBox();
HBox buttons = new HBox();
Map<String, String> accounts = new HashMap();
    @Override
    public void start(Stage window) {
        login(window);
    }

    public static void main(String[] args) {
        launch(ui.class);
    }
    
    public void crtAcc(Stage window) {
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
        Button create = new Button("Create");
        newaccbuttons.getChildren().add(create);
        
        create.setOnAction((event)-> {
            
        account newAcc = new account(newName.getText(), newpWord.getText());
        
        login(window);
    });
        
        createnewAcc.setCenter(cAcTexts);
        createnewAcc.setBottom(newaccbuttons);
        Scene createAccWindow = new Scene(createnewAcc);
        window.setScene(createAccWindow);
    }
    public void welcome(Stage window) {
        Label welcomeText = new Label("Welcome!");
        int creditScore = 0;
        int neededBc = 180 - creditScore;
        int neededMs = 360 - creditScore;
        Label credits = new Label("Your current credits: " + creditScore);
        Label untilBc = new Label("Credits until bachelor: " + neededBc);
        Label untilMs = new Label("Credits until masters: " + neededMs);

        TextField newCredit = new TextField();
        Button addnewCredits = new Button("Add new credit");
        VBox welcomeSet = new VBox();
        welcomeSet.setPrefSize(300, 180);
        
        welcomeSet.getChildren().addAll(welcomeText, credits, untilBc, untilMs, newCredit, addnewCredits);
        welcomeSet.setAlignment(Pos.TOP_CENTER);

         addnewCredits.setOnAction((event) -> {
             
            int add = Integer.parseInt(newCredit.getText());
            credits.setText("Your current credits: " + (creditScore + add));
            untilBc.setText("Credits until bachelor: " + (neededBc - add));
            untilMs.setText("Credits until masters: " + (neededMs - add));
        });
        
        Scene loggedInWindow = new Scene(welcomeSet);
        window.setScene(loggedInWindow);
    }
    public void login(Stage window) {
        window.setTitle("Studies");
//luodaan alkuikkunan asetukset
        BorderPane set = new BorderPane();

        
        texts.setSpacing(20);
        TextField logName = new TextField();
        PasswordField pWord = new PasswordField();
        Label header = new Label("Study Calculator pro 3000");
        Label askPWord = new Label("Password");
        Label askLogin = new Label("Log in");
        Label erText = new Label("");
        texts.getChildren().addAll(header, askLogin, logName, askPWord, pWord, erText);

        
        buttons.setSpacing(20);
        Button logIn = new Button("Log in");
        Button createAcc = new Button("Create a new account");
        buttons.getChildren().add(logIn);
        buttons.getChildren().add(createAcc);

        
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
            welcome(window);
        });
//laitetaa toka nappi skulaa
        createAcc.setOnAction((event) -> {
            
            crtAcc(window);
        });
//roska käyntiin
        set.setCenter(texts);
        set.setBottom(buttons);
        Scene start = new Scene(set);
        window.setScene(start);

        window.show();
    }

}
