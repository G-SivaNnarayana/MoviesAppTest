package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.time.Duration;


public class HeaderSectionTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    HomePage homePage = new HomePage(driver);

    @When("I check to the Website logo is displayed or not")
    public void iCheckToTheWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.website-logo")));
        Assert.assertTrue(homePage.checkWebsiteLogo().isDisplayed(),"Website logo is not displayed");
    }

    @And("I check to the Navbar Home element")
    public void iCheckToTheNavbarHomeEl(){
        Assert.assertTrue(homePage.checkNavbarHomeEl().isDisplayed(),"Navbar Home element is not displayed");
    }

    @And("I check to the Navbar Popular element")
    public void iCheckToTheNavbarPopularEl(){
        Assert.assertTrue(homePage.checkNavbarPopularEl().isDisplayed(),"Navbar Popular element is not displayed");
    }

    @And("I check to the Navbar Search button element")
    public void iCheckToTheNavbarSearchBtnEl(){
        Assert.assertTrue(homePage.checkNavbarSearchBtnEl().isDisplayed(),"Navbar Search btn element is not displayed");
    }

    @And("I check to the Navbar Account element")
    public void iCheckToTheNavbarAccountEl(){
        Assert.assertTrue(homePage.checkNavbarAccountEl().isDisplayed(),"Navbar Account element is not displayed");
    }

    @When("I navigate to the Popular page")
    public void iNavigateToPopularPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.website-logo")));
        homePage.navigateToPopularPage();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://qamoviesapp.ccbp.tech/popular","Urls does not match");
    }

    @And("I navigate to the Home Page")
    public void iNavigateToTheHomePage(){
        homePage.navigateToHomePage();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://qamoviesapp.ccbp.tech/","Urls does not match");
    }

    @And("I navigate to the Account Page")
    public void iNavigateToTheAccountPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.website-logo")));
        homePage.navigateToAccountPage();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/account"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://qamoviesapp.ccbp.tech/account","Urls does not match");
    }
}
