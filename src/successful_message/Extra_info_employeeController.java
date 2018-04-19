package successful_message;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import level2term2.global_variable;
import static level2term2.global_variable.conn;

public class Extra_info_employeeController {

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
    private JFXButton owner;

    @FXML
    private JFXTextField nid_cus;

    @FXML
    void back_to_homepage(MouseEvent event) {
        Stage at = (Stage) owner.getScene().getWindow();
        at.close();
    }

    @FXML
    void submit_my_registration(MouseEvent event) throws SQLException {

        String profession_cus = "";
        String address_cus = "";
        String district_cus = "";
        String b_day = "";
        String n_id_customer = "";

        try {

            profession_cus = registration_proffession.getText();
            address_cus = registration_address.getText();
            district_cus = registration_district.getValue().toString();
            b_day = registration_date_of_birth.getValue().toString();
            n_id_customer = nid_cus.getText();

        } catch (Exception E) {
            registratin_status.setText("FILLUP ALL");
        }

        String sql_supplier = "Insert into REGISTERED_EMPLOYEE(EMPLOYEE_ID ,"
                + "EMPLOYEE_NAME,EMAIL,CONTACT_NO,PASSWORD,"
                + "JOB_EXPERIENCE,ADDRESS,EMPLOYEE_DISTRICT,EMPLOYEE_NID,EMPLOYEE_BIRTHDATE)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = global_variable.conn.prepareStatement(sql_supplier);
        String sqlIdentifier = "select employee.NEXTVAL from dual";
        PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
        Integer myId = 0;
        synchronized (this) {
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                myId = rs.getInt(1);
                System.out.println(myId);
            }
        }
        //System.out.println(myId);
        ps.setInt(1, myId);
        ps.setString(2, global_variable.name);
        ps.setString(3, global_variable.email);
        ps.setString(4, global_variable.mobile_no_);
        ps.setString(5, global_variable.password);
        ps.setString(6, profession_cus);
        ps.setString(7, address_cus);
        ps.setString(8, district_cus);
        ps.setString(9, n_id_customer);
        ps.setString(10, b_day);
        ps.executeUpdate();
        ps.close();
        registratin_status.setText("SUCCESSFUL");

    }

    @FXML
    void initialize() {
        assert registration_proffession != null : "fx:id=\"registration_proffession\" was not injected: check your FXML file 'extra_info_employee.fxml'.";
        assert registration_address != null : "fx:id=\"registration_address\" was not injected: check your FXML file 'extra_info_employee.fxml'.";
        assert registration_district != null : "fx:id=\"registration_district\" was not injected: check your FXML file 'extra_info_employee.fxml'.";
        assert registration_date_of_birth != null : "fx:id=\"registration_date_of_birth\" was not injected: check your FXML file 'extra_info_employee.fxml'.";
        assert registratin_status != null : "fx:id=\"registratin_status\" was not injected: check your FXML file 'extra_info_employee.fxml'.";
        assert owner != null : "fx:id=\"owner\" was not injected: check your FXML file 'extra_info_employee.fxml'.";
        assert nid_cus != null : "fx:id=\"nid_cus\" was not injected: check your FXML file 'extra_info_employee.fxml'.";

        this.registration_district.setItems(FXCollections.observableArrayList(all_district.values()));

    }
}
