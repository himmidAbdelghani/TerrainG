/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class LoginController implements Initializable {

   @FXML
   private Button cancelbtn;
   public void cancelbtnOnAction(ActionEvent event){
       Stage stage = (Stage) cancelbtn.getScene().getWindow();
       stage.close();
   }
   @FXML
   Label lblEtat;
   @FXML
   private TextField usertxt;
   @FXML
   private PasswordField passtxt;
   @FXML 
    Label lblerreur;
   @FXML
   private Button loginbtn;
   
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public LoginController() {
        con = ConnectDB.connectionBD.conDB();

    }
    
   public void loginbtnbtnOnAction(ActionEvent event){
       
       if (logIn().equals("Success")) {
                try {

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();        
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/controllers/Dashboard.fxml")));
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    stage.centerOnScreen();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
       
       
       
       
       /*if(usertxt.getText().isEmpty() == false && passtxt.getText().isEmpty()==false){
           lblerreur.setText("trying to login in"); 
            valideLogin();
       }else {
            lblerreur.setText("please enter username and password");
       }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       if (con == null) {
            lblEtat.setTextFill(Color.TOMATO);
            lblEtat.setText("Server is Down : merci de verifier votre connexion ");
        } else {
            lblEtat.setTextFill(Color.GREEN);
            lblEtat.setText("Server is Up");
        }
    }

    private String logIn() {

        String user = usertxt.getText();
        String password = passtxt.getText();

                String sql = "SELECT * FROM administrateur Where login = ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                lblerreur.setTextFill(Color.TOMATO);
                lblerreur.setText("Enter Correct Email/Password");
                System.err.println("Wrong Logins --///");
                return "Error";

            } else {
                  

                System.out.println("Successfull Login");
                
                return "Success";
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }
          
   }
   
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
         File BGFile = new File(pathname: "");
       Image BGImage = new Image(BGFile.toURI().toString());
       BGImageView.setImage(BGImage);
    }    */

    
    

