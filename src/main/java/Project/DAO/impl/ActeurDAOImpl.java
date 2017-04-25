package Project.DAO.impl;

import Project.DAO.ActeurDAO;
import Project.DAO.FilmDAO;
import Project.Model.Acteur;
import Project.Model.Film;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class ActeurDAOImpl implements ActeurDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public long add(Acteur acteur) {
            Serializable id = sessionFactory.getCurrentSession().save(acteur);
            return (Long) id;

        }

    @Override
    public Acteur getById(long id, boolean lazy) {
        Acteur acteur =  sessionFactory.getCurrentSession().get(Acteur.class, id);
        return acteur;
    }

    @Override
    public Acteur isExist(String prenom, String nom) {
        try {
            javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Acteur where prenom = :prenom and nom = :nom");
            query.setParameter("prenom", prenom);
            query.setParameter("nom", nom);
            return (Acteur) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}

