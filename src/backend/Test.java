package backend;


import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *  A test class for connection to Amica Alvari's JSON-resource.
 */
public class Test {

    public Test(){
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.roll(Calendar.DAY_OF_WEEK, -3);

        String date = new SimpleDateFormat("YYYY-MM-dd").format(cal.getTime());
        System.out.println(date);


        }

}