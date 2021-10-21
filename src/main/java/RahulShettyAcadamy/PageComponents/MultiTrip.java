package RahulShettyAcadamy.PageComponents;

import RahulShettyAcadamy.AbstractComponents.AbstractComponents;
import RahulShettyAcadamy.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponents implements SearchFlightAvail {



    private By fromradio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By okpopup = By.id("MultiCityModelAlert");


    private By fromDrpDwn = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By checkReservation = By.id("ctl00_mainContent_chk_IndArm");
    private By ToDrpDwn = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By Search = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {

      makeStateReady(s->SelectCity(reservationDetails.get("origin")));

       // SelectCity(Origin);
      //  SelectDestCity(reservationDetails.get("destination"));
      //  findELement(checkReservation).click();
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
        findELement(By.xpath("//a[@value='"+code+"']")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("I am inside multitrip");

        findELement(fromradio).click();
        findELement(okpopup).click();
        consumer.accept(this);

    }

}
