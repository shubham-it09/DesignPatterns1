package RahulShettyAcadamy.PageComponents;

import RahulShettyAcadamy.AbstractComponents.AbstractComponents;
import RahulShettyAcadamy.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponents implements SearchFlightAvail {

    private By fromradio = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By fromDrpDwn = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By checkReservation = By.id("ctl00_mainContent_chk_IndArm");
    private By ToDrpDwn = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By Search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> ReservationDetails) {

    makeStateReady(s->SelectCity(ReservationDetails.get("origin")));

        SelectDestCity(ReservationDetails.get("destination"));
        findELement(checkReservation).click();
        findELement(Search).click();

    }
    public void SelectCity(String code)
    {
        findELement(fromDrpDwn).click();
        findELement(By.xpath("//a[@value='"+code+"']")).click();
    }

    public void SelectDestCity(String code)
    {

        findELement(ToDrpDwn).click();
        findELement(By.xpath("//a[@value='"+code+"'][2]")).click();
    }

    public void makeStateReady(Consumer<RoundTrip> consumer)
    {
        System.out.println("I am inside roundtrip");
        findELement(fromradio).click();
        consumer.accept(this);

    }
}
