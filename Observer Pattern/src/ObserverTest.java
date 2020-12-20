
public class ObserverTest {

		public static void main(String[] args) {
		    HiTech camera = new HiTech();
		    TrafficLight light = new TrafficLight();
		    camera.addObserver(light);
		    camera.changeHiTech(true);
		  }
	
}
