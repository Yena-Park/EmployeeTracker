package java2project.Views.AddEmployee;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import java2project.Models.Employee;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

   private String selectedDerpartment = "";

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
              "Employee",
              "CEO",
              "CTO"
      );

      positionComboBox.setPromptText("Select position");
      positionComboBox.setEditable(true);
      positionComboBox.valueProperty().addListener(new ChangeListener<String>()
      {
         @Override
         public void changed (ObservableValue ov, String t, String t1)
         {
            System.out.println(t1);
         }
      });

      departmentComboBox.getItems().addAll(
              "IT",
              "Sales",
              "Marketing",
              "Customer Service"
      );
      departmentComboBox.setPromptText("Select department");
      departmentComboBox.setEditable(true);
      departmentComboBox.valueProperty().addListener(new ChangeListener<String>()
      {
         @Override
         public void changed (ObservableValue ov, String t, String t1)
         {
            System.out.println(t1);
            selectedDerpartment = departmentComboBox.getSelectionModel().getSelectedItem().toString();
         }
      });
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
      if (checkValidation()) {
         saveNewEmployee();

         // go to main
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
      else {
         showAlertWithHeaderText();
      }
   }

   private boolean checkValidation ()
   {
      // TODO: 
      return employeeNumberTextField.getText().length() > 0
              && lastNameTextField.getText().length() > 0
              && firstNameTextField.getText().length() > 0
              && birthDateTextField.getText().length() > 0
              && streetTextField.getText().length() > 0
              && cityTextField.getText().length() > 0
              && provinceTextField.getText().length() > 0
              && phoneNumberTextField.getText().length() > 0
              && emailTextField.getText().length() > 0
              && emergencyContactTextField.getText().length() > 0
              && sinNumberTextField.getText().length() > 0
              && positionComboBox.getSelectionModel().getSelectedItem() != null
              && payRateTextField.getText().length() > 0
              && departmentComboBox.getSelectionModel().getSelectedItem() != null
              && hiredDateTextField.getText().length() > 0;
   }

   public void saveNewEmployee ()
   {
      Employee newEmployee = new Employee();

      newEmployee.setEmployeeNumber(Integer.parseInt(employeeNumberTextField.getText()));
      newEmployee.setLastName(lastNameTextField.getText());
      newEmployee.setFirstName(firstNameTextField.getText());
      newEmployee.setBirthday(birthDateTextField.getText());
      newEmployee.setStreetAddress(streetTextField.getText());
      newEmployee.setCity(cityTextField.getText());
      newEmployee.setProvince(provinceTextField.getText());
      newEmployee.setPhoneNumber(phoneNumberTextField.getText());
      newEmployee.setEmailAddress(emailTextField.getText());
      newEmployee.setEmergencyContact(emergencyContactTextField.getText());
      newEmployee.setSinNumber(sinNumberTextField.getText());
      newEmployee.setPosition(positionComboBox.getSelectionModel().getSelectedItem().toString());
      newEmployee.setPayRate(Double.parseDouble(payRateTextField.getText()));
      newEmployee.setDepartment(departmentComboBox.getSelectionModel().getSelectedItem().toString());
      newEmployee.setDateHired(hiredDateTextField.getText());

      Writer output;
      try {
         output = new BufferedWriter(new FileWriter("employees.txt", true));
         output.append("" + newEmployee.getEmployeeNumber());
         output.append(",");
         output.append(newEmployee.getLastName());
         output.append(",");
         output.append(newEmployee.getFirstName());
         output.append(",");
         output.append(newEmployee.getBirthday());
         output.append(",");
         output.append(newEmployee.getStreetAddress());
         output.append(",");
         output.append(newEmployee.getCity());
         output.append(",");
         output.append(newEmployee.getProvince());
         output.append(",");
         output.append(newEmployee.getPhoneNumber());
         output.append(",");
         output.append(newEmployee.getEmailAddress());
         output.append(",");
         output.append(newEmployee.getEmergencyContact());
         output.append(",");
         output.append(newEmployee.getSinNumber());
         output.append(",");
         output.append(newEmployee.getPosition());
         output.append(",");
         output.append("" + newEmployee.getPayRate());
         output.append(",");
         // bug??
         output.append(selectedDerpartment);
         output.append(",");
         output.append(newEmployee.getDateHired());
         output.append("\n");
         output.close();
      }
      catch (IOException ex) {
      }
   }

   // Show a Information Alert with header Text
   private void showAlertWithHeaderText ()
   {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Add New Employee");
      alert.setHeaderText("Enter Information");
      alert.setContentText("Please enter all inputs.");

      alert.showAndWait();
   }

}
