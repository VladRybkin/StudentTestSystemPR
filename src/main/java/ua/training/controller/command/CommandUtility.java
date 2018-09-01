package ua.training.controller.command;


import ua.training.model.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {
    static void setUserRole(HttpServletRequest request,
                            User.Role role, String login) {
        HttpSession session = request.getSession();
        session.setAttribute("userLogin", login);
        session.setAttribute("role", role);
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String userLogin, String userPassword) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(userLogin::equals))  {
            return true;
        }
        loggedUsers.add(userLogin);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

}
