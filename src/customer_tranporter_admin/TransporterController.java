package customer_tranporter_admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import level2term2.global_variable;
import successful_message.all_district;

public class TransporterController {

    String product = "";
    Integer order_id = 0;
    String supplier_status;
    String customer_status;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<transporter_table_data> transporter_dashboard;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_supplier_district;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_supplier_location;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_shop_name;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_customer_district;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_house_location;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_product_name;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_brand;

    @FXML
    private TableColumn<transporter_table_data, Integer> transporter_dashboard_amount;

    @FXML
    private TableColumn<transporter_table_data, Integer> transporter_dashboard_price;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_status_supplier;

    @FXML
    private TableColumn<transporter_table_data, String> transporter_dashboard_status_customer;

    @FXML
    private TableColumn<transporter_table_data, Integer> transporter_dashboard_id;

    @FXML
    private JFXTextField product_pin;

    @FXML
    private Text product_name;

    @FXML
    private JFXComboBox<pin_catagory> catagory_combobox;

    @FXML
    private JFXTextField new_user_name;

    @FXML
    private JFXPasswordField user_password;

    @FXML
    private JFXTextField new_contact_no;

    @FXML
    private JFXPasswordField contact_password;

    @FXML
    private JFXPasswordField old_password;

    @FXML
    private JFXPasswordField new_password;

    @FXML
    private JFXPasswordField confirm_password;

    @FXML
    private JFXTextField new_shop_location;

    @FXML
    private JFXComboBox<all_district> new_district_combobox;

    @FXML
    private JFXPasswordField location_password;

    @FXML
    private Text settings_result;
    
    @FXML
    private Text TNS_ID;

    private Integer ID;

    Thread T;

    private ObservableList<transporter_table_data> data;

    @FXML
    void change_contact_no(MouseEvent event) {

        try {

            String number = new_contact_no.getText();
            String new_password = contact_password.getText();
            if (new_password.equals(global_variable.password)) {
                String newsql = "UPDATE REGISTERED_TRANSPORTER \n"
                        + "SET CONTACT_NO = ? WHERE TRANSPORTER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setInt(1, Integer.parseInt(number));
                ps.setInt(2, ID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }

                rs.close();
                ps.close();

            } else {
                settings_result.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            settings_result.setText("INVALID PROCESS");
        }

    }

    @FXML
    void change_location(MouseEvent event) {

        try {

            String location = new_shop_location.getText();
            String district = new_district_combobox.getValue().toString();
            String new_password = location_password.getText();

            if (new_password.equals(global_variable.password)) {
                String newsql_location = "UPDATE REGISTERED_TRANSPORTER \n"
                        + "SET ADDRESS = ? WHERE TRANSPORTER_ID = ?";

                String newsql_district = "UPDATE REGISTERED_TRANSPORTER \n"
                        + "SET TRANSPORTER_DISTRICT = ? WHERE TRANSPORTER_ID = ?";

                PreparedStatement ps_location = global_variable.conn.prepareStatement(newsql_location);
                PreparedStatement ps_district = global_variable.conn.prepareStatement(newsql_district);

                ps_location.setString(1, location);
                ps_location.setInt(2, ID);

                ps_district.setString(1, district);
                ps_district.setInt(2, ID);

                ResultSet rs_location = ps_location.executeQuery();
                ResultSet rs_district = ps_district.executeQuery();

                if (rs_location.next() == true && rs_district.next() == true) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }

                rs_location.close();
                rs_district.close();
                ps_location.close();
                ps_district.close();

            } else {
                settings_result.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            settings_result.setText("INVALID PROCESS");
        }

    }

    @FXML
    void change_password(MouseEvent event) {

        try {

            String new_pass = new_password.getText();
            String old_pass = old_password.getText();
            String con_pass = confirm_password.getText();
            if (old_pass.equals(global_variable.password) == true && new_pass.equals(con_pass) == true) {
                String newsql = "UPDATE REGISTERED_TRANSPORTER \n"
                        + "SET PASSWORD = ? WHERE TRANSPORTER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, new_pass);
                ps.setInt(2, ID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                    global_variable.password = new_pass;
                } else {
                    settings_result.setText("FAILED");
                }

                rs.close();
                ps.close();

            } else {
                settings_result.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            settings_result.setText("INVALID PROCESS");
        }

    }

    @FXML
    void change_user_name(MouseEvent event) {

        try {

            String user_name = new_user_name.getText();
            String new_password = user_password.getText();
            if (new_password.equals(global_variable.password)) {
                String newsql = "UPDATE REGISTERED_TRANSPORTER \n"
                        + "SET TRANSPORTER_NAME = ? WHERE TRANSPORTER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, user_name);
                ps.setInt(2, ID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }

                rs.close();
                ps.close();

            } else {
                settings_result.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            settings_result.setText("INVALID PROCESS");
        }

    }

    @FXML
    void confirm_pin(MouseEvent event) throws SQLException {

        String cus_sup = catagory_combobox.getValue().toString();
        String sql = "";
        if (cus_sup.equals("CUSTOMER")) {
            sql = "SELECT CUSTOMER_PIN FROM ORDER_TABLE WHERE ORDER_ID = " + order_id.toString();
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(order_id);
            if (rs.next()) {
                customer_status = "YES";
                System.out.println(rs.getInt("CUSTOMER_PIN"));
                if (Integer.parseInt(product_pin.getText()) == rs.getInt("CUSTOMER_PIN")) {
                    String del_sql = "UPDATE  ORDER_TABLE SET SUCCESS_CUSTOMER = ?  WHERE ORDER_ID = " + order_id.toString();
                    PreparedStatement ps_del = global_variable.conn.prepareStatement(del_sql);
                    ps_del.setString(1, "YES");
                    ps_del.executeUpdate();

                    System.out.println(supplier_status + "   " + customer_status);
                    product_name.setText("SUCCESSFUL");
                    if(supplier_status.equals("YES") && customer_status.equals("YES"))
                    {
                        set_success();
                    }
                    initialize_transporter_dashboard();

                    ps_del.close();
                } else {
                    product_name.setText("FAILED");
                }
            }
            rs.close();
            ps.close();

        } else {
            System.out.println(order_id);
            sql = "SELECT SUPPLIER_PIN FROM ORDER_TABLE WHERE ORDER_ID = " + order_id.toString();
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                supplier_status = "YES";
                System.out.println(rs.getInt("SUPPLIER_PIN"));
                if (Integer.parseInt(product_pin.getText()) == rs.getInt("SUPPLIER_PIN")) {
                    String del_sql = "UPDATE  ORDER_TABLE SET SUCCESS_SUPPLIER_PIN = ? WHERE ORDER_ID = " + order_id.toString();
                    PreparedStatement ps_del = global_variable.conn.prepareStatement(del_sql);
                    ps_del.setString(1, "YES");
                    ps_del.executeUpdate();

                    System.out.println(supplier_status + "   " + customer_status);

                    ps_del.close();
                    if(supplier_status.equals("YES") && customer_status.equals("YES"))
                    {
                        set_success();
                    }
                    initialize_transporter_dashboard();
                    product_name.setText("SUCCESSFUL");

                } else {
                    product_name.setText("FAILED");
                }
            }
            rs.close();
            ps.close();
        }

    }

    @FXML
    void log_out(MouseEvent event) throws IOException {

        if (T.isAlive() == true) {
            T.stop();
        }
        Parent customer_page = FXMLLoader.load(getClass().getResource("/level2term2/FIRST_PAGE.fxml"));
        Scene customer_page_scene = new Scene(customer_page);
        Stage customer_stage;
        customer_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customer_stage.setTitle("Home Page");
        customer_stage.setScene(customer_page_scene);
        customer_stage.show();
    }

    @FXML
    void initialize() {
        assert transporter_dashboard != null : "fx:id=\"transporter_dashboard\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_supplier_district != null : "fx:id=\"transporter_dashboard_supplier_district\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_supplier_location != null : "fx:id=\"transporter_dashboard_supplier_location\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_customer_district != null : "fx:id=\"transporter_dashboard_customer_district\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_house_location != null : "fx:id=\"transporter_dashboard_house_location\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_product_name != null : "fx:id=\"transporter_dashboard_product_name\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_brand != null : "fx:id=\"transporter_dashboard_brand\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_amount != null : "fx:id=\"transporter_dashboard_amount\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_price != null : "fx:id=\"transporter_dashboard_price\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_status_supplier != null : "fx:id=\"transporter_dashboard_status_supplier\" was not injected: check your FXML file 'transporter.fxml'.";
        assert transporter_dashboard_status_customer != null : "fx:id=\"transporter_dashboard_status_customer\" was not injected: check your FXML file 'transporter.fxml'.";
        assert product_pin != null : "fx:id=\"product_pin\" was not injected: check your FXML file 'transporter.fxml'.";
        assert product_name != null : "fx:id=\"product_name\" was not injected: check your FXML file 'transporter.fxml'.";
        assert catagory_combobox != null : "fx:id=\"catagory_combobox\" was not injected: check your FXML file 'transporter.fxml'.";
        assert new_user_name != null : "fx:id=\"new_user_name\" was not injected: check your FXML file 'transporter.fxml'.";
        assert user_password != null : "fx:id=\"user_password\" was not injected: check your FXML file 'transporter.fxml'.";
        assert new_contact_no != null : "fx:id=\"new_contact_no\" was not injected: check your FXML file 'transporter.fxml'.";
        assert contact_password != null : "fx:id=\"contact_password\" was not injected: check your FXML file 'transporter.fxml'.";
        assert old_password != null : "fx:id=\"old_password\" was not injected: check your FXML file 'transporter.fxml'.";
        assert new_password != null : "fx:id=\"new_password\" was not injected: check your FXML file 'transporter.fxml'.";
        assert confirm_password != null : "fx:id=\"confirm_password\" was not injected: check your FXML file 'transporter.fxml'.";
        assert new_shop_location != null : "fx:id=\"new_shop_location\" was not injected: check your FXML file 'transporter.fxml'.";
        assert new_district_combobox != null : "fx:id=\"new_district_combobox\" was not injected: check your FXML file 'transporter.fxml'.";
        assert location_password != null : "fx:id=\"location_password\" was not injected: check your FXML file 'transporter.fxml'.";

        T = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    initialize_id();
                    transporter_dashboard_supplier_district.setCellValueFactory(new PropertyValueFactory<>("supplier_district"));
                    transporter_dashboard_supplier_location.setCellValueFactory(new PropertyValueFactory<>("supplier_location"));
                    transporter_dashboard_customer_district.setCellValueFactory(new PropertyValueFactory<>("customer_district"));
                    transporter_dashboard_house_location.setCellValueFactory(new PropertyValueFactory<>("customer_location"));
                    transporter_dashboard_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
                    transporter_dashboard_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
                    transporter_dashboard_price.setCellValueFactory(new PropertyValueFactory<>("price"));
                    transporter_dashboard_status_supplier.setCellValueFactory(new PropertyValueFactory<>("supplier_status"));
                    transporter_dashboard_status_customer.setCellValueFactory(new PropertyValueFactory<>("customer_status"));
                    transporter_dashboard_product_name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
                    transporter_dashboard_shop_name.setCellValueFactory(new PropertyValueFactory<>("shop_name"));
                    transporter_dashboard_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));

                    catagory_combobox.setItems(FXCollections.observableArrayList(pin_catagory.values()));
                    new_district_combobox.setItems(FXCollections.observableArrayList(all_district.values()));

                    initialize_transporter_dashboard();

                } catch (Exception E) {

                }

            }
        });

        T.start();

    }

    public void initialize_transporter_dashboard() throws SQLException {
        data = FXCollections.observableArrayList();

        String sql = "SELECT DISTINCT ORDER_ID,SHOP_NAME, SHOP_DISTRICT, SHOP_LOCATION, CUSTOMER_DISTRICT,"
                + " REGISTERED_CUSTOMER.ADDRESS,PRODUCT_NAME,CUSTOMER_NAME,AMOUNT,MONEY,SUCCESS_SUPPLIER_PIN,SUCCESS_CUSTOMER  \n"
                + "FROM ORDER_TABLE,REGISTERED_TRANSPORTER T,REGISTERED_SUPPLIER,REGISTERED_CUSTOMER,PRODUCT\n"
                + "WHERE TRANSPORTER_NO = " + ID.toString() + " AND SUPPLIER_ID = ORDER_SUPPLIER_NO AND CUSTOMER_ID = ORDER_CUSTOMER_NO \n"
                + " AND ORDER_PRODUCT_NO = PRODUCT_ID AND SUCCESS = 'NO' AND SUCCESS_SUPPLIER = 'YES' ";  //  AND SUCCESS_SUPPLIER = 'YES' 

        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new transporter_table_data(rs.getString("SHOP_DISTRICT"), rs.getString("SHOP_LOCATION"), rs.getString("SHOP_NAME"),
                    rs.getString("CUSTOMER_DISTRICT"), rs.getString("ADDRESS"), rs.getString("PRODUCT_NAME"),
                    rs.getString("CUSTOMER_NAME"), rs.getInt("AMOUNT"), rs.getInt("MONEY"),
                    rs.getString("SUCCESS_SUPPLIER_PIN"), rs.getString("SUCCESS_CUSTOMER"), rs.getInt("ORDER_ID")));
        }
        transporter_dashboard.setItems(data);

        /*rs.getString("SHOP_DISTRICT"), rs.getString("SHOP_LOCATION"), rs.getString("SHOP_NAME"),
                    rs.getString("CUSTOMER_DISTRICT"), rs.getString("REGISTERED_CUSTOMER.ADDRESS"), rs.getString("PRODUCT_NAME"),
                    rs.getString("BRAND"), rs.getInt("AMOUNT"), rs.getInt("MONEY"), "YES", "NO",rs.getInt("ORDER_ID")*/
        transporter_dashboard.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    product = transporter_dashboard.getSelectionModel().getSelectedItem().getProduct_name();
                    product_name.setText(product);
                    order_id = transporter_dashboard.getSelectionModel().getSelectedItem().getOrder_id();
                    supplier_status = transporter_dashboard.getSelectionModel().getSelectedItem().getSupplier_status();
                    customer_status = transporter_dashboard.getSelectionModel().getSelectedItem().getCustomer_status();

                } catch (Exception E) {

                }
            }
        });

    }

    public void initialize_id() throws SQLException {
        String sql = "SELECT TRANSPORTER_ID FROM REGISTERED_TRANSPORTER WHERE EMAIL = '" + global_variable.email + "' ";
        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ID = rs.getInt("TRANSPORTER_ID");
        }
        TNS_ID.setText("TRANSPORTER ID : "+ID.toString());
        rs.close();
        ps.close();
    }
    
    public void set_success() throws SQLException
    {
        System.out.println("sdfgsdfgd"  + order_id);    
        String sql = "UPDATE ORDER_TABLE SET SUCCESS = ? WHERE ORDER_ID = "+order_id.toString();
        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ps.setString(1, "YES");
        ps.executeUpdate();
        
    }

}
