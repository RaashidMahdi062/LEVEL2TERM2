package successful_message;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import level2term2.global_variable;

public class Employee_managementController {
    
    Integer supp_id;

    Integer mon = 0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

     @FXML
    private TableView<monthly_report> monthly_report;

    @FXML
    private TableColumn<monthly_report, String> SUPPLIER_NAME;

    @FXML
    private TableColumn<monthly_report, String> supplier_location;

    @FXML
    private TableColumn<monthly_report, String> shop_name;

    @FXML
    private TableColumn<monthly_report, String> shop_type;

    @FXML
    private TableColumn<monthly_report, Integer> due_taka;

    @FXML
    private TableColumn<monthly_report, Integer> supplier_id;


    @FXML
    private JFXTextField paying;

    @FXML
    private Label sid;
    @FXML
    private Text empname;

    @FXML
    private Text empid;

    @FXML
    private Text datefield;
    
    private ObservableList<monthly_report> data;

    @FXML
    void payingoperation(MouseEvent event) throws SQLException {
        Integer given = Integer.parseInt(paying.getText());
        PreparedStatement money_update = global_variable.conn.prepareStatement("UPDATE REGISTERED_SUPPLIER SET DUE_TAKA=? WHERE SUPPLIER_ID = ?");
        money_update.setInt(1, (mon - given));
        money_update.setInt(2, supp_id);
        ResultSet rs_money_update = money_update.executeQuery();
        /*if (mon - given <= 0) {
            monthly_report.getItems().removeAll(monthly_report.getSelectionModel().getSelectedItems());
        }*/
        this.monthly_report_data_initialize();
        paying.setText("");
        rs_money_update.close();
        money_update.close();

    }
    
    private void monthly_report_data_initialize() throws SQLException {

        data = FXCollections.observableArrayList();

        PreparedStatement report_trans = global_variable.conn.prepareStatement("select * from REGISTERED_SUPPLIER");
        ResultSet rs_report_trans = report_trans.executeQuery();

        while (rs_report_trans.next()) {

            data.add(new monthly_report(rs_report_trans.getString("SUPPLIER_NAME"), 
                    rs_report_trans.getString("SHOP_LOCATION"), rs_report_trans.getString("SUPPLIER_EMAIL"), 
                    rs_report_trans.getString("SHOP_TYPE"), rs_report_trans.getInt("DUE_TAKA"),
                    rs_report_trans.getInt("SUPPLIER_ID")));

        }
        monthly_report.setItems(data);

        monthly_report.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    supp_id = monthly_report.getSelectionModel().getSelectedItem().getId();
                    mon = monthly_report.getSelectionModel().getSelectedItem().getDue_taka();
                    
                    sid.setText("SUPPLIER ID : " + monthly_report.getSelectionModel().getSelectedItem().getId().toString());
                    //System.out.println(shop);

                } catch (Exception E) {
                    sid.setText("PRESS IN VALID OPTION");
                }
            }
        });

    }

    @FXML
    void initialize() throws SQLException {
        assert monthly_report != null : "fx:id=\"monthly_report\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert SUPPLIER_NAME != null : "fx:id=\"SUPPLIER_NAME\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert supplier_location != null : "fx:id=\"supplier_location\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert shop_name != null : "fx:id=\"shop_name\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert shop_type != null : "fx:id=\"shop_type\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert due_taka != null : "fx:id=\"due_taka\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert supplier_id != null : "fx:id=\"supplier_id\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert paying != null : "fx:id=\"paying\" was not injected: check your FXML file 'employee_management.fxml'.";
        assert sid != null : "fx:id=\"sid\" was not injected: check your FXML file 'employee_management.fxml'.";

        
        
        
        
        
        
        
        
        
        
        SUPPLIER_NAME.setCellValueFactory(new PropertyValueFactory<>("supplier_name"));
                    supplier_location.setCellValueFactory(new PropertyValueFactory<>("supplier_location"));
                    shop_name.setCellValueFactory(new PropertyValueFactory<>("shop_name"));
                    shop_type.setCellValueFactory(new PropertyValueFactory<>("shop_type"));
                    due_taka.setCellValueFactory(new PropertyValueFactory<>("due_taka"));
                    supplier_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    
                    String sql1="SELECT EMPLOYEE_ID,EMPLOYEE_NAME FROM REGISTERED_EMPLOYEE WHERE EMAIL = ? ";
                    PreparedStatement PS1=global_variable.conn.prepareStatement(sql1);
                    PS1.setString(1, global_variable.email);
                    ResultSet RS1=null;
                    RS1=PS1.executeQuery();
                    RS1.next();
                    empid.setText("ID : "+RS1.getString("EMPLOYEE_ID"));
                    empname.setText("Name : "+RS1.getString("EMPLOYEE_NAME"));
                    String sql="SELECT TO_CHAR(SYSDATE) FROM DUAL";
                    PreparedStatement PS=global_variable.conn.prepareStatement(sql);
                    ResultSet RS=null;
                    RS=PS.executeQuery();
                    RS.next();
                    datefield.setText("DATE : "+RS.getString(1));
                    
                    
                    monthly_report_data_initialize();
    }
    
    
    
    @FXML
    void log_out(MouseEvent event) throws IOException {
       
        Parent customer_page = FXMLLoader.load(getClass().getResource("/level2term2/FIRST_PAGE.fxml"));
        Scene customer_page_scene = new Scene(customer_page);
        Stage customer_stage;
        customer_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        customer_stage.setTitle("Home Page");
        customer_stage.setScene(customer_page_scene);
        customer_stage.show();

    }
}
