package ua.training.controller.command;



import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CommandUtility commandUtility=new CommandUtility();
        request.getSession().invalidate();
        commandUtility.setUserRole(request, User.Role.UNKNOWN, "Guest");
        return "/index.jsp";
    }
}
