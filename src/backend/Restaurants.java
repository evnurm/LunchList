package backend;

import java.util.ArrayList;

public class Restaurants {

    private static ArrayList<Restaurant> res = new ArrayList<>();

    public Restaurants() throws Exception{
        String[] amica = {"0190","0199","3579"};
        String[] sodexo = {"142"};

        AmicaDecoder ad = new AmicaDecoder();
        SodexoDecoder sd = new SodexoDecoder();

        for(String resCode: amica){
            Restaurant restaurant = ad.parseJSON("fi",resCode);
            res.add(restaurant);
        }

        for(String resCode: sodexo){
            Restaurant restaurant = sd.parseJSON("fi", resCode);
            res.add(restaurant);
        }
    }

    public static Restaurant[] getRestaurants(){
        return res.toArray(new Restaurant[0]);
    }

}
