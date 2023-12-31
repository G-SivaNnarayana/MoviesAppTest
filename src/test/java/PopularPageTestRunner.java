import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/PopularPageFunctionalities.feature")
public class PopularPageTestRunner extends AbstractTestNGCucumberTests {
}
