import java.lang.String;
public class AddressItem extends AddressComponent {
	String description;
	String name;
	String surname;
	String mail;
	public AddressItem(String description,String name,String surname,String mail)
	{
		this.description = description;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
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
	
	public void printAddress() {
		System.out.print("\t  -->" + getDescription());
		System.out.print(" " + getName());
		System.out.print("," + getSurname() );
		System.out.print(" --> " + getMail() + "\n");
		System.out.println("---------------------");
	}
}
