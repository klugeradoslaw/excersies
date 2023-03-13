package pl.klugeradoslaw.ex04readstackcrud.client.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.CategoryNameDto;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.CategoryService;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.DiscoveryBasicInfoDto;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.DiscoveryService;


import java.io.IOException;
import java.util.List;

@WebServlet
public class HomeController extends HttpServlet {
    private DiscoveryService discoveryService = new DiscoveryService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DiscoveryBasicInfoDto> discoveries = discoveryService.findAll();
        req.setAttribute("Discoveries", discoveries);
        List<CategoryNameDto> categories = categoryService.findAllCategoryName();
        req.setAttribute("Categories", categories);

        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
