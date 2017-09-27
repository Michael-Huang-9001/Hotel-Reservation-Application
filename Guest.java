public class Guest {
	
	/**
	 * Creates a guest.
	 * @param firstName first name of guest.
	 * @param lastName last name of guest.
	 * @param email email of guest.
	 * @param password the desired password.
	 * @param phoneNumber the guest's phone number.
	 * @param stAddress the guest's address.
	 * @param state part of address
	 * @param zipCode part of address
	 */
	public Guest(String firstName, String lastName, String email, String password, String phoneNumber, String stAddress,
			String state, String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.stAddress = stAddress;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String toString() {
		return firstName + " " + lastName + "\n" + email + "\n" + password + "\n" + phoneNumber + "\n" + stAddress
				+ "\n" + state + "\n" + zipCode + "\n\n";
	}

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phoneNumber;
	private String stAddress;
	private String state;
	private String zipCode;
}