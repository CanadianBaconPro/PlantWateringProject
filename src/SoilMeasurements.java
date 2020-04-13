//package CompSci.Phidgets.PlantWateringProject;

import com.phidget22.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Harper Kelly, Comp Sci. ID# 803225004 
 */
public class SoilMeasurements 
{
    private DigitalOutput sensorRelay = null;
    private VoltageInput moistureSensor = null;
    private CurrentTime time = null;
    
    /**
     * If voltage from sensor is > than this value, it will continue assuming that the soil
     * moist enough
     */
    private static final double voltageBreakeven = 4.00;
    
    /**
     * 
     * @param relayPort Set Port To Toggle Relay For Measurements
     * @param sensorPort Port for Sparkfun Soil Moisture Sensor
     */
    public SoilMeasurements(int relayPort, int sensorPort)
    {
        try 
        {
            // Init objects
            sensorRelay = new DigitalOutput();
            moistureSensor = new VoltageInput();
            
            sensorRelay.setHubPort(relayPort);
            moistureSensor.setHubPort(sensorPort);
            
            sensorRelay.setIsHubPortDevice(true);
            moistureSensor.setIsHubPortDevice(true);
            
            sensorRelay.open(1000);
            moistureSensor.open(1000);
            
            System.out.printf("\nSuccess, Moisture Sensor Opened!");
        }
        catch (PhidgetException e)
        {
            System.out.println("Error initalizing Sensor and Relay, Quitting!");
            System.exit(-1);
        }

        // Initalize Time Object
        time = new CurrentTime();
    }
    
    /**
     * Take a soil moisture measurement
     * @return If the soil is moist enough or not
     */
    public boolean takeMeasurement()
    {
        try
        {
            sensorRelay.setState(true);
            Thread.sleep(3500); // Wait for measurement to even out a little
            
            double measurement = moistureSensor.getVoltage();
            sensorRelay.setState(false);
            System.out.printf("\n%s --- Voltage is %s\n", time.returnTime(), measurement);
            if (measurement > voltageBreakeven)
            {
                return true;
            }
        }
        catch (PhidgetException | InterruptedException e)
        {
            System.out.printf("\nError Using Sensor and Relay, Quitting!\n%s", e);
            System.exit(-1);
        }
        
        return false;
    }
    
    /**
     * Close objects properly, prevents relays from being left open
     * @return If the objects closed properly, this will make the main loop wait for a response before stopping
     */
    public boolean closeObjects()
    {
        try
        {
            sensorRelay.setState(false);
            sensorRelay.close();
            moistureSensor.close();
            System.out.printf("\nMoisture Sensor and Relay Closed Successfully");
            return true;
        }
        catch (PhidgetException e) 
        {
            System.out.printf("\nError in closing Objects!\nPlease make sure to disable relays manually");
            System.exit(-1);
        }
        return false;
    }
}

/* Screen Dump

*/
