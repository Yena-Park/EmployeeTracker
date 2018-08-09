package java2project.Views.SearchEmployee;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java2project.Models.Employee;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

// @author Kimberley

public class SearchEmployeeController implements Initializable
{
   ArrayList<Employee> employeesArrayList = new ArrayList<Employee>();
   ObservableList<Employee> employeesObservableList = FXCollections.observableArrayList();

   // this ListView is currently disable
   @FXML
   private ListView<String> employeeStringList;
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
   private Button backButton;
   private Employee employee;
   @FXML
   private TextField searchTextField;

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      try {
         setupUI();
      }
      catch (Exception ex) {
      }
   }

   private void setupUI () throws Exception
   {
      File file = new File("employees.txt");
      String searchSentence = searchTextField.getText();
      Scanner line = new Scanner(file);
      line.useDelimiter("\n");

      while (line.hasNext()) {
         String sentence = line.next();
         Employee employee = new Employee();
         employee.searchEmployee(sentence, searchSentence);
         employeesObservableList.add(employee);
         employeeTable.setItems(employeesObservableList);
         employeeNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
         lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
         firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
         departmentColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
         emailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("emailAddress"));
         payRateColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("payRate"));
         employeesArrayList.add(employee);
      }
      // from this point, for 4 lines are currently disable. these are for ListView
      for (Employee emp : employeesArrayList) {
         employeeStringList.getItems().add(emp.getEmployeeBasicInfo());
      }
      employeeStringList.setVisible(false);
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
}
