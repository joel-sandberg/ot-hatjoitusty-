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
import javafx.scene.layout.FlowPane;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class ui extends Application {
   @Override
    public void start(Stage window) {
        window.setTitle("Studies");
        window.show();
        BorderPane set = new BorderPane();
        
        VBox texts = new VBox();
        texts.setSpacing(20);
        TextField logName = new TextField();
        TextField pWord = new TextField();
        Label header = new Label("Study Calculator pro 3000");
        Label askPWord = new Label("Password");
        Label askLogin = new Label("Log in");
        texts.getChildren().addAll(header, askLogin, logName, askPWord, pWord);
        
        HBox buttons = new HBox();
        buttons.setSpacing(20);
        Button logIn = new Button("Log in");
        buttons.getChildren().add(logIn);
        
        
        
        logIn.setOnAction((event)-> {
            
        });
        
     
        set.setCenter(texts);
        set.setBottom(buttons);
        Scene view = new Scene(set);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ui.class);
    }
}