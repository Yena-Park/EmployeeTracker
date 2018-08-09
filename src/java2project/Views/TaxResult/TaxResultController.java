package java2project.Views.TaxResult;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Casey
 */
public class TaxResultController implements Initializable
{

   /**
    * Initializes the controller class.
    */
   ArrayList<Employee> employees = new ArrayList<Employee>();
   ObservableList<Employee> taxList = FXCollections.observableArrayList();

   @FXML
   private Button backButton;
   @FXML
   private ListView<String> employeeList;
   @FXML
   private TableView<Employee> taxTable;
   @FXML
   private TableColumn<Employee, Integer> employeeNumberColumn;
   @FXML
   private TableColumn<TaxCalculator, Double> employeeGrossPayColumn;
   @FXML
   private TableColumn<TaxCalculator, Double> employeeCPPColumn;
   @FXML
   private TableColumn<TaxCalculator, Double> employeeEIColumn;
   @FXML
   private TableColumn<TaxCalculator, Double> employeeIncomeTaxColumn;
   @FXML
   private TableColumn<TaxCalculator, Double> employeeTotalDeductionsColumn;
   @FXML
   private TableColumn<TaxCalculator, Double> employeeNetPayColumn;

   public void readFile () throws Exception
   {
      File file = new File("employees.txt");
      Scanner line = new Scanner(file);
      line.useDelimiter("\n");

      while (line.hasNext()) {
         String sentence = line.next();
         Employee employee = new Employee();
         employee.loadEmployee(sentence);
         taxList.add(employee);
         taxTable.setItems(taxList);
         employeeNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
//         employeeGrossPayColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("grossPay"));
//         employeeCPPColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("CPP"));                 employeeEIColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("EI"));
//         employeeIncomeTaxColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("incomeTax"));
//employeeTotalDeductionsColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("totalDeductions"));
//         employeeNetPayColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("netPay"));
         employees.add(employee);
      }

      // from this point, for 4 lines are currently disable. these are for ListView
      for (Employee emp : employees) {
         employeeList.getItems().add(emp.getEmployeeBasicInfo());
      }
      employeeList.setVisible(false);
   }

   public void backButtonDidTap (ActionEvent event) throws IOException
   {
      String loc = "java2project/Views/EmployeeList/FXMLDocument.fxml";

      //Creating new Loader to get Controller first
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(loc));

      // get the root
      Parent root = fxmlLoader.load();

      Scene scene = new Scene(root);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setTitle("Tax List");
      stage.setScene(scene);
      stage.show();
   }

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      // TODO
   }

}
