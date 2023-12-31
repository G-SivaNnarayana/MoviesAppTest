package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver driver;
    @FindBy(xpath = "//button[@class = 'search-empty-button']") WebElement emptySearchLocator;
    @FindBy(xpath = "//input[@id='search']") WebElement searchLocator;
    @FindBy(xpath = "//ul[starts-with(@class,'search-movies')]/li") List<WebElement> moviesLocator;
    @FindBy(xpath = "//button[@class='search-button']") WebElement searchBtnLocator;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void emptySearchBtn(){
        emptySearchLocator.click();
    }

    public void clickSearchBox(){
        searchLocator.click();
    }

    public void enterMovieName(String name){
        searchLocator.sendKeys(name);
    }

    public void clickSearchBtn(){
        searchBtnLocator.click();
    }

    public int getMoviesCount(){
        return moviesLocator.size();
    }
}
