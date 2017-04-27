package Project.Controller;


import Project.Form.UserRegisterForm;
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
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by Pascale on 13/01/2017.
 */
@Controller

public class InscriptionController {
    public static Map<String,String> role=new HashMap<String, String>();
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/inscription")
    public String main(ModelMap modelMap, HttpSession httpSession ) {

        role.put("Admin", "admin");
        role.put("User", "user");
        //envoi un objet vide à la JSP inscription
        modelMap.addAttribute("UserInscription", new UserRegisterForm());

        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie du user à JSP
            modelMap.addAttribute("User", user);

            return "Main/inscription";
        } catch (Exception e) {
            return "Main/index";
        }
    }
    @RequestMapping( method = RequestMethod.POST , value = "/addUser")
    public String addUser(@Valid @ModelAttribute("UserInscription") UserRegisterForm userRegisterForm, BindingResult result, ModelMap modelMap,
                          HttpSession httpSession) {


        // Vérification des erreurs
        System.out.println(result.getErrorCount());
        if (result.hasErrors()) {
            return "Main/inscription";
        }

        User user = new User(userRegisterForm.getNom(), userRegisterForm.getPrenom(), userRegisterForm.getEmail(),"", userRegisterForm.getRole());

        //Récuperation du mail utilisteur en bdd
        if(userService.getByMail(user.getEmail()) != null){
            String messageErreur = "Utilisateur déjà inscrit";
            modelMap.addAttribute("Erreur", messageErreur);
            return "Main/inscription";
        }
        //Transformation du nom en majuscule
        user.setNom((user.getNom().toUpperCase()));
        //Transformation du prenom pour que seule la 1ere lettre prenne une majuscule
        user.setPrenom(user.getPrenom().substring(0,1).toUpperCase()+user.getPrenom().substring(1).toLowerCase());

        //Génération mdp
        user.setMdp(generatePassword());
        System.out.println(user.getMdp());

        //Encodage du mot de passe
        user.setMdp(encodeSHA512(user.getMdp()));
        //httpSession.setAttribute("UserId", user.getId());
        long id = userService.add(user);
        System.out.println(user.getMdp());


        //return "Main/inscription";
        return "redirect:/espace";
    }

    public static String encodeSHA512(String plainPassword) {
        return new ShaPasswordEncoder(512).encodePassword(plainPassword, null);
    }

    public static int password_length=8;
    //Méthode pour générer mot de passe
    public static String generatePassword(){
        Random random = new SecureRandom();
        String choice = "abcdefghjkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVW123456789_";
        String password="";

        for(int i=0 ; i<password_length;i++){
            int pass = random.nextInt(choice.length());
            password += (choice.charAt(pass));
        }
        return password;
    }

}


