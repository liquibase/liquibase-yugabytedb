package liquibase.ext.yugabytedb.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class YugabyteDBDatabaseTest {
    YugabyteDBDatabase database;

    @Before
    public void setup() {
        database = new YugabyteDBDatabase();
    }

    @Test
    public void testGetShortName() {
        assertEquals("yugabytedb", database.getShortName());
    }

    @Test
    public void testGetDefaultDatabaseProductName() {
        assertEquals("PostgreSQL", database.getDefaultDatabaseProductName());
    }

    @Test
    public void testGetDefaultPort() {
        assertEquals("5433",database.getDefaultPort().toString());
    }

    @Test
    public void testSupportsInitiallyDeferrableColumns() {
        assertFalse(database.supportsInitiallyDeferrableColumns());
    }


    @Test
    public void testGetDatabaseChangeLogTableName() {
        assertEquals("databasechangelog", database.getDatabaseChangeLogTableName());
    }

    @Test
    public void testGetDatabaseChangeLogLockTableName() {
        assertEquals("databasechangeloglock", database.getDatabaseChangeLogLockTableName());
    }

    @Test
    public void testSupportsTablespaces() {
        assertFalse(database.supportsTablespaces());
    }

    @Test
    public void testSupportsRestrictForeignKeys() {
        assertTrue(database.supportsRestrictForeignKeys());
    }

}
