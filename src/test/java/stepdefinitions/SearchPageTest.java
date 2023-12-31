package stepdefinitions;

import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class SearchPageTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @Given("I am on the Search Page")
    public void iAmOnTheHomePage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        loginPage.loginToMoviesApp("rahul","rahul@2021");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'search-empty-button']")));
        searchPage.emptySearchBtn();
    }

    @When("I click to the Search box")
    public void iClickToTheSearchBox(){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://qamoviesapp.ccbp.tech/search","Urls does not match");
        searchPage.clickSearchBox();
    }

    @And("I enter a movie names in search box")
    public void iEnterAMovieNames(){
        searchPage.enterMovieName("Titanic");
    }

    @And("I click to the Search Page button")
    public void iClickToTheSearchPageBtn(){
        searchPage.clickSearchBtn();
    }


    @Then("I find the count of movies")
    public void IFindTheCountOfMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[starts-with(@class,'search-movies')]/li")));
        int actualCount = searchPage.getMoviesCount();
        Assert.assertEquals(actualCount,1,"Movies count is not expected");
    }
}
