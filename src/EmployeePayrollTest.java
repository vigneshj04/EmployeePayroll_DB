import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollTest {
    @Test
    public void givenSalary_MatchTheUpdatedSalary_ReturnTrue() {
        EmployeePayroll employeePayroll = new EmployeePayroll();
        int count = employeePayroll.updateEmployeePayroll("salary", "3000000.00", 5);
        Assertions.assertEquals(1, count);
    }
}

