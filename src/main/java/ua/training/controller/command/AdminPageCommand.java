package ua.training.controller.command;


import ua.training.model.entity.User;
import ua.training.service.UserService;
import ua.training.service.comparators.UserComparator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<User> users = userService.findAllWithLimit((page - 1) * recordsPerPage, recordsPerPage);
        int noOfRecords = userService.findAll().size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        users.sort(new UserComparator());

        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("studentStats", users);
        return "/WEB-INF/pages/adminPages/admin_page.jsp";
    }
}
