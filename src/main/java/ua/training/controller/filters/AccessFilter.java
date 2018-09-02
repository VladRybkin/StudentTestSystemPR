package ua.training.controller.filters;

import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User.Role role= (User.Role) request.getSession().getAttribute("role");
        String path = request.getRequestURI();

        if(path.contains("/api/admin_page") && (session != null && role==null ||!role.equals(User.Role.ADMIN ))) {
            response.sendRedirect("/api/error");
        } else{
                filterChain.doFilter(servletRequest,servletResponse);

            }
        }


    @Override
    public void destroy() {

    }

}
