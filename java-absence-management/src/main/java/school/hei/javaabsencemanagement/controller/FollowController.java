package school.hei.javaabsencemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.javaabsencemanagement.entity.Follow;
import school.hei.javaabsencemanagement.service.FollowService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class FollowController {
    private FollowService service;

    @PostMapping("/follows")
    public String addFollow(@RequestBody Follow toAdd) throws SQLException{
        return service.addFollow(toAdd);
    }

    @GetMapping("/follows/{id}")
    public Follow findFollow(@PathVariable int id) throws SQLException{
        return service.findFollow(id);
    }

    @GetMapping("/follows")
    public List<Follow> showAllFollows() throws SQLException{
        return service.showAllFollows();
    }

    @PutMapping("/follows/{id}")
    public String updateFollow(@PathVariable int id, @RequestBody Follow toUpdate) throws SQLException{
        return service.updateFollow(id, toUpdate);
    }

    @DeleteMapping("/follows/{id}")
    public String deleteFollow(@PathVariable int id) throws SQLException{
        return service.deleteFollow(id);
    }
}
