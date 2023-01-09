package liquibase.ext.yugabytedb.database


import spock.lang.Specification

class YugabyteDBDatabaseTest extends Specification {
    YugabyteDBDatabase database;

    void setup() {
        database = new YugabyteDBDatabase();
    }

    def getShortName() {
        expect:
        database.getShortName() == "yugabytedb"
    }

    def getDefaultDatabaseProductName() {
        expect:
        database.getDefaultDatabaseProductName() == "PostgreSQL"
    }

    def getDefaultPort() {
         database.getDefaultPort().toString() == "5433"
    }

    def supportsInitiallyDeferrableColumns() {
        expect:
        !database.supportsInitiallyDeferrableColumns()
    }


    void getDatabaseChangeLogTableName() {
        expect:
        database.getDatabaseChangeLogTableName() == "databasechangelog"
    }

    def getDatabaseChangeLogLockTableName() {
        expect:
        database.getDatabaseChangeLogLockTableName() == "databasechangeloglock"
    }

    def supportsTablespaces() {
        expect:
        !database.supportsTablespaces()
    }

    def supportsRestrictForeignKeys() {
        expect:
        database.supportsRestrictForeignKeys()
    }

}
