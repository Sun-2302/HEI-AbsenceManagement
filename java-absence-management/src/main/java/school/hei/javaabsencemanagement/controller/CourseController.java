package school.hei.javaabsencemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.javaabsencemanagement.entity.Course;
import school.hei.javaabsencemanagement.service.CourseService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class CourseController {
    private CourseService service;

    @PostMapping("/courses")
    public String addCourse(@RequestBody Course toAdd) throws SQLException{
        return service.addCourse(toAdd);
    }

    @GetMapping("/courses/{id}")
    public Course findCourse(@PathVariable int id) throws SQLException{
        return service.findCourse(id);
    }

    @GetMapping("/courses")
    public List<Course> showAllCourses() throws SQLException{
        return service.showAllCourses();
    }

    @PutMapping("/courses/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody Course toUpdate) throws SQLException{
        return service.updateCourse(id, toUpdate);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) throws SQLException{
        return service.deleteCourse(id);
    }
}
