import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class WaterOverride 
{
    // Change how long the motor runs
    public final int timeout = 5000;

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
            socketBind = new ServerSocket(9595);
            s = socketBind.accept();
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
            }
            catch (PhidgetException | InterruptedException e)
            {
                //TODO: Does it Work? 
                System.out.printf("\nError, Quitting!\n%s", e);
            }
        }).start();
    }
        
}
