package school.hei.javaabsencemanagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.javaabsencemanagement.entity.Follow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FollowDAO {
    private Connection connection;

    public String add(Follow toAdd) throws SQLException{
        String sql = "INSERT INTO follow(id_student,id_teaching_units) values(?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, toAdd.getId_student());
            statement.setInt(2, toAdd.getId_teaching_units());
            statement.executeUpdate();
            return "Follow added successfully!";
        }
    }

    public Follow find(int id) throws SQLException{
        String sql = "SELECT * from follow where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Follow(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_teaching_units")
                );
            }
        }
        return null;
    }

    public List<Follow> showAll() throws SQLException{
        List<Follow> followList = new ArrayList<>();
        String sql = "SELECT * from follow order by id asc ";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                followList.add(new Follow(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_teaching_units")
                ));
            }
        }
        return followList;
    }

    public String update(int id, Follow toUpdate) throws SQLException{
        String sql = "UPDATE follow SET id_student = ?, id_teaching_units = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, toUpdate.getId_student());
            statement.setInt(2, toUpdate.getId_teaching_units());
            statement.setInt(3,id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                return "Follow not found!";
            }else {
                return "Follow updated successfully!";
            }
        }
    }

    public String delete(int id) throws SQLException{
        String sql = "DELETE from follow where id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Follow not found!";
            }

        }
        return "Follow deleted successfully!";
    }
}
