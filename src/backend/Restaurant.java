package backend;

import java.util.ArrayList;



public class Restaurant {

    private String name;

    private ArrayList<LunchOption> lunchOptions = new ArrayList<>();
    public Restaurant(String name){
        this.name = name;
    }


    private ArrayList<Day> days  = new ArrayList<>(); // contains the Day-instances.

    public void addDay(Day day){
        days.add(day);
    }

    public String getName(){
        return name;
    }

}

class Day{

    private String date;

    public Day(String date){
        this.date = date;
    }

    private ArrayList<LunchOption> lunchOptions = new ArrayList<>();

    public void addLunchOption(LunchOption lo){
        lunchOptions.add(lo);
    }

    public LunchOption[] getLunchOptions(){
        return lunchOptions.toArray(new LunchOption[0]);
    }

}
