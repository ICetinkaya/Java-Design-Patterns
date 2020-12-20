
public class RedLightState implements State
{
    public void Handle(TrafficLight trafficLight) throws InterruptedException
    {
    	trafficLight.time = 15; // For 3 seconds
        trafficLight.colorString = "Green"; // Switch the traffic light color
        Thread.sleep(trafficLight.time * 1000);
        trafficLight.nextState = new GreenLightState(); // Then green light follows
        System.out.println(trafficLight.colorString);
        trafficLight.nextState.Handle(trafficLight);
      }
}
