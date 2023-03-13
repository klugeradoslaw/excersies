package pl.klugeradoslaw.ex04readstackcrud.domain.common;

import pl.klugeradoslaw.ex04readstackcrud.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {

    public final DataSource dataSource;

    public BaseDao () {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
