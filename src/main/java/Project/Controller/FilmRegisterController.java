package Project.Controller;


import Project.DAO.RealisateurDAO;
import Project.Form.UserRegisterForm;
import Project.Model.*;
import Project.Service.*;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Pascale on 13/01/2017.
 */
@Controller

public class FilmRegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private ActeurService acteurService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private RealisateurService realisateurService;

    private List<Acteur> acteurs = new ArrayList<Acteur>();
    private List<Genre> genres = new ArrayList<Genre>();



    private Film film;


    @RequestMapping(method = RequestMethod.GET, value = "/filmRegister")
    public String filmRegister (ModelMap modelMap, HttpSession httpSession ) {

        //envoi de ma liste de genres sasis en dur dans bdd dans ma jsp
        List<Genre>genres = genreService.findAllGenre();
        modelMap.addAttribute("Genres", genres);


        //envoi un objet vide à la JSP inscription
        modelMap.addAttribute("FilmRegister", new Film());
        modelMap.addAttribute("Acteurs", new Acteur());
        modelMap.addAttribute("Realisateur", new Realisateur());

        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie du user à JSP
            modelMap.addAttribute("User", user);

            return "Main/filmRegister";
        } catch (Exception e) {
            return "Main/index";
        }


    }

    @RequestMapping( method = RequestMethod.POST , value = "/addFilm")
    public String addFilm(@Valid @ModelAttribute("FilmRegister") Film film, BindingResult result, ModelMap modelMap,
                          HttpSession httpSession) {

        // Vérification des erreurs
        System.out.println(result.getErrorCount());
        if (result.hasErrors()) {
            return "Main/inscription";
        }

        if(filmService.getByTitle(film.getTitre()) != null){
            String messageErreur = "Film dejà enregistré";
            modelMap.addAttribute("Erreur", messageErreur);
            return "Main/filmRegister";
        }

//************************* Traitement sur l'objet Film (pour uniformisation dans bdd)*************************//
        //Transformation du titre en majuscule
        film.setTitre((film.getTitre().toUpperCase()));
        //Transformation de la nationalité en majuscule
        film.setNationalite(film.getNationalite().toUpperCase());

        //Récupération de ma liste d'acteurs
        acteurs = film.getActeurs();

        //Modification de ma liste acteurs pour majuscule au nom et à la 1ere lettre du prénom
        for(Acteur a : acteurs ){
            a.setNom(a.getNom().toUpperCase());
            a.setPrenom(a.getPrenom().substring(0,1).toUpperCase()+ a.getPrenom().substring(1).toLowerCase());
        }

        //Modification du realisateur pour majuscule au nom et à la 1ere lettre du prénom
        film.setRealisateur(film.getRealisateur());
        film.getRealisateur().setNom(film.getRealisateur().getNom().toUpperCase());
        film.getRealisateur().setPrenom(film.getRealisateur().getPrenom().substring(0,1).toUpperCase()+
                film.getRealisateur().getPrenom().substring(1).toLowerCase());
        //Regex pour format durée
        String duree = film.getDuree();
        String pattern = "^[1-9]h[0-5][0-9]$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(duree);
        if(!m.find()) {
            String messageErreur = "Mauvais format de durée";
            modelMap.addAttribute("Erreur", messageErreur);
            return "Main/filmRegister";
        }
//********************* Ajout des acteurs seulement si ils n'existent pas déjà *****************************//

        //Créér une nouvelle liste acteursBdd
        //Parcourir la liste acteurs de l'objet film.
        // Pour chaque acteur de la liste acteurs
        // Récupérer dans une variable act de type Acteur, les nom et prénom en bdd.
        // Si l'acteur existe
        // ajout de l'acteur en bdd dans la liste acteurs bdd
        //Si l'acteur n'existe pas
        // ajout de l'acteur dans l'objet film à la liste bdd

        ArrayList<Acteur> acteursBdd = new ArrayList<Acteur>();
        for (Acteur a : acteurs){
            Acteur act = acteurService.isExist(a.getPrenom(),a.getNom());
            if( act != null){
                acteursBdd.add(act);
            } else {
                acteursBdd.add(a);
            }
        }
        film.setActeurs(acteursBdd);

//********************** Ajout du réalisateur en bdd seulement si il n'existe pas déjà *************************//
        // Chercher dans la bdd l'objet realisateur par nom prénom
        // Si n'existe pas, ajouter réalisateur
        // Sinon retourner réalisateur

        Realisateur realisateur = realisateurService.isExist(film.getRealisateur().getNom(),film.getRealisateur().getPrenom());

        if(realisateur == null){
            long idRealisateur=realisateurService.add(film.getRealisateur());
        }else {
            film.setRealisateur(realisateur);
        }

//********************* Sélection dans la liste genre ********************************************//
        //Récuperer genres saisis dans l'objet
        genres = film.getGenres();
        ArrayList<Genre> genresBdd = new ArrayList<Genre>();
        for(Genre g : genres) {
            Genre gbdd=genreService.isExist(g.getLibelle());

            if(gbdd != null){
                genresBdd.add(gbdd);
            }
        }
        film.setGenres(genresBdd);


        //Récuperation de l'id de l'utilisateur courant
        long idUser=(Long)httpSession.getAttribute("UserId");
        //Récupérationn de l'utilisateur courant
        User user = userService.getById(idUser, true);



        film.setUser(user);

        //Ajout du film dans la bdd
        long idFilm = filmService.add(film);

        return "redirect:/consultFilm";
    }

}


