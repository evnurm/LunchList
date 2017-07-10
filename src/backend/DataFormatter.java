package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/** Handles the data fetching from the different service providers. */
public class DataFormatter {

    /** Returns the data received from the given resource. */
    public static String getJSONData(String addr) throws Exception {
        URL url = new URL(addr);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine = in.readLine();

        String json = "";

        while(inputLine != null){
            json += inputLine + "\n";
            inputLine = in.readLine();
        }

        return json;


    }

}
