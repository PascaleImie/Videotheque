package Project.Controller;


import Project.Form.UserConnectForm;
import Project.Model.User;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * Created by Pascale on 13/01/2017.
 */
@Controller

public class ModifController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/modifMdp")
    public String modifPass(ModelMap modelMap, HttpSession httpSession) {
        //envoi un objet vide
        modelMap.addAttribute("UserModif", new User());

        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie l'objet user à la JSP
            modelMap.addAttribute("User", user);
            return "Main/modifMdp";


        } catch (NullPointerException e) {
            return "Main/index";

        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifPass")
    public String modifPass(@Valid @ModelAttribute("UserModif")UserConnectForm userConnectForm, BindingResult result, ModelMap modelMap,
                              HttpSession httpSession, @RequestParam(value="mdpConf",required=true) String mdpConf,
                            @RequestParam (value="newMdp", required=true) String newMdp) {


        //Récupère id enregistré dans session
        long id = (Long) httpSession.getAttribute("UserId");

        User userConnexion = userService.getById(id, false);
        //Si l'objet userConnexion existe
        if (userConnexion != null) {
            System.out.println("mot de passe bdd :" + userConnexion.getMdp());
            System.out.println("mdpConf :" + mdpConf);
            System.out.println("New mdp :" + newMdp);
            if (newMdp.equals(mdpConf)) {
                System.out.println("Mots de passe équivalents");
                if ((userConnexion.getMdp()).equals(encodeSHA512(userConnectForm.getMdp()))) {
                    //Encryptage du nouveau de mot de passe
                    userConnexion.setMdp(encodeSHA512(newMdp));
                    System.out.println(userConnexion.getMdp());
                    //changement en bdd
                    userService.changeMdp(userConnexion);

                    return "redirect:/connexion";
                }
            }
        }
        System.out.println("mots de passe différents");
        return "Main/modifMdp";
    }

    public static String encodeSHA512(String plainPassword) {
        return new ShaPasswordEncoder(512).encodePassword(plainPassword, null);
    }
}

