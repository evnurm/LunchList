package backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Decodes the JSON data received from Sodexo.
 */
public class SodexoDecoder extends JSONDecoder {

    // Fetches the JSON data to parse.
    private String fetchData(String lang, String restaurantCode) throws Exception {

        String date = new SimpleDateFormat("YYYY/MM/dd").format(new Date());
        return DataFormatter.getJSONData("http://www.sodexo.fi/ruokalistat/" +
                "output/daily_json/"+restaurantCode+"/"+ date +"/"+lang);
    }

    /** Parses the JSON from the given source and returns a corresponding restaurant object.*/
    public Restaurant parseJSON(String lang, String restaurantCode) throws Exception {
        String json = fetchData(lang, restaurantCode);
        JSONObject fullJSON = new JSONObject(json);

        JSONObject meta = fullJSON.getJSONObject("meta");
        String name = (String) meta.get("ref_title");

        Restaurant restaurant = new Restaurant(name);

        JSONArray courses = fullJSON.getJSONArray("courses");

        ArrayList<LunchOption> options = new ArrayList<>();

        for(Object course: courses){
            LunchOption lo = new LunchOption();

            JSONObject option = new JSONObject(course.toString());
            lo.addComponent(option.get("title_fi").toString());
            options.add(lo);
        }

        restaurant.addDay(options.toArray(new LunchOption[0]));

        return restaurant;
    }
}
