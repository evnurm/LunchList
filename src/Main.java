import backend.AmicaDecoder;
import backend.LunchOption;
import backend.Restaurant;

/**
 * Created by Valtteri on 7.7.2017.
 */
public class Main {
    public static void main(String[] args){
        AmicaDecoder test = new AmicaDecoder();
        try {
            Restaurant alvari = test.parseJSON("fi", "0190");


        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
