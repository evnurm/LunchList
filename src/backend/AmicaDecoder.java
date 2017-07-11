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
    public Restaurant parseJSON(String lang, String restaurantCode) throws Exception {
        String json = fetchData(lang, restaurantCode);
        JSONObject fullJSON = new JSONObject(json);

        String resName = fullJSON.get("RestaurantName").toString();

        // Create the restaurant object/instance with the fetched name.
        Restaurant restaurant = new Restaurant(resName);


        JSONArray menus = fullJSON.getJSONArray("MenusForDays");


        JSONArray[] setMenus = new JSONArray[7];

        for(int i = 0; i < menus.length();i++){
            JSONArray test = new JSONObject(menus.get(i).toString()).getJSONArray("SetMenus");
            setMenus[i] = test;
        }


        for(Object x: setMenus){
            if(x != null){
              JSONArray intermediate = new JSONArray(x.toString());


              for(Object y: intermediate){
                LunchOption lo = new LunchOption();
                JSONArray components = new JSONObject(y.toString()).getJSONArray("Components");

                for(Object component: components){
                    lo.addComponent(component.toString());
                }
                restaurant.addLunchOption(lo);
              }

            }
        }

        return restaurant;


    }
}
