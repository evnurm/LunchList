package backend;

import java.util.ArrayList;



public class Restaurant {

    private String name;

    private ArrayList<LunchOption> lunchOptions = new ArrayList<>();
    public Restaurant(String name){
        this.name = name;
    }


    private ArrayList<DayMenu> days  = new ArrayList<>(); // contains the Day-instances.

    /** Adds a day's menu to this restaurant. */
    public void addDay(LunchOption[] los){
        DayMenu day = new DayMenu();

        for(LunchOption lo: los){
            day.addLunchOption(lo);
        }

        days.add(day);
    }

    public DayMenu[] getDayMenus(){
        return days.toArray(new DayMenu[0]);
    }


    public String getName(){
        return name;
    }

}

class DayMenu {


    private ArrayList<LunchOption> lunchOptions = new ArrayList<>();

    public void addLunchOption(LunchOption lo){
        lunchOptions.add(lo);
    }

    public LunchOption[] getLunchOptions(){
        return lunchOptions.toArray(new LunchOption[0]);
    }

}
