package com.example.depomanagementservlet.controller;

import com.example.depomanagementservlet.dto.CategoryResponseDto;
import com.example.depomanagementservlet.service.CategoryService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService = new CategoryService();
    private final Logger log = Logger.getLogger(CategoryServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category.jsp");

        List<CategoryResponseDto> categories = categoryService.getAll();

        req.setAttribute("categories", categories);

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryService.create(req.getParameter("categoryName"));

        resp.sendRedirect(req.getRequestURI());
    }
}
