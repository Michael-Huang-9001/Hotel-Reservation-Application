public class Reservation {
	private String customer;
	private HotelRoom room;
	private Date start;
	private Date end;
	String cRoom;

	/**
	 * Creates an empty reservation.
	 */
	public Reservation(String newCustomer) {
		customer = newCustomer;
	}

	/**
	 * Sets the customer of this reservation.
	 * 
	 * @param customer
	 *            the customer of the reservation.
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Gets the customer of the reservation.
	 * 
	 * @return the customer of the reservation.
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Sets the room of the reservation.
	 * 
	 * @param room
	 *            the room of the reservation.
	 */
	public void setRoom(HotelRoom room) {
		this.room = room;
	}

	/**
	 * Gets the reserved room of the reservation.
	 * 
	 * @return the room of the reservation.
	 */
	public HotelRoom getRoom() {
		return room;
	}

	/**
	 * Sets the reservation's start date.
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 */
	public void setStartDate(int month, int day, int year) {
		this.start = new Date(month, day, year);
	}

	/**
	 * Gets the reservation's start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return this.start;
	}

	/**
	 * Sets the reservation's end date.
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 */
	public void setEndDate(int month, int day, int year) {
		this.end = new Date(month, day, year);
	}

	/**
	 * Gets the reservation's end date.
	 * @return the start date.
	 */
	public Date getEndDate() {
		return this.end;
	}

	/**
	 * Calculates the number of bays between start and end dates.
	 * @return number of days.
	 */
	public long duration() {
		return Date.daysBetween(start, end);
	}

	/**
	 * Standard toString method for a reservation.
	 */
	@Override
	public String toString() {
		return room.getRoomNumber() + "\n" + customer + "\n" + "From: " + getStartDate().toString() + " to "
				+ getEndDate().toString() + "\n" + "Total price: $" + room.getRoomPrice() * duration();
	}

	/**
	 * Validates a reservation.
	 * @return true if reservation is formatted correctly.
	 */
	public boolean validate() {
		if (customer != null && room != null && getEndDate().compareTo(getStartDate()) > 0) {
			return true;
		} else {
			return false;
		}
	}
}