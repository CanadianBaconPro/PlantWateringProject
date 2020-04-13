//package CompSci.Phidgets.PlantWateringProject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Harper Kelly USERID # 803225004
 */

// TODO(CB): I need to figure out how to call this every time a log is made, but without re creating the object
// so that it doesnt slow down the process, even using multi threading is just adding extra load
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
}

/*  Screen Dump
*/
