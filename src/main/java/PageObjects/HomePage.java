package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage{

public WebDriver driver;
private By From=By.cssSelector(".fsw_inputBox.searchCity.inactiveWidget");
private By DepatureCity=By.xpath("//input[@placeholder='From']");
private By login=By.xpath("//input[@id='username']");
private By DCity=By.cssSelector(".font14.appendBottom5.blackText");
private By LandingContainer=By.cssSelector(".landingContainer  ");
private By ArrivalCity=By.xpath("//input[@placeholder='To']");
private By ACity=By.cssSelector(".font14.appendBottom5.blackText");
private By monthYear=By.cssSelector(".DayPicker-Caption");
private By navigation=By.xpath("//span[@aria-label='Next Month']");
private By dates=By.xpath("//div[@class='dateInnerCell']/p[1]");
private By travller=By.xpath("//span[@class='appendRight10']");
private By adults=By.xpath("//div[@class='appendBottom20']/ul[1]/li");
private By child=By.xpath("//div[@class='makeFlex column childCounter']/ul/li");
private By infant=By.xpath("//div[@class='makeFlex column pushRight infantCounter']/ul/li");
private By Class = By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li");
private By apply= By.xpath("//button[@data-cy='travellerApplyBtn']");
private By fare=By.xpath("//ul[@class='specialFare']/li");
private By submit=By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");
private By flight=By.xpath("//button[@id='bookbutton-RKEY:ab829e9e-b8be-4d9e-8b72-56235f764bb5:312_0']");


    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public WebElement getFrom(){
    return driver.findElement(From);
}
    public int getLoginSize(){
        return driver.findElements(login).size();
}
    public WebElement GetDepatureCity(){ return driver.findElement(DepatureCity); }
    public List<WebElement> GetDCity(){
        return driver.findElements(DCity);
}
    public WebElement getLandingContainer(){
        return driver.findElement(LandingContainer);
}
    public WebElement getArrivaicity(){
        return driver.findElement(ArrivalCity);
}
    public List<WebElement> getACity(){
        return driver.findElements(ACity);
}
    public WebElement GetMonthYear(){
        return driver.findElement(monthYear);
    }
    public WebElement GetNavigation(){
        return driver.findElement(navigation);
        }
    public List<WebElement> GetDates(){ return driver.findElements(dates); }
    public WebElement openTraveller() { return driver.findElement(travller); }
    public List<WebElement> GetAdults(){ return driver.findElements(adults); }
    public List<WebElement> GetChild(){ return driver.findElements(child); }
    public List<WebElement> GetInfants(){ return driver.findElements(infant); }
    public List<WebElement> GetClass(){ return driver.findElements(Class); }
    public WebElement Apply(){ return driver.findElement(apply); }
    public List<WebElement> GetFare(){return driver.findElements(fare);}
    public WebElement Submit(){return driver.findElement(submit); }
    public WebElement SelectFlight() { return driver.findElement(flight); }



}
