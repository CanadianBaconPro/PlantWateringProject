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
    private PumpControl p = null;
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
        p = new PumpControl();
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
    public void listen(boolean enable)
    {
        new Thread(() -> // Async expression for logging data to a file
        {
            try
            {
                System.out.printf("\n%s---Trying to listen for override code\n", time.returnTime());
                while (enable)
                {
                    // Try and recieve response
                    s = socketBind.accept();
                    in = s.getInputStream();
                    inr = new BufferedReader(new InputStreamReader(in));
                    String response = inr.readLine();
                    System.out.printf("\n\n\'%s\'\n\ndata\n\n", response);
                    /// See if response requires the plant to be watered
                    if (response != null && response.compareTo("W") == 0)
                    {
                        System.out.printf("\n%sPump Run Request From Website\n", time.returnTime());
                        p.runPumpWithoutWait(timeout);
                    }
                    s.close(); // Maybe move inside loop
                    in.close();
                    inr.close();
                    Thread.sleep(500);
                }
                // Close objects
                socketBind.close();
            }
            catch (Exception e)
            {
                //TODO: Does it Work? 
                System.out.printf("\nError, Quitting!\n%s\n", e);
                System.exit(-9595);
            }
        }).start();
    }
        
}
