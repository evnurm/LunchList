package backend;

import java.util.ArrayList;
import java.util.Set;

/** Models the the */
public class Restaurant {

    private String name;

    private ArrayList<LunchOption> lunchOptions = new ArrayList<>();
    public Restaurant(String name){
        this.name = name;
    }

    public void addLunchOption(LunchOption lo){
        lunchOptions.add(lo);
    }

    public LunchOption[] getLunchOptions(){
        return lunchOptions.toArray(new LunchOption[0]);
    }

    public String getName(){
        return name;
    }
}
