//package PlantWateringProject.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Harper Kelly USERID # 803225004
 */

public class CurrentTime 
{
    public CurrentTime()
    {
        // Nothing to do here
    }

    /**
     * 
     * @return Date and Time In String Format 
     */
    public String returnTime()
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        
        return ("\033[1;35m[" + df.format(dateobj) + "]\033[0m");
    }


    /**
     * @return Date and Time in String Format without color
     */
    public final String returnSimpleTime()
    {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date dateobj = new Date();

        return (df.format(dateobj));
    }
}

/*  Screen Dump
*/
