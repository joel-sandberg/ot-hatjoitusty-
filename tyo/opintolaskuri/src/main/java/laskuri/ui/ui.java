/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskuri.ui;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.text.Text;
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
import laskuri.Service;
import dao.FileAccountDao;
import java.util.Properties;

public class ui extends Application {
VBox texts = new VBox();
HBox buttons = new HBox();
account acc;
private Service serv;
private Scene logged;
private Scene login;
private Scene newA;

 @Override
    public void init() throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));
        String accFile = properties.getProperty("accFile");
        FileAccountDao accDao = new FileAccountDao(accFile);
        serv = new Service(accDao);
    }
    @Override
    public void start(Stage window)  {
        
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

        

//roska käyntiin
        set.setCenter(texts);
        set.setBottom(buttons);
        login = new Scene(set);
        window.setScene(login);

        window.show();
        
        //crtAcc
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
            String name = newName.getText();
            String pass = newpWord.getText();
            if (name.length() < 3 | pass.length() < 3) {
                nAheader.setText("Name or password not acceptable");
            } else if (serv.crtAccount(name, pass)) {
                
            serv.login(name);
            this.acc = serv.getLoggedAcc();
            if (this.acc != null) {
        Label welcomeText = new Label("Welcome, " + acc.getName() + "!");
        
        Label credits = new Label("Your current credits: " + acc.getCredit());
        Label untilBc = new Label("Credits until bachelor: " + (180 - acc.getCredit()));
        Label untilMs = new Label("Credits until masters: " + (360 - acc.getCredit()));
        Label nConame = new Label("Name of completed course :");
        TextField newCourse = new TextField();
        Label askG = new Label("Grade for completed course: ");
        TextField grade = new TextField();
        Label nCoamount = new Label("Amount of credits for completed course: ");
        TextField newCredit = new TextField();
        Button addnewCredits = new Button("Add completed course");
        Label comp = new Label("Courses you have completed:");
        Label compC = new Label("");
        Label avg = new Label("Current average grade: " + acc.getAvr());
        Button logout = new Button("Log out");
        VBox welcomeSet = new VBox();
        welcomeSet.setPrefSize(300, 180);
        
        welcomeSet.getChildren().addAll(welcomeText, credits, untilBc, untilMs, nConame, newCourse, askG, grade, nCoamount, newCredit, addnewCredits, avg, comp, compC, logout);
        welcomeSet.setAlignment(Pos.TOP_CENTER);

         addnewCredits.setOnAction((e) -> {
             
            int add = Integer.parseInt(newCredit.getText());
            int addG = Integer.parseInt(grade.getText());
            acc.addCredit(add, addG);
            String text = newCourse.getText();
            grade.setText("");
            newCredit.setText("");
            newCourse.setText("");
            credits.setText("Your current credits: " + acc.getCredit());
            untilBc.setText("Credits until bachelor: " + (180 - acc.getCredit()));
            untilMs.setText("Credits until masters: " + (360 - acc.getCredit()));
            avg.setText(("Current average grade: " + acc.getAvr()));
            compC.setText(compC.getText() + " " + text + ", " + add + " credits, grade: " + addG + ";");
            compC.setPrefWidth(250);
            compC.setWrapText(true);
        });
         logout.setOnAction((s) -> {
        serv.logout();
        window.setScene(login);
        
        
    });
        
        logged = new Scene(welcomeSet);
        }
            window.setScene(logged);
            }
            
        
    });
        
        createnewAcc.setCenter(cAcTexts);
        createnewAcc.setBottom(newaccbuttons);
        newA = new Scene(createnewAcc);
        // logged in
        
        //laitetaan nappi skulaa
        logIn.setOnAction((event) -> {
            
            if (!serv.login(logName.getText())) {
                erText.setText("This account does not exist.");
                return;
            }
            if (logName.getText() == null) {
                erText.setText("Unknown password.");
                return;
            }
            if (serv.login(logName.getText())) {
            window.setScene(logged);
            }
        });
//laitetaa toka nappi skulaa
        createAcc.setOnAction((event) -> {
            
            window.setScene(newA);
        });
    }

    public static void main(String[] args) {
        launch(ui.class);
    }
    


}
