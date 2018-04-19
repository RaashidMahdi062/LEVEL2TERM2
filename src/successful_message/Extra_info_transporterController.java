package successful_message;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import level2term2.global_variable;
import static level2term2.global_variable.conn;
import level2term2.shop_type_option;

public class Extra_info_transporterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField registration_proffession;

    @FXML
    private JFXTextField registration_address;

    @FXML
    private JFXComboBox<all_district> registration_district;

    @FXML
    private JFXDatePicker registration_date_of_birth;

    @FXML
    private Label registratin_status;

    @FXML
    private JFXTextField nid_transporter;
    
    @FXML
    private JFXComboBox<tsp> T_TC;
    @FXML
    private JFXButton owner;
    

    @FXML
    void back_to_homepage(MouseEvent event) throws IOException {
        
        Stage at=(Stage)owner.getScene().getWindow();
        at.close();
        
    }

    @FXML
    void submit_my_registration(MouseEvent event) {
        
        String profession = "";
        String address = "";
        String district = "";
        String bith_date = "";
        String t_type = "";
        String N_id = "";
        
        try{
            profession = registration_proffession.getText();
            address = registration_address.getText();
            district = registration_district.getValue().toString();
            bith_date = registration_date_of_birth.getValue().toString();
            t_type = T_TC.getValue().toString().toUpperCase();
            N_id = nid_transporter.getText();
        
        
        }catch(Exception E)
        {
            registratin_status.setText("FILLUP ALL");
        }
        
        try {

            String sql_transporter = "Insert into REGISTERED_TRANSPORTER(TRANSPORTER_ID ,TRANSPORTER_NAME,EMAIL,CONTACT_NO,PASSWORD,TRANSPORT,ADDRESS,TRANSPORTER_DISTRICT,TRANSPORTER_NID,TRANSPORTER_BIRTHDATE,TRANSPORTER_PROFESSION) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = global_variable.conn.prepareStatement(sql_transporter);
            long myId = 0;
            String sqlIdentifier = "select transporter.NEXTVAL from dual";
            PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
            synchronized (this) {
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    myId = rs.getLong(1);
                    System.out.println(myId);
                }
            }
            ps.setLong(1, myId);
            ps.setString(2, global_variable.name);
            ps.setString(3, global_variable.email);
            ps.setString(4, global_variable.mobile_no_);
            ps.setString(5, global_variable.password);
            ps.setString(6, t_type);
            ps.setString(7, address);
            ps.setString(8, district);
            ps.setString(9, N_id);
            ps.setString(10, bith_date);
            ps.setString(11, profession);
            ps.executeUpdate();
            ps.close();
            registratin_status.setText("SUCCESSFUL");

        } catch (Exception E) {
           registratin_status.setText("FAILED");
        }
    }

    @FXML
    void initialize() {
        assert registration_proffession != null : "fx:id=\"registration_proffession\" was not injected: check your FXML file 'extra_info_transporter.fxml'.";
        assert registration_address != null : "fx:id=\"registration_address\" was not injected: check your FXML file 'extra_info_transporter.fxml'.";
        assert registration_district != null : "fx:id=\"registration_district\" was not injected: check your FXML file 'extra_info_transporter.fxml'.";
        assert registration_date_of_birth != null : "fx:id=\"registration_date_of_birth\" was not injected: check your FXML file 'extra_info_transporter.fxml'.";
        assert registratin_status != null : "fx:id=\"registratin_status\" was not injected: check your FXML file 'extra_info_transporter.fxml'.";
        
        
        this.registration_district.setItems(FXCollections.observableArrayList(all_district.values()));
        this.T_TC.setItems(FXCollections.observableArrayList(tsp.values()));
        

    }
}
