import java.util.Observable;
import java.util.Observer;

public class TrafficLight implements Observer
{
    // Has properties that define it's behaviour
    public int time = 0; 
    public String colorString = "Red";

    // Has internal State
    public State nextState;
    // Sets the default state
    public TrafficLight()
    {
    	this.nextState = new RedLightState();
    }


    // Receives request ...
    public void Request() throws InterruptedException
    {
        // ... then:
        // Delegates to the internal State to handle.
    	System.out.println(colorString);
        nextState.Handle(this);

        // The behaviour has changed, color, time of light, etc.
      
       
    }


	@Override
	public void update(Observable arg0, Object arg1) {
		 System.out.println("Hitech board changed: " + arg1);
		
	}
}
