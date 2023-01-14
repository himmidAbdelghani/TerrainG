/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Association;
import ConnectDB.connectionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Association;
import model.Terrains;
/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AssociationViewController implements Initializable {
     @Override
           public void initialize(URL url, ResourceBundle rb) {
      viewAssociation();
            
    }  @FXML
    private TextField codeUTXT;

    @FXML
    private TextField RespoTXT;

    @FXML
    private TextField nomAssTXT;

    @FXML
    private TextField domainTXT;

    @FXML
    private TextField telephoneTXT;

    @FXML
    private TextField emailTXT;

    @FXML
    private TextField PasswordTXT;

    @FXML
    private TextField usernameTXT;

    @FXML
    private Button Ajoutbtn;

    @FXML
    private Button updatebtn;

    @FXML
    private Button deletebtn;
           
           
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    @FXML
    private TableView<Association> AssociationTable;
    @FXML
    private TableColumn<Association, Integer> id;
    @FXML
    private TableColumn<Association, String> nom_association;
    @FXML
    private TableColumn<Association, String> responsable;
    @FXML
    private TableColumn<Association, String> DomaineActivite;
    @FXML
    private TableColumn<Association, String> email;
    @FXML
    private TableColumn<Association, String> username;
    @FXML
    private TableColumn<Association, String> password;
    @FXML
    private TableColumn<Association, String> codeUnique;
    @FXML
    private TableColumn<Association, String> telephone;
    
    public ObservableList<Association> data ; 
    
    ObservableList<Association>  AssociationList = FXCollections.observableArrayList();
    	@FXML
	private void viewAssociation() {
		
             AssociationTable.getItems().clear();
		try {
			con = ConnectDB.connectionBD.conDB();
			String sql = "SELECT * FROM association ";
			PreparedStatement stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
                        data = FXCollections.observableArrayList();
			while(rs.next()) {
                Association association = new Association(); 
                association.setId_Assoc(rs.getInt(1));
                association.setNom_Assoc(rs.getNString(2));
                association.setDomaine_activite(rs.getString(3));
                association.setNom_respo(rs.getString(4));
                association.setCode_unique(rs.getString(5));
                association.setEmail_Assoc(rs.getString(6));
                association.setUsername(rs.getString(7));
                association.setPassword(rs.getString(8));
                association.setTelephone(rs.getString(9));
                data.add(association);
                
                	
                        //data.add(new Association(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));   
                            //data.add(new Association(rs.getInt("id_Assoc"), rs.getString("nom_Assoc"), rs.getString("domaine_activite"), rs.getString("nom_respo"), rs.getString("code_unique"), rs.getString("email_Assoc"), rs.getString("username"), rs.getString("password"), rs.getString("telephone")));
			}
			con.close();
		}catch(Exception e) {
                    e.printStackTrace();
		}
                id.setCellValueFactory(new PropertyValueFactory<>("id_Assoc"));
                nom_association.setCellValueFactory(new PropertyValueFactory<>("nom_Assoc"));
		DomaineActivite.setCellValueFactory(new PropertyValueFactory<>("domaine_activite"));
                responsable.setCellValueFactory(new PropertyValueFactory<>("nom_respo"));
                codeUnique.setCellValueFactory(new PropertyValueFactory<>("code_unique"));
                email.setCellValueFactory(new PropertyValueFactory<>("email_Assoc"));
                username.setCellValueFactory(new PropertyValueFactory<>("username"));
                password.setCellValueFactory(new PropertyValueFactory<>("password"));
                telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));       	
		AssociationTable.setItems(data);
	}
   
     
     
        public void senddataAssoc(javafx.scene.input.MouseEvent event) {
     
      
    	Association association = AssociationTable.getSelectionModel().getSelectedItem();
    	if(association == null) {
                viderassoc();
    		System.out.println("Nothing");
    	}else{
    		codeUTXT.setText(association.getCode_unique());
                  RespoTXT.setText(association.getNom_respo());
                nomAssTXT.setText(association.getNom_Assoc());
                domainTXT.setText(association.getDomaine_activite());
               telephoneTXT.setText(association.getTelephone());
                emailTXT.setText(association.getEmail_Assoc());
               PasswordTXT.setText(association.getPassword());
                usernameTXT.setText(association.getUsername());
    	}
    }
    public void viderassoc() {
		codeUTXT.setText("");
                  RespoTXT.setText("");
                nomAssTXT.setText("");
                domainTXT.setText("");
               telephoneTXT.setText("");
                emailTXT.setText("");
               PasswordTXT.setText("");
                usernameTXT.setText("");
    }
    @FXML
    private Button logoutbtn;
public void cancelbtnOnAction(ActionEvent event){
       Stage stage = (Stage) logoutbtn.getScene().getWindow();
       stage.close();
   }
@FXML
    private Button loadbtn;
public void loadbtnOnAction(ActionEvent event){
       viderassoc();
       viewAssociation();
   }
    

public void AsoociationAction(ActionEvent ev) {
        Connection conn = ConnectDB.connectionBD.conDB();
    	String code = codeUTXT.getText();
              String respo =    RespoTXT.getText();
           String nomAss =     nomAssTXT.getText();
            String domaine =    domainTXT.getText();
           String telephone =    telephoneTXT.getText();
           String email =     emailTXT.getText();
           String password =    PasswordTXT.getText();
           String user =     usernameTXT.getText();
        
      
      Association association = new Association();
       
    	if(ev.getSource() == Ajoutbtn) {	
               String sql1 = "INSERT INTO `association` (`nom_Assoc`, `domaine_activite`, `nom_responsable`, `code_unique`, `email_Assoc`, `username`, `password`, `telephone`) VALUES ( ?, ?, ?, ?,?,?,?,? ) ";
        
            try {
                preparedStatement = conn.prepareStatement(sql1);
               
                preparedStatement.setString(1, nomAss);
                preparedStatement.setString(2, domaine);
                preparedStatement.setString(3, respo);
                preparedStatement.setString(4, code);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, user);
                preparedStatement.setString(7, password);
                preparedStatement.setString(8, telephone);
                
              int rowsInserted =  preparedStatement.executeUpdate();
  
                if (rowsInserted > 0) {
                 System.out.println("A new user was inserted successfully!");
                viderassoc();
             viewAssociation();
                                        }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println("UnSuccessfull Insert");
            }
    	}
    	
    	if(ev.getSource() == updatebtn) {  
            //     String sql1 = "INSERT INTO `association` (`nom_Assoc`, `domaine_activite`, `nom_responsable`, `code_unique`, `email_Assoc`, `username`, `password`, `telephone`) VALUES ( ?, ?, ?, ?,?,?,?,? ) WHERE code_unique = ?";
           String sql1 = "UPDATE association SET nom_Assoc = ?, domaine_activite = ?, nom_responsable = ?,  email_Assoc =?,username = ?, password = ?, telephone =? WHERE code_unique = ?";
            try {
                preparedStatement = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
               
                preparedStatement.setString(1, nomAss);
                preparedStatement.setString(2, domaine);
                preparedStatement.setString(3, respo);
             
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, user);
                preparedStatement.setString(6, password);
                preparedStatement.setString(7, telephone);
                 preparedStatement.setString(8, code);
                int rowsInserted =  preparedStatement.executeUpdate();
  
                if (rowsInserted > 0) {
                 System.out.println("An existing user was updaADMINted successfully!");
                viderassoc();
               viewAssociation();
                                        }
                System.out.println("Successfull Update");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println(ex);
            }
    	}
    	
    	if(ev.getSource() == deletebtn) {
    		String sql1 = "DELETE FROM association WHERE code_unique = ? ";
            try {
                preparedStatement = conn.prepareStatement(sql1);
               
                
                preparedStatement.setString(1, code);
               
                
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                  System.out.println("A user was deleted successfully!");
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successfull Insert");
                alert.setContentText("Supprimé avec succes !!!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                        viderassoc();
                       viewAssociation();
                    }
                });
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println("UnSuccessfull Delete");
            }
    	}  	
    	viewAssociation();
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
                   

                } catch (IOException ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
   public void AssociationPage(Event e)
 {viewAssociation();
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
   

    
    
}
