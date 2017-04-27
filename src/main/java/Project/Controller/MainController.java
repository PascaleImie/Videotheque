package Project.Controller;


import Project.Model.User;
import Project.Service.Mailer;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private Mailer mailer;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main(ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {

        // mailer.sendMail("Test", "Test", "test.videobox@gmail.com");

        return "Main/index";
    }
}
