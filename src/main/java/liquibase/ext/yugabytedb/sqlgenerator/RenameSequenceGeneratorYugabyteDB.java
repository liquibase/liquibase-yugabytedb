package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.database.core.*;
import liquibase.ext.yugabytedb.database.YugabyteDBDatabase;
import liquibase.sqlgenerator.core.RenameSequenceGenerator;
import liquibase.statement.core.RenameSequenceStatement;

public class RenameSequenceGeneratorYugabyteDB extends RenameSequenceGenerator {
    @Override
    public boolean supports(RenameSequenceStatement statement, Database database) {
        return false;
    }
}
