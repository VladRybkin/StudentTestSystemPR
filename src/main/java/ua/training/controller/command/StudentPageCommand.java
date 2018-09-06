package ua.training.controller.command;

import ua.training.model.entity.User;
import ua.training.service.CourseService;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class StudentPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws IOException {

        return "/WEB-INF/pages/studentPages/student_page.jsp";
    }
}
