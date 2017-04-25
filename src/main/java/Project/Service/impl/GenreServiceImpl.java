package Project.Service.impl;

import Project.DAO.ActeurDAO;
import Project.DAO.GenreDAO;
import Project.Model.Acteur;
import Project.Model.Genre;
import Project.Service.ActeurService;
import Project.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

        @Autowired
        private GenreDAO genreDAO;


        @Override
        public long add(Genre genre) {
                return genreDAO.add(genre);
        }

        public Genre getById(long id, boolean lazy)
        {return  genreDAO.getById(id,lazy);}

        @Override
        public List<Genre> findAllGenre() {
                return genreDAO.findAllGenre();
        }

        @Override
        public Genre isExist(String libelle) {
                return genreDAO.isExist(libelle);
        }


}
