package Project.Service;


import Project.Model.Genre;

import java.util.List;

public interface GenreService {

    public long add(Genre genre);

    public Genre getById(long id, boolean lazy);

    public List<Genre> findAllGenre();

    public Genre isExist(String libelle);


}