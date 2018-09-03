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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CourseService courseService = new CourseService();
        UserService userService = new UserService();

//        User user = (User) request.getSession().getAttribute("userFromLogin");
//        User user1 = userService.findCoursesByUserId(user.getId());
//        if (user1.getCourses().size() == 0) {
//            courseService.insertStudentCourses(user.getId(), 3);
//            courseService.insertStudentCourses(user.getId(), 4);
//        }



        return "/WEB-INF/pages/studentPages/student_page.jsp";
    }
}
