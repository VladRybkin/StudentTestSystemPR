package ua.training.controller.command;


import ua.training.model.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

 class CommandUtility {

      void setUserRole(HttpServletRequest request,
                            User.Role role, String login) {
        HttpSession session = request.getSession();
        session.setAttribute("userLogin", login);
        session.setAttribute("role", role);
    }

      boolean checkUserIsLogged(HttpServletRequest request, String userLogin) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        for (String loggedUser : loggedUsers) {
            if (userLogin.equals(loggedUser) ) {
                return true;
            }
        }
        loggedUsers.add(userLogin);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

}
