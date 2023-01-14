/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import controllers.DashboardController;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Views.AssociationViewController;

public class DashboardController implements Initializable {
   
                     
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label lblStatut;
    @FXML
    private Button logoutbtn;

    @FXML
    private JFXButton homebtn;

    @FXML
    private JFXButton associationbtn;

    @FXML
    private JFXButton reservationbtn;

    @FXML
    private JFXButton terrainbtn;
    @FXML
    private JFXButton transbtn;
   
    
   
    
    @FXML
  
   public void cancelbtnOnAction(ActionEvent event){
       Stage stage = (Stage) logoutbtn.getScene().getWindow();
       stage.close();
   }
   @FXML
   /**** lien vers les pages *****/
   public void HomePage(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/controllers/Dashboard.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.centerOnScreen();
                    stage.setOnCloseRequest(event -> {
				event.consume();
                                Switch(stage);
                             });

                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
   public void AssociationPage(Event e)
 {
     
      try {
           
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/Views/AssociationView.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();
                    stage.centerOnScreen();
                    stage.setOnCloseRequest(event -> {
				event.consume();
                                Switch(stage);
                             });

                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
   
     public void Switch(Stage stage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(event -> {
				event.consume();
                                Switch(stage);
                             });
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
  public void TerrainPage(Event e)
 {
     
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/Views/TerrainView.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.centerOnScreen();
                   stage.show();
                   
                   stage.setOnCloseRequest(event -> {
				event.consume();
                                Switch(stage);
                             });

                } catch (Exception ex) {
                    System.out.println("yy"+ex.getMessage());
                }
      
 }
  public void TransportPage(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/Views/TransportView.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();
                   stage.centerOnScreen();
                   
                   stage.setOnCloseRequest(event -> {
				event.consume();
                                Switch(stage);
                             });

                } catch (Exception ex) {
                    System.out.println("yy"+ex.getMessage());
                }
 }
  
 public void ReservationPage(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                  
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/Views/ReservationView.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();
                   stage.centerOnScreen();
stage.setOnCloseRequest(event -> {
				event.consume();
                                Switch(stage);
                             });
                } catch (Exception ex) {
                    System.out.println("yy"+ex.getMessage());
                }
 }
    
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
