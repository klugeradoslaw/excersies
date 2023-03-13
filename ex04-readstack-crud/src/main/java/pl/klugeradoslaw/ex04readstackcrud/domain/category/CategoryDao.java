package pl.klugeradoslaw.ex04readstackcrud.domain.category;

import pl.klugeradoslaw.ex04readstackcrud.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private final DataSource dataSource;


    public CategoryDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

        public List<Category> findAll () {
            String query = """
                SELECT
                    id, name, description
                FROM
                    category
                WHERE 
                    id = ?
                """;

            try (Connection connection = dataSource.getConnection();
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
    private Category mapRow(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        String description = set.getString("description");
        return new Category(id, name, description);
    }
}
