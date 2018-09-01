package ua.training.controller.command;

import ua.training.model.entity.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {

    String REGEX_EMAIL = "^[[\\w]|[\\.]]+@[\\w]+[\\.][\\w]+$";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService=new UserService();
        User user = new User();
        String login = request.getParameter("user_login");
        String password = request.getParameter("user_password");
        String email = request.getParameter("user_mail");
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(User.Role.STUDENT);


            if (user.getLogin() != null && user.getPassword() != null && user.getEmail() != null && user.getEmail().matches(REGEX_EMAIL) ){
                try {
                    userService.create(user);
                    request.setAttribute("successReg", "Registration successful "+"login "+login+" password "+password+" email "+email);
                }catch (Exception e){
                    return "redirect:/api/error";
                }


            }



        return "/WEB-INF/pages/regAndLog/registration.jsp";
    }
}
