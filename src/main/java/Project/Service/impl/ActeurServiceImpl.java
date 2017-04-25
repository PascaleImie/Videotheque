package Project.Service.impl;

import Project.DAO.ActeurDAO;
import Project.DAO.FilmDAO;
import Project.Model.Acteur;
import Project.Model.Film;
import Project.Service.ActeurService;
import Project.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActeurServiceImpl implements ActeurService {

        @Autowired
        private ActeurDAO acteurDAO;


        @Override
        public long add(Acteur acteur) {
                return acteurDAO.add(acteur);
        }

        @Override
        public Acteur getById(long id, boolean lazy) {
                return acteurDAO.getById(id,lazy);
        }

        @Override
        public Acteur isExist(String prenom, String nom) {
                return acteurDAO.isExist(nom,prenom);
        }


}
