/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;










public class ReservationViewController implements Initializable {
 @FXML
    private Button logoutbtn;
public void cancelbtnOnAction(ActionEvent event){
       Stage stage = (Stage) logoutbtn.getScene().getWindow();
       stage.close();
   }
  public void HomePage(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/controllers/Dashboard.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   

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
    
    
                    /**  table validation des Reservation   */
    
    
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
