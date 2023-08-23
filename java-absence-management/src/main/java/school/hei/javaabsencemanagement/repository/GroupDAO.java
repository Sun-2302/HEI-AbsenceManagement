package school.hei.javaabsencemanagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.javaabsencemanagement.entity.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class GroupDAO {

    private Connection connection;

    public String add(Group toAdd) throws SQLException{
        String sql = "INSERT INTO \"group\"(ref) values(?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toAdd.getRef());
            statement.executeUpdate();
        }
        return "Group added successfully!";
    }

    public Group find(int id) throws SQLException {
        String sql = "SELECT * from \"group\" where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Group(
                        resultSet.getInt("id"),
                        resultSet.getString("ref"),
                        resultSet.getDate("creation_date").toLocalDate()
                );
            }
        }
        return null;
    }

    public List<Group> showAll() throws SQLException{
        List<Group> groupList = new ArrayList<>();
        String sql = "SELECT * from \"group\"";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                groupList.add( new Group(
                        resultSet.getInt("id"),
                        resultSet.getString("ref"),
                        resultSet.getDate("creation_date").toLocalDate()
                ));
            }
        }
        return groupList;
    }

    public String update(int id, Group toUpdate)throws SQLException {
        String sql = "UPDATE \"group\" SET ref = ?, creation_date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toUpdate.getRef());
            statement.setDate(2, Date.valueOf(toUpdate.getCreation_date()));
            statement.setInt(3,id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                return "Group not found!";
            }else {
                return  "Group updated successfully!";
            }
        }
    }

    public String delete(int id) throws SQLException {
        String sql = "DELETE from \"group\" where id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Group not found!";
            }

        }
        return "Group deleted successfully!";
    }

}
