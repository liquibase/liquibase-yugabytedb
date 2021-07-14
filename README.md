# Liquibase Extension for YugabyteDB
This adds support for the YugabyteDB database to Liquibase

YugabyteDB is the open source, high-performance, distributed SQL database for global, internet-scale apps. It can be run on the local machine as well as cloud cluster.

## Supported Changes

The list of supported changes and how to use Liquibase with YugabyteDB can be found in [this document](https://docs.google.com/document/d/1DaH5EA2kEdNsmziPiwzWmP8XvDhr-eZv-63ws0iPem4/edit#).

## Running the Test Harness

To run the test harness, Follow the steps given below:

1. Start a YugabyteDB cluster.

   ```<YUGABYTEDB_INSTALL_DIR>/bin/yb-ctl start```

2. Run the [yugabytedb-init.sql](src/test/resources/docker/yugabytedb-init.sql) file via ysqlsh.
   
   ```<YUGABYTEDB_INSTALL_DIR>/bin/ysqlsh -f <path/to/yugabytedb-init.sql>```

3. Update the configuration details in [harness-config.yml](src/test/resources/harness-config.yml).

4. Run the command:

   ```mvn clean install```
