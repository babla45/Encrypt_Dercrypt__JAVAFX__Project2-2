package com.example.testproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws IOException {



        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Md Babla Islam!");
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
            launch();
    }

}