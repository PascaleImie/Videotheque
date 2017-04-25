package Project.Controller;

import Project.Model.User;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class EspaceController {


    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, value = "/espace")
    public String main(ModelMap modelMap, HttpSession httpSession) throws NullPointerException {


        try {
            //Récupère id enregistré dans session
            long id = (Long) httpSession.getAttribute("UserId");
            //Récupère user
            User user = userService.getById(id, false);
            //Envoie l'objet user à la JSP
            modelMap.addAttribute("User", user);
            return "Main/espace";


        } catch (NullPointerException e) {
            return "Main/index";


        }

        //if(httpSession != null) {
        //Récupère id enregistré dans session
        //   long id = (Long) httpSession.getAttribute("UserId");
        //Récupère user
        //   User user = userService.getById(id, false);
        //Envoie l'objet user à la JSP
        //    modelMap.addAttribute("User", user);


        //}
        // return "Main/espace";
        //}

    }
}
