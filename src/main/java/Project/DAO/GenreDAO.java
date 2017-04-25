package Project.DAO;

import Project.Model.Genre;

import java.util.List;

public interface GenreDAO {

    public long add(Genre genre);

    public Genre getById(long id, boolean lazy);

    public List<Genre> findAllGenre();

    public Genre isExist(String libelle);

}
