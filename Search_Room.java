import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Search_Room implements ActionListener {

	public JButton singleOnlyButton = new JButton();
	public JButton doubleOnlyButton = new JButton();
	public JButton deluxeOnlyButton = new JButton();
	public JButton presOnlyButton = new JButton();
	private JButton backButton = new JButton();

	public JButton single1 = new JButton();
	public JButton single2 = new JButton();
	public JButton single3 = new JButton();
	public JButton single4 = new JButton();
	public JButton single5 = new JButton();

	public JButton double1 = new JButton();
	public JButton double2 = new JButton();
	public JButton double3 = new JButton();

	public JButton deluxe1 = new JButton();
	public JButton deluxe2 = new JButton();

	public JButton presidentialSuite = new JButton();

	public JButton showAllButton = new JButton();
	public JButton button[];

	private JFrame frame;

	private HotelRoom[] currentHotelRooms;
	private Hotel cHotel;

	public String selectedRoom = "";
	private String currentGuest;
	private ReservationSystem rSystem;
	private ArrayList<String> rInfo;
	private JFrame rFrame;

	private int sDay;
	private int sYear = 2016;
	private int eDay;
	private int eYear;
	private String sMonth;
	private String eMonth;
	private String cRoom;

	Date sDate;
	Date eDate;

	JComboBox<String> startingDayCombo;
	JComboBox<String> startingMonthCombo;
	JComboBox<String> startingYearCombo;

	JComboBox<String> endingDayCombo;
	JComboBox<String> endingMonthCombo;
	JComboBox<String> endingYearCombo;

	final DefaultComboBoxModel<String> days = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" });

	final DefaultComboBoxModel<String> eDays = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" });

	final DefaultComboBoxModel<String> days2 = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" });

	final DefaultComboBoxModel<String> eDays2 = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" });

	final DefaultComboBoxModel<String> ifFeb = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" });

	final DefaultComboBoxModel<String> eIfFeb = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" });

	final DefaultComboBoxModel<String> leapYear = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" });

	final DefaultComboBoxModel<String> eLeapYear = new DefaultComboBoxModel<String>(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" });

	String startingMonth;
	String startingDay;
	String startingYear;
	String startingDate;

	String endingMonth;
	String endingDay;
	String endingYear;
	String endingDate;

	/**
	 * Create the application.
	 * 
	 * @param currentHotel
	 * @param system
	 * @param reservationInfo
	 * @param frame2
	 */
	public Search_Room(Hotel currentHotel, String guest, ReservationSystem system, ArrayList<String> reservationInfo,
			JFrame frame2) {
		cHotel = currentHotel;
		rSystem = system;
		rInfo = reservationInfo;
		currentHotelRooms = currentHotel.getRooms();
		currentGuest = guest;
		rFrame = frame2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Browse Rooms",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Book Antiqua", Font.PLAIN, 15), new Color(0, 0, 0)));
		panel.setBounds(10, 11, 664, 576);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// SINGLE ROOMS

		JButton single1 = new JButton("Single1");
		single1.setBounds(10, 120, 200, 30);
		panel.add(single1);
		single1.toString();
		single1.addActionListener(this);

		JButton single2 = new JButton("New button");
		single2.setBounds(10, 161, 200, 30);
		panel.add(single2);
		single2.toString();
		single2.addActionListener(this);

		JButton single3 = new JButton("New button");
		single3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		single3.setBounds(10, 202, 200, 30);
		panel.add(single3);
		single3.toString();
		single3.addActionListener(this);

		JButton single4 = new JButton("New button");
		single4.setBounds(10, 243, 200, 30);
		panel.add(single4);
		single4.toString();
		single4.addActionListener(this);

		JButton single5 = new JButton("New button");
		single5.setBounds(10, 284, 200, 30);
		panel.add(single5);
		single5.toString();
		single5.addActionListener(this);

		// DOUBLE ROOMS

		JButton double1 = new JButton("New button");
		double1.setBounds(10, 325, 200, 30);
		panel.add(double1);
		double1.toString();
		double1.addActionListener(this);

		JButton double2 = new JButton("New button");
		double2.setBounds(10, 366, 200, 30);
		panel.add(double2);
		double2.toString();
		double2.addActionListener(this);

		JButton double3 = new JButton("New button");
		double3.setBounds(10, 407, 200, 30);
		panel.add(double3);
		double3.toString();
		double3.addActionListener(this);

		// DELUXE ROOMS

		JButton deluxe1 = new JButton("New button");
		deluxe1.setBounds(10, 448, 200, 30);
		panel.add(deluxe1);
		deluxe1.toString();
		deluxe1.addActionListener(this);

		JButton deluxe2 = new JButton("New button");
		deluxe2.setBounds(10, 489, 200, 30);
		panel.add(deluxe2);
		deluxe2.toString();
		deluxe2.addActionListener(this);

		// PRESIDENTIAL SUITE

		JButton presidentialSuite = new JButton("Presidential Suite");
		presidentialSuite.setBounds(10, 530, 200, 30);
		panel.add(presidentialSuite);
		presidentialSuite.toString();
		presidentialSuite.addActionListener(this);

		JButton buttons[] = { single1, single2, single3, single4, single5, double1, double2, double3, deluxe1, deluxe2,
				presidentialSuite };

		button = Arrays.copyOf(buttons, buttons.length);
		for (int j = 0; j < buttons.length; j++) {
			if (currentHotelRooms[j].getAvailability() == true) {
				buttons[j].setText(currentHotelRooms[j].toString());
				buttons[j].setVisible(true);
			} else
				buttons[j].setVisible(false);
		}

		singleOnlyButton = new JButton("Single Only");
		singleOnlyButton.setBounds(10, 50, 120, 40);
		panel.add(singleOnlyButton);
		singleOnlyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == singleOnlyButton) {
					// set visibility of everything but single to false
					for (int i = 0; i < buttons.length; i++) {
						if (currentHotelRooms[i].getRoomType() == 0 && currentHotelRooms[i].getAvailability() == true) {
							buttons[i].setVisible(true);
							buttons[i].setText(currentHotelRooms[i].toString());
						} else
							buttons[i].setVisible(false);
					}

				}
			}
		});

		doubleOnlyButton = new JButton("Double Only");
		doubleOnlyButton.setBounds(135, 50, 120, 40);
		panel.add(doubleOnlyButton);
		doubleOnlyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttons.length; i++) {
					if (currentHotelRooms[i].getRoomType() == 1 && currentHotelRooms[i].getAvailability() == true) {
						buttons[i].setText(currentHotelRooms[i].toString());
						buttons[i].setVisible(true);
					} else
						buttons[i].setVisible(false);
				}
			}
		});

		/**
		 * JButton buttons[] = {single1, single2, single3, single4, single5,
		 * double1, double2, double3, deluxe1, deluxe2, presidentialSuite};
		 **/

		// DISPLAYS DELUXE ROOMS ONLY
		deluxeOnlyButton = new JButton("Deluxe Only");
		deluxeOnlyButton.setBounds(260, 50, 120, 40);
		panel.add(deluxeOnlyButton);
		deluxeOnlyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttons.length; i++) {
					if (currentHotelRooms[i].getRoomType() == 2 && currentHotelRooms[i].getAvailability() == true) {
						buttons[i].setText(currentHotelRooms[i].toString());
						buttons[i].setVisible(true);
					} else
						buttons[i].setVisible(false);
				}
			}
		});

		// DISPLAYS PRESIDENTIAL SUITE ONLY
		JButton presOnlyButton = new JButton("Pres. Only");
		presOnlyButton.setBounds(385, 50, 120, 40);
		panel.add(presOnlyButton);
		presOnlyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int m = 0; m < buttons.length; m++) {
					buttons[m].setVisible(false);
					if (m == buttons.length - 1 && currentHotelRooms[m].getRoomType() == 3
							&& currentHotelRooms[m].getAvailability() == true)
						buttons[m].setVisible(true);
				}
			}
		});
		showAllButton = new JButton("Show All");
		showAllButton.setBounds(385, 100, 120, 40);
		panel.add(showAllButton);

		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttons.length; i++) {
					if (currentHotelRooms[i].getAvailability() == true) {
						buttons[i].setText(currentHotelRooms[i].toString());
						buttons[i].setVisible(true);
					} else
						buttons[i].setVisible(false);
				}
			}
		});

		backButton = new JButton("Back");
		backButton.setBounds(515, 515, 120, 40);
		panel.add(backButton);
		backButton.setVisible(true);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rFrame.setVisible(true);
			}

		});

		button = Arrays.copyOf(buttons, buttons.length);

		String[] sortBy = { "Ascending Room", "Descending Room", "Ascending Price", "Descending Price",
				"Ascending Type", "Descending Type" };
		JComboBox comboBox = new JComboBox(sortBy);
		comboBox.setBounds(515, 60, 139, 20);
		panel.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Object item = comboBox.getSelectedItem();
				if (item.equals("Ascending Room")) {
					cHotel.sort(0);
					currentHotelRooms = cHotel.getRooms();
					for (int i = 0; i < buttons.length; i++) {
						buttons[i].setText(currentHotelRooms[i].toString());
						buttons[i].setVisible(true);
						button = Arrays.copyOf(buttons, buttons.length);
					}
				} else if (item.equals("Descending Room")) {
					cHotel.sort(1);
					currentHotelRooms = cHotel.getRooms();
					for (int i = 0; i < buttons.length; i++) {
						if (currentHotelRooms[i].getAvailability() == true) {
							buttons[i].setText(currentHotelRooms[i].toString());
							buttons[i].setVisible(true);
							button = Arrays.copyOf(buttons, buttons.length);
						} else
							buttons[i].setVisible(false);
					}
				} else if (item.equals("Ascending Price")) {
					cHotel.sort(2);
					currentHotelRooms = cHotel.getRooms();
					for (int i = 0; i < buttons.length; i++) {
						if (currentHotelRooms[i].getAvailability() == true) {
							buttons[i].setText(currentHotelRooms[i].toString());
							buttons[i].setVisible(true);
							button = Arrays.copyOf(buttons, buttons.length);
						} else
							buttons[i].setVisible(false);
					}
				} else if (item.equals("Descending Price")) {
					cHotel.sort(3);
					currentHotelRooms = cHotel.getRooms();
					for (int i = 0; i < buttons.length; i++) {
						if (currentHotelRooms[i].getAvailability() == true) {
							buttons[i].setText(currentHotelRooms[i].toString());
							buttons[i].setVisible(true);
							button = Arrays.copyOf(buttons, buttons.length);
						} else
							buttons[i].setVisible(false);
						;
					}
				} else if (item.equals("Ascending Type")) {
					cHotel.sort(4);
					currentHotelRooms = cHotel.getRooms();
					for (int i = 0; i < buttons.length; i++) {
						if (currentHotelRooms[i].getAvailability() == true) {
							buttons[i].setText(currentHotelRooms[i].toString());
							buttons[i].setVisible(true);
							button = Arrays.copyOf(buttons, buttons.length);
						} else
							buttons[i].setVisible(false);
					}
				} else if (item.equals("Descending Type")) {
					cHotel.sort(5);
					currentHotelRooms = cHotel.getRooms();
					for (int i = 0; i < buttons.length; i++) {
						if (currentHotelRooms[i].getAvailability() == true) {
							buttons[i].setText(currentHotelRooms[i].toString());
							buttons[i].setVisible(true);
							button = Arrays.copyOf(buttons, buttons.length);
						} else
							buttons[i].setVisible(false);
					}
				}

			}
		});

		JLabel startingMonthLabel = new JLabel("Month");
		startingMonthLabel.setBounds(260, 202, 120, 30);
		panel.add(startingMonthLabel);

		JLabel startingDayLabel = new JLabel("Day");
		startingDayLabel.setBounds(385, 202, 120, 30);
		panel.add(startingDayLabel);

		JLabel startingYearLabel = new JLabel("Year");
		startingYearLabel.setBounds(515, 202, 120, 30);
		panel.add(startingYearLabel);

		JLabel startingDateLabel = new JLabel("Starting Date");
		startingDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startingDateLabel.setBounds(260, 161, 180, 30);
		panel.add(startingDateLabel);

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		JComboBox startingMonthCombo = new JComboBox(months);
		startingMonthCombo.setBounds(260, 248, 120, 20);
		panel.add(startingMonthCombo);
		startingMonthCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// month of february
				if (startingMonthCombo.getSelectedItem() == "February") {
					startingDayCombo.setModel(ifFeb);
				}

				// Months with 31 days
				if (startingMonthCombo.getSelectedItem() == "January" || startingMonthCombo.getSelectedItem() == "March"
						|| startingMonthCombo.getSelectedItem() == "May"
						|| startingMonthCombo.getSelectedItem() == "July"
						|| startingMonthCombo.getSelectedItem() == "August"
						|| startingMonthCombo.getSelectedItem() == "October"
						|| startingMonthCombo.getSelectedItem() == "December") {
					startingDayCombo.setModel(days);
				}

				// Months with 30 days
				if (startingMonthCombo.getSelectedItem() == "April" || startingMonthCombo.getSelectedItem() == "June"
						|| startingMonthCombo.getSelectedItem() == "September"
						|| startingMonthCombo.getSelectedItem() == "November") {
					startingDayCombo.setModel(days2);
				}

				int year = (int) startingYearCombo.getSelectedItem();
				// leap year and February selection
				if (startingMonthCombo.getSelectedItem() == "February" && year % 4 == 0) {
					startingDayCombo.setModel(leapYear);
				}
				sMonth = (String) startingMonthCombo.getSelectedItem();
			}
		});

		startingDayCombo = new JComboBox(days);
		startingDayCombo.setBounds(385, 248, 120, 20);
		panel.add(startingDayCombo);
		startingDayCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sDay = Integer.valueOf(((String) startingDayCombo.getSelectedItem()).trim());
			}
		});

		Integer[] years = { 2016, 2017, 2018, 2019, 2020 };
		startingYearCombo = new JComboBox(years);
		startingYearCombo.setBounds(515, 248, 120, 20);
		panel.add(startingYearCombo);
		startingYearCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sYear = (int) startingYearCombo.getSelectedItem();

			}
		});

		// Labels
		
		JLabel endingDateLabel = new JLabel("Ending Date");
		endingDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		endingDateLabel.setBounds(260, 346, 120, 30);
		panel.add(endingDateLabel);

		JLabel endingMonthLabel = new JLabel("Month");
		endingMonthLabel.setBounds(260, 382, 120, 30);
		panel.add(endingMonthLabel);

		JLabel endingDayLabel = new JLabel("Day");
		endingDayLabel.setBounds(385, 382, 120, 30);
		panel.add(endingDayLabel);

		JLabel lblNewLabel = new JLabel("Year");
		lblNewLabel.setBounds(515, 382, 120, 30);
		panel.add(lblNewLabel);

		endingMonthCombo = new JComboBox(months);
		endingMonthCombo.setBounds(260, 423, 120, 20);
		panel.add(endingMonthCombo);
		endingMonthCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// month of february
				if (endingMonthCombo.getSelectedItem() == "February") {
					endingDayCombo.setModel(eIfFeb);
				}

				// Months with 31 days
				if (endingMonthCombo.getSelectedItem() == "January" || endingMonthCombo.getSelectedItem() == "March"
						|| endingMonthCombo.getSelectedItem() == "May" || endingMonthCombo.getSelectedItem() == "July"
						|| endingMonthCombo.getSelectedItem() == "August"
						|| endingMonthCombo.getSelectedItem() == "October"
						|| endingMonthCombo.getSelectedItem() == "December") {
					endingDayCombo.setModel(eDays);
				}

				// Months with 30 days
				if (endingMonthCombo.getSelectedItem() == "April" || endingMonthCombo.getSelectedItem() == "June"
						|| endingMonthCombo.getSelectedItem() == "September"
						|| endingMonthCombo.getSelectedItem() == "November") {
					endingDayCombo.setModel(eDays2);
				}

				int year1 = (int) endingYearCombo.getSelectedItem();
				// leap year and February selection
				if (endingMonthCombo.getSelectedItem() == "February" && year1 % 4 == 0) {
					endingDayCombo.setModel(eLeapYear);
				}
				eMonth = (String) endingMonthCombo.getSelectedItem();
			}
		});

		endingDayCombo = new JComboBox(days2);
		endingDayCombo.setBounds(385, 423, 120, 20);
		panel.add(endingDayCombo);
		endingDayCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eDay = Integer.valueOf(((String) endingDayCombo.getSelectedItem()));

			}
		});

		endingYearCombo = new JComboBox(years);
		endingYearCombo.setBounds(515, 423, 120, 20);
		panel.add(endingYearCombo);
		endingYearCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eYear = (int) endingYearCombo.getSelectedItem();
			}
		});

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		if (sMonth == null) {
			sMonth = "January";
		}
		if (eMonth == null) {
			eMonth = "January";
		}
		if (eDay == 0)
			eDay = 1;
		if (sDay == 0)
			sDay = 1;
		if (sYear < 2016)
			sYear = 2016;
		if (eYear < 2016)
			eYear = 2016;
		try {
			cal.setTime(new SimpleDateFormat("MMM").parse(sMonth));
			sDate = new Date(cal.get(Calendar.MONTH), sDay, sYear);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			cal2.setTime(new SimpleDateFormat("MMM").parse(eMonth));
			eDate = new Date(cal2.get(Calendar.MONTH), eDay, eYear);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (sDate == null || eDate == null)
			JOptionPane.showMessageDialog(frame, "Please set a proper date.");
		else if ((sDate.compareTo(eDate) > 0 || sDate.daysBetween(sDate, eDate) == 0)) {
			JOptionPane.showMessageDialog(frame, "Please set a proper date.");
		} else {
			int reply = JOptionPane.showConfirmDialog(frame, "Reserve this room?");
			if (reply == JOptionPane.YES_OPTION) {
				Object source = e.getSource();
				JButton bN = (JButton) source;
				System.out.println(bN.getText());
				JOptionPane.showMessageDialog(frame, "Room reserved! Returning to main menu.");
				frame.setVisible(false);
				System.out.println(cRoom = bN.getText().substring(6, 8).trim());

				for (int i = 0; i < button.length; i++) {
					if (source == button[i])
						cHotel.setAvailability(Integer.parseInt(cRoom), false);
				}

				Reservation nRese = new Reservation(currentGuest);

				try {
					cal.setTime(new SimpleDateFormat("MMM").parse(sMonth));
					nRese.setStartDate(cal.get(Calendar.MONTH), sDay, sYear);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					cal.setTime(new SimpleDateFormat("MMM").parse(eMonth));
					nRese.setEndDate(cal.get(Calendar.MONTH), eDay, eYear);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < button.length; i++) {
					if (source == button[i]) {
						nRese.setRoom(currentHotelRooms[Integer.parseInt(cRoom)]);
					}
				}

				rInfo.add(nRese.toString());
				cHotel.saveRoomAvailability();
				cHotel.loadRoomAvailability();
				rSystem.saveChangesToReservations(rInfo);
				rSystem.loadReservations();
				rFrame.setVisible(true);
			}
		}
	}
}