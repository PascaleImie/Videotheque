package Project.Service;

import Project.Model.Acteur;
import Project.Model.Film;

public interface ActeurService {


    public long add(Acteur acteur);

    public Acteur getById(long id, boolean lazy);

    public Acteur isExist(String prenom, String nom);
}