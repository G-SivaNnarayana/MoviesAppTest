package stepdefinitions;

import io.cucumber.java.en.When;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

import java.time.Duration;

public class MovieDetailsPageTest {

    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    PopularPage popularPage = new PopularPage(driver);
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    @When("I click to the Home Page of Movie image element")
    public void iClickToTheMovieImageEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.website-logo")));
        homePage.clickHomePageMovieImgEl();
    }

    @Then("I click to the Popular Page of Movie image element")
    public void iClickToTheMovieImgEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img[@alt='Jungle Cruise']")));
        popularPage.clickPopularPageMovieImgEl();
    }
    @And("I check to the Title details")
    public void iCheckToTheTitlesDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='movie-title']")));
        Assert.assertTrue(homePage.checkMovieTitle().isDisplayed(),"Movie title is not displayed");
        Assert.assertTrue(homePage.checkMovieWatchTime().isDisplayed(),"Watch Time element is not displayed");
        Assert.assertTrue(homePage.checkSensorRating().isDisplayed(),"Sensor Rating element is not displayed");
        Assert.assertTrue(homePage.checkReleaseYear().isDisplayed(),"Release Year element is not displayed");
        Assert.assertTrue(homePage.checkMovieOverview().isDisplayed(),"Movie Overview element is not displayed");
        Assert.assertTrue(homePage.checkMoviePlayBtn().isDisplayed(),"Play button element is not displayed");
    }

    @And("I check to the Genres category details")
    public void iCheckToTheGenresCategoryDetails(){
        Assert.assertTrue(homePage.checkGenresHeading().isDisplayed(),"Genres Heading element is not displayed");
        Assert.assertTrue(homePage.checkFirstGenre().isDisplayed(),"First Genre heading element is not displayed");
        Assert.assertTrue(homePage.checkSecondGenre().isDisplayed(),"Second Genre heading element is not displayed");
    }

    @And("I check to the Audio category details")
    public void iCheckToTheAudioCategoryDetails(){
        Assert.assertTrue(homePage.checkAudioHeading().isDisplayed(),"Audio heading element is not displayed");
        Assert.assertTrue(homePage.checkAudioLanguages(),"Audio languages elements are not displayed");
    }

    @And("I check to the Rating category details")
    public void iCheckToTheRatingCategoryDetails(){
        Assert.assertTrue(homePage.checkRatingHeading().isDisplayed(),"Rating heading element is not displayed");
        Assert.assertTrue(homePage.checkCategoryRating().isDisplayed(),"Category Rating element is not displayed");
        Assert.assertTrue(homePage.checkAvgRatingHeading().isDisplayed(),"Average Rating Heading element is not displayed");
        Assert.assertTrue(homePage.checkAvgRating().isDisplayed(),"Average Rating element is not displayed");
    }

    @And("I check to the Budget category details")
    public void iCheckToTheBudgetCategoryDetails(){
        Assert.assertTrue(homePage.checkBudgetHeading().isDisplayed(),"Budget Heading element is not displayed");
        Assert.assertTrue(homePage.checkBudgetAmount().isDisplayed(),"Budget amount element is not displayed");
        Assert.assertTrue(homePage.checkReleaseDateHeading().isDisplayed(),"Release Date heading element is not displayed");
        Assert.assertTrue(homePage.checkReleaseDate().isDisplayed(),"Release Date element is not displayed");
    }

    @And("I check to the Similar Movies heading")
    public void iCheckToTheSimilarMovieHeading(){
        Assert.assertTrue(homePage.checkSimilarMoviesHeading().isDisplayed(),"Similar Movie heading element is not displayed");
    }

    @And("I check to the Similar Movies list")
    public void iCheckToTheSimilarMoviesList(){
        Assert.assertTrue(homePage.checkSimilarMoviesList(),"List of Movie elements are not displayed");
    }

}
