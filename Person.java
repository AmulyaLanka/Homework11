
public class Person implements java.io.Serializable{
	
	String name;
	String phoneNumber;
	String dateOfBirth;
	String emailID;
	public Person(String name, String phoneNumber, String dateOfBirth, String emailID) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailID = emailID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", emailID="
				+ emailID + "]";
	}
	
	

}
