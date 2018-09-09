package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;



public class AstronomyMaterialCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/pages/materials/astronomyMaterial.jsp";
    }
}
