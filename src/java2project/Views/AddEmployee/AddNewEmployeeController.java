package java2project.Views.AddEmployee;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.DatePicker;
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
   private DatePicker birthDatePicker;
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
   private DatePicker hiredDatePicker;
   @FXML
   private DatePicker terminatedDatePicker;
   @FXML
   private TextField availabilityTextField;
   @FXML
   private TextField titleLabel;

   private String selectedDepartment = "";
   // for editting
   private ArrayList<Employee> arrayList = new ArrayList();
   private int index;
   private boolean editing;

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      setupUI();
      this.editing = false;
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
            selectedDepartment = departmentComboBox.getSelectionModel().getSelectedItem().toString();
         }
      });
   }

   private void updateFile ()
   {
      File file = new File("employees.txt");
      PrintWriter pw;
      try {
         pw = new PrintWriter(file);
         for (int i = 0; i < arrayList.size(); i++) {
            String line = arrayList.get(i).toString();
            pw.println(line);
         }
         pw.close();
      }
      catch (FileNotFoundException ex) {
         Logger.getLogger(AddNewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }


   public void populator (int index, ArrayList<Employee> arrayList)
   {
//      titleLabel.setText(Edit Employee);
      Employee employee = arrayList.get(index);
      try {
         System.out.println("test1");
         System.out.println(employee);
         System.out.println("test2");
      }
      catch (Exception ex) {
         System.out.println("ERRR");
      }
      firstNameTextField.setText(employee.getFirstName());
      lastNameTextField.setText(employee.getLastName());
      employeeNumberTextField.setText(employee.getEmployeeNumber() + "");
      birthDatePicker.setValue(LocalDate.parse(employee.getBirthday()));
      streetTextField.setText(employee.getStreetAddress());
      cityTextField.setText(employee.getCity());
      provinceTextField.setText(employee.getProvince());
      phoneNumberTextField.setText(employee.getPhoneNumber());
      emailTextField.setText(employee.getEmailAddress());
      emergencyContactTextField.setText(employee.getEmergencyContact());
      sinNumberTextField.setText(employee.getSinNumber());
      positionComboBox.setValue(employee.getPosition());
      payRateTextField.setText(employee.getPayRate() + "");
      departmentComboBox.setValue(employee.getDepartment());
      hiredDatePicker.setValue(LocalDate.parse(employee.getDateHired()));

      try {
         terminatedDatePicker.setValue(LocalDate.parse(employee.getDateTerminated()));
      }
      catch (Exception ignore) {

      }

      try {
         availabilityTextField.setText(employee.getAvailability());
      }
      catch (Exception ignore2) {

      }


      this.arrayList = arrayList;
      this.index = index;
      this.editing = true;
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
         if (editing) {
            arrayList.get(index).setFirstName(firstNameTextField.getText());
            arrayList.get(index).setLastName(lastNameTextField.getText());
            arrayList.get(index).setBirthday(birthDatePicker.getValue().toString());
            arrayList.get(index).setStreetAddress(streetTextField.getText());
            arrayList.get(index).setCity(cityTextField.getText());
            arrayList.get(index).setProvince(provinceTextField.getText());
            arrayList.get(index).setPhoneNumber(phoneNumberTextField.getText());
            arrayList.get(index).setEmailAddress(emailTextField.getText());
            arrayList.get(index).setEmergencyContact(emergencyContactTextField.getText());
            arrayList.get(index).setSinNumber(sinNumberTextField.getText());
            arrayList.get(index).setPosition(positionComboBox.getValue().toString());
            arrayList.get(index).setDepartment(departmentComboBox.getValue().toString());
            arrayList.get(index).setDateHired(hiredDatePicker.getValue().toString());
            arrayList.get(index).setPayRate(Double.parseDouble(payRateTextField.getText()));
            arrayList.get(index).setEmployeeNumber(Integer.parseInt(employeeNumberTextField.getText()));
            try {
               arrayList.get(index).setDateTerminated(terminatedDatePicker.getValue().toString());
            }
            catch (Exception ignore) {

            }
            try {
               arrayList.get(index).setAvailability(availabilityTextField.getText());
            }
            catch (Exception ignore) {

            }
            updateFile();
            editing = false;
         }
         else {
//            updateFile();
            saveNewEmployee();
         }

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
              && birthDatePicker.getValue() != null
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
              && hiredDatePicker.getValue() != null;
   }

   public void saveNewEmployee ()
   {
      Employee newEmployee = new Employee();

      newEmployee.setEmployeeNumber(Integer.parseInt(employeeNumberTextField.getText()));
      newEmployee.setLastName(lastNameTextField.getText());
      newEmployee.setFirstName(firstNameTextField.getText());
      newEmployee.setBirthday(birthDatePicker.getValue().toString());
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
      newEmployee.setDateHired(hiredDatePicker.getValue().toString());

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
         output.append(newEmployee.getDepartment());
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
