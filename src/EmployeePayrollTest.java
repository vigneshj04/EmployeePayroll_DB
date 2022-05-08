import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollTest {
    @Test
    public void givenSalary_MatchTheUpdatedSalary_ReturnTrue(){
        EmployeePayroll employee_Payroll = new EmployeePayroll();
        int count = employee_Payroll.updateEmployeePayroll("salary", 3000000,5);
        Assertions.assertEquals(1,count);
    }

    @Test
    public void givenName_GetSpecificResult_ReturnData(){
        EmployeePayroll employee_payroll_repository = new EmployeePayroll();
        employee_payroll_repository.retrieveDataByName("Terissa");
    }
    @Test
    public void givenRangeOfDate_GetSpecificResult_ReturnData(){
        EmployeePayroll employee_payroll_repository = new EmployeePayroll();
        employee_payroll_repository.retrieveDataByDate("2022-05-02" , "2022-05-03");
    }

    @Test
    public void givenGender_GetCalculatedResult_ReturnData(){
        EmployeePayroll employee_payroll_repository = new EmployeePayroll();
        employee_payroll_repository.getCalculatedData("M");
    }

}
