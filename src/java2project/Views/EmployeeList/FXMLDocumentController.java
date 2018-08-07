/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project.Views.EmployeeList;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java2project.Models.Employee;
import java2project.Views.AddEmployee.AddNewEmployeeController;
import java2project.Views.EmployeeDetail.EmployeeDetailController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author MJ
 */
public class FXMLDocumentController implements Initializable
{



   ArrayList<Employee> employees = new ArrayList<Employee>();
   ObservableList<Employee> employeesList = FXCollections.observableArrayList();

   // this ListView is currently disable
   @FXML
   private ListView<String> employeeList;
   @FXML
   private TableView<Employee> employeeTable;
   @FXML
   private TableColumn<Employee, Integer> employeeNumberColumn;
   @FXML
   private TableColumn<Employee, String> lastNameColumn;
   @FXML
   private TableColumn<Employee, String> firstNameColumn;
   @FXML
   private TableColumn<Employee, String> departmentColumn;
   @FXML
   private TableColumn<Employee, String> emailColumn;
   @FXML
   private TableColumn<Employee, Double> payRateColumn;
   @FXML
   private Button addNewEmployeeButton;
   @FXML
   private Button viewDetailButton;



   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      try {
         readFile();
      }
      catch (Exception ex) {
      }
   }

   public void readFile () throws Exception
   {
      File file = new File("employees.txt");
      Scanner line = new Scanner(file);
      line.useDelimiter("\n");

      while (line.hasNext()) {
         String sentence = line.next();
         Employee employee = new Employee();
         employee.loadEmployee(sentence);
         employeesList.add(employee);
         employeeTable.setItems(employeesList);
         employeeNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
         lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
         firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
         departmentColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
         emailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("emailAddress"));
         payRateColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("payRate"));
         employees.add(employee);
      }


      // from this point, for 4 lines are currently disable. these are for ListView
      for (Employee emp : employees) {
         employeeList.getItems().add(emp.getEmployeeBasicInfo());
      }
      employeeList.setVisible(false);
   }


   // This method is called, it will change the scene to a AddNewEmployeePage
   @FXML
   private void addNewEmployeeButtonDidTap (ActionEvent event) throws IOException
   {

      String loc = "java2project/Views/AddEmployee/AddNewEmployee.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();

      Scene scene = new Scene(root);

      // This line gets the stage information
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);

      //assign stage to the controller
      AddNewEmployeeController controller = fxmlLoader.getController(); // first get controller

      // show modal window
      stage.show();
   }

   @FXML
   private void viewDetailButtonDidTap (ActionEvent event) throws IOException
   {

      String loc = "java2project/Views/EmployeeDetail/EmployeeDetail.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();

      Scene scene = new Scene(root);

      //next page
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setTitle("Employee Detail");
      stage.setScene(scene);
      stage.show();


      //assign controller for fxml
      EmployeeDetailController controller = fxmlLoader.<EmployeeDetailController>getController();

      //set selected employee from tableView
      Employee selectedEmployee = employeeTable.focusModelProperty().getValue().getFocusedItem();
//      Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
      controller.initData(selectedEmployee);
   }
}
