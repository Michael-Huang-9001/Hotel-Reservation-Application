import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main_Menu {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu window = new Main_Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Menu() {
		initialize();
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
		// PMingLiu
		// Batang
		// Book Antiqua
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hotel Reservation System",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Book Antiqua", Font.PLAIN, 20), new Color(0, 0, 0)));
		panel.setBounds(10, 11, 464, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Make Reservation");
		btnNewButton.setBounds(10, 60, 175, 40);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View Reservation\r\n");
		btnNewButton_1.setBounds(10, 140, 175, 40);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Search Rooms\r\n");
		btnNewButton_2.setBounds(10, 220, 175, 40);
		panel.add(btnNewButton_2);
	}
}