package Project.DAO.impl;

import Project.DAO.FilmDAO;
import Project.DAO.RealisateurDAO;
import Project.Model.Realisateur;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class RealisateurDAOImpl implements RealisateurDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public long add(Realisateur realisateur) {
        Serializable id = sessionFactory.getCurrentSession().save(realisateur);
        return (Long) id;
    }

    @Override
    public Realisateur getById(long id, boolean lazy) {
        Realisateur realisateur =  sessionFactory.getCurrentSession().get(Realisateur.class, id);
        return realisateur;
    }

    @Override
    public Realisateur isExist(String nom, String prenom) {
        try {
            javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Realisateur where nom = :nom and prenom =:prenom");
            query.setParameter("nom", nom);
            query.setParameter("prenom", prenom);
            return (Realisateur) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Realisateur> getAllRealisateur() {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Realisateur");

        @SuppressWarnings("unchecked")
        List<Realisateur> realisateurs = query.getResultList();

        return realisateurs;
    }

}