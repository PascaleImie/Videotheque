package Project.Service;

import Project.Model.Film;


import java.util.List;

public interface FilmService {



    public long add(Film film);

    public Film getById(long id, boolean lazy);

    public Film getByTitle(String titre);

    public void delete(Film film);

    public List<Film> getAllFilm();


}