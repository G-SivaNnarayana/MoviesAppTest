//Error communicating with the remote browser. It may have died.
package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.time.Duration;


public class LoginPageTest {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String actualErrorMsg;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){

        loginPage = new LoginPage(driver);
    }

    @When("I checked the Website logo image is displayed or not")
    public void iCheckedWebsiteLogo(){
         Assert.assertTrue(loginPage.logoImageEl().isDisplayed(),"Logo image is not displayed");
    }

    @And("Test the Heading text is 'Login' or not")
    public void testHeadingText(){
        String actualheading = loginPage.loginHeadingEl();
        Assert.assertEquals(actualheading,"Login","Heading text is not expected");
    }

    @And("Test the Username label text is 'USERNAME' or not")
    public void testUserNameLabelText(){
        String actualUsernameLabel = loginPage.userNameLabelEl();
        Assert.assertEquals(actualUsernameLabel,"USERNAME","Username label text is not expected");
    }

    @And("Test the Password label text is 'PASSWORD' or not")
    public void testPasswordLabelText(){
        String actualPasswordLabel = loginPage.passwordLabelEl();
        Assert.assertEquals(actualPasswordLabel,"PASSWORD","Password label text is not expected");
    }

    @And("Test the Login button is selected or not")
    public void testLoginBtn(){
        Assert.assertTrue(loginPage.loginBtnEl().isDisplayed(),"Login button is not displayed");
    }

    @When("I click on the login button")
    public void iClickOnLoginButton(){
        loginPage.clickLoginBtn();
    }

    @When("I enter a valid Password")
    public void iEnterValidPassword(){
        loginPage.enterPasswordEl("rahul@2021");
    }

    @When("I enter a valid Username")
    public void iEnterValidUsername(){
        loginPage.enterUserNameEl("rahul");
    }

    @And("I enter Invalid Password")
    public void iEnterInvalidPassword(){
        loginPage.enterPasswordEl("rahul@2022");
    }

    @Then("an error message '*Username or password is invalid' should be visible")
    public void verifyInvalidUsernameAndPassword(){
        actualErrorMsg = loginPage.getErrorMsgEl();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error message is not expected");
    }

    @Then("an error message '*username and password didn't match' should be visible")
    public void verifyErrorMsgPasswordDidNotMatch(){
        actualErrorMsg = loginPage.getErrorMsgEl();
        Assert.assertEquals(actualErrorMsg,"*username and password didn't match","Error message is not expected");
    }

    @Then("I should be redirected to the homepage")
    public void iShouldRedirectedToHomePage(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"");
    }
}
