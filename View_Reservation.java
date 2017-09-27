import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class View_Reservation implements ActionListener {

	private JFrame frame;
	private JFrame menu;
	private Hotel cHotel;
	private String cGuest;
	private ReservationSystem rSystem;
	private ArrayList<String> rInfo;
	private JFrame rFrame;
	private HotelRoom[] currentHotelRooms;
	public JButton button[];
	String rNumber = " ";

	/**
	 * Create the application.
	 * 
	 * @param reservationInfo
	 * @param system
	 * @param currentGuest
	 * @param currentHotel
	 * @param frame2
	 */
	public View_Reservation(Hotel currentHotel, String currentGuest, ReservationSystem system,
			ArrayList<String> reservationInfo, JFrame frame2) {
		cHotel = currentHotel;
		currentHotelRooms = cHotel.getRooms();
		cGuest = currentGuest;
		rSystem = system;
		rInfo = reservationInfo;
		menu = frame2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "View Reservation",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Book Antiqua", Font.PLAIN, 20), new Color(0, 0, 0)));
		panel.setBounds(10, 11, 464, 419);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel reservationLabel = new JLabel("Reservation Details");
		reservationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reservationLabel.setVerticalAlignment(SwingConstants.TOP);
		reservationLabel.setBounds(10, 50, 200, 248);
		panel.add(reservationLabel);
		reservationLabel.toString();

		JButton backButton = new JButton("Back");
		backButton.setBounds(200, 383, 120, 25);
		panel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				frame.setVisible(false);
			}
		});

		JButton single1 = new JButton();
		single1.setBounds(10, 120, 200, 30);
		panel.add(single1);
		single1.toString();
		single1.addActionListener(this);

		JButton single2 = new JButton();
		single2.setBounds(10, 161, 200, 30);
		panel.add(single2);
		single2.toString();
		single2.addActionListener(this);

		JButton single3 = new JButton();
		single3.setBounds(10, 202, 200, 30);
		panel.add(single3);
		single3.toString();
		single3.addActionListener(this);

		JButton single4 = new JButton();
		single4.setBounds(10, 243, 200, 30);
		panel.add(single4);
		single4.toString();
		single4.addActionListener(this);

		JButton single5 = new JButton();
		single5.setBounds(10, 284, 200, 30);
		panel.add(single5);
		single5.toString();
		single5.addActionListener(this);

		// DOUBLE ROOMS

		JButton double1 = new JButton();
		double1.setBounds(250, 120, 200, 30);
		panel.add(double1);
		double1.toString();
		double1.addActionListener(this);

		JButton double2 = new JButton();
		double2.setBounds(250, 161, 200, 30);
		panel.add(double2);
		double2.toString();
		double2.addActionListener(this);

		JButton double3 = new JButton();
		double3.setBounds(250, 202, 200, 30);
		panel.add(double3);
		double3.toString();
		double3.addActionListener(this);

		// DELUXE ROOMS

		JButton deluxe1 = new JButton();
		deluxe1.setBounds(250, 243, 200, 30);
		panel.add(deluxe1);
		deluxe1.toString();
		deluxe1.addActionListener(this);

		JButton deluxe2 = new JButton();
		deluxe2.setBounds(250, 284, 200, 30);
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

		for (int button = 0; button < buttons.length; button++)
			buttons[button].setVisible(false);

		button = Arrays.copyOf(buttons, buttons.length);
		for (int j = 0; j < button.length; j++) {
			if (j >= rInfo.size()) {
				buttons[j].setVisible(false);
			} else if ((4 * j) + 1 < rInfo.size()) {
				if (rInfo.get((4 * j) + 1).equals(cGuest) == true) {
					String info = rInfo.get((4 * j) + 2);
					info = info.substring(5, info.length());
					String rNum = "Room: " + rInfo.get(4 * j);
					buttons[j].setText("<html>" + rNum + "<br/>" + info + "<html>");
					buttons[j].setVisible(true);
				}
			} else
				buttons[j].setVisible(false);

		}

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int reply = JOptionPane.showConfirmDialog(frame, "Cancel this reservation?");
		if (reply == JOptionPane.YES_OPTION) {
			Object source = e.getSource();
			JButton bN = (JButton) source;
			String[] res = new String[1];

			JOptionPane.showMessageDialog(frame, "Reservation cancelled.");
			for (int i = 0; i < button.length; i++) {
				if (source == button[i]) {
					res = button[i].getText().split("<br/>");
					rNumber = res[0].substring(res[0].length() - 2, res[0].length()).trim();
					cHotel.setAvailability(Integer.parseInt(rNumber), true);

					button[i].setVisible(false);
				}
			}

			for (int k = 0; k < rInfo.size(); k++) {
				if (rInfo.get(k).equals(rNumber) == true) {
					rInfo.remove(k);
					rInfo.remove(k);
					rInfo.remove(k);
					rInfo.remove(k);
				}
			}

			cHotel.saveRoomAvailability();
			cHotel.loadRoomAvailability();
			rSystem.saveChangesToReservations(rInfo);
			rSystem.loadReservations();

		}
	}

}