package customer_tranporter_admin;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import level2term2.global_variable;

public class ReceiptController {

    @FXML
    private AnchorPane gui;

    @FXML
    private Text decoration_customer_name;

    @FXML
    private Text decoration_customer_contact_no;

    @FXML
    private Text decoration_location;

    @FXML
    private Text decoration_product_name;

    @FXML
    private Text decoration_amount;

    @FXML
    private Text decoration_total_price;

    @FXML
    private Text decoration_secret_pin;

    @FXML
    private Text district;

    @FXML
    private JFXButton confirmbtn;
    
    @FXML
    private Text delivert;

    @FXML
    void aded_to_cart_shop_order(MouseEvent event) {
        Stage tag=(Stage)confirmbtn.getScene().getWindow();
        tag.close();
    }

    @FXML
    void initialize() {
        assert gui != null : "fx:id=\"gui\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_customer_name != null : "fx:id=\"decoration_customer_name\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_customer_contact_no != null : "fx:id=\"decoration_customer_contact_no\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_location != null : "fx:id=\"decoration_location\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_product_name != null : "fx:id=\"decoration_product_name\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_amount != null : "fx:id=\"decoration_amount\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_total_price != null : "fx:id=\"decoration_total_price\" was not injected: check your FXML file 'receipt.fxml'.";
        assert confirmbtn != null : "fx:id=\"confirmbtn\" was not injected: check your FXML file 'receipt.fxml'.";
        assert decoration_secret_pin != null : "fx:id=\"decoration_secret_pin\" was not injected: check your FXML file 'receipt.fxml'.";

        
        
        
        
        decoration_customer_name.setText("Customer Name : "+global_variable.username);
        decoration_customer_contact_no.setText("Customer Contact No : "+global_variable.mobile_no_);
        decoration_amount.setText("Ordered Amount : "+global_variable.amount.toString());
        
        decoration_location.setText("Delivery Location : "+global_variable.location);
        decoration_secret_pin.setText("SECRET PIN : "+global_variable.secret_pin);
        district.setText("City : "+global_variable.district);
        decoration_product_name.setText("Product Name : "+global_variable.product_name );
        
        if(global_variable.district.equalsIgnoreCase("dhaka"))
        {
            global_variable.price  = global_variable.price  - 50;
           decoration_total_price.setText("Total Price : "+(global_variable.price).toString()+" TK");
           delivert.setText("Delivery Charge : 50 TK");
        }else
        {
            global_variable.price = global_variable.price - 100;
            decoration_total_price.setText("Total Price : "+global_variable.price.toString()+" TK");
            delivert.setText("Delivery Charge : 100 TK");
        }
        
        
    }
}
