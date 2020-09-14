public class WaterOverride 
{
    public WaterOverride(t motorRelayPort, int sensorRelayPort, int sensorPort)
    {
        p = new PumpControl(motorRelayPort);
        sm = new SoilMeasurements(sensorRelayPort, sensorPort);
        time = new CurrentTime();
    }
        
}
