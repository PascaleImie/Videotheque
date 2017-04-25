package Project.DAO;

import Project.Model.Acteur;

public interface ActeurDAO {

    public long add(Acteur acteur);

    public Acteur getById(long id, boolean lazy);

    public Acteur isExist(String nom, String prenom);


}
