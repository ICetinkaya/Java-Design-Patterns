import java.util.ArrayList;

public abstract class SmartPhone {
	String name;
	double displayInch;
	int  batteryMA;
	int batteryHour;
	double cpu;
	int ram;
	int storage;
	int cameraFront;
	int cameraRear;
	String casePhone;
	String sauce;
	ArrayList toppings = new ArrayList();
	public void preparePhone(){
		System.out.println("Preparing " + name);
		System.out.println("----------------------------");
		System.out.println("Attach Cpu...     " + cpu +"GHz, " + ram +  "ram to the board");
		System.out.println("Attach Display... " + displayInch);
		System.out.println("Attach Battery... " + batteryHour +"h, "+batteryMA+"mAh");
		System.out.println("Attach Storage... " +"MicroSD support " +storage +"GB");
		System.out.println("Attach Camera...  " + cameraFront+"Mp front ," + cameraRear +"rear");
		System.out.println("Attach Case...    " + casePhone);
		for (int i = 0; i < toppings.size(); i++) {
		System.out.println( "  " + toppings.get(i));
		}
	}
	
	public String getName() {
		return name;
	}
}
