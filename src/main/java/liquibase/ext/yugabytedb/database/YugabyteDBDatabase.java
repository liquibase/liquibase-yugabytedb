package liquibase.ext.yugabytedb.database;

import liquibase.database.DatabaseConnection;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.util.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class YugabyteDBDatabase extends PostgresDatabase {

    @Override
    public int getPriority() {
        return super.getPriority()+5;
    }

    @Override
    public boolean supportsInitiallyDeferrableColumns() {
        return false;
    }

    @Override
    public boolean supportsTablespaces() {
        return false;
    }

    @Override
    public boolean supportsDDLInTransaction() {
        return false;
    }

    @Override
    public Integer getDefaultPort() {
        return 5433;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
        try (Statement stmt = ((JdbcConnection) conn).createStatement();
             ResultSet rs = stmt.executeQuery("select version()")
        ) {
            if (rs.next()) {
                return ((String) JdbcUtils.getResultSetValue(rs, 1)).matches("^PostgreSQL\\s+\\d{1,2}(\\.\\d{1,2})?-YB.*");
            }
        } catch (SQLException throwables) {
            return false;
        }
        return false;
    }

    @Override
    protected String getDefaultDatabaseProductName() {
        return "PostgreSQL";
    }

    @Override
    public String getShortName() {
        return "yugabytedb";
    }
}