package successful_message;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import level2term2.global_variable;
import static level2term2.global_variable.conn;
import level2term2.shop_type_option;
import successful_message.update_store_class.*;

public class Reg_successController {

    String product_name;
    Integer stock_amount = 0;
    String product_brand;
    Integer supplier_id = 0;
    String placed_product_name_show;
    Integer total_money = 0;
    Integer due = 0;
    Integer extra_due = 0;
    String pro_brand = "";
    String pro_cat = "";
    Integer pro_or_id = 0;

    @FXML
    private JFXTextField new_user_name;

    @FXML
    private JFXPasswordField user_password;

    @FXML
    private JFXTextField new_shop_name;

    @FXML
    private JFXPasswordField shop_passwors;

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
    private Label s_name1;

    @FXML
    private Label s_id1;

    @FXML
    private Label shop_n1;

    @FXML
    private Label s_name2;

    @FXML
    private Label s_id2;

    @FXML
    private Label shop_n2;

    @FXML
    private Label update_name;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label s_name;

    @FXML
    private Label s_id;

    @FXML
    private Label shop_n;

    @FXML
    private JFXButton placed_orders_confirm;

    @FXML
    private TableView<supplier_placed_orders> placed_orders_table;

    @FXML
    private TableColumn<supplier_placed_orders, String> placed_order_name;

    @FXML
    private TableColumn<supplier_placed_orders, String> placed_order_brand;

    @FXML
    private TableColumn<supplier_placed_orders, Integer> placed_order_amount;

    @FXML
    private TableColumn<supplier_placed_orders, Integer> placed_order_price;

    @FXML
    private TableColumn<supplier_placed_orders, Integer> placed_order_pin;

    @FXML
    private TableColumn<supplier_placed_orders, String> placed_order_date;

    @FXML
    private TableColumn<supplier_placed_orders, Integer> trans_id;

    @FXML
    private TableColumn<supplier_placed_orders, Integer> placed_orders_id;

    @FXML
    private TableColumn<supplier_placed_orders, String> placed_orders_status;

    @FXML
    private TableColumn<supplier_placed_orders, JFXCheckBox> placed_order_ckb;

    @FXML
    private JFXTextField search_bos_update;

    @FXML
    private JFXTextField amount_update;

    @FXML
    private JFXComboBox<incdec> inc_dec_combo;

    @FXML
    private TableView<update_store_class> update_store_table;

    @FXML
    private TableColumn<update_store_class, String> update_store_name;

    @FXML
    private TableColumn<update_store_class, String> update_store_brand;

    @FXML
    private TableColumn<update_store_class, Integer> update_store_amount;

    @FXML
    private TableColumn<update_store_class, Integer> current_price;

    @FXML
    private TableColumn<update_store_class, String> update_catagory;
    
    @FXML
    private TableColumn<update_store_class, String> update_STOCK;

    @FXML
    private TableView<mysell> my_sell_table;

    @FXML
    private TableColumn<mysell, String> my_sell_name;

    @FXML
    private TableColumn<mysell, String> my_sell_brand;

    @FXML
    private TableColumn<mysell, Integer> my_sell_amount;

    @FXML
    private TableColumn<mysell, String> date_of_sell;

    @FXML
    private TableColumn<mysell, Integer> my_sell_price;

    private ObservableList<supplier_placed_orders> data;

    private ObservableList<update_store_class> update_datas;

    private ObservableList<mysell> my_sell_record;

    private ObservableList<update_store_class> my_products;

    @FXML
    private Text settings_result;

    @FXML
    private JFXComboBox<day_range> my_shop_sells_day_range;

    private Thread T;
    private boolean is_filter_update_pressed = false;

    @FXML
    private Text total_sell_in_range;

    @FXML
    private Text placed_order_successful_status;

    @FXML
    private JFXComboBox<search_shop_type_option> catagory_combo_box;

    @FXML
    private Text charged_money;

    @FXML
    void go_to_homepage(MouseEvent event) throws IOException {
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
    void placed_order_confirm_button(MouseEvent event) throws SQLException {

        for (supplier_placed_orders order_id : data) {
            if (order_id.getCkb().isSelected() == true) {
                pro_or_id = order_id.getOrder_id();

                String product_sql = "SELECT PRODUCT_ID FROM PRODUCT,ORDER_TABLE WHERE"
                        + " ORDER_PRODUCT_NO = PRODUCT_ID AND ORDER_ID = " + pro_or_id.toString();
                PreparedStatement ps_product = global_variable.conn.prepareStatement(product_sql);

                ResultSet rs_product = ps_product.executeQuery();

                if (rs_product.next()) {
                    Integer prod_id = rs_product.getInt("PRODUCT_ID");

                    String newsql = "UPDATE ORDER_TABLE \n"
                            + "SET SUCCESS_SUPPLIER = 'YES' WHERE ORDER_ID = " + pro_or_id.toString();

                    System.out.println(newsql);
                    System.out.println(prod_id);
                    PreparedStatement ps = global_variable.conn.prepareStatement(newsql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        placed_order_successful_status.setText("SUCCESSFUL");
                        rs.close();

                        order_table_data_initialize();
                        due_taka_refresh();

                    }
                    ps.close();
                } else {
                    placed_order_successful_status.setText("FAILED");
                }
            }
        }
    }

    @FXML
    void to_update_store_button(MouseEvent event) throws SQLException {

        try {
            is_filter_update_pressed = false;
            String product_sql = "SELECT PRODUCT_ID FROM PRODUCT WHERE PRODUCT_NAME = '" + product_name + "'";
            PreparedStatement ps_product = global_variable.conn.prepareStatement(product_sql);

            ResultSet rs_product = ps_product.executeQuery();

            if (rs_product.next()) {

                Integer prod_id = rs_product.getInt("PRODUCT_ID");
                Integer inc_dec_amount = 0;

                if (inc_dec_combo.getValue().toString().equals("INCREASE")) {
                    inc_dec_amount = Integer.parseInt(amount_update.getText());
                } else {
                    inc_dec_amount = -Integer.parseInt(amount_update.getText());
                }

                String newsql = "UPDATE STOCK \n"
                        + "SET QUANTITY = ? WHERE SUPPLIER_NO = ? and  PRODUCT_NO = ? ";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);
                Integer update = inc_dec_amount + stock_amount;
                if (update >= 0) {
                    ps.setInt(1, update);
                    ps.setInt(2, supplier_id);
                    ps.setInt(3, prod_id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        stock_amount = update;
                        do_update();
                    }
                    rs.close();

                } else {
                    update_name.setText("STORAGE CANN'T BE NEGATIVE");
                }
                ps.close();

            }
        } catch (Exception E) {
            update_name.setText("PLEASE FILLUP ALL");
        }

    }

    @FXML
    void initialize() throws SQLException {
        assert placed_orders_confirm != null : "fx:id=\"placed_orders_confirm\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_orders_table != null : "fx:id=\"placed_orders_table\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_order_name != null : "fx:id=\"placed_order_name\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_order_brand != null : "fx:id=\"placed_order_brand\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_order_amount != null : "fx:id=\"placed_order_amount\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_order_price != null : "fx:id=\"placed_order_price\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_order_pin != null : "fx:id=\"placed_order_pin\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert placed_order_date != null : "fx:id=\"placed_order_date\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert search_bos_update != null : "fx:id=\"search_bos_update\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert amount_update != null : "fx:id=\"amount_update\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert inc_dec_combo != null : "fx:id=\"inc_dec_combo\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert update_store_table != null : "fx:id=\"update_store_table\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert update_store_name != null : "fx:id=\"update_store_name\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert update_store_brand != null : "fx:id=\"update_store_brand\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert update_store_amount != null : "fx:id=\"update_store_amount\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert my_sell_table != null : "fx:id=\"my_sell_table\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert my_sell_name != null : "fx:id=\"my_sell_name\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert my_sell_brand != null : "fx:id=\"my_sell_brand\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert my_sell_amount != null : "fx:id=\"my_sell_amount\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";
        assert my_sell_price != null : "fx:id=\"my_sell_price\" was not injected: check your FXML file 'success_supplier_dashboard.fxml'.";

        T = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    inc_dec_combo.setItems(FXCollections.observableArrayList(incdec.values()));
                    catagory_combo_box.setItems(FXCollections.observableArrayList(search_shop_type_option.values()));
                    new_district_combobox.setItems(FXCollections.observableArrayList(all_district.values()));
                    my_shop_sells_day_range.setItems(FXCollections.observableArrayList(day_range.values()));
                    order_table_data_initialize();
                    do_update();
                    nam_id_initialize();
                    my_sell_of_business(100);
                    due_taka_refresh();
                } catch (SQLException ex) {
                    Logger.getLogger(Reg_successController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        T.start();

    }

    public void order_table_data_initialize() throws SQLException {

        data = FXCollections.observableArrayList();

        placed_order_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        placed_order_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        placed_order_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        placed_order_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        placed_order_pin.setCellValueFactory(new PropertyValueFactory<>("pin"));
        placed_order_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        trans_id.setCellValueFactory(new PropertyValueFactory<>("tran_id"));
        placed_orders_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        placed_orders_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        placed_order_ckb.setCellValueFactory(new PropertyValueFactory<>("ckb"));

        System.out.println(global_variable.email);
        PreparedStatement suplier_check = global_variable.conn.prepareStatement("SELECT  PRODUCT_NAME, BRAND,AMOUNT,PRICE,SUPPLIER_PIN,"
                + "Date_Ordered,TRANSPORTER_NO, ORDER_ID,SUCCESS_SUPPLIER "
                + "from ORDER_TABLE,REGISTERED_SUPPLIER, PRODUCT WHERE ORDER_SUPPLIER_NO = SUPPLIER_ID  AND SUCCESS_SUPPLIER <> 'PAID' "
                + "and  SUPPLIER_EMAIL = '" + global_variable.email + "' and PRODUCT_ID = ORDER_PRODUCT_NO ");
        ResultSet rs_check = suplier_check.executeQuery();

        while (rs_check.next()) {

            JFXCheckBox ck = new JFXCheckBox();

            data.add(new supplier_placed_orders(rs_check.getString("PRODUCT_NAME"),
                    rs_check.getString("BRAND"), rs_check.getInt("AMOUNT"), rs_check.getInt("PRICE"),
                    rs_check.getInt("SUPPLIER_PIN"), rs_check.getString("Date_Ordered"),
                    rs_check.getInt("TRANSPORTER_NO"), rs_check.getInt("ORDER_ID"),
                    rs_check.getString("SUCCESS_SUPPLIER"), ck));

        }

        placed_orders_table.setItems(data);
        rs_check.close();
        suplier_check.close();

        placed_orders_table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    placed_product_name_show = placed_orders_table.getSelectionModel().getSelectedItem().getName();
                    extra_due = (placed_orders_table.getSelectionModel().getSelectedItem().getPrice() / 10);
                    pro_or_id = placed_orders_table.getSelectionModel().getSelectedItem().getOrder_id();

                } catch (Exception E) {

                }
            }
        });

    }

    public void do_update() throws SQLException {
        update_datas = FXCollections.observableArrayList();

        update_store_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        update_store_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        update_store_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        current_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        update_catagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        update_STOCK.setCellValueFactory(new PropertyValueFactory<>("stock"));

        String sql = "SELECT PRODUCT_NAME,BRAND,QUANTITY,PRICE,PRODUCT_TYPE  FROM STOCK , PRODUCT , REGISTERED_SUPPLIER "
                + "WHERE SUPPLIER_EMAIL = '" + global_variable.email + "' and SUPPLIER_ID = SUPPLIER_NO and PRODUCT_ID = PRODUCT_NO ";

        PreparedStatement ps_stock = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps_stock.executeQuery();
        while (rs.next()) {
            
            String stock_q = "";
            
            if( rs.getInt("QUANTITY") <= 5)
            {
                stock_q = "LOW";
            }else if(rs.getInt("QUANTITY") > 5 && rs.getInt("QUANTITY") <= 20)
            {
                stock_q = "MEDIUM";
            }else 
            {
                stock_q = "ENOUGH";
            }
            update_datas.add(new update_store_class(rs.getString("PRODUCT_NAME"), rs.getString("BRAND"), 
            rs.getInt("QUANTITY"), rs.getInt("PRICE"), rs.getString("PRODUCT_TYPE"),stock_q));

        }

        update_store_table.setItems(update_datas);

        update_store_table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    product_name = update_store_table.getSelectionModel().getSelectedItem().getName();
                    stock_amount = update_store_table.getSelectionModel().getSelectedItem().getAmount();
                    product_brand = update_store_table.getSelectionModel().getSelectedItem().getBrand();
                    update_name.setText("NAME : " + product_name);

                } catch (Exception E) {

                }
            }
        });

        if (rs != null) {
            rs.close();
        }
        ps_stock.close();

    }

    public void my_sell_of_business(Integer day) throws SQLException {
        System.out.println(global_variable.email);

        my_sell_record = FXCollections.observableArrayList();
        my_sell_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        my_sell_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        my_sell_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        my_sell_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        date_of_sell.setCellValueFactory(new PropertyValueFactory<>("ndate"));
        String sql = "select PRODUCT_NAME, BRAND, HISTORY_AMOUNT , PRICE, ENTRY_DATE FROM  PRODUCT,BUY_SELL_HISTORY,REGISTERED_SUPPLIER  where HISTORY_SUPPLIER_NO = SUPPLIER_ID"
                + " and SUPPLIER_EMAIL = '" + global_variable.email + "'"
                + " and PRODUCT_ID = HISTORY_PRODUCT_NO  AND " + day.toString() + " > (TO_DATE(SYSDATE,'DD-MM-YYYY') - TO_DATE(ENTRY_DATE,'DD-MM-YYYY')) ";
        PreparedStatement ps_history = global_variable.conn.prepareStatement(sql);

        ResultSet rs = ps_history.executeQuery();
        total_money = 0;
        while (rs.next()) {
            ///rs.getString("PRODUCT_NAME"), rs.getString("BRAND"),rs.getInt("AMOUNT"), rs.getInt("PRICE")*rs.getInt("AMOUNT")),rs.getString("")
            my_sell_record.add(new mysell(rs.getString("PRODUCT_NAME"), rs.getString("BRAND"), rs.getInt("HISTORY_AMOUNT"), rs.getInt("PRICE") * rs.getInt("HISTORY_AMOUNT"), rs.getString("ENTRY_DATE")));
            total_money += rs.getInt("PRICE") * rs.getInt("HISTORY_AMOUNT");
        }

        my_sell_table.setItems(my_sell_record);
        if (rs != null) {
            rs.close();
        }
        ps_history.close();
        total_sell_in_range.setText("TOTAL SELL: " + total_money.toString() + " TK");
    }

    public void nam_id_initialize() throws SQLException {
        System.out.println(global_variable.sup_id);
        String sql = "SELECT SUPPLIER_NAME,SHOP_NAME,SUPPLIER_ID from REGISTERED_SUPPLIER where SUPPLIER_EMAIL = '" + global_variable.email + "'";
        PreparedStatement ps_stock = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps_stock.executeQuery();

        if (rs.next()) {
            s_name.setText("SUPPLIER NAME : " + rs.getString("SUPPLIER_NAME"));
            supplier_id = rs.getInt("SUPPLIER_ID");
            s_id.setText("SUPPLIUER ID : " + rs.getString("SUPPLIER_ID"));
            shop_n.setText("SHOP NAME : " + rs.getString("SHOP_NAME"));
            s_name1.setText("SUPPLIER NAME : " + rs.getString("SUPPLIER_NAME"));
            s_id1.setText("SUPPLIUER ID : " + rs.getString("SUPPLIER_ID"));
            shop_n1.setText("SHOP NAME : " + rs.getString("SHOP_NAME"));
            s_name2.setText("SUPPLIER NAME : " + rs.getString("SUPPLIER_NAME"));
            s_id2.setText("SUPPLIUER ID : " + rs.getString("SUPPLIER_ID"));
            shop_n2.setText("SHOP NAME : " + rs.getString("SHOP_NAME"));

        }
        rs.close();
        ps_stock.close();
    }

    @FXML
    void add_new_product_filter(MouseEvent event) throws SQLException {

        is_filter_update_pressed = true;
        my_products = FXCollections.observableArrayList();
        String id = supplier_id.toString();
        System.out.println(id);
        update_name.setText("");
        String cat = "";
        String s = "";
        try {
            cat = catagory_combo_box.getValue().toString();
        } catch (Exception E) {
            cat = "";
        }
        try {
            s = search_bos_update.getText();
        } catch (Exception E) {
            s = "";
        }

        if (cat.length() > 1 && cat.equals("ALL") == false && s.length() == 0) {

            String sql = "SELECT PRODUCT_NAME, BRAND, PRICE, PRODUCT_TYPE   FROM PRODUCT WHERE PRODUCT_TYPE = ? "
                    + "and 0 = (SELECT COUNT(STOCK_ID) FROM STOCK WHERE PRODUCT_NO = PRODUCT_ID AND SUPPLIER_NO = " + id + " )";
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ps.setString(1, cat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                my_products.add(new update_store_class(rs.getString("PRODUCT_NAME"), 
                        rs.getString("BRAND"), 0, rs.getInt("PRICE"), rs.getString("PRODUCT_TYPE"),"LOW"));
            }
            rs.close();
            ps.close();

        } else if (s.length() > 0 && cat.equals("ALL") == true) {
            String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE ? "
                    + "and 0 = (SELECT COUNT(*) FROM STOCK WHERE PRODUCT_NO = PRODUCT_ID AND SUPPLIER_NO = " + id + " )";
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                my_products.add(new update_store_class(rs.getString("PRODUCT_NAME"),
                        rs.getString("BRAND"), 0, rs.getInt("PRICE"), 
                        rs.getString("PRODUCT_TYPE"),"EMPTY"));
            }
            rs.close();
            ps.close();

        } else if (s.length() > 0 && cat.equals("ALL") == false && cat.length() > 0) {
            String sql = "SELECT *FROM PRODUCT WHERE PRODUCT_NAME LIKE ? and PRODUCT_TYPE = ? "
                    + "and 0 = (SELECT COUNT(*) FROM STOCK WHERE PRODUCT_NO = PRODUCT_ID AND SUPPLIER_NO = " + id + " )";
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            ps.setString(2, cat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                my_products.add(new update_store_class(rs.getString("PRODUCT_NAME"),
                        rs.getString("BRAND"), 0, rs.getInt("PRICE"), rs.getString("PRODUCT_TYPE"),"EMPTY"));
            }
            rs.close();
            ps.close();
        } else {
            String sql = "SELECT *FROM PRODUCT "
                    + " WHERE 0 = (SELECT COUNT(*) FROM STOCK WHERE PRODUCT_NO = PRODUCT_ID AND SUPPLIER_NO = " + id + " )";
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                my_products.add(new update_store_class(rs.getString("PRODUCT_NAME"), 
                        rs.getString("BRAND"), 0, rs.getInt("PRICE"), rs.getString("PRODUCT_TYPE"),"EMPTY"));
            }
            rs.close();
            ps.close();
        }

        update_store_table.setItems(my_products);

    }

    @FXML
    void add_new_product_to_store(MouseEvent event) throws SQLException {

        if (is_filter_update_pressed == true && product_name.equals("") == false) {
            Integer myId = 0;

            String nqsql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME = '" + product_name + "' ";
            PreparedStatement ps_product = global_variable.conn.prepareStatement(nqsql);
            ResultSet rst = ps_product.executeQuery();
            Integer product_id_ = 0;
            if (rst.next()) {
                product_id_ = rst.getInt("PRODUCT_ID");
            }

            String sqlIdentifier = "select for_product.NEXTVAL from dual";
            PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
            synchronized (this) {
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    myId = rs.getInt(1);
                    System.out.println(myId);
                }
                rs.close();
            }
            pst.close();
            try {
                String sql = "Insert into STOCK(STOCK_ID ,SUPPLIER_NO,PRODUCT_NO,QUANTITY) \n"
                        + " values(?,?,?,?)";

                PreparedStatement ps = global_variable.conn.prepareStatement(sql);

                System.out.println(product_id_);
                System.out.println(supplier_id);
                ps.setInt(1, myId);
                ps.setInt(2, supplier_id);
                ps.setInt(3, product_id_);
                ps.setInt(4, 0);

                ps.executeUpdate();
                update_name.setText("SUCCESSFUL");
                rst.close();
                ps.close();

            } catch (Exception E) {
                update_name.setText("FAILED");
            }
        } else {
            update_name.setText("ALREADY IN STORE");
        }
        product_name = "";

    }

    @FXML
    void change_contact_no(MouseEvent event) {

        try {

            String number = new_contact_no.getText();
            String new_password = contact_password.getText();
            if (new_password.equals(global_variable.password)) {
                String newsql = "UPDATE REGISTERED_SUPPLIER \n"
                        + "SET SUPPLIER_MOBILE_NO = ? WHERE SUPPLIER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setInt(1, Integer.parseInt(number));
                ps.setInt(2, supplier_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }
                nam_id_initialize();
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
                String newsql_location = "UPDATE REGISTERED_SUPPLIER \n"
                        + "SET SHOP_LOCATION = ? WHERE SUPPLIER_ID = ?";

                String newsql_district = "UPDATE REGISTERED_SUPPLIER \n"
                        + "SET SHOP_DISTRICT = ? WHERE SUPPLIER_ID = ?";

                PreparedStatement ps_location = global_variable.conn.prepareStatement(newsql_location);
                PreparedStatement ps_district = global_variable.conn.prepareStatement(newsql_district);

                ps_location.setString(1, location);
                ps_location.setInt(2, supplier_id);

                ps_district.setString(1, district);
                ps_district.setInt(2, supplier_id);

                ResultSet rs_location = ps_location.executeQuery();
                ResultSet rs_district = ps_district.executeQuery();

                if (rs_location.next() == true && rs_district.next() == true) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }

                nam_id_initialize();
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
                String newsql = "UPDATE REGISTERED_SUPPLIER \n"
                        + "SET PASSWORD = ? WHERE SUPPLIER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, new_pass);
                ps.setInt(2, supplier_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }
                global_variable.password = new_pass;
                nam_id_initialize();
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
    void change_shop_name(MouseEvent event) {

        try {

            String shop_name = new_shop_name.getText();
            String new_password = shop_passwors.getText();
            if (new_password.equals(global_variable.password)) {
                String newsql = "UPDATE REGISTERED_SUPPLIER \n"
                        + "SET SHOP_NAME = ? WHERE SUPPLIER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, shop_name);
                ps.setInt(2, supplier_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }
                nam_id_initialize();

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
                String newsql = "UPDATE REGISTERED_SUPPLIER \n"
                        + "SET SUPPLIER_NAME = ? WHERE SUPPLIER_ID = ?";

                PreparedStatement ps = global_variable.conn.prepareStatement(newsql);

                ps.setString(1, user_name);
                ps.setInt(2, supplier_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    settings_result.setText("SUCCESSFUL");
                } else {
                    settings_result.setText("FAILED");
                }

                nam_id_initialize();

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
    void my_shop_sell_filter(MouseEvent event) throws SQLException {

        String num = "";
        String combo_info;

        try {
            combo_info = my_shop_sells_day_range.getValue().toString();
            String[] sp = combo_info.split("_");

            Integer day = Integer.parseInt(sp[1]);

            my_sell_of_business(day);

        } catch (Exception E) {
            total_sell_in_range.setText("PLEASE FILLUP DAY");
        }

    }

    @FXML
    void refresh_update_table(MouseEvent event) throws SQLException {
        do_update();
        is_filter_update_pressed = false;
    }

    public void due_taka_refresh() throws SQLException {
        String sql = "SELECT DUE_TAKA FROM REGISTERED_SUPPLIER WHERE SUPPLIER_EMAIL = '" + global_variable.email + "' ";
        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            due = rs.getInt("DUE_TAKA");
            charged_money.setText("DUE TAKA : " + due.toString());
        }
    }

    @FXML
    void paid_option(MouseEvent event) throws SQLException {

        for (supplier_placed_orders order_id : data) {
            if (order_id.getCkb().isSelected() == true) {
                pro_or_id = order_id.getOrder_id();

                String product_sql = "SELECT PRODUCT_ID FROM PRODUCT,ORDER_TABLE WHERE"
                        + " ORDER_PRODUCT_NO = PRODUCT_ID AND ORDER_ID = " + pro_or_id.toString();
                PreparedStatement ps_product = global_variable.conn.prepareStatement(product_sql);

                ResultSet rs_product = ps_product.executeQuery();

                if (rs_product.next()) {
                    Integer prod_id = rs_product.getInt("PRODUCT_ID");

                    String newsql = "UPDATE ORDER_TABLE \n"
                            + "SET SUCCESS_SUPPLIER = 'PAID' WHERE ORDER_ID = " + pro_or_id.toString();

                    System.out.println(newsql);
                    System.out.println(prod_id);
                    PreparedStatement ps = global_variable.conn.prepareStatement(newsql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        placed_order_successful_status.setText("SUCCESSFUL");
                        rs.close();

                        order_table_data_initialize();
                        due_taka_refresh();

                    }
                    ps.close();
                } else {
                    placed_order_successful_status.setText("FAILED");
                }
            }
        }

    }

}
