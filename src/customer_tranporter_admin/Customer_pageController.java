package customer_tranporter_admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import level2term2.global_variable;
import successful_message.all_district;

public class Customer_pageController {

    Integer customer_id = 0;
    String strc = "";
    Integer advertise_product_id = 0;

    //for showing details of product
    String product_name;
    String product_brand;
    String product_catagory;
    Integer product_price;
    String pin_number;
    Integer transporter_number;

    String web_image_video = "IMAGE";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab order_product_search_field;
    @FXML
    private Tab ord;
    @FXML
    private JFXTabPane tabpanes;

    @FXML
    private AnchorPane tab_pane;

    @FXML
    private TableView<order_product> order_product_table;

    @FXML
    private TableColumn<order_product, String> order_product_name;

    @FXML
    private TableColumn<order_product, String> order_product_brand;

    @FXML
    private TableColumn<order_product, String> order_product_catagory;

    @FXML
    private TableColumn<order_product, Integer> order_product_price;

    @FXML
    private JFXComboBox<price_range_all> order_product_price_range;

    @FXML
    private Text order_product_details_warranty;

    @FXML
    private Text order_product_details_release_date;

    @FXML
    private Text order_product_details_price;

    @FXML
    private Text order_product_details_name;

    @FXML
    private Text order_product_details_about_it;

    @FXML
    private WebView order_product_web_view;

    @FXML
    private JFXTextField order_product_amount;

    @FXML
    private JFXTextField search_by_name;
    @FXML
    private JFXButton searchbtn;
    @FXML
    private JFXButton addcartbtn;

    @FXML
    private TableView<added_to_cart1> aded_to_cart_product_table;

    @FXML
    private TableColumn<added_to_cart1, String> aded_to_cart_product_name;

    @FXML
    private TableColumn<added_to_cart1, String> aded_to_cart_product_brand;

    @FXML
    private TableColumn<added_to_cart1, Integer> aded_to_cart_product_price;

    @FXML
    private TableColumn<added_to_cart1, Integer> aded_to_cart_product_amount;

    @FXML
    private TableColumn<added_to_cart1, Integer> aded_to_cart_product_pin;

    @FXML
    private TableColumn<added_to_cart1, Integer> aded_to_cart_product_transporter_id;

    @FXML
    private TableView<added_to_cart2> aded_to_cart_shop_table;

    @FXML
    private TableColumn<added_to_cart2, String> aded_to_cart_shop_product_name;

    @FXML
    private TableColumn<added_to_cart2, String> aded_to_cart_shop_name;

    @FXML
    private TableColumn<added_to_cart2, String> aded_to_cart_shop_district;

    @FXML
    private TableColumn<added_to_cart2, String> aded_to_cart_shop_road_location;

    @FXML
    private Text aded_to_cart_shop_status;

    @FXML
    private TableView<customer_total_orders> order_record_table;

    @FXML
    private TableColumn<customer_total_orders, String> order_record_name;

    @FXML
    private TableColumn<customer_total_orders, String> order_record_brand;

    @FXML
    private TableColumn<customer_total_orders, Integer> order_record_price;

    @FXML
    private TableColumn<customer_total_orders, Integer> order_record_amount;

    @FXML
    private TableColumn<customer_total_orders, Integer> order_record_transporter_id;

    @FXML
    private TableColumn<customer_total_orders, String> order_record_delivery_status;

    @FXML
    private TableColumn<customer_total_orders, Integer> pin;

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
    private Text change_status;

    @FXML
    private TableView<advertise> add_table;

    @FXML
    private TableColumn<advertise, String> add_table_name;

    @FXML
    private TableColumn<advertise, String> add_table_brand;

    @FXML
    private TableColumn<advertise, Integer> add_table_price;

    @FXML
    private Text user_name;

    @FXML
    private Text user_id;

    @FXML
    private Text user_district;

    @FXML
    private Text user_location;

    @FXML
    private Text add_cart_successful;

    @FXML
    private JFXButton orderbtn;

    private ObservableList<advertise> data_add;
    private ObservableList<order_product> data_order;
    private ObservableList<customer_total_orders> dataordered;
    private ObservableList<added_to_cart1> data_cart1;
    private ObservableList<added_to_cart2> data_cart2;

    Thread T = null;

    @FXML
    void aded_to_cart_shop_cancel_order(MouseEvent event) {
        aded_to_cart_shop_table.getItems().removeAll(data_cart2);
        aded_to_cart_product_table.getItems().removeAll(data_cart1);

    }

    @FXML
    void aded_to_cart_shop_order(MouseEvent event) throws SQLException, IOException {

        //changable
        Integer sid = 0;
        Integer pri = aded_to_cart_product_table.getSelectionModel().getSelectedItem().getPrice();
        Integer am = aded_to_cart_product_table.getSelectionModel().getSelectedItem().getAmount();
        String sname = aded_to_cart_shop_table.getSelectionModel().getSelectedItem().getShop_name();
        String dname = aded_to_cart_shop_table.getSelectionModel().getSelectedItem().getDistrict();
        String lname = aded_to_cart_shop_table.getSelectionModel().getSelectedItem().getRoad_location();
        String pname = aded_to_cart_shop_table.getSelectionModel().getSelectedItem().getProduct_name();
        aded_to_cart_product_table.getItems().removeAll(aded_to_cart_product_table.getSelectionModel().getSelectedItem());
        aded_to_cart_shop_table.getItems().removeAll(aded_to_cart_shop_table.getSelectionModel().getSelectedItem());
        PreparedStatement pst = null;
        String que = "SELECT SUPPLIER_ID FROM REGISTERED_SUPPLIER WHERE SHOP_NAME = ? AND SHOP_LOCATION = ? AND SHOP_DISTRICT = ? ";
        pst = global_variable.conn.prepareStatement(que);
        pst.setString(1, sname);
        pst.setString(2, lname);
        pst.setString(3, dname);
        ResultSet rse = pst.executeQuery();
        if (rse.next()) {
            sid = rse.getInt("SUPPLIER_ID");
        }
        pst.close();
        rse.close();
        String query = "{? = call GET_PRO_ID(?)}";
        CallableStatement stmt1 = global_variable.conn.prepareCall(query);
        stmt1.setString(2, pname);
        global_variable.product_name = pname;
        stmt1.registerOutParameter(1, Types.INTEGER);
        stmt1.execute();
        Integer pid = stmt1.getInt(1);
        String quer = "{ ? = call GET_SEQUENCE(?)}";
        CallableStatement stmt = global_variable.conn.prepareCall(quer);
        stmt.setString(2, "ORDER");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        Integer seri = stmt.getInt(1);
        String quer1 = "{ ? = call GET_SEQUENCE(?)}";
        CallableStatement stmt2 = global_variable.conn.prepareCall(quer);
        stmt.setString(2, "SUPPLIER_PIN");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        Integer serip = stmt.getInt(1);
        String insert = "Insert into ORDER_TABLE(ORDER_ID ,ORDER_CUSTOMER_NO,ORDER_SUPPLIER_NO,ORDER_PRODUCT_NO,TRANSPORTER_NO,AMOUNT,MONEY,SUPPLIER_PIN,CUSTOMER_PIN) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst1 = global_variable.conn.prepareStatement(insert);
        pst1.setInt(1, seri);
        pst1.setInt(2, customer_id);
        pst1.setInt(3, sid);
        pst1.setInt(4, pid);
        pst1.setInt(5, transporter_number);
        pst1.setInt(6, am);
        if (strc.equalsIgnoreCase("DHAKA")) {
            pst1.setInt(7, (pri * am) + 50);
            global_variable.price = (pri * am) + 50;
        } else {
            pst1.setInt(7, (pri * am) + 100);
            global_variable.price = (pri * am) + 100;
        }
        pst1.setInt(8, serip);
        pst1.setInt(9, Integer.parseInt(pin_number));
        ResultSet rst1 = pst1.executeQuery();

        rst1.next();
        order_record_table.getItems().removeAll(dataordered);
        order_record_table_initialize();
        pst1.close();
        rst1.close();

        /*---------------------------------------------------------------------*/
        global_variable.amount = am;
        global_variable.secret_pin = pin_number;

        Stage tag = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("receipt.fxml"));
        //Text tx = new Text("kichu to aai");
        Parent root1 = (Parent) loader.load();
        tag.setScene(new Scene(root1));
        tag.initStyle(StageStyle.UNDECORATED);
        tag.initModality(Modality.APPLICATION_MODAL);
        tag.initOwner(orderbtn.getScene().getWindow());

        tag.showAndWait();

        data_cart2 = FXCollections.observableArrayList();
        aded_to_cart_shop_table.setItems(data_cart2);

    }

    @FXML
    void change_contact_no(MouseEvent event) {

        try {

            String number = new_contact_no.getText();
            String new_password = contact_password.getText();
            if (new_password.equals(global_variable.password)) {
                String newsql = "UPDATE REGISTERED_CUSTOMER \n"
                        + "SET CUSTOMER_CONTACT_NO = ? WHERE CUSTOMER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setInt(1, Integer.parseInt(number));
                ps.setInt(2, customer_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    change_status.setText("SUCCESSFUL");
                } else {
                    change_status.setText("FAILED");
                }
                //nam_id_initialize();
                rs.close();
                ps.close();
                customer_initialize();
            } else {
                change_status.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            change_status.setText("INVALID PROCESS");
        }

    }

    @FXML
    void change_location(MouseEvent event) {

        try {

            String location = new_shop_location.getText();
            String district = new_district_combobox.getValue().toString();
            String new_password = location_password.getText();

            if (new_password.equals(global_variable.password)) {
                String newsql_location = "UPDATE REGISTERED_CUSTOMER \n"
                        + "SET ADDRESS = ? WHERE CUSTOMER_ID = ?";

                String newsql_district = "UPDATE REGISTERED_CUSTOMER \n"
                        + "SET CUSTOMER_DISTRICT = ? WHERE CUSTOMER_ID = ?";

                PreparedStatement ps_location = global_variable.conn.prepareStatement(newsql_location);
                PreparedStatement ps_district = global_variable.conn.prepareStatement(newsql_district);

                ps_location.setString(1, location);
                ps_location.setInt(2, customer_id);

                ps_district.setString(1, district);
                ps_district.setInt(2, customer_id);

                ResultSet rs_location = ps_location.executeQuery();
                ResultSet rs_district = ps_district.executeQuery();

                if (rs_location.next() == true && rs_district.next() == true) {
                    change_status.setText("SUCCESSFUL");
                } else {
                    change_status.setText("FAILED");
                }

                rs_location.close();
                rs_district.close();
                ps_location.close();
                ps_district.close();
                customer_initialize();

            } else {
                change_status.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            change_status.setText("INVALID PROCESS");
        }

    }

    @FXML
    void change_password(MouseEvent event) {

        try {

            String new_pass = new_password.getText();
            String old_pass = old_password.getText();
            String con_pass = confirm_password.getText();
            if (old_pass.equals(global_variable.password) == true && new_pass.equals(con_pass) == true) {
                String newsql = "UPDATE REGISTERED_CUSTOMER \n"
                        + "SET PASSWORD = ? WHERE CUSTOMER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, new_pass);
                ps.setInt(2, customer_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    change_status.setText("SUCCESSFUL");
                } else {
                    change_status.setText("FAILED");
                }
                global_variable.password = new_pass;

                rs.close();
                ps.close();
                customer_initialize();

            } else {
                change_status.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            change_status.setText("INVALID PROCESS");
        }

    }

    @FXML
    void change_user_name(MouseEvent event) {

        try {

            String user_name = new_user_name.getText();
            String new_password = user_password.getText();
            if (new_password.equals(global_variable.password)) {
                String newsql = "UPDATE REGISTERED_CUSTOMER \n"
                        + "SET CUSTOMER_NAME = ? WHERE CUSTOMER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, user_name);
                ps.setInt(2, customer_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    change_status.setText("SUCCESSFUL");
                } else {
                    change_status.setText("FAILED");
                }

                //nam_id_initialize();
                rs.close();
                ps.close();
                customer_initialize();

            } else {
                change_status.setText("INVALID PASSWORD");
            }

        } catch (Exception E) {
            change_status.setText("INVALID PROCESS");
        }

    }

    Integer get_random_number() {
        Integer rand = 0;
        int min = 223;
        int max = 100;
        Random getRandom = new Random();
        rand = min + getRandom.nextInt(max);
        return rand;
    }

    @FXML
    void order_product_add_to_cart(MouseEvent event) throws SQLException {

        //data_cart1.add(new added_to_cart1(product_name, product_brand, product_price, Integer.parseInt(order_product_amount.getText()), Integer.parseInt(tg),get_random_number()));
        if (Integer.parseInt(order_product_amount.getText()) > 0) {
            data_cart1.add(new added_to_cart1(product_name, product_brand, product_price, Integer.parseInt(order_product_amount.getText()), "----", "----"));
            aded_to_cart_product_table.setItems(data_cart1);
            add_cart_successful.setText("CHECK YOUR CART");
        }

    }

    @FXML
    void order_product_search(MouseEvent event) throws SQLException {
        //tabpanes.getTabs().indexOf(ord);

        aded_to_cart_shop_status.setText("");
        order_product_amount.setText("");
        String price_range;
        try {
            price_range = order_product_price_range.getValue().toString();
        } catch (Exception E) {
            price_range = "MORE_THAN_1000001";
        }

        String[] part = price_range.split("_");
        Integer upper_limit = 0;
        Integer lower_limit = 0;
        System.out.println(price_range);
        if (part[0].equals("MORE")) {
            upper_limit = 2000000000;
            lower_limit = 1000001;
        } else {
            upper_limit = Integer.parseInt(part[3]);
            lower_limit = Integer.parseInt(part[1]);
        }

        System.out.println(upper_limit + "   " + lower_limit);

        //order_product_table.getItems().removeAll(data_order);
        data_order = FXCollections.observableArrayList();
        order_product_table.setItems(data_order);
        String pro = "";
        try {
            pro = search_by_name.getText().toString().toUpperCase();
        } catch (Exception E) {
            pro = "ALL";
        }
        System.out.println(pro);

        String seq = "SELECT for_search.NEXTVAL from dual";
        PreparedStatement psseq = global_variable.conn.prepareStatement(seq);
        ResultSet rsseq = psseq.executeQuery();
        rsseq.next();

        String que = "SELECT * FROM PRODUCT WHERE PRODUCT_TYPE= ? AND PRICE BETWEEN ? AND ?";
        PreparedStatement pss = null;

        if (pro.equals("ALL")) {
            que = "SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ?";
            pss = global_variable.conn.prepareStatement(que);
            pss.setInt(1, lower_limit);
            pss.setInt(2, upper_limit);

        } else {
            que = "SELECT * FROM PRODUCT WHERE PRODUCT_TYPE = ? AND PRICE BETWEEN ? AND ?";
            pss = global_variable.conn.prepareStatement(que);
            pss.setString(1, pro);
            pss.setInt(2, lower_limit);
            pss.setInt(3, upper_limit);
        }

        ResultSet rss = pss.executeQuery();
        if (!rss.next()) {
            pss = global_variable.conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE ?  AND PRICE BETWEEN ? AND ?");
            pss.setString(1, "%" + pro + "%");
            pss.setInt(2, lower_limit);
            pss.setInt(3, upper_limit);
            rss = pss.executeQuery();
        } else {
            String adver = "INSERT INTO SEARCH_TABLE (SEARCH_ID,CUSTOMER_NO,SEARCH_PRODUCT) VALUES (? , ? ,? )";
            PreparedStatement pst42 = global_variable.conn.prepareStatement(adver);
            pst42.setInt(1, rsseq.getInt(1));
            pst42.setInt(2, customer_id);
            pst42.setString(3, rss.getString("PRODUCT_TYPE"));
            ResultSet rst42 = pst42.executeQuery();
            rst42.next();
            pst42.close();
            rst42.close();
            data_order.add(new order_product(rss.getString("PRODUCT_NAME"), rss.getString("BRAND"), rss.getString("PRODUCT_TYPE"),
                    rss.getInt("PRICE")));
            order_product_table.setItems(data_order);
        }

        while (rss.next()) {

            seq = "SELECT for_search.NEXTVAL from dual";
            psseq = global_variable.conn.prepareStatement(seq);
            rsseq = psseq.executeQuery();
            rsseq.next();

            String adver = "INSERT INTO SEARCH_TABLE (SEARCH_ID,CUSTOMER_NO,SEARCH_PRODUCT) VALUES (? , ? ,? )";
            PreparedStatement pst42 = global_variable.conn.prepareStatement(adver);
            pst42.setInt(1, rsseq.getInt(1));
            pst42.setInt(2, customer_id);
            pst42.setString(3, rss.getString("PRODUCT_TYPE"));
            ResultSet rst42 = pst42.executeQuery();
            rst42.next();
            pst42.close();
            rst42.close();
            data_order.add(new order_product(rss.getString("PRODUCT_NAME"), rss.getString("BRAND"), rss.getString("PRODUCT_TYPE"),
                    rss.getInt("PRICE")));
            order_product_table.setItems(data_order);
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
        assert order_product_search_field != null : "fx:id=\"order_product_search_field\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert tab_pane != null : "fx:id=\"tab_pane\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_table != null : "fx:id=\"order_product_table\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_name != null : "fx:id=\"order_product_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_brand != null : "fx:id=\"order_product_brand\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_catagory != null : "fx:id=\"order_product_catagory\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_price != null : "fx:id=\"order_product_price\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_price_range != null : "fx:id=\"order_product_price_range\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_details_warranty != null : "fx:id=\"order_product_details_warranty\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_details_release_date != null : "fx:id=\"order_product_details_release_date\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_details_price != null : "fx:id=\"order_product_details_price\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_details_name != null : "fx:id=\"order_product_details_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_details_about_it != null : "fx:id=\"order_product_details_about_it\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_web_view != null : "fx:id=\"order_product_web_view\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_product_amount != null : "fx:id=\"order_product_amount\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_table != null : "fx:id=\"aded_to_cart_product_table\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_name != null : "fx:id=\"aded_to_cart_product_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_brand != null : "fx:id=\"aded_to_cart_product_brand\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_price != null : "fx:id=\"aded_to_cart_product_price\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_amount != null : "fx:id=\"aded_to_cart_product_amount\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_pin != null : "fx:id=\"aded_to_cart_product_pin\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_product_transporter_id != null : "fx:id=\"aded_to_cart_product_transporter_id\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_shop_table != null : "fx:id=\"aded_to_cart_shop_table\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_shop_product_name != null : "fx:id=\"aded_to_cart_shop_product_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_shop_name != null : "fx:id=\"aded_to_cart_shop_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_shop_district != null : "fx:id=\"aded_to_cart_shop_district\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_shop_road_location != null : "fx:id=\"aded_to_cart_shop_road_location\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert aded_to_cart_shop_status != null : "fx:id=\"aded_to_cart_shop_status\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_table != null : "fx:id=\"order_record_table\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_name != null : "fx:id=\"order_record_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_brand != null : "fx:id=\"order_record_brand\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_price != null : "fx:id=\"order_record_price\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_amount != null : "fx:id=\"order_record_amount\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_transporter_id != null : "fx:id=\"order_record_transporter_id\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert order_record_delivery_status != null : "fx:id=\"order_record_delivery_status\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert new_user_name != null : "fx:id=\"new_user_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert user_password != null : "fx:id=\"user_password\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert new_contact_no != null : "fx:id=\"new_contact_no\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert contact_password != null : "fx:id=\"contact_password\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert old_password != null : "fx:id=\"old_password\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert new_password != null : "fx:id=\"new_password\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert confirm_password != null : "fx:id=\"confirm_password\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert new_shop_location != null : "fx:id=\"new_shop_location\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert new_district_combobox != null : "fx:id=\"new_district_combobox\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert location_password != null : "fx:id=\"location_password\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert settings_result != null : "fx:id=\"settings_result\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert add_table != null : "fx:id=\"add_table\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert add_table_name != null : "fx:id=\"add_table_name\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert add_table_brand != null : "fx:id=\"add_table_brand\" was not injected: check your FXML file 'customer_page.fxml'.";
        assert add_table_price != null : "fx:id=\"add_table_price\" was not injected: check your FXML file 'customer_page.fxml'.";

        T = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    data_add = FXCollections.observableArrayList();

                    data_cart1 = FXCollections.observableArrayList();
                    data_cart2 = FXCollections.observableArrayList();
                    dataordered = FXCollections.observableArrayList();

                    order_product_price_range.setItems(FXCollections.observableArrayList(price_range_all.values()));
                    new_district_combobox.setItems(FXCollections.observableArrayList(all_district.values()));

                    product_description_initialize();
                    customer_initialize();
                    advertisement_initialize();
                    order_table_initialize();
                    all_table_variable_initialize();
                    added_to_cart1_initialize();
                    added_to_cart2_initialize();
                    order_record_table_initialize();

                    all_show_product();

                } catch (SQLException ex) {
                    Logger.getLogger(Customer_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        T.start();

    }

    public void product_description_initialize() {

    }

    public void order_record_table_initialize() throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        data_order = FXCollections.observableArrayList();

        order_record_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        order_record_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        order_record_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        order_record_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        order_record_transporter_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        order_record_delivery_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        pin.setCellValueFactory(new PropertyValueFactory<>("pin"));

        String stri = "SELECT * FROM ORDER_TABLE WHERE ORDER_CUSTOMER_NO = ? ";

        PreparedStatement pst = global_variable.conn.prepareStatement(stri);
        pst.setInt(1, customer_id);
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
            String str = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ? ";
            PreparedStatement pst1 = global_variable.conn.prepareStatement(str);
            pst1.setInt(1, rst.getInt("ORDER_PRODUCT_NO"));
            ResultSet rst1 = pst1.executeQuery();
            rst1.next();
            dataordered.add(new customer_total_orders(rst1.getString("PRODUCT_NAME"),
                    rst1.getString("BRAND"), rst.getInt("MONEY"),
                    rst.getInt("AMOUNT"), rst.getInt("TRANSPORTER_NO"),
                    rst.getString("SUCCESS"), rst.getInt("CUSTOMER_PIN")));
            order_record_table.setItems(dataordered);
        }
    }

    public void customer_initialize() throws SQLException {
        String sql = "SELECT CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_DISTRICT,ADDRESS,CUSTOMER_CONTACT_NO"
                + "  FROM REGISTERED_CUSTOMER WHERE EMAIL = '" + global_variable.email + "' ";

        PreparedStatement ps = global_variable.conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            strc = rs.getString("CUSTOMER_DISTRICT");
            user_name.setText("NAME : " + rs.getString("CUSTOMER_NAME"));
            global_variable.username = rs.getString("CUSTOMER_NAME");
            customer_id = rs.getInt("CUSTOMER_ID");
            user_id.setText("ID : " + customer_id.toString());
            user_district.setText("DISTICT : " + rs.getString("CUSTOMER_DISTRICT"));
            global_variable.location = rs.getString("ADDRESS");
            user_location.setText("LOCATION : " + rs.getString("ADDRESS"));
            global_variable.district = rs.getString("CUSTOMER_DISTRICT");
            global_variable.mobile_no_ = rs.getString("CUSTOMER_CONTACT_NO");

        }
        rs.close();
        ps.close();
        String query = "{ ? = call GET_SEQUENCE(?)}";
        CallableStatement stmt = global_variable.conn.prepareCall(query);
        stmt.setString(2, "CUSTOMER_PIN");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        String tg = stmt.getString(1);
        transporter_number = get_random_number();
        pin_number = tg;

    }

    public void advertisement_initialize() throws SQLException {

        data_add = FXCollections.observableArrayList();
        //String sql = "SELECT MAX(COUNT(*)),PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,PRODUCT.PRICE FROM SEARCH_TABLE,PRODUCT, WHERE CUSTOMER_NO = 123 AND PRODUCT_TYPE = 'LAPTOP' ";
        String sql = "select count(*),search_product from search_table\n"
                + "where customer_no = " + customer_id.toString()
                + "  group by SEARCH_PRODUCT\n"
                + "  order by count(*) desc";
        PreparedStatement stmt1 = global_variable.conn.prepareStatement(sql);

        ResultSet tsr = stmt1.executeQuery();
        //stmt1.execute();
        String PN = "";
        if (tsr.next()) {
            PN = tsr.getString("SEARCH_PRODUCT");
            System.out.println("dsagddfsfsghj" + PN);
        }

        String sql1 = "SELECT PRODUCT_NAME,BRAND,PRICE,PRODUCT_ID FROM PRODUCT WHERE PRODUCT_TYPE = ?";
        PreparedStatement pst1 = global_variable.conn.prepareStatement(sql1);
        pst1.setString(1, PN);
        ResultSet rs = pst1.executeQuery();

        int a = 0;

        while (a < 100 && rs.next()) {
            System.out.println("bal");
            data_add.add(new advertise(rs.getString("PRODUCT_NAME"), rs.getString("BRAND"), rs.getInt("PRICE")));
            advertise_product_id = rs.getInt("PRODUCT_ID");

            a++;

        }
        add_table.setItems(data_add);

        add_table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
                    product_name = add_table.getSelectionModel().getSelectedItem().getName();
                    product_brand = add_table.getSelectionModel().getSelectedItem().getBrand();
                    product_price = add_table.getSelectionModel().getSelectedItem().getPrice();
                    //product_catagory = add_table.getSelectionModel().getSelectedItem().getCatagory();
                    String query = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ? AND BRAND = ? AND PRICE = ? ";
                    PreparedStatement psquery = null;
                    psquery = global_variable.conn.prepareStatement(query);
                    psquery.setString(1, product_name);
                    psquery.setString(2, product_brand);
                    psquery.setInt(3, product_price);
                    ResultSet rsquery = psquery.executeQuery();
                    rsquery.next();
                    order_product_details_name.setText("Name : " + rsquery.getString("PRODUCT_NAME"));
                    order_product_details_release_date.setText("RELEASE DATE : " + rsquery.getString("RELEASE_DATE"));
                    Integer inte = rsquery.getInt("PRICE");
                    order_product_details_price.setText("PRICE : " + inte.toString());
                    order_product_details_warranty.setText("WARRENTY : " + rsquery.getString("WARRENTY"));
                    order_product_details_about_it.setText("ABOUT IT : " + rsquery.getString("PRODUCT_DESCRIPTION"));
                    WebEngine engine = order_product_web_view.getEngine();

                    if (web_image_video.equals("IMAGE")) {
                        engine.load(rsquery.getString("IMAGE"));
                    } else {
                        engine.load(rsquery.getString("VIDEO"));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Customer_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void order_table_initialize() throws SQLException {
        order_product_table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
                    product_name = order_product_table.getSelectionModel().getSelectedItem().getName();
                    product_brand = order_product_table.getSelectionModel().getSelectedItem().getBrand();
                    product_price = order_product_table.getSelectionModel().getSelectedItem().getPrice();
                    product_catagory = order_product_table.getSelectionModel().getSelectedItem().getCatagory();
                    String query = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ? AND BRAND = ? AND PRICE = ? ";
                    PreparedStatement psquery = null;
                    psquery = global_variable.conn.prepareStatement(query);
                    psquery.setString(1, product_name);
                    psquery.setString(2, product_brand);
                    psquery.setInt(3, product_price);
                    ResultSet rsquery = psquery.executeQuery();
                    rsquery.next();
                    order_product_details_name.setText("Name : " + rsquery.getString("PRODUCT_NAME"));
                    order_product_details_release_date.setText("RELEASE DATE : " + rsquery.getString("RELEASE_DATE"));
                    Integer inte = rsquery.getInt("PRICE");
                    order_product_details_price.setText("PRICE : " + inte.toString());
                    order_product_details_warranty.setText("WARRENTY : " + rsquery.getString("WARRENTY"));
                    order_product_details_about_it.setText("ABOUT IT : " + rsquery.getString("PRODUCT_DESCRIPTION"));
                    WebEngine engine = order_product_web_view.getEngine();

                    if (web_image_video.equals("IMAGE")) {
                        engine.load(rsquery.getString("IMAGE"));
                    } else {
                        engine.load(rsquery.getString("VIDEO"));
                    }

                    //CHONIR KAJ TA BAKI
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void added_to_cart1_initialize() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.

        aded_to_cart_product_table.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    added_to_cart2_initialize();
                    String pro_name = aded_to_cart_product_table.getSelectionModel().getSelectedItem().getName();
                    Integer amo = aded_to_cart_product_table.getSelectionModel().getSelectedItem().getAmount();
                    String query = "{? = call GET_PRO_ID(?)}";
                    CallableStatement stmt1 = global_variable.conn.prepareCall(query);
                    stmt1.setString(2, pro_name);
                    stmt1.registerOutParameter(1, Types.INTEGER);
                    stmt1.execute();
                    Integer PID = stmt1.getInt(1);
                    String query1 = "SELECT SUPPLIER_NO FROM STOCK WHERE PRODUCT_NO = ? AND QUANTITY >= ? ";
                    PreparedStatement pst = global_variable.conn.prepareCall(query1);
                    pst.setInt(1, PID);
                    pst.setInt(2, amo);
                    ResultSet rsq = pst.executeQuery();
                    if (!rsq.next()) {
                        aded_to_cart_product_table.getItems().removeAll(aded_to_cart_product_table.getSelectionModel().getSelectedItem());
                        aded_to_cart_shop_status.setText("Sorry, Product is not available");
                    } else {
                        String query2 = "{call supplier_details(? , ? , ? , ? )}";
                        CallableStatement stmt2 = global_variable.conn.prepareCall(query2);
                        Integer SID = Integer.parseInt(rsq.getString("SUPPLIER_NO"));
                        stmt2.setInt(1, SID);
                        stmt2.registerOutParameter(2, Types.VARCHAR);
                        stmt2.registerOutParameter(3, Types.VARCHAR);
                        stmt2.registerOutParameter(4, Types.VARCHAR);
                        stmt2.execute();
                        data_cart2.add(new added_to_cart2(pro_name, stmt2.getString(2), stmt2.getString(4), stmt2.getString(3)));
                        aded_to_cart_shop_table.setItems(data_cart2);

                    }
                    while (rsq.next()) {
                        String query2 = "{call supplier_details(? , ? , ? , ? )}";
                        CallableStatement stmt2 = global_variable.conn.prepareCall(query2);
                        Integer SID = Integer.parseInt(rsq.getString("SUPPLIER_NO"));
                        stmt2.setInt(1, SID);
                        stmt2.registerOutParameter(2, Types.VARCHAR);
                        stmt2.registerOutParameter(3, Types.VARCHAR);
                        stmt2.registerOutParameter(4, Types.VARCHAR);
                        stmt2.execute();
                        data_cart2.add(new added_to_cart2(pro_name, stmt2.getString(2), stmt2.getString(4), stmt2.getString(3)));
                        aded_to_cart_shop_table.setItems(data_cart2);
                    }

                    //System.out.println(tg1);
                    //throw new UnsupportedOperationException("Not supported yet.");
                    //To change body of generated methods, choose Tools | Templates.
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    private void added_to_cart2_initialize() {
        aded_to_cart_shop_product_name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        aded_to_cart_shop_name.setCellValueFactory(new PropertyValueFactory<>("shop_name"));
        aded_to_cart_shop_district.setCellValueFactory(new PropertyValueFactory<>("district"));
        aded_to_cart_shop_road_location.setCellValueFactory(new PropertyValueFactory<>("road_location"));
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
        aded_to_cart_shop_table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet.");
                //To change body of generated methods, choose Tools | Templates.

            }

        });
    }

    public void all_table_variable_initialize() {

        // ORDER PRODUCT -- FIRST TAB
        order_product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        order_product_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        order_product_catagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        order_product_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        //ADDED TO CART 
        aded_to_cart_product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        aded_to_cart_product_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        aded_to_cart_product_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        aded_to_cart_product_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        aded_to_cart_product_pin.setCellValueFactory(new PropertyValueFactory<>("pin"));
        aded_to_cart_product_transporter_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        // AVAILABLE SHOPS  
        //ORDER RECORDS  
        order_record_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        order_record_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        order_record_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        order_record_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        order_record_transporter_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        order_record_delivery_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        //OBSERVABLE ARRAY LIST
        add_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        add_table_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        add_table_price.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    @FXML
    void web_image_show(MouseEvent event) {

        web_image_video = "IMAGE";

    }

    @FXML
    void web_video_show(MouseEvent event) {

        web_image_video = "VIDEO";

    }

    public void all_show_product() throws SQLException {
        String sql = "SELECT * FROM PRODUCT";
        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet rss = ps.executeQuery();
        while (rss.next()) {
            data_order.add(new order_product(rss.getString("PRODUCT_NAME"), rss.getString("BRAND"), rss.getString("PRODUCT_TYPE"),
                    rss.getInt("PRICE")));
        }

        order_product_table.setItems(data_order);
    }

}
