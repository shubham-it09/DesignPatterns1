package RahulShettyAcadamy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponents {

WebElement sectionElement;
    public AbstractComponents(WebDriver driver, By sectionElement) {
        this.sectionElement =driver.findElement(sectionElement);
    }
    public WebElement findELement(By findElementBy)
    {
       return sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findELements(By findElementBy)
    {
        return sectionElement.findElements(findElementBy);
    }
}
