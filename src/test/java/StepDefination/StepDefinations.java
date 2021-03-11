package StepDefination;

import PageObjects.HomePage;
import PageObjects.SecondPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Resources.BaseClass;
import Resources.dataDriven;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StepDefinations extends BaseClass {
    WebDriver driver;
    @Given("^Navigate to (.+)$")
    public void navigate_to(String url) throws Throwable {
        driver = initializerDriver();
        driver.get(url);
    }
    HomePage hp;
    SecondPage sp;
    dataDriven dd;
    ArrayList data;
    int strlen;
    String city;
    @When("^Select DepatureCity$")
    public void select_depaturecity() throws Throwable {
        hp = new HomePage(driver);
        if (hp.getLoginSize() > 0) {
            hp.getLandingContainer().click();
        }
        hp.getFrom().click();
        dd = new dataDriven();
        data = dd.getData("Depature City");
        hp.GetDepatureCity().sendKeys((CharSequence) data.get(1));
        int depatureCityCount = hp.GetDCity().size();
        for (int i = 0; i <= depatureCityCount; i++) {
            strlen = String.valueOf(data.get(1)).length();
            city = hp.GetDCity().get(i).getText().substring(0, strlen);
            if (city.equals(String.valueOf(data.get(1)))) {
                hp.GetDCity().get(i).click();
                break;
            }
        }
    }

    @And("^Select ArrivalCity$")
    public void select_arrivalcity() throws Throwable {
        data = dd.getData("Arrival City");
        hp.getArrivaicity().sendKeys(String.valueOf(data.get(1)));
        int ArrialCityCount = hp.getACity().size();
        for (int i = 0; i < ArrialCityCount; i++) {
            strlen = String.valueOf(data.get(1)).length();
            city = hp.getACity().get(i).getText().substring(0, strlen);
            if (city.equals(String.valueOf(data.get(1)))) {
                hp.getACity().get(i).click();
                break;
            }
        }
    }
    LocalDate givenDate;
    int reqDate;
    String reqMonthYear;
    @And("^Select Depature Date And return Date$")
    public void select_depature_date_and_return_date() throws Throwable {
        data = dd.getData("Depature Date");
        //System.out.println(data.get(1));
        String rDate=String.valueOf(data.get(1));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        givenDate= LocalDate.parse(rDate);
        boolean tday=LocalDate.parse(rDate).isBefore(LocalDate.now());
        Assert.assertFalse(tday);
        reqDate = givenDate.getDayOfMonth();
        String reqMonth=String.valueOf(givenDate.getMonth());
        String reqYear=String.valueOf(givenDate.getYear());
        reqMonthYear=reqMonth.substring(0,1).concat(reqMonth.substring(1,reqMonth.length()).toLowerCase()).concat(" ").concat(reqYear);
        while(true) {
            if (hp.GetMonthYear().getText().equalsIgnoreCase(reqMonthYear)) {
                int count = hp.GetDates().size();
                for (int i = 0; i < count; i++) {
                    if (hp.GetDates().get(i).getText().equalsIgnoreCase(String.valueOf(reqDate))) {
                        hp.GetDates().get(i).click();
                        break;
                    }
                }
                break;
            } else
                hp.GetNavigation().click();
        }

    }

    @And("^Select Traveller and Class$")
    public void select_traveller_and_class() throws Throwable {

        data = dd.getData("Adults");
        hp.openTraveller().click();
        int AdultsCount = hp.GetAdults().size();

        if (Integer.parseInt(String.valueOf(data.get(1))) <= 9) {
            for (int i = 0; i < AdultsCount - 1; i++)
            {
                if (hp.GetAdults().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1))))
                {
                    hp.GetAdults().get(i).click();
                    break;
                }

            }
        }

        else { hp.GetAdults().get(AdultsCount-1).click(); }

        data=dd.getData("Children");
        int ChildernCount= hp.GetChild().size();

        if(Integer.parseInt(String.valueOf(data.get(1)))<=6)
        {
            for(int i=0;i<ChildernCount-1;i++)
            {
                if(hp.GetChild().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1))))
                {
                    hp.GetChild().get(i).click();
                    break;
                }
            }
        }

        else { hp.GetChild().get(ChildernCount-1).click(); }

        data=dd.getData("InFants");
        int infants=hp.GetInfants().size();
        Assert.assertTrue(Integer.parseInt(String.valueOf(dd.getData("Adults").get(1)))>Integer.parseInt(String.valueOf(dd.getData("InFants").get(1))));

        if(Integer.parseInt(String.valueOf(data.get(1)))<=6)
        {
            for(int i=0;i<infants-1;i++)
            {
                if(hp.GetInfants().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1))))
                {
                    hp.GetInfants().get(i).click();
                }
            }
        }

        else { hp.GetInfants().get(infants-1).click(); }

        data= dd.getData("TravelClass");
        int Tc= hp.GetClass().size();
        for (int i =0;i<Tc-1;i++)
        {
            if(hp.GetClass().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1))))
            {
                hp.GetClass().get(i).click();
            }
        }
        hp.Apply().click();

    }

    @And("^Select Type of Fare$")
    public void select_type_of_fare() throws Throwable {
        data=dd.getData("Type of Fare");
        int fc=hp.GetFare().size();
        for (int i=0;i<fc-1;i++)
        {
            if (hp.GetFare().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1))))
            {
                hp.GetFare().get(i).click();
            }
        }

    }



    @Then("^Search for the flight$")
    public void search_for_the_flight() throws Throwable {
        System.out.println(driver.getTitle());
        hp.Submit().click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

    }

    @And("^book the cheapest flight$")
    public void book_the_cheapest_flight() throws Throwable {
        sp=new SecondPage(driver);
        sp.SelectFlight().click();
        sp.SelectTicket().click();

    }



}
