package RahulShettyAcadamy.PageObjects;

import RahulShettyAcadamy.AbstractComponents.SearchFlightAvail;
import RahulShettyAcadamy.AbstractComponents.StrategyFactor;
import RahulShettyAcadamy.PageComponents.FooterNav;
import RahulShettyAcadamy.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    By SectionElement=By.xpath("//div[@id='traveller-home']");
    By HeaderNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo()
    {
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise");
    }

    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver,HeaderNavSectionElement);
    }
    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,SectionElement);

    }

    public void setBokingStrategy(String StrategyType)
    {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail=strategyFactor.createStrategy(StrategyType);
        this.searchFlightAvail = searchFlightAvail;

    }
    public void checkAvail(HashMap<String,String> reservationDetails)
    {

        searchFlightAvail.checkAvail(reservationDetails);
    }
    public void getTitle()
    {
        String title = driver.getTitle();
        System.out.println("this is title of the page " +title);
        System.out.println("this is title of the page again please print " +title);
        System.out.println("no no no this is title of the page again please print " +title);
    }
}
