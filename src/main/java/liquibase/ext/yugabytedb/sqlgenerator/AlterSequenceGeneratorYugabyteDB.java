package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.yugabytedb.database.YugabyteDBDatabase;
import liquibase.sqlgenerator.core.AlterSequenceGenerator;
import liquibase.statement.core.AlterSequenceStatement;

public class AlterSequenceGeneratorYugabyteDB extends AlterSequenceGenerator {
    @Override
    public boolean supports(AlterSequenceStatement statement, Database database) {
        return false;
    }
}
