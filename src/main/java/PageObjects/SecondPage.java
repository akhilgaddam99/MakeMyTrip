package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondPage {
    public WebDriver driver;
    private By flight=By.xpath("//span[@class='appendRight8']");
    private By selectTicket=By.xpath("//button[@class='button latoBlack buttonPrimary fontSize13']");
    public SecondPage(WebDriver driver) { this.driver=driver; }

    public WebElement SelectFlight() { return driver.findElement(flight); }
    public WebElement SelectTicket() { return driver.findElement(selectTicket); }
}
