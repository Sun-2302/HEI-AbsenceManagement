package school.hei.javaabsencemanagement.service;

import org.springframework.stereotype.Service;
import school.hei.javaabsencemanagement.entity.Student;
import school.hei.javaabsencemanagement.repository.StudentDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    private StudentDAO dao;

    public StudentService(StudentDAO dao) {
        this.dao = dao;
    }

    public String addStudent(Student toAdd) throws SQLException{
        return dao.add(toAdd);
    }

    public Student findStudent(int id)throws SQLException{
        return dao.find(id);
    }

    public List<Student> showAllStudents()throws SQLException{
        return dao.showAll();
    }

    public String updateStudent(int id, Student toUpdate)throws SQLException{
        return dao.update(id, toUpdate);
    }

    public String deleteStudent(int id)throws SQLException{
        return dao.delete(id);
    }

}
