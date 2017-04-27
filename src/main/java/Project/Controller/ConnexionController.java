package Project.Controller;


import Project.Form.UserConnectForm;
import Project.Model.User;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static Project.Controller.InscriptionController.encodeSHA512;


/**
 * Created by Pascale on 13/01/2017.
 */
@Controller

public class ConnexionController {
    @Autowired
    private UserService userService;



    @RequestMapping(method = RequestMethod.GET, value = "/connexion")
    public String main(ModelMap modelMap, HttpSession httpSession) {
        //envoi un objet vide
        modelMap.addAttribute("User", new User());

        return "Main/connexion";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/connectUser")
    public String connectUser(@Valid @ModelAttribute("User")UserConnectForm userConnectForm, BindingResult result, ModelMap modelMap,
                              HttpSession httpSession) {


        User userConnexion = userService.getByMail(userConnectForm.getEmail());
        //Si l'objet userConnexion existe
        if (userConnexion != null) {
            System.out.println(userConnexion.getEmail());
            System.out.println(userConnexion.getMdp());
            System.out.println(userConnectForm.getMdp());
            //Si le mdp stocké en bdd est égal au mdp encodé saisi sur le fomulaire connexion
            if ((userConnexion.getMdp()).equals(encodeSHA512(userConnectForm.getMdp()))) {
                //je sauvegarde l'id dans la session
                httpSession.setAttribute("UserId", userConnexion.getId());
                //je redirige vers l'espace admin
                return "redirect:/espace";
            } else {
                String messageErreur = "Mot de passe incorrect";
                modelMap.addAttribute("Erreur", messageErreur);
                return "Main/connexion";
            }
        } else {
            //System.out.println("Email ou mot de passe non valide");
            String messageErreur ="Adresse Mail non reconnue.Etes-vous certain d'être inscrit ?";
            modelMap.addAttribute("Erreur", messageErreur);
            return "Main/connexion";
        }
    }

    public static String encodeSHA512(String plainPassword) {
        return new ShaPasswordEncoder(512).encodePassword(plainPassword, null);
    }
}

