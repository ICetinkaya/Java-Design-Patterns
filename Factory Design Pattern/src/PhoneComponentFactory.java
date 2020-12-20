
public interface PhoneComponentFactory {
	public CpuRam attachCpuRam();
	public Display attachDisplay();
	public Battery attachBattery(); 	
	public Storage attachStorage();
	public Camera attachCamera(); 
	public Case enclosePhoneCase(); 
}
