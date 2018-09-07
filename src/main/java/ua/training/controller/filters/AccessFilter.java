package ua.training.controller.filters;


import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessFilter implements Filter {
    private List<String> studentPages = new ArrayList<>();
    private List<String> adminPages = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        studentPages.add("/api/astronomyCourse");
        studentPages.add("/api/geographyCourse");
        studentPages.add("/api/student_page");
        studentPages.add("/api/geographyCourse");
        studentPages.add("/api/astronomyCourse");
        studentPages.add("/api/geographyTest");
        studentPages.add("/api/astronomyTest");
        studentPages.add("/api/user_statistic");
        adminPages.add("/api/admin_page");
        adminPages.add("/api/testResultsStatistic");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        User.Role role = (User.Role) request.getSession().getAttribute("role");
        String path = request.getRequestURI();

        if (studentPages.contains(path) && (role == null || (!role.equals(User.Role.STUDENT)) && !role.equals(User.Role.ADMIN))) {
            response.sendRedirect("/api/error");
        }

        if (adminPages.contains(path) && (role == null || (!role.equals(User.Role.ADMIN)))) {
            response.sendRedirect("/api/error");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    @Override
    public void destroy() {
    }


}
