package pl.klugeradoslaw.ex04readstackcrud.client.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.CategoryFullInfoDto;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.CategoryService;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.DiscoveryBasicInfoDto;
import pl.klugeradoslaw.ex04readstackcrud.domain.api.DiscoveryService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final DiscoveryService discoveryService = new DiscoveryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));
        CategoryFullInfoDto category = categoryService.findById(categoryId)
                .orElseThrow();
        req.setAttribute("category", category);
        List<DiscoveryBasicInfoDto> discoveries = discoveryService.findByCategory(categoryId);
        req.setAttribute("discoveries", discoveries);
        req.getRequestDispatcher("/category.jsp").forward(req, resp);
    }
}
