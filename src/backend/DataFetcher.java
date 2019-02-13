package backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 *  Fetches data from the web backend and par
 */
public class DataFetcher extends JSONDecoder {
    private static String fetchData() throws Exception{
        String address = "http://localhost:3000";
        return DataFormatter.getJSONData(address);
    }

    public static Restaurant[] parseJSON() throws Exception {
        String json = fetchData();
        JSONArray arr = new JSONArray(json);

        ArrayList<Restaurant> restaurants = new ArrayList();
        // System.out.println(arr.toString(2));
        for(Object res: arr) {
            JSONObject restaurantJSON = new JSONObject(res.toString());
            Restaurant restaurant = new Restaurant(restaurantJSON.getString("title"));
            String[] weekdays = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

            for(String day: weekdays) {
                JSONArray dayOptions = restaurantJSON.getJSONArray(day);
                ArrayList<LunchOption> los = new ArrayList();

                for(Object course: dayOptions) {
                    LunchOption lo = new LunchOption();
                    String[] components = course.toString().split("\\r?\\n"); // split at \n.
                    for(String component: components) {
                        lo.addComponent(component);
                    }
                    los.add(lo);
                }
                restaurant.addDay(los.toArray(new LunchOption[0]));
            }
            restaurants.add(restaurant);
        }
        return restaurants.toArray(new Restaurant[0]);
    }
}
