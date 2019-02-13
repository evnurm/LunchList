package backend;

public class Restaurants {


    public static Restaurant[] getRestaurants(){
        Restaurant[] restaurants = {};
        try {
            restaurants =  DataFetcher.parseJSON();
        } catch(Exception ex) {
            System.out.println("Fetching restaurant info failed!");
            ex.printStackTrace();
        }
        return restaurants;
    }

}
