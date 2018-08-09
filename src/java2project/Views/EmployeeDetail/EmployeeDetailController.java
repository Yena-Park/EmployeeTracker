/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project.Views.EmployeeDetail;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aney
 */
public class EmployeeDetailController implements Initializable
{

   // UI
   @FXML
   private Button backButton;
   @FXML
   private Label titleLabel;
   @FXML
   private Label employeeNumberLabel;
   @FXML
   private Label nameLabel;
   @FXML
   private Label emailLabel;
   @FXML
   private Label birthDateLabel;
   @FXML
   private Label addressLabel;
   @FXML
   private Label phoneNumberLabel;
   @FXML
   private Label emergencyContactLabel;
   @FXML
   private Label sinNumberLabel;
   @FXML
   private Label positionLabel;
   @FXML
   private Label payRateLabel;
   @FXML
   private Label departmentLabel;
   @FXML
   private Label hiredDateLabel;
   @FXML
   private Label terminatedDateLabel;
   @FXML
   private Label availabilityLabel;
   @FXML
   private Label bankNameLabel;
   @FXML
   private Label bankTransitNumberLabel;
   @FXML
   private Label bankInstitutionNumberLabel;
   @FXML
   private Label bankAccountNumberLabel;

   //Properties
   private Employee employee;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      if (employee != null) {
         setupUI();
      }
   }

   public void initData (Employee employee)
   {
      setEmployee(employee);

      setupUI();
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

   private void setupUI ()
   {
      String fullName = employee.getLastName() + " " + employee.getFirstName();
      // set title
      titleLabel.setText(fullName + "'s Profile");

      // setup detail infomation
      employeeNumberLabel.setText("" + employee.getEmployeeNumber());
      nameLabel.setText(fullName);
      birthDateLabel.setText(employee.getBirthday());
      String address = employee.getStreetAddress() + " " + employee.getCity() + " " + employee.getProvince();
      addressLabel.setText(address);
      emailLabel.setText(employee.getEmailAddress());
      phoneNumberLabel.setText(employee.getPhoneNumber());
      emergencyContactLabel.setText(employee.getEmergencyContact());
      sinNumberLabel.setText(employee.getSinNumber());
      positionLabel.setText(employee.getPosition());
      payRateLabel.setText("" + employee.getPayRate());
      departmentLabel.setText(employee.getDepartment());
      hiredDateLabel.setText(employee.getDateHired());
      terminatedDateLabel.setText(employee.getDateTerminated());
      availabilityLabel.setText(employee.getAvailability());
      bankNameLabel.setText(employee.getBankName());
      bankTransitNumberLabel.setText("" + employee.getBankTransitNumber());
      bankInstitutionNumberLabel.setText("" + employee.getBankInstitutionNumber());
      bankAccountNumberLabel.setText("" + employee.getBankAccountNumber());
   }
}
