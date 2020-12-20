
public class AddressTest {


	public static void main(String args[]) {
	AddressComponent groupAddress = new Address("GROUP_1","Admin","Admin", "cengstudents4th@gtu.edu.tr");
	AddressComponent groupAddress2 = new Address("GROUP_2","Admin1","Admin1", "students@gtu.edu.tr");
	AddressComponent groupAddressRoot = new Address("GROUP_ROOT","AdminStudent","AdminStudent", "students4th@gtu.edu.tr");
	AddressComponent personalAddress = new Address("PERSONAL_1","ibr","cetn", "icetinkaya@gtu.edu.tr");
	AddressComponent personalAddress2 = new Address("PERSONAL_2","ibrahim","cetinkaya", "icetin@gtu.edu.tr");
	AddressComponent personalAddress3 = new Address("PERSONAL_3","ibo","cet", "icet@gtu.edu.tr");
	groupAddress.add(personalAddress);
	groupAddress.add(personalAddress2);
	groupAddress.add(personalAddress3);
	
	groupAddressRoot.add(groupAddress);
	groupAddressRoot.add(personalAddress2);
	groupAddressRoot.add(groupAddress2);
	groupAddressRoot.add(personalAddress2);
	groupAddressRoot.add(personalAddress3);
	
	groupAddress2.add(new AddressItem("PERSONAL_4","icet","icet", "icetin@gtu.edu.tr"));
	
	Client client = new Client(groupAddressRoot);
	client.print();
	}
}