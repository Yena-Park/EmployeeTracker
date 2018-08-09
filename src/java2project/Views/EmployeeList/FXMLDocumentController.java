package java2project.Views.EmployeeList;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java2project.Models.Employee;
import java2project.Views.AddEmployee.AddNewEmployeeController;
import java2project.Views.EmployeeDetail.EmployeeDetailController;
import java2project.Views.SearchEmployee.SearchEmployeeController;
import java2project.Views.TaxResult.TaxResultController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author MJ
 */
public class FXMLDocumentController implements Initializable
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
   private Button addNewEmployeeButton;
   @FXML
   private Button viewDetailButton;
   @FXML
   private Button taxButton;
   @FXML
   private Button searchButton;
   @FXML
   private TextField searchTextField;


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


   private void searchFile () throws Exception
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

   public void updateTextFile () throws Exception
   {
      File file = new File("employees.txt");
      PrintWriter pw = new PrintWriter(file);

      for (int i = 0; i < employeesArrayList.size(); i++) {
         String line = employeesArrayList.get(i).toString();
         pw.println(line);
      }
      pw.close();
   }


   ArrayList<Employee> results = new ArrayList<>();

   // search Button 
   @FXML
   private void searchButtonPushed ()
   {
      results.clear();
      employeeTable.setItems(FXCollections.observableList(results));

      String keyword = searchTextField.getText().trim();

      if (!keyword.isEmpty()) {
         for (int i = 0; i < employeesArrayList.size(); i++) {
            if (employeesArrayList.get(i).checkFirstName(keyword)) {
               results.add(employeesArrayList.get(i));
            }
         }
         employeeTable.setItems(FXCollections.observableList(results));
      }
   }

   @FXML
   private void searchButtonDidTap (ActionEvent event) throws IOException
   {
      String loc = "java2project/Views/SearchEmployee/SearchEmployee.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();

      Scene scene = new Scene(root);

      // This line gets the stage information
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);

      //assign stage to the controller
      SearchEmployeeController controller = fxmlLoader.getController(); // first get controller

      // show modal window
      stage.show();
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

//      controller.
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

   // To delete the row in the table and update the text file
   @FXML
   private void deleteButtonDidTap (ActionEvent event) throws IOException, Exception
   {
      ObservableList<Employee> selectedRows, visibleRecords;
      visibleRecords = employeeTable.getItems();

      selectedRows = employeeTable.getSelectionModel().getSelectedItems();

      for (Employee selected : selectedRows) {
         visibleRecords.remove(selected);
         employeesArrayList.remove(selected);
         JOptionPane.showMessageDialog(null, "Deleted!!");
      }
      updateTextFile();
   }

   @FXML
   private void editButtonDidTap (ActionEvent event) throws IOException
   {
      String loc = "java2project/Views/AddEmployee/AddNewEmployee.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();



      ObservableList<Employee> selectedRows;
      selectedRows = employeeTable.getSelectionModel().getSelectedItems();

      Scene scene = new Scene(root);

      // This line gets the stage information
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);

      //assign stage to the controller
      AddNewEmployeeController controller = fxmlLoader.getController(); // first get controller

      controller.populator(employeesArrayList.indexOf(employeeTable.focusModelProperty().getValue().getFocusedItem()), employeesArrayList);


      // show modal window
      stage.show();




   }

   @FXML
   private void taxButtonDidTap (ActionEvent event) throws IOException
   {
      String loc = "java2project/Views/TaxResult/TaxResult.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();

      Scene scene = new Scene(root);

      // This line gets the stage information
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);

      //assign stage to the controller
      TaxResultController controller = fxmlLoader.getController(); // first get controller

      // show modal window
      stage.show();
   }

   private void showAlert ()
   {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Edit / Delete / Tax Functions");
      alert.setHeaderText("It does not support now.");
      alert.setContentText("It will be updated...");

      alert.showAndWait();
   }

   @FXML
   private void refreshButtonDidTap (ActionEvent event) throws IOException
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
