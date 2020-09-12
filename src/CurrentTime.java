//package PlantWateringProject.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("MST"));
        Date d = new Date();
        
        return ("\033[1;35m[" + sdf.format(d) + "]\033[0m");
    }


    /**
     * @return Date and Time in String Format without color
     */
    public final String returnSimpleTime()
    {   
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("MST"));
        Date d = new Date();

        return (sdf.format(d));
    }
}

/*  Screen Dump
*/
