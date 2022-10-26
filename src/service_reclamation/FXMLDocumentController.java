/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_reclamation;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author khchi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private TableView<reclamation> table;
    @FXML
    private TableColumn<reclamation,Integer> colid;
    @FXML
    private TableColumn<reclamation,Integer> colclient_id;
    @FXML
    private TableColumn<reclamation,String> colsujet;
    @FXML
    private TableColumn<reclamation,String> coldescription;
    @FXML
    private TextField ID;
    @FXML
    private TextField CLIENT_ID;
    @FXML
    private TextField SUJET;
    @FXML
    private TextArea DESC;
    @FXML
    private Button supp;
    @FXML
    private Button update;
    @FXML
    private TextField ID1;

    /**
     * Initializes the controller class.
     */
    
    Connection conx=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
       show1();
    }    
@FXML
    private void show1() {
          service ps= new service();
        ArrayList<reclamation> list = new ArrayList<>();
        try {
            list=(ArrayList<reclamation>) ps.getAllreclamations();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<reclamation> obsl = FXCollections.observableArrayList(list);
        table.setItems(obsl);
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colclient_id.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        colsujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
       

    }
   

    @FXML
    private void handleButtonAction(ActionEvent event) {
        ajouter();
    }

    @FXML
    private void btnsupp(ActionEvent event) {
        supp();
    }
    @FXML
    private void update(ActionEvent event) {
        update();
    }
    
    private void executeQuery(String query){
     Connection conx = mysqlconnect.connectDB();
      Statement st;
     try{
    st = conx.createStatement();
    st.executeUpdate(query);
      }catch(Exception ex){
      ex.printStackTrace();
 }
   }
    private void ajouter() {
   String query = "insert into reclamation VALUES("+ID.getText()+","+CLIENT_ID.getText()+",'" +SUJET.getText()+ "','" +DESC.getText()+"')";
       
         
           executeQuery(query);
       show1();
        JOptionPane.showMessageDialog(null, "reclamation ajouter avec success");
       
         
}
      
private void supp(){
    String query = "DELETE  from reclamation  WHERE id =" + ID1.getText() +"";


        int a= JOptionPane.showConfirmDialog(null, "voulez vous vraiment SUPPRIMER cette reclamation?","select",JOptionPane.YES_NO_OPTION);
        if(a==1)
        {
           show1();
        }
        else {
            executeQuery(query);
        show1();}        
 }

private void update(){
    String query = "UPDATE reclamation  SET client_id = '" +CLIENT_ID.getText()+"',sujet='"+SUJET.getText()+"',description='"+DESC.getText()+"' WHERE id =" + ID.getText()+"";


      int a= JOptionPane.showConfirmDialog(null, "voulez vous vraiment MODIFIER cette reclamation?","select",JOptionPane.YES_NO_OPTION);
        if(a==1)
        {
           show1();
        }
        else {
            executeQuery(query);
        show1();}        

 }
@FXML
    private void Clicked(MouseEvent event) {
       
   reclamation reclamation = table.getSelectionModel().getSelectedItem();
    ID.setText(""+ reclamation.getId());
    CLIENT_ID.setText(""+ reclamation.getClient_id());
    SUJET.setText(""+ reclamation.getSujet());
    DESC.setText(""+ reclamation.getDescription());
    
   
   
    }
}
