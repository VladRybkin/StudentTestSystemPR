package ua.training.controller.command;



import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        CommandUtility commandUtility=new CommandUtility();
        request.getSession().invalidate();
        commandUtility.setUserRole(request, User.Role.UNKNOWN, "Guest");
        return "/index.jsp";
    }
}
