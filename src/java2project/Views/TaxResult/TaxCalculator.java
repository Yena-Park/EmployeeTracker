package java2project.Views.TaxResult;
import java2project.Models.Employee;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class TaxCalculator extends Employee
{
   protected double payRate = super.getPayRate();

   //method for gross pay (pay rate x 40 hours)
   public double grossPayCalculator (double payRate)
   {
      return payRate * 40;
   }

   //possibly all the following methods are actually all part of the same method?

   //method for CPP deduction

   //method for EI deduction

   //method for income tax deduction

   //method for net pay
}
