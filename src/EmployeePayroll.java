import java.sql.*;

public class EmployeePayroll {
    DBConnection dbConnection = null;
    //DQL: select -> executeQuery();
    static String selectQuery = "select * from employee_payroll;";
    //DML->executeUpdate()
    public void start() {
        try {
            retrieveAllData();


        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public void retrieveAllData(){
        try{
            dbConnection = DBConnection.getInstance();
            Connection con = dbConnection.getConnection();;
            assert con != null;
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectQuery);
            System.out.println("id | name | gender | salary | start date | phone | address");
            while (rs.next()) {
                System.out.println(rs.getInt(1) +
                        " | " + rs.getString(2) +
                        " | " + rs.getString(3)+
                        " | " + rs.getFloat(4)+
                        " | " + rs.getDate(5)+
                        " | " + rs.getLong(6)+
                        " | " + rs.getString(7));
            }
            stmt.close();
            con.close();

            System.out.println("Done!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveDataByName(String name){
        try{
            dbConnection = DBConnection.getInstance();
            Connection con = dbConnection.getConnection();
            assert con != null;
            PreparedStatement stmt = con.prepareStatement("select * from employee_payroll where name = ?;");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();

            displayData(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayData(ResultSet rs) {
        try{
            System.out.println("id | name | gender | salary | start date | phone | address");
            while (rs.next()) {
                System.out.println(rs.getInt(1) +
                        " | " + rs.getString(2) +
                        " | " + rs.getString(3)+
                        " | " + rs.getFloat(4)+
                        " | " + rs.getDate(5)+
                        " | " + rs.getLong(6)+
                        " | " + rs.getString(7));
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static int updateEmployeePayroll(String colName, long updateValue, int id) {
        int count = 0;
        try {
            dbConnection = DBConnection.getInstance();
            Connection con = dbConnection.getConnection();
            String updateQuery = "update employee_payroll set "+ colName +"=? where id = ?;" ;
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(updateQuery);
            stmt.setLong(1,updateValue);
            stmt.setLong(2,id);
            count = stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return count;
    }
}