import java.io.*;
import java.net.*;
import com.phidget22.*;


/**
 *  @author CanadianBacon
 */
public class WaterOverride 
{
    // Change how long the motor runs
    public final int timeout = 5000;

    // Port for socket to bind on
    private final int port = 9595;

    // init objects
    private CurrentTime time = null;
    
    // Objects for listening for request from frontend
    private ServerSocket socketBind = null;
    private Socket s = null;
    private InputStream in = null;
    private BufferedReader inr = null;


    /**
     *  Constructor
     */
    public WaterOverride()
    {
        time = new CurrentTime();
        try 
        {
            socketBind = new ServerSocket(port);
            System.out.printf("\n%s--- Socket Bound on %s\n", time.returnTime(), port);
        }
        catch (Exception e) { System.out.printf("\nError in creating socket \n%s", e); System.exit(-9595); }
    }

    /**
     * 
     * @param enable Enable the listener for frontend 
     */
    public boolean listen(boolean enable)
    {
        try
        {
            System.out.printf("\n%s--- Trying to listen for override code\n", time.returnTime());
            
            // Try and recieve response
            s = socketBind.accept();
            in = s.getInputStream();
            inr = new BufferedReader(new InputStreamReader(in));
            String response = inr.readLine();
            /// See if response requires the plant to be watered
            if (response != null && response.compareTo("W") == 0)
            {
                // Close objects before returning true to avoid leaving them open
                in.close();
                inr.close();

                return true;
            }
            
            in.close();
            inr.close();
            Thread.sleep(500);
            // Close objects
        }
        catch (Exception e)
        {
            //TODO: Does it Work? 
            try { s.close(); } catch (Exception ree) { System.out.printf("\n%s\n", ree); }
            System.out.printf("\nError, Quitting!\n%s\n", e);
            System.exit(-9595);
        }
        
        return false;
    }
        
}
