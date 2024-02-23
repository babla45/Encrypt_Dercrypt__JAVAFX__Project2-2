package com.example.testproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class decryptController {

    @FXML
    private Label levelid;

    @FXML
    private TextField textId;

    @FXML
    void decryptPasswordMethod(ActionEvent event) {

        // textId.setText("Encrypted: "+textId.getText());
        String s=textId.getText();
        StringBuilder s2= new StringBuilder();
        int n=s.length();
        for(int a=0; a<n; a++)
        {
            char c=s.charAt(a);
            int tot=55;
            tot*=(a+1);
            tot%=128;
            int x=c;

            for(int b=0; b<tot; b++)
            {
                x-=1;
                if(x==31) x=127;
            }

            s2.append((char)x);
        }

        textId.setText(String.valueOf(s2));
        levelid.setText("Original password is generated below");

    }

    @FXML
    void gotoHome(ActionEvent e) throws IOException {
        FXMLLoader ff=new FXMLLoader(getClass().getResource("options.fxml"));
        Parent parentNode=ff.load();
        Scene scene2=new Scene(parentNode);
        Stage primaryStage= (Stage) (  (Node)e.getSource()).getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.show();

    }

}
