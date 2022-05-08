import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollTest {
    @Test
    public void givenSalary_MatchTheUpdatedSalary_ReturnTrue(){
        EmployeePayroll employee_Payroll = new EmployeePayroll();
        int count = EmployeePayroll.updateEmployeePayroll("salary", 3000000,5);
        Assertions.assertEquals(1,count);
    }

    @Test
    public void givenName_GetSpecificResult_ReturnData(){
        EmployeePayroll employee_payroll_repository = new EmployeePayroll();
        employee_payroll_repository.retrieveDataByName("Terissa");
    }
}