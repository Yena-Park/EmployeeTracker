package java2project.Views.AddEmployee;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MJ
 */
public class AddNewEmployeeController implements Initializable
{

   @FXML
   private TextField lastNameTextField;
   @FXML
   private TextField firstNameTextField;
   @FXML
   private TextField employeeNumberTextField;
   @FXML
   private TextField birthDateTextField;
   @FXML
   private TextField streetTextField;
   @FXML
   private TextField cityTextField;
   @FXML
   private TextField provinceTextField;
   @FXML
   private TextField phoneNumberTextField;
   @FXML
   private TextField emailTextField;
   @FXML
   private TextField emergencyContactTextField;
   @FXML
   private TextField sinNumberTextField;
   @FXML
   private ComboBox positionComboBox;
   @FXML
   private TextField payRateTextField;
   @FXML
   private ComboBox departmentComboBox;
   @FXML
   private TextField hiredDateTextField;
   @FXML
   private TextField terminatedTextField;
   @FXML
   private TextField availabilityTextField;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      // TODO:
      setupUI();
   }

   private void setupUI ()
   {
      positionComboBox.getItems().addAll(
              "Manager",
              "Staff",
              "CEO",
              "CTO"
      );
      departmentComboBox.getItems().addAll(
              "IT",
              "Marketing",
              "Customer Service"
      );
   }

   @FXML
   private void backButtonDidTap (ActionEvent event) throws IOException
   {
      String loc = "java2project/Views/EmployeeList/FXMLDocument.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();

      Scene scene = new Scene(root);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setTitle("Employee List");
      stage.setScene(scene);
      stage.show();
   }

   @FXML
   private void saveButtonDidTap (ActionEvent event) throws IOException
   {
      //TODO: Save txt File
   }

   @FXML
   private void departmentComboBoxValueChanged (ActionEvent event) throws IOException
   {

   }

   @FXML
   private void positionComboBoxValueChanged (ActionEvent event) throws IOException
   {

   }

}
