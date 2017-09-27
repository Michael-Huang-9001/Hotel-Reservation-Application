public class HotelRoom {
	private int roomNumber;
	private int roomType;
	private double roomPrice;
	private boolean available;
	static final int SINGLE = 0;
	static final int DOUBLE = 1;
	static final int DELUXE_SUITE = 2;
	static final int PRESIDENTIAL = 3;

	/**
	 * HotelRoom Constructor. This constructor is used to create individual
	 * rooms of a hotel with all its basic information.
	 */
	public HotelRoom(int newRoomNumber, int newRoomType, double newRoomPrice, boolean newRoomStatus) {
		roomNumber = newRoomNumber;
		roomType = newRoomType;
		roomPrice = newRoomPrice;
		available = true;
	}

	/**
	 * Gets the rooms reservation status.
	 * 
	 * @return the availability of the room
	 */
	public boolean getAvailability() {
		return available;
	}

	public String getAvailabilityForPrinting() {
		return String.valueOf(available) + "\n";
	}

	/**
	 * Changes the availability of the room.
	 */
	public void setAvailability(boolean availability) {
		available = availability;
	}

	/**
	 * Gets the price of the room.
	 * 
	 * @return the price of the room.
	 */
	public double getRoomPrice() {
		return roomPrice;
	}

	/**
	 * Gets the room number.
	 * 
	 * @return the room's number.
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Gets the room type.
	 * @return thr room type.
	 */
	public int getRoomType() {
		return roomType;
	}

	/**
	 * Gets the room type name.
	 * 
	 * @return the room type's name.
	 */
	public String getRoomTypeName() {
		if (roomType == SINGLE) {
			return "Single";
		} else if (roomType == DOUBLE) {
			return "Double";
		} else if (roomType == DELUXE_SUITE) {
			return "Deluxe Suite";
		} else {
			return "Presidential";
		}
	}

	/**
	 * toString method for a HotelRoom.
	 */
	@Override
	public String toString() {
		return "[Room " + getRoomNumber() + " | " + getRoomTypeName() + "] $" + getRoomPrice() + "\n\n";
	}

	/**
	 * A compareTo method for comparing/sorting HotelRooms.
	 * @param room the room to compare to.
	 * @param compareBy the way you wish to compare them.
	 * @return -1 if less than, 1 if greater, 0 if equal.
	 */
	public int compareTo(HotelRoom room, int compareBy) {
		if (compareBy == Hotel.ASCENDING_ROOM) {
			return compareByRoomNumber(room, false);
		} else if (compareBy == Hotel.DESCENDING_ROOM) {
			return compareByRoomNumber(room, true);
		} else if (compareBy == Hotel.ASCENDING_PRICE) {
			return compareByPrice(room, false);
		} else if (compareBy == Hotel.DESCENDING_PRICE) {
			return compareByPrice(room, true);
		} else if (compareBy == Hotel.ASCENDING_TYPE) {
			return compareByRoomType(room, false);
		} else {
			return compareByRoomType(room, true);
		}
	}

	/**
	 * Compares room by room number.
	 * @param room the room to compare to.
	 * @param reverse if you wish to reverse the order for sorting
	 * @return the comparison result
	 */
	public int compareByRoomNumber(HotelRoom room, boolean reverse) {
		if (this.roomNumber < room.getRoomNumber()) {
			if (reverse) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.roomNumber > room.getRoomNumber()) {
			if (reverse) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}

	/**
	 * Compares room by room type.
	 * @param room the room to compare to.
	 * @param reverse if you wish to reverse the order for sorting
	 * @return the comparison result
	 */
	public int compareByRoomType(HotelRoom room, boolean reverse) {
		if (this.roomType < room.getRoomType()) {
			if (reverse) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.roomType > room.getRoomType()) {
			if (reverse) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}

	/**
	 * Compares room by room price.
	 * @param room the room to compare to.
	 * @param reverse if you wish to reverse the order for sorting
	 * @return the comparison result
	 */
	public int compareByPrice(HotelRoom room, boolean reverse) {
		if (this.roomPrice < room.getRoomPrice()) {
			if (reverse) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.roomPrice > room.getRoomPrice()) {
			if (reverse) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}
}