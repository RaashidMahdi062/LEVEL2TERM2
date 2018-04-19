package successful_message;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import level2term2.global_variable;
import static level2term2.global_variable.conn;
import level2term2.shop_type_option;

public class AdminnewController {

    String supp_name = "";
    Integer mon = 0;
    String shop = "";
    String hsuppname = "";
    String hcustname = "";
    String htransname = "";
    String hproname = "";
    Integer pri = 0;
    Integer amo = 0;
    Integer cust_no = 0;
    Integer supp_no = 0;
    Integer trans_no = 0;
    Integer o_no = 0;
    String product_name_ = "";
    String product_brand_ = "";
    String catagory_ = "";
    
    String FOR_SQL = "REGISTERED_CUSTOMER";
    String FOR_SQL_APPROVAL = "CUSTOMER_APPROVE";
    String FOR_SQL_ID = "CUSTOMER_ID";

    VBox vb;
    VBox vb2;
    
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<admin_profit_class> taka_and_poisa;
    
    @FXML
    private TableColumn<admin_profit_class, Integer> admin_profit_id;

    @FXML
    private TableColumn<admin_profit_class, Integer> admin_profit_salary;

    @FXML
    private TableColumn<admin_profit_class, String> admin_profit_month;

    @FXML
    private TableColumn<admin_profit_class, String> admin_profit_year;

    @FXML
    private TableView<monitor> buy_sell_history1;

    @FXML
    private TableColumn<monitor, String> supplier_name1;

    @FXML
    private TableColumn<monitor, Integer> supp_id;

    @FXML
    private TableColumn<monitor, String> customer_name1;

    @FXML
    private TableColumn<monitor, Integer> cust_id;

    @FXML
    private TableColumn<monitor, String> transporter_name1;

    @FXML
    private TableColumn<monitor, Integer> trans_id;

    @FXML
    private TableColumn<monitor, String> prod_name1;

    @FXML
    private TableColumn<monitor, Integer> amount;

    @FXML
    private TableColumn<monitor, Integer> money1;

    @FXML
    private TableColumn<monitor, JFXCheckBox> success1;

    @FXML
    private TableColumn<monitor, Integer> o_id;

    @FXML
    private TableColumn<monitor, String> date_see;

    @FXML
    private TableColumn<monitor, String> DELIVERED_SEE;

    @FXML
    private TableView<monthly_report> monthly_report;

    @FXML
    private TableColumn<monthly_report, String> SUPPLIER_NAME;

    @FXML
    private TableColumn<monthly_report, String> supplier_location;


    @FXML
    private TableColumn<monthly_report, String> shop_type;

    @FXML
    private TableColumn<monthly_report, Integer> due_taka;

    @FXML
    private TableColumn<monthly_report, Integer> supplier_id;

    @FXML
    private JFXTextField product_name;

    @FXML
    private JFXTextField product_brand;

    @FXML
    private JFXTextField product_warrantee;

    @FXML
    private JFXTextField product_price;

    @FXML
    private JFXTextField product_image_link;

    @FXML
    private JFXTextField product_video_link;

    @FXML
    private JFXTextField product_description;

    @FXML
    private JFXComboBox<admin_product_catagory> product_catagory_combobox;

    @FXML
    private JFXDatePicker product_release_date;

    @FXML
    private JFXButton product_add;

    @FXML
    private Label result_show;


    @FXML
    private TableView<productwisereport> PROD_TABLE;

    @FXML
    private TableColumn<productwisereport, String> NAME;

    @FXML
    private TableColumn<productwisereport, String> BRAND;

    @FXML
    private TableColumn<productwisereport, Integer> AMOUNT;

    @FXML
    private TableColumn<productwisereport, String> CATAGORY;

    @FXML
    private TableColumn<productwisereport, Integer> unit_price;

    @FXML
    private JFXTextField searchfor;

    @FXML
    private Label product_name_price_update;

    @FXML
    private JFXTextField new_price;

    @FXML
    private Text c_product;

    @FXML
    private TableView<customer_monitor_by_admin> customer_information;

    @FXML
    private TableColumn<customer_monitor_by_admin, Integer> customer_information_id;

    @FXML
    private TableColumn<customer_monitor_by_admin, String> customer_information_name;

    @FXML
    private TableColumn<customer_monitor_by_admin, String> customer_information_district;

    @FXML
    private TableColumn<customer_monitor_by_admin, String> customer_information_road;

    @FXML
    private TableColumn<customer_monitor_by_admin, Integer> customer_information_total_buy;

    @FXML
    private TableView<our_all_people> OUR_PEOPLE;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_NAME;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_EMAIL;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_CONTACT_NO;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_DISTRICT;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_ROAD_LOCATION;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_NID;

    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_REGISTER_DATE;

    @FXML
    private TableColumn<our_all_people, Integer> OUR_PEOPLE_ID;

    @FXML
    private TableColumn<our_all_people, JFXCheckBox> OUR_PEOPLE_CHECK_BOX;
    
    @FXML
    private TableColumn<our_all_people, String> OUR_PEOPLE_APPROVAL;
    
    @FXML
    private JFXHamburger confirm_ham;

    @FXML
    private JFXHamburger catagory_ham;

    @FXML
    private JFXDrawer catagory_ham_drawer;

    @FXML
    private JFXDrawer confirm_ham_drawer;
    
    @FXML
    private Text cata_text;

    HamburgerNextArrowBasicTransition catagory_transition;
    HamburgerBackArrowBasicTransition confirm_trisition_ham;

    Thread T;

    @FXML
    void finally_add_product_button(MouseEvent event) {

        try {
            long myId = 0;
            //String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            //System.out.println(timeStamp);
            String sql = "Insert into PRODUCT(PRODUCT_ID ,PRODUCT_NAME,PRODUCT_TYPE,"
                    + "BRAND,RELEASE_DATE,WARRENTY,PRICE,PRODUCT_DESCRIPTION,IMAGE,VIDEO)"
                    + " values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = null;
            ps = global_variable.conn.prepareStatement(sql);
            String sqlIdentifier = "select for_product.NEXTVAL from dual";
            PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
            synchronized (this) {
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    myId = rs.getLong(1);
                    System.out.println(myId);
                }
            }

            Integer price = Integer.parseInt(product_price.getText());
            System.out.println(product_catagory_combobox.getValue().toString());
            System.out.println(price);

            ps.setLong(1, myId);
            ps.setString(2, product_name.getText());
            ps.setString(3, product_catagory_combobox.getValue().toString().toUpperCase());
            ps.setString(4, product_brand.getText());
            ps.setString(5, product_release_date.getValue().toString());
            ps.setString(6, product_warrantee.getText());
            ps.setInt(7, price);
            ps.setString(8, product_description.getText());
            ps.setString(9, product_image_link.getText());
            ps.setString(10, product_video_link.getText());
            ps.executeUpdate();
            ps.close();
            result_show.setText("SUCCESSFUL");

            product_name.setText("");
            product_brand.setText("");
            product_warrantee.setText("");
            product_description.setText("");
            product_image_link.setText("");
            product_video_link.setText("");

        } catch (SQLException s) {
            result_show.setText("FAILED TO SET");
        }

    }

    private ObservableList<monthly_report> data;
    private ObservableList<productwisereport> data2;
    private ObservableList<monitor> monitor_data;
    private ObservableList<productwisereport> product_data;
    private ObservableList<customer_monitor_by_admin> customer;
    private ObservableList<our_all_people> our_working_people;
    private ObservableList<admin_profit_class> profit_data;
    
    

    private void monthly_report_data_initialize() throws SQLException {

        data = FXCollections.observableArrayList();

        PreparedStatement report_trans = global_variable.conn.prepareStatement("select * from REGISTERED_SUPPLIER");
        ResultSet rs_report_trans = report_trans.executeQuery();

        while (rs_report_trans.next()) {

            data.add(new monthly_report(rs_report_trans.getString("SUPPLIER_NAME"), rs_report_trans.getString("SHOP_LOCATION"), rs_report_trans.getString("SUPPLIER_EMAIL"), rs_report_trans.getString("SHOP_TYPE"), rs_report_trans.getInt("DUE_TAKA"), rs_report_trans.getInt("SUPPLIER_ID")));

        }
        monthly_report.setItems(data);

        

    }

    @FXML
    void initialize() {
        assert monthly_report != null : "fx:id=\"monthly_report\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert SUPPLIER_NAME != null : "fx:id=\"SUPPLIER_NAME\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert supplier_location != null : "fx:id=\"supplier_location\" was not injected: check your FXML file 'Adminnew.fxml'.";
        
        assert shop_type != null : "fx:id=\"shop_type\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert due_taka != null : "fx:id=\"due_taka\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_name != null : "fx:id=\"product_name\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_brand != null : "fx:id=\"product_brand\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_warrantee != null : "fx:id=\"product_warrantee\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_price != null : "fx:id=\"product_price\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_image_link != null : "fx:id=\"product_image_link\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_description != null : "fx:id=\"product_description\" was not injected: check your FXML file 'Adminnew.fxml'.";
        assert product_add != null : "fx:id=\"product_add\" was not injected: check your FXML file 'Adminnew.fxml'.";

        this.product_catagory_combobox.setItems(FXCollections.observableArrayList(admin_product_catagory.values()));

        T = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    
                    
                    
                    admin_profit_id.setCellValueFactory(new PropertyValueFactory<>("profit"));
                    admin_profit_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                    admin_profit_month.setCellValueFactory(new PropertyValueFactory<>("month"));
                    admin_profit_year.setCellValueFactory(new PropertyValueFactory<>("year"));
                    
                    
                    

                    supplier_name1.setCellValueFactory(new PropertyValueFactory<>("supplier_name"));
                    supp_id.setCellValueFactory(new PropertyValueFactory<>("supp_id"));
                    customer_name1.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
                    cust_id.setCellValueFactory(new PropertyValueFactory<>("cust_id"));
                    transporter_name1.setCellValueFactory(new PropertyValueFactory<>("transporter_name"));
                    trans_id.setCellValueFactory(new PropertyValueFactory<>("trans_id"));
                    prod_name1.setCellValueFactory(new PropertyValueFactory<>("product_name"));
                    amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
                    money1.setCellValueFactory(new PropertyValueFactory<>("money"));
                    success1.setCellValueFactory(new PropertyValueFactory<>("success"));
                    o_id.setCellValueFactory(new PropertyValueFactory<>("ORDER"));
                    date_see.setCellValueFactory(new PropertyValueFactory<>("date"));
                    DELIVERED_SEE.setCellValueFactory(new PropertyValueFactory<>("DELIVERY"));

                    SUPPLIER_NAME.setCellValueFactory(new PropertyValueFactory<>("supplier_name"));
                    supplier_location.setCellValueFactory(new PropertyValueFactory<>("supplier_location"));
 
                    shop_type.setCellValueFactory(new PropertyValueFactory<>("shop_type"));
                    due_taka.setCellValueFactory(new PropertyValueFactory<>("due_taka"));
                    supplier_id.setCellValueFactory(new PropertyValueFactory<>("id"));

                    NAME.setCellValueFactory(new PropertyValueFactory<>("PRODUCT"));
                    BRAND.setCellValueFactory(new PropertyValueFactory<>("BRAND"));
                    CATAGORY.setCellValueFactory(new PropertyValueFactory<>("CATAGORY"));
                    AMOUNT.setCellValueFactory(new PropertyValueFactory<>("SELL"));
                    unit_price.setCellValueFactory(new PropertyValueFactory<>("PRICE"));

                    customer_information_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    customer_information_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                    customer_information_district.setCellValueFactory(new PropertyValueFactory<>("district"));
                    customer_information_road.setCellValueFactory(new PropertyValueFactory<>("road"));
                    customer_information_total_buy.setCellValueFactory(new PropertyValueFactory<>("buy"));

                    OUR_PEOPLE_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
                    OUR_PEOPLE_EMAIL.setCellValueFactory(new PropertyValueFactory<>("email"));
                    OUR_PEOPLE_CONTACT_NO.setCellValueFactory(new PropertyValueFactory<>("contact"));
                    OUR_PEOPLE_DISTRICT.setCellValueFactory(new PropertyValueFactory<>("district"));
                    OUR_PEOPLE_ROAD_LOCATION.setCellValueFactory(new PropertyValueFactory<>("location"));
                    OUR_PEOPLE_NID.setCellValueFactory(new PropertyValueFactory<>("nid"));
                    OUR_PEOPLE_REGISTER_DATE.setCellValueFactory(new PropertyValueFactory<>("register_date"));
                    OUR_PEOPLE_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
                    OUR_PEOPLE_CHECK_BOX.setCellValueFactory(new PropertyValueFactory<>("ck"));
                    OUR_PEOPLE_APPROVAL.setCellValueFactory(new PropertyValueFactory<>("approve"));

                    monthly_report_data_initialize();
                    set_data_monitor();
                    all_product_monitor();
                    our_customer();
                    set_table("CUSTOMER");
                    admin_profit_function();

                    catagory_transition = new HamburgerNextArrowBasicTransition(catagory_ham);
                    confirm_trisition_ham = new HamburgerBackArrowBasicTransition(confirm_ham);

                    catagory_ham_drawer.close();
                    catagory_transition.setRate(-1);
                    confirm_trisition_ham.setRate(-1);

                } catch (SQLException ex) {

                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        T.start();

    }

    @FXML
    void log_out(MouseEvent event) throws IOException {
        T.stop();
        Parent customer_page = FXMLLoader.load(getClass().getResource("/level2term2/FIRST_PAGE.fxml"));
        Scene customer_page_scene = new Scene(customer_page);
        Stage customer_stage;
        customer_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customer_stage.setTitle("Home Page");
        customer_stage.setScene(customer_page_scene);
        customer_stage.show();

    }

    void set_data_monitor() throws SQLException {

        monitor_data = FXCollections.observableArrayList();

        String sql = "SELECT SUPPLIER_ID,SUPPLIER_NAME,CUSTOMER_ID,CUSTOMER_NAME,"
                + "TRANSPORTER_ID,TRANSPORTER_NAME,PRODUCT_NAME,AMOUNT,"
                + "MONEY,Date_Ordered,SUCCESS,ORDER_ID\n"
                + "from REGISTERED_SUPPLIER,REGISTERED_CUSTOMER,"
                + "REGISTERED_TRANSPORTER,PRODUCT,ORDER_TABLE\n"
                + "where ORDER_SUPPLIER_NO = SUPPLIER_ID and ORDER_CUSTOMER_NO = CUSTOMER_ID "
                + "and TRANSPORTER_NO = TRANSPORTER_ID and ORDER_PRODUCT_NO = PRODUCT_ID";

        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int a = 0;
        while (rs.next()) {
            JFXCheckBox ckb = new JFXCheckBox();
            monitor_data.add(new monitor(rs.getString("SUPPLIER_NAME"), rs.getString("CUSTOMER_NAME"), rs.getString("TRANSPORTER_NAME"),
                    rs.getString("PRODUCT_NAME"), rs.getInt("MONEY"), ckb, rs.getInt("TRANSPORTER_ID"), rs.getInt("CUSTOMER_ID"),
                    rs.getInt("SUPPLIER_ID"), rs.getInt("AMOUNT"), rs.getInt("ORDER_ID"), rs.getString("Date_Ordered"), rs.getString("SUCCESS")));
            /*rs.getInt("ORDER_ID"), rs.getString("SUPPLIER_NAME"),
                    rs.getString("CUSTOMER_NAME"), rs.getString("TRANSPORTER_NAME"), rs.getString("PRODUCT_NAME"),
                    rs.getInt("MONEY"), new JFXCheckBox(), rs.getInt("TRANSPORTER_ID"), rs.getInt("CUSTOMER_ID"),
                    rs.getInt("SUPPLIER_ID"), rs.getInt("AMOUNT"), rs.getString("Date_Ordered")*/
        }

        buy_sell_history1.setItems(monitor_data);

    }

    

    @FXML
    void sellrecord(MouseEvent event) throws SQLException {
        String pro = "";
        product_data = FXCollections.observableArrayList();
        boolean cat = false;

        try {
            pro = searchfor.getText();
        } catch (Exception E) {
            pro = "";
        }

        String sql = "SELECT SUM(BUY_SELL_HISTORY.HISTORY_AMOUNT) CNT ,PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,\n"
                + "PRODUCT.PRODUCT_TYPE,PRODUCT.PRICE  FROM PRODUCT,BUY_SELL_HISTORY\n"
                + "WHERE HISTORY_PRODUCT_NO = PRODUCT_ID "
                + "GROUP BY  PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,PRODUCT.PRODUCT_TYPE,PRODUCT.PRICE";

        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cat = true;
            product_data.add(new productwisereport(rs.getString("PRODUCT_NAME"),
                    rs.getString("BRAND"), rs.getInt("CNT"), rs.getString("PRODUCT_TYPE"),
                    rs.getInt("PRICE")));
        }
        PROD_TABLE.setItems(product_data);

        sql = "SELECT SUM(BUY_SELL_HISTORY.HISTORY_AMOUNT) CNT ,PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,\n"
                + "PRODUCT.PRODUCT_TYPE,PRODUCT.PRICE  FROM PRODUCT,BUY_SELL_HISTORY\n"
                + "WHERE HISTORY_PRODUCT_NO = PRODUCT_ID "
                + "GROUP BY  PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,PRODUCT.PRODUCT_TYPE,PRODUCT.PRICE";

        if (cat == false) {
            ps = global_variable.conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                product_data.add(new productwisereport(rs.getString("PRODUCT_NAME"),
                        rs.getString("BRAND"), rs.getInt("CNT"), rs.getString("PRODUCT_TYPE"),
                        rs.getInt("PRICE")));
            }
            PROD_TABLE.setItems(product_data);

        }

    }

    @FXML
    void update_new_price(MouseEvent event) {

        System.out.println(product_name_ + "  " + product_brand_ + "   " + catagory_ + "   " + new_price.getText());
        String sql = "UPDATE PRODUCT SET PRICE = ? WHERE "
                + "PRODUCT_NAME = ? AND BRAND  = ? AND PRODUCT_TYPE = ?";

        try {
            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(new_price.getText()));
            ps.setString(2, product_name_);
            ps.setString(3, product_brand_);
            ps.setString(4, catagory_);
            ResultSet rs = ps.executeQuery();
            c_product.setText("UPDATED SUCCESSFULLY");
            all_product_monitor();
        } catch (Exception E) {
            c_product.setText("FAILED TO UPDATE");
        }

        // c_product.setText("FAILED TO UPDATE");
    }

    @FXML
    void remove_checked(MouseEvent event) throws SQLException {

        PreparedStatement ps;
        ResultSet rs;
        for (monitor mon : monitor_data) {
            if (mon.getSuccess().isSelected() == true && mon.getDELIVERY().equals("YES")) {
                System.out.println(mon.getORDER());

                String sql = "DELETE FROM ORDER_TABLE WHERE ORDER_ID = " + mon.getORDER().toString();

                ps = global_variable.conn.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
            }

        }
        all_product_monitor();
        set_data_monitor();
        

    }

    public void all_product_monitor() throws SQLException {

        product_data = FXCollections.observableArrayList();

        String sql = "SELECT COUNT(*) CNT ,PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,\n"
                + "PRODUCT.PRODUCT_TYPE,PRODUCT.PRICE  FROM BUY_SELL_HISTORY,PRODUCT\n"
                + "WHERE HISTORY_PRODUCT_NO = PRODUCT.PRODUCT_ID\n"
                + "GROUP BY PRODUCT.PRODUCT_NAME,PRODUCT.BRAND,PRODUCT.PRODUCT_TYPE,PRODUCT.PRICE";

        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet RS = ps.executeQuery();

        while (RS.next()) {

            product_data.add(new productwisereport(RS.getString("PRODUCT_NAME"),
                    RS.getString("BRAND"), RS.getInt("CNT"), RS.getString("PRODUCT_TYPE"),
                    RS.getInt("PRICE")));
        }
        /*product_data.add(new productwisereport(RS.getString("PRODUCT.PRODUCT_NAME"),
                    RS.getString("PRODUCT.BRAND"), RS.getInt("CNT"), RS.getString("PRODUCT.PRODUCT_TYPE"),
                    RS.getInt("PRICE")));*/
        PROD_TABLE.setItems(product_data);

        PROD_TABLE.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    product_name_ = PROD_TABLE.getSelectionModel().getSelectedItem().getPRODUCT();
                    product_brand_ = PROD_TABLE.getSelectionModel().getSelectedItem().getBRAND();
                    catagory_ = PROD_TABLE.getSelectionModel().getSelectedItem().getCATAGORY();
                    System.out.println(product_brand_);
                    System.out.println(catagory_);
                    c_product.setText(product_name_);

                } catch (Exception E) {
                   c_product.setText("PRESS IN VALID OPTION");
                   
                }
            }
        });

    }

    @FXML
    void refresh_product_table(MouseEvent event) {

        try {
            all_product_monitor();
        } catch (SQLException ex) {
            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void taka_vau(MouseEvent event) throws SQLException {
        
        admin_profit_function();
        //System.out.println("purabi apa");

    }

    public void our_customer() throws SQLException {
        customer = FXCollections.observableArrayList();

        String sql = "SELECT *FROM REGISTERED_CUSTOMER";

        PreparedStatement ps = global_variable.conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            customer.add(new customer_monitor_by_admin(rs.getInt("CUSTOMER_ID"),
                    rs.getString("CUSTOMER_NAME"), rs.getString("CUSTOMER_DISTRICT"),
                    rs.getString("ADDRESS"), rs.getInt("CUSTOMER_TOTAL_BUY")));
        }
        customer_information.setItems(customer);

        rs.close();
        ps.close();

    }

    

    public void set_table(String catagory) throws SQLException {
        our_working_people = FXCollections.observableArrayList();

        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (catagory.equals("TRANSPORTER")) {
            sql = "SELECT *FROM REGISTERED_TRANSPORTER";

            ps = global_variable.conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                our_working_people.add(new our_all_people(rs.getString("TRANSPORTER_NAME"), rs.getString("EMAIL"),
                        rs.getString("CONTACT_NO"), rs.getString("TRANSPORTER_DISTRICT"),
                        rs.getString("ADDRESS"), rs.getString("TRANSPORTER_NID"),
                        rs.getString("REG_DATE_TRANSPORTER"), rs.getInt("TRANSPORTER_ID"), 
                        new JFXCheckBox(),rs.getString("TRANSPORTER_APPROVE")));
            }

        } else if (catagory.equals("SUPPLIER")) {
            sql = "SELECT * FROM REGISTERED_SUPPLIER";
            ps = global_variable.conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                our_working_people.add(new our_all_people(rs.getString("SUPPLIER_NAME"),
                        rs.getString("SUPPLIER_EMAIL"), rs.getString("SUPPLIER_MOBILE_NO"),
                        rs.getString("SHOP_DISTRICT"), rs.getString("SHOP_LOCATION"),
                        rs.getString("SUPPLIER_NID"), rs.getString("REG_DATE_SUPPLIER"),
                        rs.getInt("SUPPLIER_ID"), new JFXCheckBox(),rs.getString("SUPPLIER_APPROVE")));
            }

        } else if(catagory.equals("CUSTOMER")) {
            sql = "SELECT * FROM REGISTERED_CUSTOMER";
            ps = global_variable.conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                our_working_people.add(new our_all_people(rs.getString("CUSTOMER_NAME"),
                        rs.getString("EMAIL"), rs.getString("CUSTOMER_CONTACT_NO"),
                        rs.getString("CUSTOMER_DISTRICT"), rs.getString("ADDRESS"),
                        rs.getString("CUSTOMER_NID"), rs.getString("REG_DATE_CUSTOMER"),
                        rs.getInt("CUSTOMER_ID"), new JFXCheckBox(),rs.getString("CUSTOMER_APPROVE")));
            }
        }else
        {
            sql = "SELECT * FROM REGISTERED_EMPLOYEE";
            ps = global_variable.conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                our_working_people.add(new our_all_people(rs.getString("EMPLOYEE_NAME"),
                        rs.getString("EMAIL"), rs.getString("CONTACT_NO"),
                        rs.getString("EMPLOYEE_DISTRICT"), rs.getString("ADDRESS"),
                        rs.getString("EMPLOYEE_NID"), rs.getString("REG_DATE_EMPLOYEE"),
                        rs.getInt("EMPLOYEE_ID"), new JFXCheckBox(),rs.getString("EMPLOYEE_APPROVE")));
            }
        }

        OUR_PEOPLE.setItems(our_working_people);

    }

    

    @FXML
    void confirm_pressed(MouseEvent event) throws SQLException, IOException {

        vb = FXMLLoader.load(getClass().getResource("vbox_drawer.fxml"));

        confirm_trisition_ham.setRate(confirm_trisition_ham.getRate() * -1);
        confirm_trisition_ham.play();
        if (confirm_ham_drawer.isShown()) {
            confirm_ham_drawer.close();
        } else {
            confirm_ham_drawer.open();
            confirm_ham_drawer.setSidePane(vb);
        }

        for (Node node : vb.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

                    if (node.getAccessibleText().equals("approve_all")) {
                        System.out.println("approve_all");
                        
                        String sql = "";
                        if(cata_text.getText().equalsIgnoreCase("customer"))
                        {
                            sql = "UPDATE REGISTERED_CUSTOMER SET "
                                    + "CUSTOMER_APPROVE = 'APPROVED'"
                                    + " WHERE CUSTOMER_APPROVE = 'WAITING' ";
                            
                            FOR_SQL = "REGISTERED_CUSTOMER";
                            FOR_SQL_APPROVAL = "CUSTOMER_APPROVE";
                            FOR_SQL_ID = "CUSTOMER_ID";
                            
                            
                        }else if(cata_text.getText().equalsIgnoreCase("supplier"))
                        {
                            sql = "UPDATE REGISTERED_SUPPLIER"
                                    + " SET SUPPLIER_APPROVE = 'APPROVED'"
                                    + " WHERE SUPPLIER_APPROVE = 'WAITING' ";
                            
                            FOR_SQL = "REGISTERED_SUPPLIER";
                            FOR_SQL_APPROVAL = "SUPPLIER_APPROVE";
                            FOR_SQL_ID = "SUPPLIER_ID";
                            
                        }else if(cata_text.getText().equalsIgnoreCase("transporter"))
                        {
                            sql = "UPDATE REGISTERED_TRANSPORTER "
                                    + "SET TRANSPORTER_APPROVE = 'APPROVED' "
                                    + "WHERE TRANSPORTER_APPROVE = 'WAITING' ";
                            
                            FOR_SQL = "REGISTERED_TRANSPORTER";
                            FOR_SQL_APPROVAL = "TRANSPORTER_APPROVE";
                            FOR_SQL_ID = "TRANSPORTER_ID";
                        }else
                        {
                            sql = "UPDATE REGISTERED_EMPLOYEE "
                                    + "SET EMPLOYEE_APPROVE = 'APPROVED' "
                                    + "WHERE EMPLOYEE_APPROVE = 'WAITING' ";
                            
                            FOR_SQL = "REGISTERED_EMPLOYEE";
                            FOR_SQL_APPROVAL = "EMPLOYEE_APPROVE";
                            FOR_SQL_ID = "EMPLOYEE_ID";
                        }
                        
                        System.out.println(FOR_SQL);
                        
                        try {
                            PreparedStatement ps = global_variable.conn.prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();
                            set_table(cata_text.getText());
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                        
                        
                    } else if (node.getAccessibleText().equals("approve_selected")) {
                        
                        for(our_all_people people : our_working_people)
                        {
                            if(people.getCk().isSelected() == true)
                            {
                                try {
                                    String sql = "UPDATE "+FOR_SQL+" SET "+FOR_SQL_APPROVAL+" = 'APPROVED' "
                                            + "WHERE "+FOR_SQL_ID + " = "+people.getId().toString();
                                    
                                    PreparedStatement ps = global_variable.conn.prepareStatement(sql);
                                    ResultSet rs = ps.executeQuery();
                                    
                                    
                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        
                        try {
                            set_table(cata_text.getText());
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                    } else {
                        for(our_all_people people : our_working_people)
                        {
                            if(people.getCk().isSelected() == true)
                            {
                                try {
                                    String sql = "UPDATE "+FOR_SQL+" SET "+FOR_SQL_APPROVAL+" = 'BLOCKED' "
                                            + "WHERE "+FOR_SQL_ID + " = "+people.getId().toString();
                                    
                                    PreparedStatement ps = global_variable.conn.prepareStatement(sql);
                                    ResultSet rs = ps.executeQuery();
                                    
                                    
                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        try {
                            set_table(cata_text.getText());
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
            }
        }

        /*

        //String sql = "UPDATE REGISTERED_TRANSPORTER SET TRANSPORTER_APPROVE = 'APPROVED' WHERE TRANSPORTER_ID = ?";         
        //String sql = "UPDATE REGISTERED_CUSTOMER SET CUSTOMER_APPROVE = 'APPROVED' WHERE CUSTOMER_ID = ";        
        //String sql = "UPDATE REGISTERED_SUPPLIER SET SUPPLIER_APPROVE = 'APPROVED' WHERE SUPPLIER_ID = ";
        //String sql = "UPDATE REGISTERED_TRANSPORTER SET TRANSPORTER_APPROVE = 'APPROVED' WHERE TRANSPORTER_APPROVE = 'WAITING' ";
        //String sql = "UPDATE REGISTERED_CUSTOMER SET CUSTOMER_APPROVE = 'APPROVED' WHERE CUSTOMER_APPROVE = 'WAITING' ";
        String sql = "UPDATE REGISTERED_SUPPLIER SET SUPPLIER_APPROVE = 'APPROVED' WHERE SUPPLIER_APPROVE = 'WAITING' ";

    
         */
    }

    @FXML
    void catagory_selection_and_show(MouseEvent event) throws IOException {

        vb2 = FXMLLoader.load(getClass().getResource("vbox_2.fxml"));
        catagory_transition.setRate(catagory_transition.getRate() * -1);
        catagory_transition.play();

        if (catagory_ham_drawer.isShown()) {
            catagory_ham_drawer.close();
        } else {
            catagory_ham_drawer.open();
            catagory_ham_drawer.setSidePane(vb2);
        }

        for (Node node : vb2.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

                    if (node.getAccessibleText().equals("customer")) {
                        try {
                            
                            FOR_SQL = "REGISTERED_CUSTOMER";
                            FOR_SQL_APPROVAL = "CUSTOMER_APPROVE";
                            FOR_SQL_ID = "CUSTOMER_ID";
                            set_table("CUSTOMER");
                            cata_text.setText("CUSTOMER");
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (node.getAccessibleText().equals("supplier")) {
                        try {
                            
                            FOR_SQL = "REGISTERED_SUPPLIER";
                            FOR_SQL_APPROVAL = "SUPPLIER_APPROVE";
                            FOR_SQL_ID = "SUPPLIER_ID";
                            
                            
                            set_table("SUPPLIER");
                            cata_text.setText("SUPPLIER");
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if(node.getAccessibleText().equals("transporter")) {
                        try {
                            
                            FOR_SQL = "REGISTERED_TRANSPORTER";
                            FOR_SQL_APPROVAL = "TRANSPORTER_APPROVE";
                            FOR_SQL_ID = "TRANSPORTER_ID";
                            
                            set_table("TRANSPORTER");
                            cata_text.setText("TRANSPORTER");
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else
                    {
                        try {
                            
                            FOR_SQL = "REGISTERED_EMPLOYEE";
                            FOR_SQL_APPROVAL = "EMPLOYEE_APPROVE";
                            FOR_SQL_ID = "EMPLOYEE_ID";
                            
                            set_table("EMPLOYEE");
                            cata_text.setText("STAFF");
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminnewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
            }

        }

    }
    
    
    
    
    
    
    
    
    
    public void admin_profit_function() throws SQLException
    {
        
        profit_data = FXCollections.observableArrayList();
        
        String sql = "SELECT SUM(PROFIT) PO ,MONTH,YEAR,"
                + "SUM(MONTHLY_SALARY)/COUNT(*) MON "
                + " FROM ADMIN_PROFIT GROUP BY MONTH,YEAR";
        PreparedStatement ps = global_variable.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        
        while(rs.next())
        {
            profit_data.add(new admin_profit_class(rs.getInt("PO"), 
                    rs.getInt("MON"),rs.getString("MONTH"), 
                    rs.getString("YEAR")));
        }
        
        taka_and_poisa.setItems(profit_data);
        
        
        
        
    }
    
    
    
   
}

  