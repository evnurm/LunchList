package backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Decodes the JSON data received from Sodexo.
 */
public class SodexoDecoder extends JSONDecoder {

    // Fetches the JSON data to parse.
    private String fetchData(String lang, String restaurantCode, Date day) throws Exception {

        String date = new SimpleDateFormat("YYYY/MM/dd").format(day);
        return DataFormatter.getJSONData("http://www.sodexo.fi/ruokalistat/" +
                "output/daily_json/"+restaurantCode+"/"+ date +"/"+lang);
    }

    private Date[] days = new Date[7];

    // constructor that initializes the array 'days'.
    public SodexoDecoder(){
        days[0] = getMonday();

        for(int i = 1; i < 7; i++){
            cal.roll(Calendar.DAY_OF_WEEK, 1);
            days[i] = cal.getTime();
        }
    }



    /** Parses the JSON from the given source and returns a corresponding restaurant object.*/
    public Restaurant parseJSON(String lang, String restaurantCode) throws Exception {

        String[] jsons = new String[7];

        for(int i = 0; i < 7; i++){
            jsons[i] = fetchData(lang, restaurantCode, days[i]);
        }

        String json = jsons[0];

        JSONObject fullJSON = new JSONObject(json);

        JSONObject meta = fullJSON.getJSONObject("meta");
        String name = (String) meta.get("ref_title");

        Restaurant restaurant = new Restaurant(name);


        JSONArray courses = fullJSON.getJSONArray("courses");
        restaurant.addDay(getDayMenu(courses));

        for(int i = 1; i < 7; i++){
           courses =  new JSONObject(jsons[i]).getJSONArray("courses");
           restaurant.addDay(getDayMenu(courses));
        }

        return restaurant;
    }

    // gets the lunch options for one day.
    private LunchOption[] getDayMenu(JSONArray courses){

        ArrayList<LunchOption> options = new ArrayList<>();

        for(Object course: courses){
            LunchOption lo = new LunchOption();

            JSONObject option = new JSONObject(course.toString());
            lo.addComponent(option.get("title_fi").toString());
            options.add(lo);
        }

        return options.toArray(new LunchOption[0]);
    }
}
