import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/AccountPageFunctionalities.feature")
public class AccountPageTestRunner extends AbstractTestNGCucumberTests {
}
