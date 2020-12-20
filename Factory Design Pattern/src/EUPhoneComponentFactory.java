
public class EUPhoneComponentFactory implements PhoneComponentFactory{

	@Override
	public CpuRam attachCpuRam() {
		// TODO Auto-generated method stub
		return new CpuRamFourCore();
	}

	@Override
	public Display attachDisplay() {
		// TODO Auto-generated method stub
		return new Display24bit();
	}

	@Override
	public Battery attachBattery() {
		// TODO Auto-generated method stub
		return new LithiumIon();
	}

	@Override
	public Storage attachStorage() {
		// TODO Auto-generated method stub
		return new Storage64Gb();
	}

	@Override
	public Camera attachCamera() {
		// TODO Auto-generated method stub
		return new OpticZoomThree();
	}

	@Override
	public Case enclosePhoneCase() {
		// TODO Auto-generated method stub
		return new WaterproofOneMeter();
	}

}
