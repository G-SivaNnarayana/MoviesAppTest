import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features\\LoginPageFunctionalities.feature")
public class LoginPageTestRunner extends AbstractTestNGCucumberTests {
}
