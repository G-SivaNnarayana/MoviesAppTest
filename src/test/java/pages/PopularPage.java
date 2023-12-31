package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;

    By moviesListLocator = By.xpath("//li[@class='movie-icon-item']");

    @FindBy(xpath = "//a/img[@alt='Jungle Cruise']") WebElement popularPageMovieLocator;
    @FindBy(xpath = "//h1[@class='movie-title']") WebElement movieTitleLocator;
    @FindBy(xpath = "//p[@class='watch-time']") WebElement movieWatchTimeLocator;
    @FindBy(xpath = "//p[@class='sensor-rating']") WebElement movieSensorLocator;
    @FindBy(xpath = "//p[@class='release-year']") WebElement movieReleaseYearLocator;
    @FindBy(xpath = "//p[@class='movie-overview']") WebElement movieOverviewLocator;
    @FindBy(xpath = "//button[@class='play-button']") WebElement moviePlayBtnLocator;
    @FindBy(xpath = "//h1[@class='genres-heading']") WebElement movieGenresHeadingLocator;
    @FindBy(xpath = "//div[@class='genres-container']/p[1]") WebElement movieGenreOneLocator;
    @FindBy(xpath = "//div[@class='genres-container']/p[2]") WebElement movieGenreTwoLocator;
    //@FindBy(xpath = "//div[@class='genres-container']/p[3]") WebElement movieGenreThreeLocator;
    //@FindBy(xpath = "//div[@class='genres-container']/p[4]") WebElement movieGenreFourLocator;
    @FindBy(xpath = "//h1[@class='audio-heading']") WebElement audioHeadingLocator;
    @FindBy(xpath = "//li[@class='audio-list-item']/p") List<WebElement> audioListLocator;
    @FindBy(css = "h1.rating-heading") WebElement ratingHeadingLocator;
    @FindBy(css = "h1.rating-heading+p") WebElement categoryRatingLocator;
    @FindBy(css = "h1[class*='rating-average']") WebElement averageRatingHeadingLocator;
    @FindBy(css = "h1[class*='rating-average']+p") WebElement averageRatingLocator;
    @FindBy(css = "h1.budget-heading") WebElement budgetHeadingLocator;
    @FindBy(css = "h1[class*='budget-heading']+p") WebElement budgetLocator;
    @FindBy(css = "h1[class*='release-date']") WebElement releaseDateHeadingLocator;
    @FindBy(css = "h1[class*='release-date']+p") WebElement releaseDateLocator;
    @FindBy(css = "h1[class*='similar-movies']") WebElement similarMoviesHeadingLocator;
    @FindBy(css = "ul[class*='similar-movies'] li") List<WebElement> similarMoviesListLocator;


    public PopularPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean getPopularMoviesList() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesListLocator));
        List<WebElement> checkMoviesList = driver.findElements(moviesListLocator);
        Boolean result = false;
        for(int i=0;i<checkMoviesList.size();i++) {
            Boolean list = checkMoviesList.get(i).isDisplayed();
            if(list==true){
                result = true;
            }
        }
        return result;
    }

    public void clickPopularPageMovieImgEl(){
        popularPageMovieLocator.click();
    }

    public WebElement checkMovieTitle(){
        return movieTitleLocator;
    }

    public WebElement checkMovieWatchTime(){
        return movieWatchTimeLocator;
    }

    public WebElement checkSensorRating(){
        return movieSensorLocator;
    }

    public WebElement checkReleaseYear(){
        return movieReleaseYearLocator;
    }

    public WebElement checkMovieOverview(){
        return movieOverviewLocator;
    }

    public WebElement checkMoviePlayBtn(){
        return moviePlayBtnLocator;
    }

    public WebElement checkGenresHeading(){
        return movieGenresHeadingLocator;
    }

    public WebElement checkFirstGenre(){
        return movieGenreOneLocator;
    }

    public WebElement checkSecondGenre(){
        return movieGenreTwoLocator;
    }

    //public WebElement checkThirdGenre(){
      //  return movieGenreThreeLocator;
    //}

    //public WebElement checkFourthGenre(){
      //  return movieGenreFourLocator;
    //}

    public WebElement checkAudioHeading(){
        return audioHeadingLocator;
    }

    public Boolean checkAudioLanguages(){
        int n = audioListLocator.size();
        Boolean result = false;
        for(int i=0;i<n;i++){
            Boolean res = audioListLocator.get(i).isDisplayed();
            if(res==true){
                result = true;
            }
        }
        return result;
    }

    public WebElement checkRatingHeading(){
        return ratingHeadingLocator;
    }

    public WebElement checkCategoryRating(){
        return categoryRatingLocator;
    }

    public WebElement checkAvgRatingHeading(){
        return averageRatingHeadingLocator;
    }

    public WebElement checkAvgRating(){
        return averageRatingLocator;
    }

    public WebElement checkBudgetHeading(){
        return budgetHeadingLocator;
    }

    public WebElement checkBudgetAmount(){
        return budgetLocator;
    }

    public WebElement checkReleaseDateHeading(){
        return releaseDateHeadingLocator;
    }

    public WebElement checkReleaseDate(){
        return releaseDateLocator;
    }

    public WebElement checkSimilarMoviesHeading(){
        return similarMoviesHeadingLocator;
    }

    public Boolean checkSimilarMoviesList(){
        Boolean result = false;
        int n = similarMoviesListLocator.size();
        for(int i=0;i<n;i++){
            Boolean res = similarMoviesListLocator.get(i).isDisplayed();
            if(res==true){
                result = true;
            }
        }
        return result;
    }


}
