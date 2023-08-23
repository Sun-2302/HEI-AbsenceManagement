package school.hei.javaabsencemanagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.javaabsencemanagement.entity.TeachingUnits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class TeachingUnitsDAO {

    private Connection connection;

    public String add(TeachingUnits toAdd) throws SQLException {
        String sql = "INSERT INTO teaching_units(name) values(?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toAdd.getName());
            statement.executeUpdate();

            return "Teaching Units added successfully!";
        }
    }

    public TeachingUnits find(int id)  throws SQLException{
        String sql = "SELECT * from teaching_units where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new TeachingUnits(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        }
        return null;
    }

    public List<TeachingUnits> showAll() throws SQLException{
        List<TeachingUnits> teachingUnitsList = new ArrayList<>();
        String sql = "SELECT * from teaching_units order by id asc";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                teachingUnitsList.add( new TeachingUnits(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                ));
            }
        }
        return teachingUnitsList;
    }

    public String update(int id,TeachingUnits toUpdate) throws SQLException {
        String sql = "UPDATE teaching_units SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toUpdate.getName());
            statement.setInt(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                return "Teaching Units not found!";
            }else {
                return "Teaching Units updated successfully!";
            }
        }
    }

    public String delete(int id)  throws SQLException{
        String sql = "DELETE from teaching_units where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Teaching Units not found!";
            }
        }
        return "Teaching Units deleted successfully!";
    }

}
