package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;


public class StudentPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request)  {
        return "/WEB-INF/pages/studentPages/student_page.jsp";
    }
}
