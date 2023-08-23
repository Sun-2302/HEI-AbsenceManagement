package school.hei.javaabsencemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.javaabsencemanagement.entity.Group;
import school.hei.javaabsencemanagement.service.GroupService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class GroupController {
    private GroupService service;

    @PostMapping("/groups")
    public String addGroup(@RequestBody Group toAdd) throws SQLException{
        return service.addGroup(toAdd);
    }

    @GetMapping("/groups/{id}")
    public Group findGroup(@PathVariable int id) throws SQLException{
        return service.findGroup(id);
    }

    @GetMapping("/groups")
    public List<Group> showAllGroups() throws SQLException{
        return service.showAllGroups();
    }

    @PutMapping("/groups/{id}")
    public String updateGroup(@PathVariable int id, @RequestBody Group toUpdate)throws SQLException{
        return service.updateGroup(id, toUpdate);
    }

    @DeleteMapping("/groups/{id}")
    public String deleteGroup(@PathVariable int id) throws SQLException{
        return service.deleteGroup(id);
    }

}
