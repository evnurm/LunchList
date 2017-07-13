package backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Decodes the JSON data received from Amica.
 */
public class AmicaDecoder extends JSONDecoder {

    private String fetchData(String lang, String restaurantCode) throws Exception{



        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String date = sdf.format(getMonday());
        System.out.println(date);

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
               // array whose elements are the menus for one day.
              JSONArray intermediate = new JSONArray(x.toString());
              ArrayList<LunchOption> options = new ArrayList<>();
              for(Object y: intermediate){

                LunchOption lo = new LunchOption();
                JSONArray components = new JSONObject(y.toString()).getJSONArray("Components");


                for(Object component: components){
                    lo.addComponent(component.toString());
                }
                options.add(lo);


              }
              restaurant.addDay(options.toArray(new LunchOption[0]));
              options.clear();
            }
        }

        return restaurant;


    }
}
