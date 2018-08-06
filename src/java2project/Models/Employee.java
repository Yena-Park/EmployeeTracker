package java2project.Models;
import java.util.Scanner;
import java2project.Views.EmployeeList.FXMLDocumentController;
/**
 * @author MJ @ Sheridan College
 */





public class Employee extends FXMLDocumentController
{
   private int employeeNumber;
   private String firstName;
   private String lastName;
   private String birthday;
   private String streetAddress;
   private String city;
   private String province;
   private String phoneNumber;
   private String emailAddress;
   private String emergencyContact;
   private String sinNumber;
   private String position;
   private double payRate;
   private String department;
   private String dateHired;
   private String dateTerminated;
   private String availability;
   private String bankName;
   private int bankTransitNumber;
   private int bankInstitutionNumber;
   private int bankAccountNumber;

   public Employee ()
   {
      this.employeeNumber = employeeNumber;
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthday = birthday;
      this.streetAddress = streetAddress;
      this.city = city;
      this.province = province;
      this.phoneNumber = phoneNumber;
      this.emailAddress = emailAddress;
      this.emergencyContact = emergencyContact;
      this.sinNumber = sinNumber;
      this.position = position;
      this.payRate = payRate;
      this.department = department;
      this.dateHired = dateHired;
      this.dateTerminated = dateTerminated;
      this.availability = availability;
      this.bankName = bankName;
      this.bankTransitNumber = bankTransitNumber;
      this.bankInstitutionNumber = bankInstitutionNumber;
      this.bankAccountNumber = bankAccountNumber;
   }

   public Employee (int employeeNumber, String firstName, String lastName, String birthday, String streetAddress, String city, String province, String phoneNumber, String emailAddress, String emergencyContact, String sinNumber, String position, double payRate, String department, String dateHired, String dateTerminated, String availability, String bankName, int bankTransitNumber, int bankInstitutionNumber, int bankAccountNumber)
   {
      this.employeeNumber = employeeNumber;
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthday = birthday;
      this.streetAddress = streetAddress;
      this.city = city;
      this.province = province;
      this.phoneNumber = phoneNumber;
      this.emailAddress = emailAddress;
      this.emergencyContact = emergencyContact;
      this.sinNumber = sinNumber;
      this.position = position;
      this.payRate = payRate;
      this.department = department;
      this.dateHired = dateHired;
      this.dateTerminated = dateTerminated;
      this.availability = availability;
      this.bankName = bankName;
      this.bankTransitNumber = bankTransitNumber;
      this.bankInstitutionNumber = bankInstitutionNumber;
      this.bankAccountNumber = bankAccountNumber;
   }

   public void loadEmployee (String employeeDetail)
   {
      Scanner ip = new Scanner(employeeDetail);
      ip.useDelimiter(",");
      employeeNumber = ip.nextInt();
      firstName = ip.next();
      lastName = ip.next();
      birthday = ip.next();
      streetAddress = ip.next();
      city = ip.next();
      province = ip.next();
      phoneNumber = ip.next();
      emailAddress = ip.next();
      emergencyContact = ip.next();
      sinNumber = ip.next();
      position = ip.next();
      payRate = ip.nextDouble();
      department = ip.next();
      dateHired = ip.next();
//      dateTerminated = ip.next();
//      availability = ip.next();
//      bankName = ip.next();
//      bankTransitNumber = ip.nextInt();
//      bankInstitutionNumber = ip.nextInt();
//      bankAccountNumber = ip.nextInt();
      ip.close();
   }

   public String getEmployeeBasicInfo ()
   {
      return employeeNumber + "\t" + firstName + "\t" + lastName;
   }

   public int getEmployeeNumber ()
   {
      return employeeNumber;
   }

   public void setEmployeeNumber (int employeeNumber)
   {
      this.employeeNumber = employeeNumber;
   }

   public String getFirstName ()
   {
      return firstName;
   }

   public void setFirstName (String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName ()
   {
      return lastName;
   }

   public void setLastName (String lastName)
   {
      this.lastName = lastName;
   }

   public String getBirthday ()
   {
      return birthday;
   }

   public void setBirthday (String birthday)
   {
      this.birthday = birthday;
   }

   public String getStreetAddress ()
   {
      return streetAddress;
   }

   public void setStreetAddress (String streetAddress)
   {
      this.streetAddress = streetAddress;
   }

   public String getCity ()
   {
      return city;
   }

   public void setCity (String city)
   {
      this.city = city;
   }


   public String getProvince ()
   {
      return province;
   }

   public void setProvince (String province)
   {
      this.province = province;
   }

   public String getPhoneNumber ()
   {
      return phoneNumber;
   }

   public void setPhoneNumber (String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   public String getEmailAddress ()
   {
      return emailAddress;
   }

   public void setEmailAddress (String emailAddress)
   {
      this.emailAddress = emailAddress;
   }

   public String getEmergencyContact ()
   {
      return emergencyContact;
   }

   public void setEmergencyContact (String emergencyContact)
   {
      this.emergencyContact = emergencyContact;
   }

   public String getSinNumber ()
   {
      return sinNumber;
   }

   public void setSinNumber (String sinNumber)
   {
      this.sinNumber = sinNumber;
   }

   public String getPosition ()
   {
      return position;
   }

   public void setPosition (String position)
   {
      this.position = position;
   }

   public double getPayRate ()
   {
      return payRate;
   }

   public void setPayRate (double payRate)
   {
      this.payRate = payRate;
   }

   public String getDepartment ()
   {
      return department;
   }

   public void setDepartment (String Department)
   {
      this.department = department;
   }

   public String getDateHired ()
   {
      return dateHired;
   }

   public void setDateHired (String dateHired)
   {
      this.dateHired = dateHired;
   }

   public String getDateTerminated ()
   {
      return dateTerminated;
   }

   public void setDateTerminated (String dateTerminated)
   {
      this.dateTerminated = dateTerminated;
   }

   public String getAvailability ()
   {
      return availability;
   }

   public void setAvailability (String availability)
   {
      this.availability = availability;
   }

   public String getBankName ()
   {
      return bankName;
   }

   public void setBankName (String bankName)
   {
      this.bankName = bankName;
   }

   public int getBankTransitNumber ()
   {
      return bankTransitNumber;
   }

   public void setBankTransitNumber (int bankTransitNumber)
   {
      this.bankTransitNumber = bankTransitNumber;
   }

   public int getBankInstitutionNumber ()
   {
      return bankInstitutionNumber;
   }

   public void setBankInstitutionNumber (int bankInstitutionNumber)
   {
      this.bankInstitutionNumber = bankInstitutionNumber;
   }

   public int getBankAccountNumber ()
   {
      return bankAccountNumber;
   }

   public void setBankAccountNumber (int bankAccountNumber)
   {
      this.bankAccountNumber = bankAccountNumber;
   }
}
