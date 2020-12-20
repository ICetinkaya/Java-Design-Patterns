
public class Client {
	public static void main(String[] args) {
		IflasTechnologiesLtd  turkeyStore = new TurkeyIflasTechnologiesLtd();
		IflasTechnologiesLtd  globalStore = new GlobalIflasTechnologiesLtd();
		SmartPhone smartphone = turkeyStore.orderPhone("MaximumEffort");
		System.out.println("Ethan ordered a " + smartphone.getName() + "\n");
		smartphone = globalStore.orderPhone("IflasDeluxe");
		System.out.println("Joel ordered a " + smartphone.getName() + "\n");
	}
}