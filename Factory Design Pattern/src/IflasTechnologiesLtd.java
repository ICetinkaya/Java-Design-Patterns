
public abstract class IflasTechnologiesLtd {
	public SmartPhone orderPhone(String type) {
		SmartPhone smartphone;
		smartphone = createSmartPhone(type);
		smartphone.preparePhone();
		return smartphone;
	}
	protected abstract SmartPhone createSmartPhone(String type);
}
