package school.hei.javaabsencemanagement.service;

import org.springframework.stereotype.Service;
import school.hei.javaabsencemanagement.entity.TeachingUnits;
import school.hei.javaabsencemanagement.repository.TeachingUnitsDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class TeachingUnitsService {
    private TeachingUnitsDAO dao;

    public TeachingUnitsService(TeachingUnitsDAO dao) {
        this.dao = dao;
    }

    public String addTeachingUnits(TeachingUnits toAdd) throws SQLException{
        return dao.add(toAdd);
    }

    public TeachingUnits findTeachingUnits(int id)  throws SQLException{
        return dao.find(id);
    }

    public List<TeachingUnits> showAllTeachingUnits() throws SQLException{
        return dao.showAll();
    }

    public String updateTeachingUnits(int id, TeachingUnits toUpdate) throws SQLException{
        return dao.update(id, toUpdate);
    }

    public String deleteTeachingUnits(int id)  throws SQLException{
        return dao.delete(id);
    }
}
