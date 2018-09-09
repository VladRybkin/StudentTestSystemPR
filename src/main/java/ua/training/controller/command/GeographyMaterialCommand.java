package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;


public class GeographyMaterialCommand implements  Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/pages/materials/geographyMaterial.jsp";
    }
}
