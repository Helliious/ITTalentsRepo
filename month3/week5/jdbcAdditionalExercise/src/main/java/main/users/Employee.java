package main.users;

import java.time.LocalDate;

public class Employee {
    private final int id;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String phone_number;
    private final LocalDate hire_date;
    private final String job_id;
    private final double salary;
    private final double commission_pct;
    private final int manager_id;
    private final int department_id;

    public Employee(int id,
                    String first_name,
                    String last_name,
                    String email,
                    String phone_number,
                    LocalDate hire_date,
                    String job_id,
                    double salary,
                    double commission_pct,
                    int manager_id,
                    int department_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_id = manager_id;
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employee: " + first_name + " " + last_name + "\n" +
                "id: " + id + "\n" +
                "email: " + email + "\n" +
                "phone_number: " + phone_number + "\n" +
                "hire_date: " + hire_date + "\n" +
                "job_id: " + job_id + "\n" +
                "salary: " + salary + "\n" +
                "commission_pct: " + commission_pct + "\n" +
                "manager_id: " + manager_id + "\n" +
                "department_id: " + department_id + "\n";
    }
}
