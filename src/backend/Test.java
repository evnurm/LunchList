package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *  A test class for connection to Amica Alvari's JSON-resource.
 */
public class Test {

    URL url;


    public Test(){
      try {
          url = new URL("http://www.amica.fi/modules/json/json/Index?costNumber=0190&language=fi&firstDay=2017-7-10");
          BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

          String inputLine = in.readLine();

          String json = "";

          while(inputLine != null){
            json += inputLine + "\n";
            inputLine = in.readLine();
          }

          JSONObject testJSON = new JSONObject(json);
          JSONArray array = testJSON.getJSONArray("MenusForDays");
          System.out.println(new JSONObject(array.get(0).toString()).get("SetMenus"));


      } catch(Exception ex) {
          ex.printStackTrace();
      }
    }
}
