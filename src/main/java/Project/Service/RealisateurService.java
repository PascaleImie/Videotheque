package Project.Service;

import Project.Model.Realisateur;


import java.util.List;

public interface RealisateurService {

    public long add(Realisateur realisateur);

    public Realisateur getById(long id, boolean lazy);

    public Realisateur isExist(String nom, String prenom);

    public List<Realisateur> getAllRealisateur();





}