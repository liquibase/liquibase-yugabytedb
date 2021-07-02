package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.database.core.*;
import liquibase.ext.yugabytedb.database.YugabyteDatabase;
import liquibase.sqlgenerator.core.RenameSequenceGenerator;
import liquibase.statement.core.RenameSequenceStatement;

public class RenameSequenceGeneratorYugabyte extends RenameSequenceGenerator {
    @Override
    public boolean supports(RenameSequenceStatement statement, Database database) {
        return database.supportsSequences()
                && !(database instanceof YugabyteDatabase)
                && !(database instanceof AbstractDb2Database)
                && !(database instanceof FirebirdDatabase)
                && !(database instanceof H2Database)
                && !(database instanceof HsqlDatabase)
                && !(database instanceof InformixDatabase);
    }
}
