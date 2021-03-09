package main;

import main.users.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCDemo {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        try (Connection connection = DBConnector.getInstance().getConnection();
             Statement st = connection.createStatement()) {
            ResultSet result = st.executeQuery("SELECT * FROM employees");
            while (result.next()) {
                employees.add(new Employee(
                        result.getInt("employee_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("phone_number"),
                        result.getDate("hire_date").toLocalDate(),
                        result.getString("job_id"),
                        result.getDouble("salary"),
                        result.getDouble("commission_pct"),
                        result.getInt("manager_id"),
                        result.getInt("department_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error creating statement. " + e.getMessage());
        }

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }
}
