package RahulShettyAcadamy.AbstractComponents;

import RahulShettyAcadamy.PageComponents.MultiTrip;
import RahulShettyAcadamy.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {
    WebDriver driver;
    By sectionElement=By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver=driver;
    }


    public SearchFlightAvail createStrategy(String StrategyType)
    {
        if(StrategyType.equalsIgnoreCase("multitrip"))
        {
            return new MultiTrip(driver,sectionElement);

        }
        if(StrategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver,sectionElement);

        }
        return null;
    }
}

