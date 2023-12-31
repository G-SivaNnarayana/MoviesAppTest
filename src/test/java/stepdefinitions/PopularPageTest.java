package stepdefinitions;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;

import java.time.Duration;


public class PopularPageTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;

    @Given("I am on the Home page")
    public void iAmOnTheHomePage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);

        loginPage.loginToMoviesApp("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Urls does not match");
    }

    @And("I check to the Movies are displayed or not")
    public void iCheckToTheMovies(){
        Assert.assertEquals(popularPage.getPopularMoviesList(),true,"Popular page movies are not displayed");
    }
}
