package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp(){
        //Set the path to the Chrome driver executable
        System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\SELENIUM_SUITES\\chromedriver-win32\\chromedriver.exe");

        //Launch the Chrome browser
        driver = new ChromeDriver();

        //Navigate to the home page url
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @After
    public void tearDown(){
        //Quit the Web driver instance
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
