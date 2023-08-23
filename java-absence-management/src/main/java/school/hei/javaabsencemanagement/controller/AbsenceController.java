package school.hei.javaabsencemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.javaabsencemanagement.entity.Absence;
import school.hei.javaabsencemanagement.service.AbsenceService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class AbsenceController{
    private AbsenceService service;

    @PostMapping("/absences")
    public String addAbsence(@RequestBody Absence toAdd)throws SQLException{
        return service.addAbsence(toAdd);
    }

    @GetMapping("/absences/{id}")
    public Absence findByIdAbsence(@PathVariable int id) throws SQLException{
        return service.findByIdAbsence(id);
    }

    @GetMapping("/absences")
    public List<Absence> showAllAbsences() throws SQLException {
        return service.showAllAbsences();
    }

    @PutMapping("/absences/{id}")
    public String updateAbsence(@PathVariable int id, @RequestBody Absence toUpdate) throws SQLException{
        return service.updateAbsence(id, toUpdate);
    }

    @DeleteMapping("/absences/{id}")
    public String deleteAbsence(@PathVariable int id) throws SQLException{
        return service.deleteAbsence(id);
    }
}
