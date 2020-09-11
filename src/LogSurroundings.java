//package PlantWateringProject.src;

import com.phidget22.*;

/**
 *
 * @author Harper Kelly, Comp Sci. ID# 803225004 
 */
public class LogSurroundings 
{
    /*
    This will need to be an async function as it will just be logging
    sunlight to be graphed
    */
    private LightSensor l = null;
    private TemperatureSensor t = null;
    private HumiditySensor h = null;
    private CurrentTime time = null;
    
    /**
     * Init objects
     * @param lightSensorPort Port for the Phidget LUX1000_0 
     * @param temperatureSensorPort Port for the Phidget HUM1000_0 Temperature Sensor
     * @param humiditySensorPort Port for the Phidget HUM1000_0 Humidity Sensor 
     */
    public LogSurroundings(int lightSensorPort, int temperatureSensorPort, int humiditySensorPort)
    {
        try
        {
            // Address Objects
            l = new LightSensor();
            t = new TemperatureSensor();
            h = new HumiditySensor();
            
            l.setHubPort(lightSensorPort);
            t.setHubPort(temperatureSensorPort);
            h.setHubPort(humiditySensorPort);
            
            l.setIsHubPortDevice(false);
            t.setIsHubPortDevice(false);
            h.setIsHubPortDevice(false);
            
            l.open(1000);
            t.open(1000);
            h.open(1000);
        }
        catch (PhidgetException e)
        {
            System.out.printf("\nError initalizing data logging.\nThis is a non critical error, so the program will not be halted.\nPlease restart if you would like functionality fully restored.");
        }

        // Init time object
        time = new CurrentTime();
    }

    /**
     *
     * @param log Boolean which tells the thread to stop logging in the event of termination to prevent a hung process
     */
    public void logData(boolean log)
    {
        new Thread(() -> // Async Lambda expression for logging data to a file, Not currently logging to a file
        {
            try
            {
                while (log) 
                {
                    System.out.printf("\n%s ---\nLight %slx\nHumidity %s%%\nTemperature %s°C\n", time.returnTime(), l.getIlluminance(), h.getHumidity(), t.getTemperature());
                    String[] data = {"t-" + time.returnTime(), "\nL-" + Double.toString(l.getIlluminance()), "\nH-" + Double.toString(h.getHumidity()), "\nT-" + Double.toString(t.getTemperature()), "\n\n"};
                    FilesData.append("./data.log", data);
                    Thread.sleep(5500); 
                }
                // Close objects
                l.close();
                t.close();
                h.close();
                System.out.printf("\nSensors Closed Successfully");
                //closeObjects();
            }
            catch (PhidgetException | InterruptedException e)
            {
                System.out.printf("\nError Running Sensors, Quitting!\n%s", e);
            }
        }).start();
    }
}

/* Screen Dump

*/