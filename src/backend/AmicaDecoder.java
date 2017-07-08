package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 * Decodes the JSON data received from Amica.
 */
public class AmicaDecoder implements JSONDecoder {

    private Date today = new Date();

    private SimpleDateFormat format = new SimpleDateFormat("YYYY-DD-MM");

    private String date = format.format(today);
    private String restaurantCode;  // Alvari 0190, TUAS 0199

    private String language;

    private String address = "http://www.amica.fi/modules/json/json/Index?costNumber="+restaurantCode
            +"&language="+language+"&firstDay=" + date;

   // private URL url = new URL(address);

    //private BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));




    // constructor
    public AmicaDecoder(String restaurantCode, String language){
        this.restaurantCode = restaurantCode;
        this.language = language;
    }

}
