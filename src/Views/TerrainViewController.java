
package Views;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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

import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Terrains;
import ConnectDB.connectionBD;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.Terrains;
import java.util.Observable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class TerrainViewController implements Initializable {
 Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField nomtxt;
private ObservableList<String> data = FXCollections.observableArrayList();
     @FXML
    private TextArea adressetxt;
    @FXML
    private TextField ID;
    @FXML
    private TextField superficietxt;

    @FXML
    private TextField typetxt;

    @FXML
    private TextField dispotxt;

    

    @FXML
    private Button ajoutbrn;

    @FXML
    private Button updatebtn;
@FXML
    private ComboBox<String> comboT;
    @FXML
    private Button deletebtn;
    @FXML
    private Button logoutbtn;
 @FXML
 private TableView<Terrains> TerrainTable;
    
    @FXML
    private TableColumn<Terrains,Integer > idCol;
    @FXML
    private TableColumn<Terrains,String > nomCol;
    @FXML
    private TableColumn<Terrains, String> adresseCol;
    @FXML
    private TableColumn<Terrains, String> superficieCol;
    @FXML
    private TableColumn<Terrains, String> dispoCol;
    @FXML
    private TableColumn<Terrains, String> typeCol;
    private TableColumn<Terrains, String> editCol;
    
   private final ObservableList<Terrains>  TerrainsList = FXCollections.observableArrayList();
 
  
   @FXML
    private Button load; 
 public void LoadbtnOnAction(ActionEvent event){
     TerrainTable.getItems().clear();
       viewTerrain();
       vidertrans();
       fillComboboxterrain();
   }   
private void viewTerrain() {

       
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;	
    Terrains terrain = new Terrains();
       
    TerrainTable.getItems().clear();
		try {
			con = ConnectDB.connectionBD.conDB();
                        String sql1 = ("SELECT terrain.id, terrain.Nom, terrain.Adresse, terrain.Superficie, terrain.Disponibilite,terrain.type_id, terrain_type.type FROM terrain INNER JOIN terrain_type ON terrain_type.type_id = terrain.type_id ");
                        
                         preparedStatement = con.prepareStatement(sql1);
			 resultSet = preparedStatement.executeQuery();
                        
			while(resultSet.next()) {
                            TerrainsList.add(new Terrains(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString("terrain_type.type")));
                                         
			}
			
		}catch(Exception e) {
		}
                idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
                nomCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		adresseCol.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
                superficieCol.setCellValueFactory(new PropertyValueFactory<>("Superficie"));
                dispoCol.setCellValueFactory(new PropertyValueFactory<>("Disponibilite"));
                typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
      
                TerrainTable.setItems(TerrainsList);
	}
 
 
 public void senddataTerains(javafx.scene.input.MouseEvent event) {
     
      
    	Terrains terain = TerrainTable.getSelectionModel().getSelectedItem();
    	if(terain == null) {
                vidertrans();
    		System.out.println("Nothing");
    	}else{
    		nomtxt.setText(terain.getNom());
    		adressetxt.setText(terain.getAdresse());
        	superficietxt.setText(terain.getSuperficie());
                comboT.setValue(terain.getType());
                // typetxt.setText(terain.getType());
                dispotxt.setText(terain.getDisponibilite());
                ID.setText(Integer.toString(terain.getId()));
    	}
    }
    public void vidertrans() {
		nomtxt.setText("");
		adressetxt.setText("");
                superficietxt.setText("");
                typetxt.setText("");
                dispotxt.setText(null);
                comboT.setValue("");
                ID.setText("");
	}
 private ObservableList<String> data2 = FXCollections.observableArrayList();
    public void fillComboboxterrain() {
        Connection co = ConnectDB.connectionBD.conDB();
        comboT.getItems().removeAll(comboT.getItems());
       
        
    		
        try {
            String sqltype = " SELECT  `type` FROM `terrain_type` ";
            preparedStatement = co.prepareStatement(sqltype);
            ResultSet RS = preparedStatement.executeQuery(sqltype);
            
            while (RS.next()) {
                
            	data2.add(new String(RS.getString(1)));
            }
            RS.close();
             
        } catch (Exception e) {
            
            e.printStackTrace();
        }
       comboT.setItems(data2);
    }
    public void TerrainsAction(ActionEvent ev) {
        Connection conn = ConnectDB.connectionBD.conDB();
    	String nomT = nomtxt.getText().toUpperCase();
        String Adresse = adressetxt.getText().toUpperCase();
        String Superficie = superficietxt.getText();    
        String disponible = dispotxt.getText().toUpperCase();
        String typeT = comboT.getValue();
        String id = ID.getText();
        
      
      Terrains terrain = new Terrains();
       
    	if(ev.getSource() == ajoutbrn) {	
               String sql1 = "INSERT INTO terrain (Nom, Adresse, Superficie, Disponibilite, type_id) SELECT ?, ?, ?, ?, type_id FROM terrain_type WHERE type = ?";
        
            try {
                preparedStatement = conn.prepareStatement(sql1);
               
                preparedStatement.setString(1, nomT);
                preparedStatement.setString(2, Adresse);
                preparedStatement.setString(3, Superficie);
                preparedStatement.setString(4, disponible);
                preparedStatement.setString(5, typeT);
                 
              int rowsInserted =  preparedStatement.executeUpdate();
  
                if (rowsInserted > 0) {
                 System.out.println("A new user was inserted successfully!");
                 vidertrans();
       viewTerrain();
                                        }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println("UnSuccessfull Insert");
            }
    	}
    	
    	if(ev.getSource() == updatebtn) {  
                //String sql1 = "INSERT INTO transport VALUES (default,'" + trans.getImmatricule() + "','" + trans.getMarque()+ "','" + trans.getModel() + "','" + trans.getDisponibilite() + "')";            
           String sql1 = "UPDATE terrain SET Nom = ?, Adresse = ?, Superficie = ?, Disponibilite = ?, type_id = (SELECT type_id FROM terrain_type WHERE type = ?) WHERE Nom = ?";
            try {
                preparedStatement = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
               
                preparedStatement.setString(1, nomT);
                preparedStatement.setString(2, Adresse);
                preparedStatement.setString(3, Superficie);
                preparedStatement.setString(4, disponible);
                preparedStatement.setString(5, typeT);
                preparedStatement.setString(6, nomT);
                int rowsInserted =  preparedStatement.executeUpdate();
  
                if (rowsInserted > 0) {
                 System.out.println("An existing user was updated successfully!");
                 vidertrans();
       viewTerrain() ;
                                        }
                System.out.println("Successfull Update");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println(ex);
            }
    	}
    	
    	if(ev.getSource() == deletebtn) {
    		String sql1 = "DELETE FROM terrain WHERE Nom = ? AND type_id = (SELECT type_id FROM terrain_type WHERE type = ?)";
            try {
                preparedStatement = conn.prepareStatement(sql1);
               
                
                preparedStatement.setString(1, nomT);
                preparedStatement.setString(2, typeT);
                
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
                        vidertrans();
       viewTerrain() ;
                    }
                });
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.out.println("UnSuccessfull Delete");
            }
    	}  	
    	viewTerrain() ;
    }
    
    
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
      viewTerrain() ;
      fillComboboxterrain();
    }    
    
}
