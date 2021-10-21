package RahulShettyAcadamy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    

    public WebDriver initializeDriver()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SS\\Desktop\\InteliJ\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
        return driver;
    }


    public List getJsonData(String JsonFilePath) throws IOException {
        String jsoncontent= FileUtils.readFileToString(new File(JsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data=  mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;
    }
}
