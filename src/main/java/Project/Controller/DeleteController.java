package Project.Controller;

import Project.Model.Acteur;
import Project.Model.Film;
import Project.Model.User;
import Project.Service.ActeurService;
import Project.Service.FilmService;
import Project.Service.GenreService;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class DeleteController {



    @Autowired
    private UserService userService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActeurService acteurService;

    @Autowired
    private GenreService genreService;


    @RequestMapping(method = RequestMethod.GET, value = "deleteUser/{listUserid}")
    public String deleteUser(@PathVariable(value="listUserid") int id, ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {

        User user = userService.getById(id,true);
        userService.delete(user);

        return "redirect:/consultUser";
    }

    @RequestMapping(method = RequestMethod.GET, value = "deleteFilm/{id_film}")
    public String deleteFilm(@PathVariable(value="id_film") int id_film, ModelMap modelMap, HttpSession httpSession)throws UnsupportedEncodingException{

        Film film = filmService.getById(id_film,true);
        filmService.delete(id_film);
        return "redirect:/consultFilm";
    }




}
