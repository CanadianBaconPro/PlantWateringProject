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
            System.out.printf("\n%s---\n Socket Bound on %s\n", time.returnTime(), port);
        }
        catch (Exception e) { System.out.printf("\nError in creating socket \n%s", e); }
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
                System.out.printf("%s---\nTrying to listen for override code\n", time.returnTime());
                s = socketBind.accept();
                while (enable)
                {
                    // Try and recieve response
                    in = s.getInputStream();
                    inr = new BufferedReader( new InputStreamReader(in));
                    String response = inr.readLine();

                    /// See if response requires the plant to be watered
                    if (response.compareTo("W") == 0)
                    {
                        System.out.printf("Pump Run Request From Website at %s", time.returnTime());
                        p.runPump(timeout);
                    }
                    Thread.sleep(100);
                }
                // Close objects
                socketBind.close();
                s.close();
                in.close();
                inr.close();
            }
            catch (Exception e)
            {
                //TODO: Does it Work? 
                System.out.printf("\nError, Quitting!\n%s", e);
            }
        }).start();
    }
        
}
