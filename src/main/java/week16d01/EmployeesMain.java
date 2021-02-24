package week16d01;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesMain {


    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3308/employees?useUnicode=true";
        String username = "employees";
        String password = "employees";
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        EmployeesMain emp = new EmployeesMain();
        emp.insertALine(dataSource, "Feri");
        // emp.selectALine(dataSource, 2L);
        emp.selectAllLine(dataSource);
    }

    public void insertALine(MariaDbDataSource dataSource, String emp) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into employees (emp_name) values(?)")) {
            stmt.setString(1, emp);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<String> selectAllLine(MariaDbDataSource dataSource) {
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select emp_name from employees")
        ) {
            while (rs.next()) {
                String name = rs.getString("emp_name");
                result.add(name);
                System.out.println(name);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
        return result;
    }

    public void selectALine(MariaDbDataSource dataSource, long index) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "select emp_name from employees where id = ?");
        ) {
            stmt.setLong(1, index);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("emp_name");
                    System.out.println(name);
                }
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }
}

//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
//        dataSource.setUser("employees");
//        dataSource.setPassword("employees");
