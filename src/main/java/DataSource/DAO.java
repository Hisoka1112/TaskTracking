package DataSource;

import java.sql.SQLException;

public interface DAO<T> {
    public abstract void insert(T object) throws SQLException;
    public abstract void delete(int id) throws SQLException;
    public abstract void getAll( ) throws SQLException;

}
