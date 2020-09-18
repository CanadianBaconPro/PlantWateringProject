//package PlantWateringProject.src;

import com.phidget22.*;
/**
 *
 * @author Harper Kelly, Comp Sci. ID# 803225004 
 */
public class PumpControl 
{
    private DigitalOutput motorRelay = null;
             
    /**
     * 
     * @param port Set Hub Port for Motor Relay
     */
    public PumpControl(int port)
    {
        try
        {   
            motorRelay = new DigitalOutput();
            System.out.printf("\nInitalizing Pump\n");
            motorRelay.setHubPort(port);
            motorRelay.setIsHubPortDevice(true);
            motorRelay.open(1000);
            
            System.out.printf("\nSuccess, Pump Opened!");
        }
        catch (PhidgetException e)
        {
            System.out.printf("\nError initalizing Pump, Quitting!\n%s", e);
            System.exit(-1);
        }
    }

    /**
     * 
     * @param timeout Set time for motor to stay on
     */
    public void runPumpWithoutWait(int timeout)
    {  
        new Thread(() ->  /// Runs as Asnync function so It wont hold up the program
        {
            try 
            {
                System.out.printf("\nRunning\n");
                motorRelay.setState(true);
                Thread.sleep(timeout);
                motorRelay.setState(false);
            }
            catch (Exception e)
            {
                System.out.printf("\nError initalizing Pump, Quitting!\n%s", e);
                System.exit(-1);
            }
        }).start();
    }
    
    /**
     * 
     * @param timeout Set time for motor to stay on
     */
    public void runPump(int timeout)
    {
        try 
        {
            motorRelay.setState(true);
            Thread.sleep(timeout);
            motorRelay.setState(false);
        }
        catch (PhidgetException | InterruptedException e)
        {
            System.out.printf("\nError Running Pump, Quitting!\n%s", e);
            System.exit(-1);
        }
    }
    
    /**
     * Close objects properly, prevents relays from being left open
     * @return If the objects closed properly, this will make the main loop wait for a response before stopping
     */
    public boolean closeObjects()
    {
        try
        {
            motorRelay.setState(false);
            motorRelay.close();
            System.out.printf("\nMotor and Relay Closed Successfully");
            return true;
        }
        catch (PhidgetException e) 
        {
            System.out.printf("\nError in closing Objects!\nPlease make sure to disable relays manually\n%s", e);
            System.exit(-1);
        }
        return false;
    }
}

/* Screen Dump

*/