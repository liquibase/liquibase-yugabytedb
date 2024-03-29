package liquibase.harness.snapshot.yugabytedb

import liquibase.harness.snapshot.SnapshotObjectTests
import liquibase.snapshot.DatabaseSnapshot
import liquibase.structure.core.Table

[
        [
                setup : "create table test_table (test_col int, col2 varchar(10))",
                verify: {
                    DatabaseSnapshot snapshot ->
                        snapshot.get(new Table(name: "test_table")).with {
                            assert name.equalsIgnoreCase("test_table")
                            assert columns*.name.toString().equalsIgnoreCase("[test_col, col2]")
                            assert primaryKey == null
                        }

                }
        ],
] as SnapshotObjectTests[]
