package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.yugabytedb.database.YugabyteDatabase;
import liquibase.sqlgenerator.core.DropPrimaryKeyGenerator;
import liquibase.statement.core.DropPrimaryKeyStatement;

public class DropPrimaryKeyGeneratorYugabyte extends DropPrimaryKeyGenerator {
    @Override
    public boolean supports(DropPrimaryKeyStatement statement, Database database) {
        return (!(database instanceof YugabyteDatabase));
    }
}
