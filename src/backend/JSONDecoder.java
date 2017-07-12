package backend;

import java.util.Calendar;

/**
 * Serves as a supertype for the decoders used for
 * different service providers, ie. Amica and Sodexo.
 *
 * @author evnurm
 */
public interface JSONDecoder{
    Calendar cal = Calendar.getInstance();

}
