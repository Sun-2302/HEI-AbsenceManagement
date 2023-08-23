package school.hei.javaabsencemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.javaabsencemanagement.entity.Student;
import school.hei.javaabsencemanagement.service.StudentService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController {
    private StudentService service;

    @PostMapping("/students")
    public String addStudent(@RequestBody Student toAdd) throws SQLException{
        return service.addStudent(toAdd);
    }

    @GetMapping("/students/{id}")
    public Student findStudent(@PathVariable int id)throws SQLException{
        return service.findStudent(id);
    }

    @GetMapping("/students")
    public List<Student> showAllStudents()throws SQLException{
        return service.showAllStudents();
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student toUpdate)throws SQLException{
        return service.updateStudent(id, toUpdate);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id)throws SQLException{
        return service.deleteStudent(id);
    }
}
