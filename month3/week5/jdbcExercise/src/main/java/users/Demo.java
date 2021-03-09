package users;

import java.sql.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Student student1 = new Student("Timothy", "Burton", "Burbank", 63, "M", "dog");
        Student student2 = new Student("Terry", "Pratchett", "Beaconsfield", 73, "M", "cat");
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        insertStudent(students);
    }

    public static void insertStudent(ArrayList<Student> students) {
        String sql = "INSERT INTO students (" +
                "first_name, " +
                "last_name, " +
                "age, " +
                "city, " +
                "gender, " +
                "pet_type, " +
                "created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DBConnector.getInstance().getConnection();
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (int i = 0; i < students.size(); i++) {
                st.setString(1, students.get(i).getFirst_name());
                st.setString(2, students.get(i).getLast_name());
                st.setInt(3, students.get(i).getAge());
                st.setString(4, students.get(i).getCity());
                st.setString(5, students.get(i).getGender());
                st.setString(6, students.get(i).getPet_type());
                st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                st.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
