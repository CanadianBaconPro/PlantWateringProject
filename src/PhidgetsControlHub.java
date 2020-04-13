//package CompSci.Phidgets.PlantWateringProject;

import com.phidget22.PhidgetException;

import java.io.IOException;

/**
 *
 * @author Harper Kelly, Comp Sci. ID# 803225004 
 */
public class PhidgetsControlHub 
{
    // Define Ports Here
    private static final int SensorRelayPort     = 3;
    private static final int MoistureSensorPort  = 4;
    private static final int MotorRelayPort      = 5;
    private static final int HumiditySensorPort  = 2;
    private static final int LightSensorPort     = 1;
    
    // TODO(CB): Compile all files into a jar package so that it can be run without frills
    public static void main(String[] args)
    {
        CheckWaterLevel wl = new CheckWaterLevel(MotorRelayPort, SensorRelayPort, MoistureSensorPort);
        LogSurroundings l = new LogSurroundings(LightSensorPort, HumiditySensorPort, HumiditySensorPort);
        
        System.out.printf("\n\n");
        
        l.logData(true); // Log Data
        wl.run(true);

        // This process will catch a SIGTERM from both inside and outside the program, and should shut everything down properly
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    System.out.printf("\nSIGTERM Caught, Quitting");
                    l.logData(false);
                    wl.run(false);
                    System.out.printf("\n\n");
                    Thread.sleep(100); // Give objects a second to close
                    System.out.printf("\n\n");
                    // TODO(CB): Figure out a way to wait on all sensors to close before shutting down the program
                }
                catch (InterruptedException e)
                {
                    System.out.printf("\nError in Main\n%s\n\nProgram did not shut down correctly!", e);
                }
            }
        });

        while (true)
        {
            try
            {
                if (System.in.available() > 0)
                {
                    System.exit(0);
                }
                Thread.sleep(100);
            }
            catch (IOException | InterruptedException e)
            {
                System.out.printf("\nError in Main\n%s", e);
            }
        }
        /*
        For taking measurements, I should probably run the pump, and then wait a few seconds before starting the 
        probe so that the water can dispurse first
        */
    }

    // TODO(CB): I need to figure out a better way to end all tasks
    // TODO(CB): Read variable date from files in an easy way to allow for config files from the webpage
    // TODO(CB): Fix broken ssmtp server not sending texts (RENEW Email CERT)
}
