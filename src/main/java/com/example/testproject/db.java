package com.example.testproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

public class db {
    public static void signup(ActionEvent event, String username, String password){
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement psCheckUserExists=null;
        ResultSet resultSet=null;

        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/babla","root","");
            psCheckUserExists=connection.prepareStatement("SELECT * FROM data WHERE username=?");
            psCheckUserExists.setString(1,username);
            resultSet=psCheckUserExists.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("user already exists");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("use another username");
                alert.show();
            }
            else{
                psInsert=connection.prepareStatement("INSERT INTO data (username, password) VALUES(?,?)");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.executeUpdate();

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public static void login(ActionEvent event, String username, String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/babla","root","");
            preparedStatement=connection.prepareStatement("SELECT password FROM data WHERE username=?");
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("user not found");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect credential");
                alert.show();
               // return 0;
            }

            else{
                    while(resultSet.next()) {

                    String retPassword=resultSet.getString("password");

                   /* if(!retPassword.equals(password)){
                        System.out.println("password did not match");
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provide correct password");
                        alert.show();
                        return 0;

                    }
                    else{
                    }*/

                        if(retPassword.equals(password)){
                            try{
                                FXMLLoader ff=new FXMLLoader(db.class.getResource("options.fxml"));
                                Parent parentNode=ff.load();
                                Scene scene2=new Scene(parentNode);
                                Stage primaryStage= (Stage) (  (Node)event.getSource()).getScene().getWindow();
                                primaryStage.setScene(scene2);
                                primaryStage.show();
                            }
                            catch (Exception exception){

                            }

                        }
                        else{
                            System.out.println("password did not match");
                            Alert alert=new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Provide correct password");
                            alert.show();
                        }
                }
            }
        }
        catch (SQLException e) {
        }
       // return 1;
    }
}
