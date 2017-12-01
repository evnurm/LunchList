package backend;

import java.util.ArrayList;

public class Restaurants {


    public static Restaurant[] getRestaurants(){

        ArrayList<Restaurant> res = new ArrayList<>();

        String[] amica = {"0190","0199", /*"3579"*/ }; // last one commented out because the data could not be fetched.
        String[] fazer = {"3101"};
        String[] sodexo = {"142", "26521", "13918"};

        FazerDecoder ad = new FazerDecoder("amica");
        FazerDecoder fd = new FazerDecoder("fazerfoodco");
        SodexoDecoder sd = new SodexoDecoder();

        try {
            for (String resCode : amica) {
                Restaurant restaurant = ad.parseJSON("fi", resCode);

                res.add(restaurant);
            }

            for (String resCode : fazer) {
                Restaurant restaurant = fd.parseJSON("fi", resCode);
                res.add(restaurant);
            }

            for (String resCode : sodexo) {
                Restaurant restaurant = sd.parseJSON("fi", resCode);
                res.add(restaurant);
            }
        } catch(Exception ex){
            System.out.println("Something went wrong.");
            ex.printStackTrace();
        }


        return res.toArray(new Restaurant[0]);
    }

}
