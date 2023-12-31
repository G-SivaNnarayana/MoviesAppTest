package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait ;

    @FindBy(xpath = "//img[contains(@class,'website-logo')]") WebElement logoImageLocator;
    @FindBy(xpath = "//h1[contains(@class,'heading')]") WebElement loginHeadingLocator;
    @FindBy(xpath = "//div/label[contains(@for,'username')]") WebElement userNameLabelLocator;
    @FindBy(xpath = "//div/label[contains(@for,'password')]") WebElement passwordLabelLocator;
    @FindBy(xpath = "//button[@class = 'login-button']") WebElement loginBtnLocator;
    @FindBy(id = "usernameInput") WebElement usernameLocator;
    @FindBy(id = "passwordInput") WebElement passwordLocator;
    @FindBy(className = "error-message") WebElement errorMsgLocator;

    //Define methods
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement logoImageEl(){
        return logoImageLocator;
    }

    public String loginHeadingEl(){
        return loginHeadingLocator.getText();
    }

    public String userNameLabelEl(){
        return userNameLabelLocator.getText();
    }

    public String passwordLabelEl(){
        return passwordLabelLocator.getText();
    }

    public WebElement loginBtnEl(){
        return loginBtnLocator;
    }

    public void enterUserNameEl(String username){
        usernameLocator.sendKeys(username);
    }

    public void enterPasswordEl(String password){
        passwordLocator.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtnLocator.click();
    }

    public void loginToMoviesApp(String username,String password){
        enterUserNameEl(username);
        enterPasswordEl(password);
        clickLoginBtn();
    }

    public String getErrorMsgEl(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMsgLocator.getText();
    }
}
