package school.hei.javaabsencemanagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.javaabsencemanagement.entity.Absence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class AbsenceDAO {

    private Connection connection;

    public String add(Absence toAdd) throws SQLException{
        String sql = "INSERT INTO absence(id_student,id_course) values(?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, toAdd.getId_student());
            statement.setInt(2, toAdd.getId_course());
            statement.executeUpdate();

            return  "Absence added successfully!";
        }
    }

    public Absence findById(int id) throws SQLException{
        String sql = "SELECT * from absence where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Absence(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_course")
                );
            }
        }
        return null;
    }

    public List<Absence> showAll() throws SQLException{
        List<Absence> absenceList = new ArrayList<>();
        String sql = "SELECT * from absence order by id asc";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                absenceList.add(new Absence(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_course")
                ));
            }
        }
        return absenceList;
    }

    public String update(int id, Absence toUpdate) throws SQLException{
        String sql = "UPDATE absence SET id_student = ?, id_course = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, toUpdate.getId_student());
            statement.setInt(2, toUpdate.getId_course());
            statement.setInt(3,id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                return "Absence not found!";
            }else {
                return "Absence updated successfully!";
            }
        }
    }

    public String delete(int id) throws SQLException{
        String sql = "DELETE from absence where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Absence not found!";
            }
        }
            return "Absence deleted successfully!";
    }

}
