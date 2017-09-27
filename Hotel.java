import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

public class Hotel {
	static final int ASCENDING_ROOM = 0;
	static final int DESCENDING_ROOM = 1;;
	static final int ASCENDING_PRICE = 2;
	static final int DESCENDING_PRICE = 3;
	static final int ASCENDING_TYPE = 4;
	static final int DESCENDING_TYPE = 5;
	private int roomID;
	private final int DEFAULT_HOTEL_SIZE = 11;
	private HotelRoom[] rooms;
	private HashMap<HotelRoom, Reservation> reservations;

	Scanner in;
	Writer writer;
	
	public static void main(String... args) {
		Hotel a = new Hotel();
		a.sort(DESCENDING_ROOM);
		a.printRooms();
	}

	public void printRooms() {
		for (HotelRoom room : rooms) {
			if (room != null) {
				System.out.println(room.toString());
			}
		}
	}

	public HotelRoom[] getRooms() {
		return rooms;

	}

	void setAvailability(int n, boolean newAvail) {
		rooms[n].setAvailability(newAvail);
	}

	public Hotel() {
		rooms = new HotelRoom[DEFAULT_HOTEL_SIZE];
		roomID = 0;
		makeRooms(HotelRoom.SINGLE, 50, 5, HotelRoom.DOUBLE, 80, 3, HotelRoom.DELUXE_SUITE, 120, 2);
		addRoom(HotelRoom.PRESIDENTIAL, 200);
		reservations = new HashMap<HotelRoom, Reservation>();

	}

	/**
	 * Make rooms of specific type, prices, and quantity of each.
	 * 
	 * @param type1
	 *            the first type of rooms to create.
	 * @param price1
	 *            the price of the first type of rooms.
	 * @param quantity1
	 *            the number of the first type of rooms to create.
	 * @param type2
	 *            the second type of rooms to create.
	 * @param price2
	 *            the price of the second type of rooms.
	 * @param quantity2
	 *            the number of the second type of rooms to create.
	 * @param type3
	 *            the third type of rooms to create.
	 * @param price3
	 *            the price of the third type of rooms.
	 * @param quantity3
	 *            the number of the third type of rooms to create.
	 */
	public void makeRooms(int type1, double price1, int quantity1, int type2, double price2, int quantity2, int type3,
			double price3, int quantity3) {
		if (quantity1 + quantity2 + quantity3 > rooms.length) {
			System.out.println("Number of rooms exceeds hotel capacity. Max room capacity is " + rooms.length + ".");
			return;
		}
		if (type1 > 3 || type2 > 3 || type3 > 3) {
			System.out.println("Please enter 1 (single), 2 (double), or 3 (deluxe suite) for the room type.");
			return;
		}
		for (int i = 0; i < quantity1; i++) {
			addRoom(type1, price1);
		}
		for (int i = 0; i < quantity2; i++) {
			addRoom(type2, price2);
		}
		for (int i = 0; i < quantity3; i++) {
			addRoom(type3, price3);
		}
	}

	public boolean isFull() {
		if (roomID >= rooms.length) {
			return true;
		} else {
			return false;
		}
	}

	public void unassignedRooms() {
		int unassigned = rooms.length - roomID;
		System.out.println(unassigned + " out of " + rooms.length + " rooms are unassigned.");
	}

	/**
	 * Helper method for adding hotel rooms.
	 * 
	 * @param type
	 *            the type of room to create.
	 * @param price
	 *            the price of the room.
	 */
	public void addRoom(int type, double price) {
		if (roomID >= rooms.length) {
			return;
		}
		HotelRoom room = new HotelRoom(roomID, type, price, true);
		rooms[roomID++] = room;
	}

	public void reserveRoom(HotelRoom room, Reservation reservation) {
		if (reservations.containsKey(room) && reservations.get(room) != null) {
			return;
		}
		reservations.put(room, reservation);
	}

	public Reservation getResveration(HotelRoom room) {
		return reservations.get(room);
	}

	public void sort(int sortby) {
		if (!isFull()) {
			// System.out.println("Hotel has unassigned rooms, cannot begin
			// sorting.");
			return;
		}
		quickSort(this.rooms, 0, rooms.length - 1, sortby);
	}

	private HotelRoom medianOf3(HotelRoom[] rooms, int start, int end, int sortby) {
		int mid = (start + end) / 2;
		if (rooms[end].compareTo(rooms[mid], sortby) < 0) {
			swap(rooms, end, mid);
		}
		if (rooms[mid].compareTo(rooms[start], sortby) < 0) {
			swap(rooms, mid, start);
		}
		if (rooms[end].compareTo(rooms[mid], sortby) < 0) {
			swap(rooms, end, mid);
		}
		swap(rooms, mid, end - 1);
		return rooms[end - 1];
	}

	private void quickSort(HotelRoom[] rooms, int start, int end, int sortby) {
		if (start + 3 <= end) {
			HotelRoom pivot = medianOf3(rooms, start, end, sortby);
			int i = start;
			int j = end - 1;
			boolean done = false;
			while (!done) {
				while (rooms[++i].compareTo(pivot, sortby) < 0) {
				}
				while (rooms[--j].compareTo(pivot, sortby) > 0) {
				}
				if (i < j) {
					swap(rooms, i, j);
				} else {
					done = true;
				}
			}
			swap(rooms, i, end - 1);
			quickSort(rooms, start, i - 1, sortby);
			quickSort(rooms, i + 1, end, sortby);
		} else {
			insertionSort(rooms, start, end, sortby);
		}
	}

	private void insertionSort(HotelRoom[] rooms, int start, int end, int sortby) {
		for (int i = start + 1; i <= end; i++) {
			HotelRoom temp = rooms[i];
			int j;
			for (j = i; j > start && temp.compareTo(rooms[j - 1], sortby) < 0; j--)
				rooms[j] = rooms[j - 1];
			rooms[j] = temp;
		}
	}

	private void swap(HotelRoom[] rooms, int index1, int index2) {
		HotelRoom temp = rooms[index1];
		rooms[index1] = rooms[index2];
		rooms[index2] = temp;
	}

	/**
	 * kappa
	 */
	public void loadRoomAvailability() {
		try {
			File file = new File("RoomAvailability.txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
					FileWriter fw = new FileWriter("RoomAvailability.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for (int i = 0; i < rooms.length; i++) {
						bw.write(rooms[i].getAvailabilityForPrinting());
					}
					bw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				in = new Scanner(new File("RoomAvailability.txt"));
				int i = 0;
				while (in.hasNextLine()) {
					rooms[i].setAvailability(Boolean.valueOf(in.nextLine().trim()));
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveRoomAvailability() {
		File file = new File("RoomAvailability.txt");
		if (file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter("RoomAvailability.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				for (int i = 0; i < rooms.length; i++) {
					bw.write(rooms[i].getAvailabilityForPrinting());
				}
				bw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}