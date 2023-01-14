/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.transport;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class TransportViewController implements Initializable {
 
    @FXML
    private TextField immatriculeTxt;

    @FXML
    private TextField marqueTXT;

    @FXML
    private TextField modelTXT;

    @FXML
    private TextField dispotransTXT;

    @FXML
    private Button ajoutbtn;

    @FXML
    private Button updatebtn;

    @FXML
    private Button deletebtn;
    
    
    @FXML
    private TextField idtxt;
    
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    @FXML
    private TableView<transport> TransportTable;
    @FXML
    private TableColumn<transport, Integer> idCol;

    @FXML
    private TableColumn<transport, String> marqueCol;

    @FXML
    private TableColumn<transport, String> immatriculeCol;

    @FXML
    private TableColumn<transport, String> modelCol;

    @FXML
    private TableColumn<transport, String> DispoCol;

    
    public ObservableList<transport> data ; 
    
    ObservableList<transport>  transportList = FXCollections.observableArrayList();
    	@FXML
	private void viewTranspot() {
		
             TransportTable.getItems().clear();
		try {
			con = ConnectDB.connectionBD.conDB();
			String sql = "SELECT * FROM transport ";
			PreparedStatement stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
                        data = FXCollections.observableArrayList();
			while(rs.next()) {
                transport trans = new transport(); 
                trans.setId_transp(rs.getInt(1));
                trans.setImmatricule(rs.getString(2).toUpperCase());
                trans.setMarque(rs.getString(3).toUpperCase());
                trans.setModel(rs.getString(4));
                trans.setDisponibilite(rs.getString(5).toUpperCase());
                data.add(trans);
                
                	
           
			}
			con.close();
		}catch(Exception e) {
                    e.printStackTrace();
		}
                idCol.setCellValueFactory(new PropertyValueFactory<>("Id_transp"));
                immatriculeCol.setCellValueFactory(new PropertyValueFactory<>("Immatricule"));
                marqueCol.setCellValueFactory(new PropertyValueFactory<>("Marque"));
		modelCol.setCellValueFactory(new PropertyValueFactory<>("Model"));
                DispoCol.setCellValueFactory(new PropertyValueFactory<>("Disponibilite"));
                      	
		TransportTable.setItems(data);
	}
     
    @FXML
    private Button loadbtn;
public void loadbtnOnAction(ActionEvent event){
        vidertrans();
       viewTranspot();   }
    
    public void senddataTrans(MouseEvent event) {
    	transport trans = TransportTable.getSelectionModel().getSelectedItem();
    	if(trans == null) {
                vidertrans();
    		System.out.println("Nothing");
    	}else{
    		immatriculeTxt.setText(trans.getImmatricule());
    		marqueTXT.setText(trans.getMarque());
    		modelTXT.setText(trans.getModel());
                dispotransTXT.setText(trans.getDisponibilite());
                idtxt.setText(Integer.toString(trans.getId_transp()));
    	}
    }
    public void vidertrans() {
		immatriculeTxt.setText("");
		marqueTXT.setText("");
                modelTXT.setText("");
                dispotransTXT.setText("");
                idtxt.setText(null);
	}
    
    public void transports(ActionEvent ev) {
        Connection conn = ConnectDB.connectionBD.conDB();
    	  String immatricule = immatriculeTxt.getText();
        String marque = marqueTXT.getText();
        String model = modelTXT.getText();    
        String dispo = dispotransTXT.getText();
      //  int ID = Integer.parseInt(idtxt.getText());
      transport trans = new transport();
       
    	if(ev.getSource() == ajoutbtn) {	
               String sql1 = "INSERT INTO transport(`immatricule`, `Marque`, `Model`, `disponibilite`) VALUES (?,?,?,?)";
        //    String sql1 = "INSERT INTO transport VALUES (default,'" + trans.getImmatricule() + "','" + trans.getMarque()+ "','" + trans.getModel() + "','" + trans.getDisponibilite() + "')";
            try {
                preparedStatement = conn.prepareStatement(sql1);
               
                preparedStatement.setString(1, immatricule);
                preparedStatement.setString(2, marque);
                preparedStatement.setString(3, model);
                preparedStatement.setString(4, dispo);
              int rowsInserted =  preparedStatement.executeUpdate();
  
                if (rowsInserted > 0) {
                 System.out.println("A new user was inserted successfully!");
                 vidertrans();
       viewTranspot();
                                        }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println("UnSuccessfull Insert");
            }
    	}
    	
    	if(ev.getSource() == updatebtn) {  
                //String sql1 = "INSERT INTO transport VALUES (default,'" + trans.getImmatricule() + "','" + trans.getMarque()+ "','" + trans.getModel() + "','" + trans.getDisponibilite() + "')";            
           String sql1 = "UPDATE `transport` SET `Marque`=?,`Model`=?,`disponibilite`=? WHERE `immatricule`= ? ";
            try {
                preparedStatement = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
               
                preparedStatement.setString(1, marque);
                preparedStatement.setString(2, model);
                preparedStatement.setString(3, dispo);
                preparedStatement.setString(4, immatricule);
                int rowsInserted =  preparedStatement.executeUpdate();
  
                if (rowsInserted > 0) {
                 System.out.println("An existing user was updated successfully!");
                 vidertrans();
       viewTranspot();
                                        }
                System.out.println("Successfull Update");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println(ex);
            }
    	}
    	
    	if(ev.getSource() == deletebtn) {
    		String sql1 = "DELETE FROM transport WHERE immatricule = ? ";
            try {
                preparedStatement = conn.prepareStatement(sql1);
                preparedStatement.setString(1, immatricule);
                
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                  System.out.println("A user was deleted successfully!");
                }
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Successfull Insert");
                alert.setContentText("Supprimé avec succes !!!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                        vidertrans();
       viewTranspot();
                    }
                });
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println("UnSuccessfull Delete");
            }
    	}  	
    	viewTranspot();
    }
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private Button logoutbtn;
public void cancelbtnOnAction(ActionEvent event){
       Stage stage = (Stage) logoutbtn.getScene().getWindow();
       stage.close();
   }











    public void HomePage(Event e)
 {
      try {
                    
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        viewTranspot();
    }    
    
}
