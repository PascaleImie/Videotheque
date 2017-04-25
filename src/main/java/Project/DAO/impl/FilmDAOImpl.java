package Project.DAO.impl;

import Project.DAO.FilmDAO;
import Project.DAO.UserDAO;
import Project.Model.Acteur;
import Project.Model.Film;
import Project.Model.Genre;
import Project.Model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public long add (Film film){
        Serializable id = sessionFactory.getCurrentSession().save(film);
        return (Long) id;

    }

    public Film getById(long id, boolean lazy){
       Film film =  sessionFactory.getCurrentSession().get(Film.class, id);
        Hibernate.initialize(film.getActeurs());
        Hibernate.initialize(film.getGenres());
        Hibernate.initialize(film.getRealisateur());
       return film;
    }



    public void delete(long id_film){
        //Récupération session hibernate
        Session session = sessionFactory.getCurrentSession();
        //création d'une requête hibernate HQL
        Query query = session.createQuery("delete from film_acteur where film_id="+id_film);
        query.executeUpdate();
        query = session.createQuery("delete from film_genre where film_id="+id_film);
        query.executeUpdate();
        //Récupération des résultats
        Film film = (Film) query.uniqueResult();
        List<Acteur> acteurs = film.getActeurs();
        List<Genre> genres = film.getGenres();

        //Suppression film
        session.delete(film);
        //Suppression des acteurs associés
         for(Acteur act : acteurs){
            session.delete(act);
        }
        //Suppression des genres associés
        for(Genre g : genres){
            session.delete(g);
        }
    }

    @Override
    public Film getByTitle(String titre) {
        try {
            javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Film where titre = :titre");
            query.setParameter("titre", titre);
            return (Film) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Film> getAllFilm(){
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from Film f");

        @SuppressWarnings("unchecked")
        List<Film> films = query.getResultList();

        return films;

    }



}