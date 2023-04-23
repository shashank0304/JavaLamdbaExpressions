package lambdas.ch04;

public final class Customer {
	
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public Customer(String firstName,String lastName,String email,int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email= email;
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	

	
	public String toString() {
		return this.getName() + " : "+this.email;
	}

}
