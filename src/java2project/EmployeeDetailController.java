/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java2project.Models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aney
 */
public class EmployeeDetailController implements Initializable
{
   @FXML
   private Button backButton;




   private Employee employee;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      // TODO
   }


   @FXML
   void loadDoneOp (ActionEvent event)
   {
      System.out.println("@@@");
   }


   public void setEmployee (Employee employee)
   {
      this.employee = employee;
   }

   void setStage (Stage stage)
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @FXML
   private void backButtonDidTap (ActionEvent event) throws IOException
   {
      Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

      Scene scene = new Scene(root);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
   }
}
