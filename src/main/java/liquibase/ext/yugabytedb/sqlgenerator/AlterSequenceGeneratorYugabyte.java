package liquibase.ext.yugabytedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.yugabytedb.database.YugabyteDatabase;
import liquibase.sqlgenerator.core.AlterSequenceGenerator;
import liquibase.statement.core.AlterSequenceStatement;

public class AlterSequenceGeneratorYugabyte extends AlterSequenceGenerator {
    @Override
    public boolean supports(AlterSequenceStatement statement, Database database) {
        if(database instanceof YugabyteDatabase)
            return false;
        else
            return database.supportsSequences();
    }
}
