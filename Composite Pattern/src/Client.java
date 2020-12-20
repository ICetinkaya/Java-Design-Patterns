
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	AddressComponent allAddress;
	public Client(AddressComponent allAddress) {
		this.allAddress = allAddress;
	}
	public void print() {
		allAddress.printAddress();
	}
}
