package school.hei.javaabsencemanagement.service;

import org.springframework.stereotype.Service;
import school.hei.javaabsencemanagement.entity.Group;
import school.hei.javaabsencemanagement.repository.GroupDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class GroupService {
    private GroupDAO dao;

    public GroupService(GroupDAO dao) {
        this.dao = dao;
    }

    public String addGroup(Group toAdd) throws SQLException{
        return dao.add(toAdd);
    }

    public Group findGroup(int id) throws SQLException{
        return dao.find(id);
    }

    public List<Group> showAllGroups() throws SQLException{
        return dao.showAll();
    }

    public String updateGroup(int id, Group toUpdate)throws SQLException{
        return dao.update(id, toUpdate);
    }

    public String deleteGroup(int id) throws SQLException{
        return dao.delete(id);
    }
}
