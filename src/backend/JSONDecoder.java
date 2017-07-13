package backend;

import java.util.Calendar;
import java.util.Date;

/**
 * Serves as a supertype for the decoders used for
 * different service providers, ie. Amica and Sodexo.
 *
 * @author evnurm
 */
abstract class JSONDecoder{
    Calendar cal = Calendar.getInstance();

    /** Returns the date object that represents Monday of the current week. */
    Date getMonday(){
       int today = cal.get(Calendar.DAY_OF_WEEK);
       cal.roll(Calendar.DAY_OF_WEEK,today - 2);
       return cal.getTime();

    }

}
