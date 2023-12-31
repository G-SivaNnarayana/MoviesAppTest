package stepdefinitions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.HomePage;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    LoginPage loginPage;
    HomePage homePage;

    @Given("I am on the Home Page")
    public void iAmOnTheHomePage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginToMoviesApp("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Urls does not match");
    }

    @When("I check to the Heading text of each section")
    public void iCheckToTheHeadingText(){
        String actualHeading1 = homePage.getHomePageHeadingText1();
        Assert.assertEquals(actualHeading1,"Trending Now","Heading Text is does not match");

        String actualHeading2 = homePage.getHomePageHeadingText2();
        Assert.assertEquals(actualHeading2,"Originals","Heading Text is does not match");
    }

    @And("I check to the Movies or displayed or not")
    public void checkToTheDisplayMovies() {

        Assert.assertEquals(homePage.getMoviesList(),true,"Movies are not displayed");
    }
    @And("I check to the Contact Us Section")
    public void checkToTheContactSection(){
        String actualText = homePage.getContactUsEl();
        Assert.assertEquals(actualText,"Contact Us","Contact Us text is does not macth");
    }
}
