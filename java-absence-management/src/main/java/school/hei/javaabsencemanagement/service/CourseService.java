package school.hei.javaabsencemanagement.service;

import org.springframework.stereotype.Service;
import school.hei.javaabsencemanagement.entity.Course;
import school.hei.javaabsencemanagement.repository.CourseDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class CourseService {
    private CourseDAO dao;

    public CourseService(CourseDAO dao) {
        this.dao = dao;
    }

    public String addCourse(Course toAdd) throws SQLException{
        return dao.add(toAdd);
    }

    public Course findCourse(int id) throws SQLException{
        return dao.find(id);
    }

    public List<Course> showAllCourses() throws SQLException{
        return dao.showAll();
    }

    public String updateCourse(int id, Course toUpdate) throws SQLException{
        return dao.update(id, toUpdate);
    }

    public String deleteCourse(int id) throws SQLException{
        return dao.delete(id);
    }
}
