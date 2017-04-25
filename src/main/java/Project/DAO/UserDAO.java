package Project.DAO;

import Project.Model.User;

import java.util.List;

public interface UserDAO {

    public Long add(User user);

    public User getById(long id, boolean lazy);

    public void delete(User user);

    public User getByMail(String mail);

    public User getByMdp(String email,String mdp);

    public List<User> getAllUser();

    public void changeMdp(User user);
}
