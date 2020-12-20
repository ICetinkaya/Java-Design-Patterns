
public class YellowLightState implements State
{
    public void Handle(TrafficLight trafficLight) throws InterruptedException
    {
        trafficLight.colorString = "Red"; // Switch the traffic light color
        trafficLight.time = 3; // For 3 seconds
        trafficLight.nextState = new RedLightState(); // Then red light follows
        System.out.println(trafficLight.colorString);
        trafficLight.nextState.Handle(trafficLight);
    }
}