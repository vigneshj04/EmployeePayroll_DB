
import java.sql.*;

public class EmployeePayroll{

    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            stmt.close();
            con.close();

            System.out.println("Done!!!");
        }catch (SQLException | NullPointerException e) {
            System.out.println(e);
        }
    }
}