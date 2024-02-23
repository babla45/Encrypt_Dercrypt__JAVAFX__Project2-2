package com.example.testproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class optionsController {

    @FXML
    void decryptPasswordButtonAction(ActionEvent e) throws IOException {
        FXMLLoader ff=new FXMLLoader(getClass().getResource("decrypt.fxml"));
        Parent parentNode=ff.load();
        Scene scene2=new Scene(parentNode);
        Stage primaryStage= (Stage) (  (Node)e.getSource()).getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.show();

    }

    @FXML
    void encryptPasswordButtonAction(ActionEvent e) throws IOException {
        FXMLLoader ff=new FXMLLoader(getClass().getResource("encrypt.fxml"));
        Parent parentNode=ff.load();
        Scene scene2=new Scene(parentNode);
        Stage primaryStage= (Stage)(  (Node)e.getSource() ).getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.show();
    }


    @FXML
    void logoutAction(ActionEvent e)   throws  IOException{

        FXMLLoader ff=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent parentNode=ff.load();
        Scene scene2=new Scene(parentNode);
        Stage primaryStage= (Stage)(  (Node)e.getSource() ).getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.show();


    }

}
