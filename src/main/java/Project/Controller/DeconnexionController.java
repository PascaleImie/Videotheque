package Project.Controller;

import Project.Service.Mailer;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class DeconnexionController {



    @Autowired
    private UserService userService;

    @Autowired
    private Mailer mailer;

    @RequestMapping(method = RequestMethod.GET, value = "/deconnexion")
    public String main(ModelMap modelMap, HttpSession httpSession, SessionStatus status) throws UnsupportedEncodingException {

        httpSession.invalidate();

        return "Main/index";
    }

}
