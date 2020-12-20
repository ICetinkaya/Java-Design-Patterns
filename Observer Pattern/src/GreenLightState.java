
public class GreenLightState implements State
{
    public void Handle(TrafficLight trafficLight) throws InterruptedException
    {
        trafficLight.colorString = "Yellow"; // Switch the traffic light color
        trafficLight.time = 60; // For 60 seconds
        Thread.sleep(trafficLight.time * 1000);
        trafficLight.nextState = new YellowLightState(); // Then Amber light follows
        System.out.println(trafficLight.colorString);
        trafficLight.nextState.Handle(trafficLight);
    }
}