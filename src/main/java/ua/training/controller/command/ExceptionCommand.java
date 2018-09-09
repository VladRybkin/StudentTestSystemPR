package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ExceptionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/pages/errors/error.jsp";
    }
}
