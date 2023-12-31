package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage {
    WebDriver driver;

    @FindBy(css = "h1.account-heading") WebElement accountHeadingEl;
    @FindBy(xpath = "//div[@class='membership-container']/p") WebElement membershipHeadingEl;
    @FindBy(css = "p.membership-username") WebElement membershipUserNameEl;
    @FindBy(css = "p.membership-password") WebElement membershipPasswordEl;
    @FindBy(xpath = "//div[@class='plan-container']/p") WebElement planHeadingEl;
    @FindBy(css = "p.plan-paragraph") WebElement planTypeEl;
    @FindBy(css = "p.plan-details") WebElement planQualityEl;
    @FindBy(css = "hr.line-element") List<WebElement> lineElements;
    @FindBy(css = "button.logout-button") WebElement logotBtnEl;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement checkAccountHeading(){
        return accountHeadingEl;
    }

    public WebElement checkMembershipHeading(){
        return membershipHeadingEl;
    }

    public WebElement checkMembershipUserName(){
        return membershipUserNameEl;
    }

    public WebElement checkMembershipPassword (){
        return membershipPasswordEl;
    }

    public WebElement checkPlanHeading(){
        return planHeadingEl;
    }

    public WebElement checkPlanType(){
        return planTypeEl;
    }

    public WebElement checkPlanQuality(){
        return planQualityEl;
    }

    public Boolean checkLineEl(){
        int n = lineElements.size();
        Boolean result = false;
        for(int i=0;i<n;i++){
            boolean res = lineElements.get(i).isDisplayed();
            if(res==true)
                result = true;
        }
        return result;
    }

    public WebElement checkLogOutBtn(){
        return logotBtnEl;
    }

    public void clickLogoOutBtn(){
        logotBtnEl.click();
    }
}
