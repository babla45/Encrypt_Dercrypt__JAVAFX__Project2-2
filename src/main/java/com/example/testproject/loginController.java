package com.example.testproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    @FXML
    private PasswordField loginPasswordId;

    @FXML
    private TextField loginUsernameId;

    @FXML
    private Label levelId;

    @FXML
    private Button signupButtonId,loginButtonId;





    public void loginAction1(ActionEvent e) throws IOException {



      /*  try{
            FXMLLoader ff=new FXMLLoader(getClass().getResource("options.fxml"));
            Parent parentNode=ff.load();
            Scene scene2=new Scene(parentNode);
            Stage primaryStage= (Stage) (  (Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(scene2);
            primaryStage.show();
        }
        catch (Exception exception){

        }*/
        db.login(e,loginUsernameId.getText(),loginPasswordId.getText());

    }


    public void signupaction1(ActionEvent e) throws IOException {
        try{
            FXMLLoader ff=new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent parentNode=ff.load();
            Scene scene2=new Scene(parentNode);
            Stage primaryStage= (Stage) (  (Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(scene2);
            primaryStage.show();
        }
        catch (Exception exception){

        }
    }



}
