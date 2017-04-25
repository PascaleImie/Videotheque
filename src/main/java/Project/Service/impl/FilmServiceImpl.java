package Project.Service.impl;

import Project.DAO.FilmDAO;
import Project.DAO.UserDAO;
import Project.Model.Film;
import Project.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

        @Autowired
        private FilmDAO filmDAO;


        @Override
        public long add(Film film) {
                return filmDAO.add(film);
        }


        @Override
        public Film getById(long id, boolean lazy) {
                return filmDAO.getById(id,lazy);
        }

        @Override
        public Film getByTitle(String titre) {
                return filmDAO.getByTitle(titre);
        }


        @Override
        public void delete(long id_film) {
                filmDAO.delete(id_film);

        }

        @Override
        public List<Film> getAllFilm() {
                return filmDAO.getAllFilm();
        }
}
