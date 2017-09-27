public class Customer {
	private String title;
	private String fname;
	private String mname;
	private String lname;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public static void main(String... args) {
		Customer c = new Customer();
		c.setTitle("Mr.");
		c.setFirstName("Douglas");
		c.setMiddleName("Jay");
		c.setLastName("Falcon");
		System.out.println(c.toString());
	}

	/**
	 * Creates a customer.
	 */
	public Customer() {
	}

	/**
	 * Sets title.
	 * @param title the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the title.
	 * @return the title.
	 */
	public String getTitle() {
		if (title == null)
			return "";
		return title + " ";
	}

	/**
	 * Sets the first name of the customer.
	 * 
	 * @param name
	 *            the customer's first name.
	 */
	public void setFirstName(String fname) {
		this.fname = fname;
	}

	/**
	 * Gets the customer's first name.
	 * 
	 * @return the customer's first name.
	 */
	public String getFirstName() {
		if (fname == null)
			return "";
		return fname + " ";
	}

	/**
	 * Sets the middle name of the customer.
	 * 
	 * @param name
	 *            the customer's middle name.
	 */
	public void setMiddleName(String mname) {
		this.mname = mname;
	}

	/**
	 * Gets the customer's middle name.
	 * 
	 * @return the customer's middle name.
	 */
	public String getMiddleName() {
		if (mname == null)
			return "";
		return mname + " ";
	}

	/**
	 * Sets the last name of the customer.
	 * 
	 * @param name
	 *            the customer's last name.
	 */
	public void setLastName(String lname) {
		this.lname = lname;
	}

	/**
	 * Gets the customer's last name.
	 * 
	 * @return the customer's last name.
	 */
	public String getLastName() {
		if (lname == null)
			return "";
		return lname + " \n";
	}

	/**
	 * Sets the customer's primary address.
	 * 
	 * @param address
	 *            the customer's primary address.
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the customer's primary address.
	 * 
	 * @return the customer's primary address.
	 */
	public String getAddress1() {
		if (address1 == null)
			return "";
		return address1 + " ";
	}

	/**
	 * Sets the customer's secondary address.
	 * 
	 * @param address
	 *            the customer's secondary address.
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the customer's secondary address.
	 * 
	 * @return the customer's secondary address.
	 */
	public String getAddress2() {
		if (address2 == null)
			return "";
		return address2 + " \n";
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		if (city == null)
			return "";
		return this.city + " ";
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		if (state == null)
			return "";
		return this.state + " ";
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip() {
		if (zip == null)
			return "";
		return this.zip + " \n";
	}

	/**
	 * Sets the customer's phone number.
	 * 
	 * @param phone
	 *            the customer's phone number.
	 */
	public void setPhoneNumber(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the customer's phone number.
	 * 
	 * @return the customer's phone number.
	 */
	public String getPhoneNumber() {
		if (phone == null)
			return "";
		return phone;
	}

	public String toString() {
		return getTitle() + getFirstName() + getMiddleName() + getLastName() + getAddress1() + getAddress2() + getCity()
				+ getState() + getZip() + getPhoneNumber();
	}
}