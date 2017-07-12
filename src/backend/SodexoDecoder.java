package backend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Decodes the JSON data received from Sodexo.
 */
public class SodexoDecoder implements JSONDecoder {

    // Fetches the JSON data to parse.
    private String fetchData(String lang, String restaurantCode) throws Exception{

        String date = new SimpleDateFormat("YYYY/MM/dd").format(new Date());
        return DataFormatter.getJSONData("http://www.sodexo.fi/ruokalistat/output/daily_json/"+restaurantCode+"/"+ date +"/"+lang);
    }

    /** Parses the JSON from the given source and returns a corresponding restaurant object.*/
    public Restaurant parseJSON() throws Exception {
        return new Restaurant("");
    }
}
