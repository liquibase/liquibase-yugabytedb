import liquibase.harness.AdvancedHarnessSuite
import liquibase.harness.snapshot.SnapshotObjectTests
import org.junit.platform.suite.api.SelectClasses

@SelectClasses({ SnapshotObjectTests.class})
class AdvancedExtensionHarnessTestSuite extends AdvancedHarnessSuite {
    
}