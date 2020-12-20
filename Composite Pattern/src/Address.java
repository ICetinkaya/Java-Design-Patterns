import java.util.ArrayList;
import java.util.Iterator ;
public class Address extends AddressComponent {
	ArrayList addressComponents = new ArrayList();
	String name;
	String description;
	// constructor code here
	String surname;
	String mail;
	public Address(String description,String name,String surname,String mail)
	{
		this.description = description;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}
	public void add(AddressComponent addressComponent){
		this.addressComponents.add(addressComponent);
	}
	public void remove(AddressComponent addressComponent){
		this.addressComponents.remove(addressComponent);
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getDescription() {
		return description;
	}
	public String getMail() {
		return mail;
	}
	// other methods here
	public void printAddress() {
		System.out.print("\t  -->" + getDescription());
		System.out.print(" " + getName());
		System.out.print("," + getSurname() );
		System.out.print(" --> " + getMail() + "\n");
		System.out.println("---------------------");
		Iterator iterator = addressComponents.iterator();
		while (iterator.hasNext()) {
			AddressComponent addressComponent = (AddressComponent)iterator.next();
			addressComponent.printAddress();
		}
	}
}