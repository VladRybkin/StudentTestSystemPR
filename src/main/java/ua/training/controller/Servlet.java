package ua.training.controller;

import ua.training.controller.command.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {


    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("geographyTest", new GeographyTestCommand());
        commands.put("astronomyTest", new AstronomyTestCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("admin_page", new AdminPageCommand());
        commands.put("student_page", new StudentPageCommand());
        commands.put("error", new ExceptionCommand());
        commands.put("user_statistic", new UserStatisticCommand());
        commands.put("astronomyCourse", new AstronomyCourseCommand());
        commands.put("geographyCourse", new GeographyCourseCommand());
        commands.put("geographyMaterial", new GeographyMaterialCommand());
        commands.put("astronomyMaterial", new AstronomyMaterialCommand());


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);




    }
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/api/" , "");
        Command command = commands.getOrDefault(path, (r, p)->"/index.jsp)");
        String page = command.execute(request, response);
        if (page.contains("redirect")){
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }


//
    }
}