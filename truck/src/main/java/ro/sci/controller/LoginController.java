package ro.sci.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sci.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("auth/login");

        return modelAndView;
    }

    @RequestMapping(value = "/acces-denied",method = RequestMethod.GET )
    public ModelAndView accesDenied(){
        ModelAndView modelAndView=new ModelAndView("auth/access-denied");

        return modelAndView;
    }

    @RequestMapping("/onLogin")
    public ModelAndView onLogin(String username, String pass,
                                HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        ///use UserService to check the login
        String u=request.getParameter("username");

        if (u.equals("admin")) {
            boolean loginWithSuccess = true;
            if (loginWithSuccess) {
                User user = new User("admin");
                user.setUserName("admin");
                if ("admin".equalsIgnoreCase(username)) {
                    user.getRoles().add("Admin");
                }

                request.getSession().setAttribute("currentUser", user);
                modelAndView.setView(new RedirectView((String) request.getSession().getAttribute("nextUrl")));
            }
      }else{
            response.sendRedirect("Client.html");
        }
        return modelAndView;
    }
}
