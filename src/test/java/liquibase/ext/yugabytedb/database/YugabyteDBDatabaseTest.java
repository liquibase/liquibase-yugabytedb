package liquibase.ext.yugabytedb.database;

import org.junit.Before;
import org.junit.Test;

import liquibase.CatalogAndSchema;
import liquibase.database.jvm.JdbcConnection;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;

import static liquibase.servicelocator.PrioritizedService.PRIORITY_DATABASE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;


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
