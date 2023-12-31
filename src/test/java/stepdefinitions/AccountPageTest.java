package stepdefinitions;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;

public class AccountPageTest {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    AccountsPage accountsPage = new AccountsPage(driver);

    @And("I check to the Account heading")
    public void iCheckToTheAccountHeding(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.account-heading")));
        Assert.assertTrue(accountsPage.checkAccountHeading().isDisplayed(),"Account Heading is not displayed");
    }

    @And("I check to the Membership Details")
    public void iCheckTheMembershipDetails(){
        Assert.assertTrue(accountsPage.checkMembershipHeading().isDisplayed(),"Membership Heading is not displayed");
        Assert.assertTrue(accountsPage.checkMembershipUserName().isDisplayed(),"Membership Username is not displayed");
        Assert.assertTrue(accountsPage.checkMembershipPassword().isDisplayed(),"Membership Password is not displayed");
    }

    @And("I check to the Plan Details")
    public void iCheckThePlanDetails(){
        Assert.assertTrue(accountsPage.checkPlanHeading().isDisplayed(),"Plan Heading is not displayed");
        Assert.assertTrue(accountsPage.checkPlanType().isDisplayed(),"Plan Type is not displayed");
        Assert.assertTrue(accountsPage.checkPlanQuality().isDisplayed(),"Plan Quality is not displayed");
        Assert.assertEquals(accountsPage.checkLineEl(),true,"Line Elements are not displayed");
    }

    @And("I check to the Logout Button element")
    public void iCheckTheLogoutBtn(){
        Assert.assertTrue(accountsPage.checkLogOutBtn().isDisplayed(),"Logout Btn is not displayed");
    }

    @And("I click to the Logout Button element")
    public void iClickToLogoutBtn(){
        accountsPage.clickLogoOutBtn();
    }

    @Then("I should redirect to the Login page")
    public void RedirectToTheLoginPage(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(actualUrl,expectedUrl,"Urls does not match");
    }
}
