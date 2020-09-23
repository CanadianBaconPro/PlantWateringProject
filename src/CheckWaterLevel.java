//package PlantWateringProject.src;
import java.io.IOException;
/**
 *
 * @author Harper Kelly, Comp Sci. ID# 803225004 
 */
public class CheckWaterLevel 
{
    // Change how long the motor runs
    public final int timeout = 5000;
    
    private PumpControl p = null;
    private SoilMeasurements sm = null;
    private CurrentTime time = null;
    private WaterOverride wo = null;
    
    /**
     * 
     * @param motorRelayPort Port for the Motor relay
     * @param sensorRelayPort Port for the Moisture sensor relay
     * @param sensorPort Port for the Moisture sensor
     */
    public CheckWaterLevel(int motorRelayPort, int sensorRelayPort, int sensorPort)
    {
        p = new PumpControl(motorRelayPort);
        sm = new SoilMeasurements(sensorRelayPort, sensorPort);
        time = new CurrentTime();
        wo = new WaterOverride();
    }
    
    /**
     * Run the moisture sensor, then run the pump if needed
     * @param running Tell the process if it should quit 
     */
    public void run(boolean running)
    {
        if (running)
        {
            new Thread(() ->
            {
                try
                {
                    while (true)
                    {
                        if (wo.listen(true))
                        {
                            ExecuteProcess.text("./wateringplant.message");
		    	            p.runPumpWithoutWait(timeout);
		    	            System.out.printf("\n\n%s--- \033[1;36mWatering\033[0m\n\n", time.returnTime());
		    	            Thread.sleep((timeout + 2000));
                        }
                    }
                }
                catch (Exception e) { System.out.printf("\nError! \n%s\n", e); }

            }).start();
        }

        new Thread(() ->
        {
            try
            {
                // Start the listener for the frontend 
                while (running)
                {
                    WaterPlant:
                    while (true)
                    {
                        if (sm.takeMeasurement())
                        {
                            System.out.printf("\nMoist Enough");
                            break WaterPlant;
                        }  
                        else
                        {
                            ExecuteProcess.text("./wateringplant.message");
			                p.runPump(timeout);
			                System.out.printf("\n%s --- \033[1;36mWatering\033[0m\n", time.returnTime());
			                Thread.sleep((timeout + 2000));
                        }
                    }
                    Thread.sleep(1800000);
                }
                // Close objects
                wo.listen(false);
                p.closeObjects();
                sm.closeObjects();
            }
            catch (InterruptedException e)
            {
                System.out.printf("\nCritical Error, %s\nQuitting!", e);
                System.exit(-1);
            }
        }).start();
    }
}

/* Screen Dump

*/
