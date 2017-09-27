import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class ReservationSystem {

	private JFrame frame;
	private String currentGuest;
	private Scanner in;
	private ArrayList<String> reservationInfo;
	private ReservationSystem system;
	private ArrayList<String> guestReservations;

	/*
	 * The reservation System will attempt to load a Hotel.txt file. Using the
	 * loadHotel() method. If no such file is found, then create a hotel.
	 */
	public ReservationSystem(String guest) {
		system = this;
		reservationInfo = new ArrayList<>();
		currentGuest = guest;
		guestReservations = new ArrayList<>();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currentHotel = new Hotel();
					currentHotel.loadRoomAvailability();
					loadReservations();
					System.out.println("Current user: " + currentGuest);
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hotel Reservation System",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Book Antiqua", Font.PLAIN, 20), new Color(0, 0, 0)));
		panel.setBounds(10, 11, 464, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("View Reservation\r\n");
		btnNewButton_1.setBounds(40, 140, 175, 40);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (reservationCheck() == true) {
					View_Reservation vR = new View_Reservation(currentHotel, currentGuest, system, reservationInfo,
							frame);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "You currently have no reservations.");
				}
			}
		});

		JButton btnNewButton_2 = new JButton("Browse Rooms\r\n");
		btnNewButton_2.setBounds(260, 140, 175, 40);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Search_Room sR = new Search_Room(currentHotel, currentGuest, system, reservationInfo, frame);
				frame.setVisible(false);
			}
		});

		frame.setVisible(true);
	}

	/**
	 * occurs after a change is made to the arraylist
	 */
	public void saveChangesToReservations(ArrayList<String> newList) {
		File file = new File("HotelReservations.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter("HotelReservations.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				for (int i = 0; i < newList.size(); i++) {
					String item = newList.get(i) + "\n";
					bw.write(item);
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Loads reservations on file.
	 */
	public void loadReservations() {
		try {
			File file = new File("HotelReservations.txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
					FileWriter fw = new FileWriter("HotelReservations.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					bw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				in = new Scanner(new File("HotelReservations.txt"));
				reservationInfo = new ArrayList<>();
				while (in.hasNextLine()) {
					reservationInfo.add(in.nextLine());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Check if the reservation is for said guest.
	 * @return true if reservation is for said guest.
	 */
	public boolean reservationCheck() {
		boolean status = false;
		for (int i = 1; i < 43; i += 4) {
			if (i >= reservationInfo.size())
				;
			else if (reservationInfo.get(i).equals(currentGuest)) {
				status = true;
			}
		}
		return status;
	}

	private Hotel currentHotel;
}