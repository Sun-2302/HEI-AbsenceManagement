package school.hei.javaabsencemanagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.javaabsencemanagement.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class CourseDAO {
    private Connection connection;

    public String add(Course toAdd) throws SQLException{
        String sql = "INSERT INTO course(date_time, id_teaching_units, id_group) values(?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setTimestamp(1, Timestamp.valueOf(toAdd.getDate_time()));
            statement.setInt(2, toAdd.getId_teaching_units());
            statement.setInt(3, toAdd.getId_group());
            statement.executeUpdate();

            return "Course added successfully!";
        }
    }

    public Course find(int id) throws SQLException{
        String sql = "SELECT * from course where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Course(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("date_time").toLocalDateTime(),
                        resultSet.getInt("id_teaching_units"),
                        resultSet.getInt("id_group")
                );
            }
        }
        return null;
    }

    public List<Course> showAll() throws SQLException{
        List<Course> courseList = new ArrayList<>();
        String sql = "SELECT * from course order by id asc";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courseList.add(new Course(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("date_time").toLocalDateTime(),
                        resultSet.getInt("id_teaching_units"),
                        resultSet.getInt("id_group")
                ));
            }
        }
        return courseList;
    }

    public String update(int id, Course toUpdate) throws SQLException{
        String sql = "UPDATE course SET date_time = ?, id_teaching_units = ?, id_group = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setTimestamp(1, Timestamp.valueOf(toUpdate.getDate_time()));
            statement.setInt(2, toUpdate.getId_teaching_units());
            statement.setInt(3,toUpdate.getId_group());
            statement.setInt(4,id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                return "Course not found!";
            }else {
                return "Course updated successfully!";
            }
        }
    }

    public String delete(int id) throws SQLException{
        String sql = "DELETE from course where id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Course not found!";
            }

        }
        return "Course deleted successfully!";
    }
}
