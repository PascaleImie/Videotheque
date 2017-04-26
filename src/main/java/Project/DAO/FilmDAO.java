package Project.DAO;

import Project.Model.Film;
import Project.Model.User;

import java.util.List;

public interface FilmDAO {

    public long add(Film film);

    public Film getById(long id, boolean lazy);

    public void delete(Film film);

    public Film getByTitle(String titre);

    public List<Film> getAllFilm();


}
