package ua.training.controller.command;

import ua.training.model.entity.User;
import ua.training.service.LoginService;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginCommand implements Command {
    private LoginService loginService = new LoginService();
    private User.Role role = User.Role.UNKNOWN;


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null) {
            User user = loginService.getUserByLogin(login);
            request.getSession().setAttribute("userFromLogin", user);
        }
        if (login != null) {
            role = loginService.getRoleByLoginPassword(login, password);

        }
        if (login == null || login.equals("") || password == null || password.equals("")) {
            return "/WEB-INF/pages/regAndLog/login.jsp";
        }
        if(CommandUtility.checkUserIsLogged(request, login, password)){
            return "redirect:/api/error";
        }


        if (String.valueOf(role).equals("ADMIN")) {
            CommandUtility.setUserRole(request, User.Role.ADMIN, login);
            return "redirect:/api/admin_page";
        } else if (String.valueOf(role).equals("STUDENT")) {
            CommandUtility.setUserRole(request, User.Role.STUDENT, login);
            return "redirect:/api/student_page";
        } else {
            CommandUtility.setUserRole(request, User.Role.UNKNOWN, login);
            return "redirect:/api/login";
        }


    }


}
