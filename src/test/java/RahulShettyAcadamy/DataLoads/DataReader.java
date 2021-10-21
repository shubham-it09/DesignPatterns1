package RahulShettyAcadamy.DataLoads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List getJsonData(String JsonFilePath) throws IOException {
        String jsoncontent=FileUtils.readFileToString(new File("reservation.json"), StandardCharsets.UTF_8);
        
        ObjectMapper mapper = new ObjectMapper();
      List<HashMap<String,String>> data=  mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
        });
      return data;
    }
}
