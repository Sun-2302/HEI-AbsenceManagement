package school.hei.javaabsencemanagement.service;

import org.springframework.stereotype.Service;
import school.hei.javaabsencemanagement.entity.Absence;
import school.hei.javaabsencemanagement.repository.AbsenceDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class AbsenceService {
    private AbsenceDAO dao;

    public AbsenceService(AbsenceDAO dao) {
        this.dao = dao;
    }

    public String addAbsence(Absence toAdd)throws SQLException{
        return dao.add(toAdd);
    }

    public Absence findByIdAbsence(int id) throws SQLException{
        return dao.findById(id);
    }

    public List<Absence> showAllAbsences() throws SQLException{
        return dao.showAll();
    }

    public String updateAbsence(int id, Absence toUpdate) throws SQLException{
        return dao.update(id, toUpdate);
    }

    public String deleteAbsence(int id) throws SQLException{
        return dao.delete(id);
    }
}
