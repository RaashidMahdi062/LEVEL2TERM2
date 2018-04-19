/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level2term2;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class LEVEL2TERM2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        global_variable.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","hr");
        if(global_variable.conn != null)
        {
            Parent root = FXMLLoader.load(getClass().getResource("FIRST_PAGE.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
      
    
}


