package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;


public class AstronomyCourseCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/pages/courses/astronomyCourse.jsp";
    }
}
