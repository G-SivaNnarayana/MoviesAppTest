import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/MoviesDetailsPageFunctionalities.feature")
public class MoviesDetailsPageTestRunner extends AbstractTestNGCucumberTests {
}
