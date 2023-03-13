package pl.klugeradoslaw.ex04readstackcrud.domain.category;

import pl.klugeradoslaw.ex04readstackcrud.domain.common.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao extends BaseDao {

        public List<Category> findAll () {
            String query = """
                SELECT
                    id, name, description
                FROM
                    category
                """;

            try (Connection connection = getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                List<Category> allCategories = new ArrayList<>();
                while (resultSet.next()) {
                    Category category = mapRow(resultSet);
                    allCategories.add(category);
                }
                return allCategories;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    public Optional<Category> findById (int categoryId) {
        String query = """
                SELECT
                    id, name, description
                FROM
                    category
                WHERE 
                    id = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            List<Category> allCategories = new ArrayList<>();
            if (resultSet.next()) {
                Category category = mapRow(resultSet);
                return Optional.of(category);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Category mapRow(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        String description = set.getString("description");
        return new Category(id, name, description);
    }
}
