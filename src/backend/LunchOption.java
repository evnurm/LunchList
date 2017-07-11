package backend;

import java.util.ArrayList;

/**
 * Created by Valtteri on 10.7.2017.
 */
public class LunchOption {
    private ArrayList<String> components = new ArrayList();

    public void addComponent(String component){
        components.add(component);
    }
    public String[] getComponents(){return components.toArray(new String[0]);}

}
