/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import level2term2.global_variable;
import static level2term2.global_variable.conn;
import level2term2.shop_type_option;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Extra_info_supplierController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField shop_name;

    @FXML
    private JFXTextField shop_reg_number;

    @FXML
    private JFXTextField shop_street_road;

    @FXML
    private JFXComboBox<all_district> shop_district_combo;

    @FXML
    private JFXComboBox<shop_type_option> shop_combo;

    @FXML
    private JFXButton go_to_home_page;

    @FXML
    private Label upload_status;

    @FXML
    private JFXButton confirm_submission;

    @FXML
    private JFXTextField NID_num;
    
    @FXML
    private JFXButton owner;

    @FXML
    void confirm_all_submission(MouseEvent event) throws SQLException {

        String name_of_shop = "";
        String reg_num = "";
        String district = "";
        String shop_catagory = "";
        String NID = "";
        String road_post = "";
        try {

            name_of_shop = shop_name.getText();
            reg_num = shop_reg_number.getText();
            district = shop_district_combo.getValue().toString();
            shop_catagory = shop_combo.getValue().toString().toUpperCase();
            NID = NID_num.getText();
            road_post = shop_street_road.getText();

        } catch (Exception E) {
            upload_status.setText("FILLUP ALL");
        }

        try {
            Integer myId = 0;
            String sql_supplier = "Insert into REGISTERED_SUPPLIER(SUPPLIER_ID ,SUPPLIER_NAME,SUPPLIER_EMAIL,PASSWORD,SHOP_TYPE,SUPPLIER_MOBILE_NO,SHOP_LOCATION,SHOP_DISTRICT,SUPPLIER_NID,SHOP_NAME,SHOP_REGISTRATION_NUMBER) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = global_variable.conn.prepareStatement(sql_supplier);
            String sqlIdentifier = "select supplier.NEXTVAL from dual";
            PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
            synchronized (this) {
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    myId = rs.getInt(1);
                    System.out.println(myId);
                }
            }
            System.out.println(myId);
            ps.setInt(1, myId);
            ps.setString(2, global_variable.name);
            ps.setString(3, global_variable.email);
            ps.setString(4, global_variable.password);
            ps.setString(5, shop_catagory);
            ps.setString(6, global_variable.mobile_no_);
            ps.setString(7, road_post);
            ps.setString(8, district);
            ps.setString(9, NID);
            ps.setString(10, name_of_shop);
            ps.setString(11, reg_num);
            ps.executeUpdate();
            ps.close();
            upload_status.setText("SUCCESSFUL");
        } catch (Exception E) {
            upload_status.setText("FAILED");
        }

    }

    @FXML
    void switch_to_home_page(MouseEvent event) throws IOException {
        Stage at=(Stage)go_to_home_page.getScene().getWindow();
        at.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.shop_combo.setItems(FXCollections.observableArrayList(shop_type_option.values()));
        this.shop_district_combo.setItems(FXCollections.observableArrayList(all_district.values()));
    }

}
