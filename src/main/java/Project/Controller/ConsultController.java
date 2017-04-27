package Project.Controller;

import Project.Form.UserRegisterForm;
import Project.Model.Film;
import Project.Model.Realisateur;
import Project.Model.User;
import Project.Service.FilmService;
import Project.Service.Mailer;
import Project.Service.RealisateurService;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ConsultController {



    @Autowired
    private UserService userService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private RealisateurService realisateurService;


    @RequestMapping(method = RequestMethod.GET, value = "consultUser")
    public String main(ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {

        List<User> listUser = userService.getAllUser();
        modelMap.addAttribute("listUser",listUser);

        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie l'objet user à la JSP
            modelMap.addAttribute("User", user);
            return "Main/consultUser";


        } catch (NullPointerException e) {
            return "Main/index";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "infoUser")
    public String info(ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {
        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie l'objet user à la JSP
            modelMap.addAttribute("User", user);
            return "Main/infoUser";


        } catch (NullPointerException e) {
            return "Main/index";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "consultFilm")
    public String filmConsult(ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {

        List<Film> films = filmService.getAllFilm();
        modelMap.addAttribute("Films",films);

        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie l'objet user à la JSP
            modelMap.addAttribute("User", user);
            return "Main/consultFilm";


        } catch (NullPointerException e) {
            return "Main/index";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "consultOneFilm/{id_film}")
    public String oneFilmConsult(@PathVariable("id_film") long id_film, ModelMap modelMap, HttpSession httpSession)
            throws UnsupportedEncodingException {

        Film  film = filmService.getById(id_film,true);
        modelMap.addAttribute("Film", film);
        modelMap.addAttribute("Realisateur",film.getRealisateur());
        modelMap.addAttribute("Acteurs",film.getActeurs());
        modelMap.addAttribute("Genres",film.getGenres());


        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie du user à JSP
            modelMap.addAttribute("User", user);

            return "Main/consultOneFilm";
        } catch (Exception e) {
            return "consultFilm";
        }


    }

}
