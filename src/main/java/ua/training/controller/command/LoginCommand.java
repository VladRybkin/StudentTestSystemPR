package ua.training.controller.command;

import ua.training.model.entity.User;
import ua.training.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommandUtility commandUtility = new CommandUtility();
        LoginService loginService = new LoginService();
        User.Role role = User.Role.UNKNOWN;
        User user = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null) {
            user = loginService.getUserByLoginAndPass(login, password);
            role = user.getRole();
            request.getSession().setAttribute("userFromLogin", user);
        }

        if (login == null || login.equals("") || password == null || password.equals("")) {
            return "/WEB-INF/pages/regAndLog/login.jsp";
        }
        if (commandUtility.checkUserIsLogged(request, user.getLogin())) {
            return "redirect:/api/error";
        }


        if (String.valueOf(role).equals("ADMIN")) {
            commandUtility.setUserRole(request, User.Role.ADMIN, login);
            return "redirect:/api/admin_page";
        } else if (String.valueOf(role).equals("STUDENT")) {
            commandUtility.setUserRole(request, User.Role.STUDENT, login);
            return "redirect:/api/student_page";
        } else {
            commandUtility.setUserRole(request, User.Role.UNKNOWN, login);
            return "redirect:/api/login";
        }
    }


}
