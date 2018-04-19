package level2term2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static level2term2.global_variable.conn;

public class FXMLDocumentController {

    @FXML
    private Label newregister_text;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text check_it_;

    @FXML
    private Text now_ststus_;

    @FXML
    private JFXTextField loginemail;

    @FXML
    private JFXPasswordField loginpassword;

    @FXML
    private JFXComboBox<catagory> logincatagory;

    @FXML
    private JFXButton userloginbtn;

    @FXML
    private JFXTextField registername;

    @FXML
    private JFXTextField registeremail;

    @FXML
    private JFXTextField mobile_no;

    @FXML
    private JFXPasswordField registerpassword;

    @FXML
    private JFXComboBox<catagory> registercatagory;

    @FXML
    private JFXButton registersubmitbtn;

    @FXML
    private Label loginlabel;

    @FXML
    void login_check_fxml(MouseEvent event) throws IOException, SQLException {
        String ctg = logincatagory.getValue().toString().toUpperCase();
        System.out.println(ctg);
        String sql_catagory = "";
        String title = "";
        String appr = "";
        boolean tst = false;
        String full_catagory = "";
        if (ctg.equals("CUSTOMER")) {
            tst = true;
            sql_catagory = "select *from REGISTERED_CUSTOMER where EMAIL = ? and PASSWORD = ?";
            full_catagory = "/customer_tranporter_admin/customer_page.fxml";
            title = "Customer Window";
            appr = "CUSTOMER_APPROVE";
        } else if (ctg.equals("SUPPLIER")) {
            tst = true;
            sql_catagory = "select *from REGISTERED_SUPPLIER where SUPPLIER_EMAIL= ? and PASSWORD = ?";
            full_catagory = "/successful_message/success_supplier_dashboard.fxml";
            title = "Supplier Window";
            appr = "SUPPLIER_APPROVE";
        } else if (ctg.equals("TRANSPORTER")) {
            tst = true;
            sql_catagory = "select *from REGISTERED_TRANSPORTER where EMAIL = ? and PASSWORD = ?";
            full_catagory = "/customer_tranporter_admin/transporter.fxml";
            title = "Tranporter Page";
            appr = "TRANSPORTER_APPROVE";
        } else if (ctg.equals("EMPLOYEE")) {
            tst = true;
            sql_catagory = "select *from REGISTERED_EMPLOYEE where EMAIL = ? and PASSWORD = ?";
            full_catagory = "/successful_message/employee_management.fxml";
            title = "Employee Page";
            appr = "EMPLOYEE_APPROVE";
        }
        if (tst == true) {
            PreparedStatement ps = global_variable.conn.prepareStatement(sql_catagory);
            ps.setString(1, loginemail.getText());
            ps.setString(2, loginpassword.getText());
            ResultSet rs = ps.executeQuery();
            global_variable.password = loginpassword.getText();
            global_variable.email = loginemail.getText();
            if (rs.next()) {

                if (rs.getString(appr).equals("APPROVED")) {
                    Parent page = FXMLLoader.load(getClass().getResource(full_catagory));
                    Scene page_scene = new Scene(page);

                    Stage stage;
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    stage.setTitle(title);
                    stage.setScene(page_scene);

                    stage.show();
                } else {
                    now_ststus_.setText("WAITING FOR APPROVAL");
                }

            } else {
                now_ststus_.setText("Invalid Login");
                System.out.println("not valid");
            }
            rs.close();
            ps.close();
        } else {
            if (loginemail.getText().equals("Admin") && loginpassword.getText().equals("database")) {
                Parent page = FXMLLoader.load(getClass().getResource("/successful_message/Adminnew.fxml"));
                Scene page_scene = new Scene(page);
                Stage stage;
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Control Pannel");
                stage.setScene(page_scene);

                stage.show();
            } else {
                now_ststus_.setText("Invalid Login");
            }
        }

    }

    @FXML
    void registration(MouseEvent event) {

        try {
            global_variable.email = registeremail.getText();
            global_variable.name = registername.getText();
            global_variable.password = registerpassword.getText();
            global_variable.mobile_no_ = this.mobile_no.getText();
            global_variable.catagory = registercatagory.getValue().toString().toUpperCase();
            global_variable.username = global_variable.name;
            global_variable.usercatagory = global_variable.catagory;

            if (global_variable.catagory.equals("CUSTOMER")) {

                //PreparedStatement check = global_variable.conn.prepareStatement("select * from REGISTERED_CUSTOMER where EMAIL = ?");
                //check.setString(1, global_variable.email);
                //ResultSet check_rs = check.executeQuery();
                String query = "{? = call VALIDITY(?,?)}";
                CallableStatement stmt1 = global_variable.conn.prepareCall(query);
                stmt1.setString(2, "CUSTOMER");
                stmt1.setString(3, global_variable.email);
                //System.out.println("Product_Name : " + pname);

                stmt1.registerOutParameter(1, Types.VARCHAR);
                stmt1.execute();
                String pid = stmt1.getString(1);

                if (pid.equals("YES")) {
                    check_it_.setText("E-mail already exists");
                } else {
                    Stage tag = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/successful_message/extra_info_customer.fxml"));
                    //Text tx = new Text("kichu to aai");
                    Parent root1 = (Parent) loader.load();
                    tag.setScene(new Scene(root1));
                    tag.initStyle(StageStyle.UNDECORATED);
                    tag.initModality(Modality.APPLICATION_MODAL);
                    tag.initOwner(registersubmitbtn.getScene().getWindow());

                    tag.showAndWait();

                    log_();
                }

            } else if (global_variable.catagory.equals("SUPPLIER")) {
                //String shop = shoptype.getValue().toString().toUpperCase();
                String query = "{? = call VALIDITY(?,?)}";
                CallableStatement stmt1 = global_variable.conn.prepareCall(query);
                stmt1.setString(2, "SUPPLIER");
                stmt1.setString(3, global_variable.email);
                stmt1.registerOutParameter(1, Types.VARCHAR);
                stmt1.execute();
                String pid = stmt1.getString(1);
                if (pid.equals("YES")) {
                    check_it_.setText("Invalid Email");
                } else {
                    Stage tag = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/successful_message/extra_info_supplier.fxml"));
                    //Text tx = new Text("kichu to aai");
                    Parent root1 = (Parent) loader.load();
                    tag.setScene(new Scene(root1));
                    tag.initStyle(StageStyle.UNDECORATED);
                    tag.initModality(Modality.APPLICATION_MODAL);
                    tag.initOwner(registersubmitbtn.getScene().getWindow());

                    tag.showAndWait();

                    log_();
                }
                ;

            } else if (global_variable.catagory.equals("TRANSPORTER")) {
                String query = "{? = call VALIDITY(?,?)}";
                CallableStatement stmt1 = global_variable.conn.prepareCall(query);
                stmt1.setString(2, "TRANSPORTER");
                stmt1.setString(3, global_variable.email);
                //System.out.println("Product_Name : " + pname);

                stmt1.registerOutParameter(1, Types.VARCHAR);
                stmt1.execute();
                String pid = stmt1.getString(1);
                if (pid.equals("YES")) {
                    check_it_.setText("Invalid Email");
                } else {

                    Stage tag = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/successful_message/extra_info_transporter.fxml"));
                    //Text tx = new Text("kichu to aai");
                    Parent root1 = (Parent) loader.load();
                    tag.setScene(new Scene(root1));
                    tag.initStyle(StageStyle.UNDECORATED);
                    tag.initModality(Modality.APPLICATION_MODAL);
                    tag.initOwner(registersubmitbtn.getScene().getWindow());

                    tag.showAndWait();

                    log_();
                }

            } else if (global_variable.catagory.equals("EMPLOYEE")) {
                //String shop = shoptype.getValue().toString().toUpperCase();
                String query = "{? = call VALIDITY(?,?)}";
                CallableStatement stmt1 = global_variable.conn.prepareCall(query);
                stmt1.setString(2, "EMPLOYEE");
                stmt1.setString(3, global_variable.email);
                stmt1.registerOutParameter(1, Types.VARCHAR);
                stmt1.execute();
                String pid = stmt1.getString(1);
                if (pid.equals("YES")) {
                    check_it_.setText("Invalid Email");
                } else {
                    Stage tag = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/successful_message/extra_info_employee.fxml"));
                    //Text tx = new Text("kichu to aai");
                    Parent root1 = (Parent) loader.load();
                    tag.setScene(new Scene(root1));
                    tag.initStyle(StageStyle.UNDECORATED);
                    tag.initModality(Modality.APPLICATION_MODAL);
                    tag.initOwner(registersubmitbtn.getScene().getWindow());

                    tag.showAndWait();

                    log_();

                }
                ;

            } else {
                check_it_.setText("INVALID OPERATION");
            }

            //ps.executeUpdate();
            //ps.close();
        } catch (Exception E) {
            check_it_.setText("PLEASE FILLUP ALL");
        }
        /*Parent customer_page = FXMLLoader.load(getClass().getResource("/successful_message/reg_success.fxml"));
            Scene customer_page_scene = new Scene(customer_page);
            Stage customer_stage;
            customer_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            customer_stage.setTitle("Registration Successful");
            customer_stage.setScene(customer_page_scene);
            customer_stage.show();*/

    }

    @FXML
    void newregistration_initialize(MouseEvent event) {
        this.registeremail.setOpacity(1);
        this.registername.setOpacity(1);
        this.registerpassword.setOpacity(1);
        this.registercatagory.setOpacity(1);
        this.registersubmitbtn.setOpacity(1);
        this.mobile_no.setOpacity(1);
        this.loginemail.setOpacity(0);
        this.loginpassword.setOpacity(0);
        this.logincatagory.setOpacity(0);
        this.userloginbtn.setOpacity(0);
        this.loginlabel.setText("");
        this.now_ststus_.setText("");
        this.newregister_text.setText("REGISTRATION");
        this.userloginbtn.setDisable(true);
        this.registersubmitbtn.setDisable(false);
    }

    public void log_() {
        this.registeremail.setOpacity(0);
        this.registername.setOpacity(0);
        this.registerpassword.setOpacity(0);
        this.registercatagory.setOpacity(0);
        this.registersubmitbtn.setOpacity(0);
        this.mobile_no.setOpacity(0);
        this.loginemail.setOpacity(1);
        this.loginpassword.setOpacity(1);
        this.logincatagory.setOpacity(1);
        this.userloginbtn.setOpacity(1);
        this.loginlabel.setText("Log In");
        this.now_ststus_.setText("");
        this.newregister_text.setText("CREATE NEW ACCOUNT ?");
        this.userloginbtn.setDisable(false);
        this.registersubmitbtn.setDisable(true);
    }

    @FXML
    void initialize() {
        assert check_it_ != null : "fx:id=\"check_it_\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert now_ststus_ != null : "fx:id=\"now_ststus_\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert loginemail != null : "fx:id=\"loginemail\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert loginpassword != null : "fx:id=\"loginpassword\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert logincatagory != null : "fx:id=\"logincatagory\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert userloginbtn != null : "fx:id=\"userloginbtn\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert registername != null : "fx:id=\"registername\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert registeremail != null : "fx:id=\"registeremail\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert mobile_no != null : "fx:id=\"mobile_no\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert registerpassword != null : "fx:id=\"registerpassword\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert registercatagory != null : "fx:id=\"registercatagory\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";
        assert registersubmitbtn != null : "fx:id=\"registersubmitbtn\" was not injected: check your FXML file 'FIRST_PAGE.fxml'.";

        this.registeremail.setOpacity(0);
        this.registername.setOpacity(0);
        this.registerpassword.setOpacity(0);
        this.registercatagory.setOpacity(0);
        this.registersubmitbtn.setOpacity(0);
        this.mobile_no.setOpacity(0);
        this.logincatagory.setItems(FXCollections.observableArrayList(catagory.values()));
        this.registercatagory.setItems(FXCollections.observableArrayList(catagory.values()));
        this.userloginbtn.setDisable(false);

    }

}
