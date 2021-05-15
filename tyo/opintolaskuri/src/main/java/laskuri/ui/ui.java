/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskuri.ui;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.text.Font;
import javafx.scene.effect.InnerShadow;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.geometry.Pos;
import laskuri.account;
import laskuri.Service;
import dao.FileAccountDao;
import java.util.Properties;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.FontWeight;
import javafx.scene.media.*;
import java.io.File;
public class ui extends Application {
VBox texts = new VBox();
HBox buttons = new HBox();
account acc;
private Service serv;
private Scene logged;
private Scene login;
private Scene newA;
private AudioClip click;
 @Override
    public void init() throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));
        String accFile = properties.getProperty("accFile");
        FileAccountDao accDao = new FileAccountDao(accFile);
        serv = new Service(accDao);
        
        String sound = properties.getProperty("click");
        click = new AudioClip(new File(sound).toURI().toString());
        
    }
    @Override
    public void start(Stage window)  {
        
        window.setTitle("Studies");

        BorderPane set = new BorderPane();

        
        texts.setSpacing(20);
        TextField logName = new TextField();
        logName.setFont(Font.font("Comic Sans MS", 15));
        PasswordField pWord = new PasswordField();
        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);
        Label header = new Label("Study Calculator pro 3000");
        header.setEffect(is);       
        header.setTextFill(Color.LIME);
        header.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        Label askPWord = new Label("Password");
        askPWord.setFont(Font.font("Comic Sans MS", 20));
        Label askLogin = new Label("Log in");
        askLogin.setFont(Font.font("Comic Sans MS", 20));
        Label erText = new Label("");
        erText.setFont(Font.font("Comic Sans MS", 20));
        erText.setTextFill(Color.RED);
        texts.getChildren().addAll(header, askLogin, logName, askPWord, pWord, erText);

        
        buttons.setSpacing(20);
        Button logIn = new Button("Log in");
        Button createAcc = new Button("Create a new account");
        logIn.setFont(Font.font("Comic Sans MS", 15));
        createAcc.setFont(Font.font("Comic Sans MS", 15));
        buttons.getChildren().add(logIn);
        buttons.getChildren().add(createAcc);

        


        set.setCenter(texts);
        set.setBottom(buttons);
        login = new Scene(set);
        window.setScene(login);

        window.show();
        
     
        BorderPane createnewAcc = new BorderPane();

        VBox cAcTexts = new VBox();
        cAcTexts.setSpacing(20);
        Label nheader2 = new Label("Study Calculator pro 3000");
        nheader2.setEffect(is);       
        nheader2.setTextFill(Color.LIME);
        nheader2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        TextField newName = new TextField();
        newName.setFont(Font.font("Comic Sans MS", 15));
        PasswordField newpWord = new PasswordField();
        Label nAheader = new Label("Creating an account");
        nAheader.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));

        Label asknewPWord = new Label("Type your password");
        asknewPWord.setFont(Font.font("Comic Sans MS", 20));
        Label asknewLogin = new Label("Type your log in name");
        asknewLogin.setFont(Font.font("Comic Sans MS", 20));
        cAcTexts.getChildren().addAll(nheader2, nAheader, asknewLogin, newName, asknewPWord, newpWord);

        HBox newaccbuttons = new HBox();
        buttons.setSpacing(20);
        Button create = new Button("Create");
        create.setFont(Font.font("Comic Sans MS", 15));
        newaccbuttons.getChildren().add(create);
        
        create.setOnAction((event)-> {
            click.play();
            String name = newName.getText();
            String pass = newpWord.getText();
            if (name.length() < 3 | pass.length() < 3) {
                nAheader.setText("Name or password not acceptable");
                nAheader.setTextFill(Color.RED);
            } else if (serv.crtAccount(name, pass)) {
                
            serv.login(name);
            this.acc = serv.getLoggedAcc();
            if (this.acc != null) {
        Label nheader = new Label("Study Calculator pro 3000");
        nheader.setEffect(is);       
        nheader.setTextFill(Color.LIME);
        nheader.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        Label welcomeText = new Label("Welcome, " + acc.getName() + "!");
        welcomeText.setFont(Font.font("Comic Sans MS", 25));
        Label credits = new Label("Your current credits: " + acc.getCredit());
        credits.setFont(Font.font("Comic Sans MS", 20));
        Label untilBc = new Label("Credits until bachelor: " + (180 - acc.getCredit()));
        untilBc.setFont(Font.font("Comic Sans MS", 20));
        Label untilMs = new Label("Credits until masters: " + (360 - acc.getCredit()));
        untilMs.setFont(Font.font("Comic Sans MS", 20));
        Label nConame = new Label("Name of completed course :");
        nConame.setFont(Font.font("Comic Sans MS", 15));
        TextField newCourse = new TextField();
        newCourse.setFont(Font.font("Comic Sans MS", 15));
        Label askG = new Label("Grade for completed course: ");
        askG.setFont(Font.font("Comic Sans MS", 15));
        TextField grade = new TextField();
        grade.setFont(Font.font("Comic Sans MS", 15));
        Label nCoamount = new Label("Amount of credits for completed course: ");
        nCoamount.setFont(Font.font("Comic Sans MS", 15));
        TextField newCredit = new TextField();
        newCredit.setFont(Font.font("Comic Sans MS", 15));
        Button addnewCredits = new Button("Add completed course");
        addnewCredits.setFont(Font.font("Comic Sans MS", 15));
        Label comp = new Label("Courses you have completed:");
        comp.setFont(Font.font("Comic Sans MS", 15));
        Label compC = new Label("");
        compC.setFont(Font.font("Comic Sans MS", 10));
        Label avg = new Label("Current average grade: " + acc.getAvr());
        avg.setFont(Font.font("Comic Sans MS", 15));
        Button logout = new Button("Log out");
        logout.setFont(Font.font("Comic Sans MS", 15));
        VBox welcomeSet = new VBox();
        welcomeSet.setPrefSize(300, 180);
        
        welcomeSet.getChildren().addAll(nheader, welcomeText, credits, untilBc, untilMs, nConame, newCourse, askG, grade, nCoamount, newCredit, addnewCredits, avg, comp, compC, logout);
        welcomeSet.setAlignment(Pos.TOP_CENTER);

         addnewCredits.setOnAction((e) -> {
            click.play();
            if (!newCredit.getText().matches("[0-9]+") && !grade.getText().matches("[0-9]+")) {
            grade.setText("");
            newCredit.setText(""); 
            welcomeText.setText("Invalid credit or grade!");
            welcomeText.setTextFill(Color.RED);
            return;
            }
            int add = Integer.parseInt(newCredit.getText());
            int addG = Integer.parseInt(grade.getText());
           
            acc.addCredit(add, addG);
            String text = newCourse.getText();
            grade.setText("");
            newCredit.setText("");
            newCourse.setText("");
            welcomeText.setText("Course added successfully.");
            welcomeText.setTextFill(Color.GREEN);
            credits.setText("Your current credits: " + acc.getCredit());
            untilBc.setText("Credits until bachelor: " + (180 - acc.getCredit()));
            untilMs.setText("Credits until masters: " + (360 - acc.getCredit()));
            avg.setText(("Current average grade: " + acc.getAvr()));
            compC.setText(compC.getText() + "\n" + text + ", " + add + " credits, grade: " + addG + ";");
            compC.setPrefWidth(250);
            compC.setWrapText(true);
        });
         logout.setOnAction((s) -> {
        click.play();
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
        
        logIn.setOnAction((event) -> {
            click.play();
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

        createAcc.setOnAction((event) -> {
            click.play();
            window.setScene(newA);
        });
    }

    public static void main(String[] args) {
        launch(ui.class);
    }
    


}
