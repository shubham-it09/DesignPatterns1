package RahulShettyAcadamy;

import RahulShettyAcadamy.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.lifecycle.LifecycleState;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{
    WebDriver driver;
    TravelHomePage travelHomePage;
    @BeforeTest
    public void setup()
    {
        driver = initializeDriver();
         travelHomePage = new TravelHomePage(driver);
    }

    //@Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails)
    {
        travelHomePage.goTo();
        travelHomePage.getFooterNav().selectFlight();
        travelHomePage.getNavigationBar().selectFlight();
        travelHomePage.getFooterNav().getLinkCount();

        travelHomePage.getNavigationBar().getLinkCount();



        travelHomePage.setBokingStrategy("multitrip");
        travelHomePage.checkAvail(reservationDetails);

//        travelHomePage.setBokingStrategy("roundtrip");
//
//        travelHomePage.checkAvail(reservationDetails);

    }
    @DataProvider
    public Object[][] getData() throws IOException {

//        HashMap<String,String> reservationDetails = new HashMap<String,String>();
//        reservationDetails.put("origin","MAA");
//        reservationDetails.put("destination","GOI");
//
//        HashMap<String,String> reservationDetails1 = new HashMap<String,String>();
//        reservationDetails.put("origin","DEL");
//        reservationDetails.put("destination","HYD");
//        List<HashMap<String, String>> l = new ArrayList<>();
//
//        l.add(reservationDetails);

       // l.add(reservationDetails1);
        List<HashMap<String, String>>  l=   getJsonData(System.getProperty("user.dir")+"//src//test//java//RahulShettyAcadamy//DataLoads//reservation.json"); ;
        return new Object[][]
                {

                        {l.get(0)},{l.get(1)}
                };

    }

    @AfterTest
    public void tearDown()
    {
      driver.quit();
    }
}
