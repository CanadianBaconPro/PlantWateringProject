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

    private String[] space = {" "};
    
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
        new Thread(() -> // Async Lambda expression for logging data to a file
        {
            try
            {
                {
                    System.out.printf("\n%s ---\nLight %slx\nHumidity %s%%\nTemperature %s°C\n", time.returnTime(), l.getIlluminance(), h.getHumidity(), t.getTemperature());
                    String[] data = {"t-" + time.returnTime(), "\nL-" + Double.toString(l.getIlluminance()), "\nH-" + Double.toString(h.getHumidity()), "\nT-" + Double.toString(t.getTemperature()), "\n\n"};
                    FilesData.append("../log/sunlight.txt", (Double.toString(l.getIlluminance())).split(" "));
                    FilesData.append("../log/sunlight.txt", space);
                    FilesData.append("../log/temperature.txt", (Double.toString(t.getTemperature())).split(" "));
                    FilesData.append("../log/temperature.txt", space);
                    FilesData.append("../log/humidity.txt", (Double.toString(h.getHumidity())).split(" "));
                    FilesData.append("../log/humidity.txt", space);
                    FilesData.append("../log/time.txt", (time.returnSimpleTime()).split(" "));
                    FilesData.append("../log/time.txt", space);
                    Thread.sleep(3600000); 
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