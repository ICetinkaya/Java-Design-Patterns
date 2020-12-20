import java.util.Observable;
import java.util.Observer;
public class HiTech  extends Observable {
	private boolean flag;
	
	public HiTech() { 
		
	}
	public void changeHiTech(boolean flag) {
		this.flag = flag;
	    setChanged();
	    notifyObservers(flag);
	  }
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	public void setMeasurements(boolean flag) {
		this.flag = flag;
		measurementsChanged();
	}
	public boolean getFlag() {
		return flag;
	}
	
}

