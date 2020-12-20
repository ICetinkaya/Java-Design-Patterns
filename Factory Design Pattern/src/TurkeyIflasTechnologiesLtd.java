
public class TurkeyIflasTechnologiesLtd extends IflasTechnologiesLtd{

	@Override
	protected SmartPhone createSmartPhone(String type) {
		if (type.equals("MaximumEffort")) {
			return new MaximumEffort();
		}else if (type.equals("IflasDeluxe")) {
			return new IflasDeluxe();
		}else if (type.equals("IIAmanIflas")) {
			return new MaximumEffort();
		}else{
			return null;
		}
	}
	
}
