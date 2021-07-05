# Liquibase Extension for YugabyteDB

## Run Tests

1. Start a YugabyteDB cluster.

   ```<YUGABYTEDB_INSTALL_DIR>/bin/yb-ctl start```

2. Run the [yugabytedb-init.sql](src/test/resources/docker/yugabytedb-init.sql) file via ysqlsh.

3. Update the configuration in [harness-config.yml](src/test/resources/harness-config.yml).

4. Run the command:

   ```mvn clean install```