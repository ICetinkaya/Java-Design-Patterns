
public class GlobalPhoneComponentFactory implements PhoneComponentFactory {

	@Override
	public CpuRam attachCpuRam() {
		// TODO Auto-generated method stub
		return new CpuRamTwoCore();
	}

	@Override
	public Display attachDisplay() {
		// TODO Auto-generated method stub
		return new Display24bit();
	}

	@Override
	public Battery attachBattery() {
		// TODO Auto-generated method stub
		return new LithiumCobalt();
	}

	@Override
	public Storage attachStorage() {
		// TODO Auto-generated method stub
		return new Storage32Gb();
	}

	@Override
	public Camera attachCamera() {
		// TODO Auto-generated method stub
		return new OpticZoomTwo();
	}

	@Override
	public Case enclosePhoneCase() {
		// TODO Auto-generated method stub
		return new WaterproofFiftyCentiMeter();
	}

}
