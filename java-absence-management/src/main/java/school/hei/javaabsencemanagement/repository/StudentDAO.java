package school.hei.javaabsencemanagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.javaabsencemanagement.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class StudentDAO {
    private Connection connection;

    public String add(Student toAdd) throws SQLException{
        String sql = "INSERT INTO student(first_name, last_name, gender, ref, email, phone) values(?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toAdd.getFirst_name());
            statement.setString(2, toAdd.getLast_name());
            statement.setString(3, toAdd.getGender());
            statement.setString(4, toAdd.getRef());
            statement.setString(5, toAdd.getEmail());
            statement.setString(6, toAdd.getPhone());
            statement.executeUpdate();

            return "Student added successfully!";
        }
    }

    public Student find(int id)throws SQLException {
        String sql = "SELECT * from student where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("ref"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                );
            }
        }
        return null;
    }

    public List<Student> showAll()throws SQLException {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * from student order by id asc";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("ref"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                ));
            }
        }
        return studentList;
    }

    public String update(int id, Student toUpdate)throws SQLException {
        String sql = "UPDATE student SET first_name = ?, last_name = ?, gender = ?, ref = ?, email = ?, phone = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toUpdate.getFirst_name());
            statement.setString(2, toUpdate.getLast_name());
            statement.setString(3, toUpdate.getGender());
            statement.setString(4, toUpdate.getRef());
            statement.setString(5, toUpdate.getEmail());
            statement.setString(6, toUpdate.getPhone());
            statement.setInt(7,id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                return "Student not found!";
            }else {
                return "Student updated successfully!";
            }
        }
    }

    public String delete(int id)throws SQLException{
        String sql = "DELETE from student where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Student not found!";
            }

        }
        return "Student deleted successfully!";
    }

}
