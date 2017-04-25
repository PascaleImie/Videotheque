package Project.DAO.impl;

import Project.DAO.FilmDAO;
import Project.DAO.GenreDAO;
import Project.Model.Film;
import Project.Model.Genre;
import Project.Model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public long add(Genre genre) {
        Serializable id = sessionFactory.getCurrentSession().save(genre);
        return (Long) id;
    }

    public Genre getById(long id, boolean lazy){
        Genre genre =  sessionFactory.getCurrentSession().get(Genre.class, id);
        return genre;
    }

    public List<Genre> findAllGenre(){
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Genre order by libelle");

        @SuppressWarnings("unchecked")
        List<Genre> listGenre = query.getResultList();

        return listGenre;
    }

    @Override
    public Genre isExist(String libelle) {
        try {
            javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Genre where libelle = :libelle");
            query.setParameter("libelle", libelle);
            return (Genre) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}