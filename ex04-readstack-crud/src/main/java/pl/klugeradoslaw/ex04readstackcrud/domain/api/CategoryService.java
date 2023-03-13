package pl.klugeradoslaw.ex04readstackcrud.domain.api;

import pl.klugeradoslaw.ex04readstackcrud.domain.category.Category;
import pl.klugeradoslaw.ex04readstackcrud.domain.category.CategoryDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();


    public List<CategoryNameDto> findAllCategoryName() {
        return categoryDao.findAll()
                .stream().map(CategoryNameMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<CategoryFullInfoDto> findById(int categoryId) {
        return categoryDao.findById(categoryId)
                .map(CategoryFullInfoDtoMapper::map);
    }

    private static class CategoryNameMapper {
        static CategoryNameDto map(Category c) {
            return new CategoryNameDto(
                    c.getId(),
                    c.getName()
            );
        }
    }

    private static class CategoryFullInfoDtoMapper {
        static CategoryFullInfoDto map(Category c) {
            return new CategoryFullInfoDto(
                    c.getId(),
                    c.getName(),
                    c.getDescription()
            );
        };
    }
}
