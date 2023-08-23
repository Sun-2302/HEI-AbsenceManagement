package school.hei.javaabsencemanagement.service;

import org.springframework.stereotype.Service;
import school.hei.javaabsencemanagement.entity.Follow;
import school.hei.javaabsencemanagement.repository.FollowDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class FollowService {
    private FollowDAO dao;

    public FollowService(FollowDAO dao) {
        this.dao = dao;
    }

    public String addFollow(Follow toAdd) throws SQLException{
        return dao.add(toAdd);
    }

    public Follow findFollow(int id) throws SQLException{
        return dao.find(id);
    }

    public List<Follow> showAllFollows() throws SQLException{
        return dao.showAll();
    }

    public String updateFollow(int id, Follow toUpdate) throws SQLException{
        return dao.update(id, toUpdate);
    }

    public String deleteFollow(int id) throws SQLException{
        return dao.delete(id);
    }
}
