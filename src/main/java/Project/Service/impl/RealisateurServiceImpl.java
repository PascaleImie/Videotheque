package Project.Service.impl;

import Project.DAO.RealisateurDAO;
import Project.DAO.UserDAO;
import Project.Model.Genre;
import Project.Model.Realisateur;
import Project.Model.User;
import Project.Service.RealisateurService;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RealisateurServiceImpl implements RealisateurService {

        @Autowired
        private RealisateurDAO realisateurDAO;

        @Override
        public long add(Realisateur realisateur) {
                return  realisateurDAO.add(realisateur);
        }

        @Override
        public Realisateur getById(long id, boolean lazy) {
                return realisateurDAO.getById(id,lazy);
        }

        @Override
        public Realisateur isExist(String nom, String prenom) {
                return realisateurDAO.isExist(nom,prenom);
        }

        @Override
        public List<Realisateur> getAllRealisateur() {
                return realisateurDAO.getAllRealisateur();
        }


}
