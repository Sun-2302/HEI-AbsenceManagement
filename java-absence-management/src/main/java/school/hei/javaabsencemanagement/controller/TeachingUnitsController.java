package school.hei.javaabsencemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.javaabsencemanagement.entity.TeachingUnits;
import school.hei.javaabsencemanagement.service.TeachingUnitsService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class TeachingUnitsController {
    private TeachingUnitsService service;

    @PostMapping("/teaching-units")
    public String addTeachingUnits(@RequestBody TeachingUnits toAdd) throws SQLException{
        return service.addTeachingUnits(toAdd);
    }

    @GetMapping("/teaching-units/{id}")
    public TeachingUnits findTeachingUnits(@PathVariable int id)  throws SQLException{
        return service.findTeachingUnits(id);
    }

    @GetMapping("/teaching-units")
    public List<TeachingUnits> showAllTeachingUnits() throws SQLException{
        return service.showAllTeachingUnits();
    }

    @PutMapping("/teaching-units/{id}")
    public String updateTeachingUnits(@PathVariable int id, @RequestBody TeachingUnits toUpdate) throws SQLException{
        return service.updateTeachingUnits(id, toUpdate);
    }

    @DeleteMapping("/teaching-units/{id}")
    public String deleteTeachingUnits(@PathVariable int id)  throws SQLException{
        return service.deleteTeachingUnits(id);
    }
}
