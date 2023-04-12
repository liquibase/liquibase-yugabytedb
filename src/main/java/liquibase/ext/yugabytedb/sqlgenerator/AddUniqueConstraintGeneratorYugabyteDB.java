package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.sql.Sql;
import liquibase.sql.UnparsedSql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.core.AddUniqueConstraintGenerator;
import liquibase.statement.core.AddUniqueConstraintStatement;
import liquibase.structure.core.Index;

public class AddUniqueConstraintGeneratorYugabyteDB extends AddUniqueConstraintGenerator {

    @Override
    public Sql[] generateSql(AddUniqueConstraintStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        String sql;
        if (statement.getConstraintName() == null) {
            sql = String.format("ALTER TABLE %s ADD UNIQUE" + (statement.isClustered() ? " CLUSTERED " : " ") + "(%s)"
                    , database.escapeTableName(statement.getCatalogName(), statement.getSchemaName(), statement.getTableName())
                    , database.escapeColumnNameList(statement.getColumnNames())
            );
        } else {
            sql = String.format("ALTER TABLE %s ADD CONSTRAINT %s UNIQUE" + (statement.isClustered() ? " CLUSTERED " : " ") + "(%s)"
                    , database.escapeTableName(statement.getCatalogName(), statement.getSchemaName(), statement.getTableName())
                    , database.escapeConstraintName(statement.getConstraintName())
                    , database.escapeColumnNameList(statement.getColumnNames())
            );
        }
        boolean isInUsingIndexClause = false;

        if (statement.getForIndexName() != null) {
            sql += " USING INDEX ";
            sql += database.escapeObjectName(statement.getForIndexCatalogName(), statement.getForIndexSchemaName(),
                    statement.getForIndexName(), Index.class);
            isInUsingIndexClause = true;
        }
        return new Sql[]{
                new UnparsedSql(sql, getAffectedUniqueConstraint(statement))
        };
    }
}
