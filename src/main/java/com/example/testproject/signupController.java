package com.example.testproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class signupController {

    @FXML
    private Button signupPageButtonId;

    @FXML
    private Label signupPagelevelId;

    @FXML
    private PasswordField signupPasswordId;

    @FXML
    private TextField signupUsernameId;

    @FXML
    void signupAction(ActionEvent e) throws IOException {


        if(!signupUsernameId.getText().trim().isEmpty() && !signupPasswordId.getText().trim().isEmpty()){
            db.signup(e,signupUsernameId.getText(),signupPasswordId.getText());
        }
        else{
            System.out.println("please fill all information");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all information to sign up");
            alert.show();
        }

        try{
            FXMLLoader ff=new FXMLLoader(getClass().getResource("login.fxml"));
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
