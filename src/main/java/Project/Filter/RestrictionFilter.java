package Project.Filter;

import Project.Model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by Pascale on 03/03/2017.
 */
public class RestrictionFilter implements Filter {


    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Récuperation de la session
        HttpSession session = (HttpSession) request.getAttribute("UserId");


        if (session == null) {
            //Redirection vers la page index
            request.getRequestDispatcher("index").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }


    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
