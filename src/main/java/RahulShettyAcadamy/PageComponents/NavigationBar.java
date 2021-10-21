package RahulShettyAcadamy.PageComponents;

import RahulShettyAcadamy.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponents {

    By flights = By.xpath("//a[@title='Flights']");
    By links = By.tagName("a");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }



    public void selectFlight()
    {
        System.out.println("Classname is "+findELement(flights).getAttribute("class"));
        // findELement(flights).click();
    }

    public void getLinkCount()
    {
        findELements(links).size();
        System.out.println("link count is "+findELements(links).size());
    }

}
