package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.yugabytedb.database.YugabyteDBDatabase;
import liquibase.sqlgenerator.core.DropPrimaryKeyGenerator;
import liquibase.statement.core.DropPrimaryKeyStatement;

public class DropPrimaryKeyGeneratorYugabyteDB extends DropPrimaryKeyGenerator {
    @Override
    public boolean supports(DropPrimaryKeyStatement statement, Database database) {
        return false;
    }
}
