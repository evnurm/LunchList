package backend;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Decodes the JSON data received from Amica.
 */
public class AmicaDecoder implements JSONDecoder {

    private String fetchData(String lang, String restaurantCode) throws Exception{
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String date = sdf.format(today);

        String address = "http://www.amica.fi/modules/json/json/Index?" +
                "costNumber="+restaurantCode +
                "&language="+lang+"&firstDay=" + date;

        return DataFormatter.getJSONData(address);
    }

    /** Parses the json from the given source. */
    public void parseJSON(String lang, String restaurantCode) throws Exception {
        String json = fetchData(lang, restaurantCode);
        JSONObject fullJSON = new JSONObject(json);

        JSONArray menus = fullJSON.getJSONArray("MenusForDays");
        //System.out.println(menus.toString(2));

        JSONArray[] setMenus = new JSONArray[7];

        for(int i = 0; i < menus.length();i++){
            JSONArray test = new JSONObject(menus.get(i).toString()).getJSONArray("SetMenus");
            setMenus[i] = test;
            //System.out.println(test.toString(2) + "\n-----\n");
        }

        JSONArray[] components = new JSONArray[7];

        for(Object x: setMenus){
            JSONArray intermediate = new JSONArray(x.toString());
            for(Object y: intermediate){
                System.out.println(new JSONObject(y.toString()).getJSONArray("Components"));
            }
        }



    }
}
