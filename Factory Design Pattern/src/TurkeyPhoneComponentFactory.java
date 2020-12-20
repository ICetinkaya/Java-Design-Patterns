
public class TurkeyPhoneComponentFactory implements PhoneComponentFactory {

	@Override
	public CpuRam attachCpuRam() {
		// TODO Auto-generated method stub
		return new CpuRamEightCore();
	}

	@Override
	public Display attachDisplay() {
		// TODO Auto-generated method stub
		return new Display32bit();
	}

	@Override
	public Battery attachBattery() {
		// TODO Auto-generated method stub
		return new LithiumBoron();
	}

	@Override
	public Storage attachStorage() {
		// TODO Auto-generated method stub
		return new Storage128Gb();
	}

	@Override
	public Camera attachCamera() {
		// TODO Auto-generated method stub
		return new OpticZoomFour();
	}

	@Override
	public Case enclosePhoneCase() {
		// TODO Auto-generated method stub
		return new WaterproofTwoMeter();
	}
}
