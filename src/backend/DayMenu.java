package backend;

import java.util.ArrayList;

/**
 * Created by Valtteri on 16.7.2017.
 */
public class DayMenu {

    private ArrayList<LunchOption> lunchOptions = new ArrayList<>();

    public void addLunchOption(LunchOption lo){
        lunchOptions.add(lo);
    }

    public LunchOption[] getLunchOptions(){
        return lunchOptions.toArray(new LunchOption[0]);
    }

}
