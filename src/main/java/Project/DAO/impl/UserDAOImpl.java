package Project.DAO.impl;

import Project.DAO.UserDAO;
import Project.Model.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long add(User user) {
        Serializable id = sessionFactory.getCurrentSession().save(user);
        return (Long) id;
    }

    @Override
    public User getById(long id, boolean lazy) {
        User user =  sessionFactory.getCurrentSession().get(User.class, id);

        return user;
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Override
    public User getByMail(String email) {
        try {
            javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from User where email = :email");
            query.setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public User getByMdp(String email, String mdp){
        try {
            javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from User where email = :email and :mdp");
            query.setParameter("mdp", mdp);
            query.setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public List<User> getAllUser(){
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from User");

        @SuppressWarnings("unchecked")
        List<User> listUser = query.getResultList();

        return listUser;

    }

    public void changeMdp(User user){
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}