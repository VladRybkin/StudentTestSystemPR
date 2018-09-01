package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GeographyCourseCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setAttribute("userLogin", request.getSession().getAttribute("userLogin"));
        request.setAttribute("userRole", request.getSession().getAttribute("role"));
        return "/WEB-INF/pages/courses/geographyCourse.jsp";

    }
}
