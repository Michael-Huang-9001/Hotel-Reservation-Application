import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUp_Page {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public SignUp_Page() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Create Your Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 464, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Create Your Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// notify user that account is created and take them back to
				// login
				// check if passwords the same
				if (Arrays.equals(passwordField_1.getPassword(), passwordField.getPassword())) {
					if (!textField_5.getText().trim().matches("[0-9]+") || textField_5.getText().trim().length() < 7) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid phone number with numbers only.");
					} else if (passwordField.getPassword().length <= 7) {
						JOptionPane.showMessageDialog(frame,
								"Please enter a password that is 7 characters or longer for your security.");
					} else if (!textField_8.getText().trim().matches("[0-9]+")
							|| textField_8.getText().trim().length() < 5) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid zip code.");
					} else if (textField_3.getText().trim().isEmpty() || textField_4.getText().trim().isEmpty()
							|| textField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()
							|| textField_5.getText().trim().isEmpty() || textField_6.getText().trim().isEmpty()
							|| textField_7.getText().trim().isEmpty() || textField_8.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please fill out all fields before continuing.");
					} else {
						Guest newGuest = new Guest(textField_3.getText(), textField_4.getText(), textField.getText(),
								HuffmanTree.huff(passwordField.getText()), textField_5.getText(), textField_6.getText(),
								textField_7.getText(), textField_8.getText());
						saveGuest(newGuest.toString());
						JOptionPane.showMessageDialog(frame, "Account created. Please login.");
						frame.dispose();
						Login_Page1 lP = new Login_Page1();
						lP.signUpInit();
					}
				} else {
					// Notify user of incorrect
					JOptionPane.showMessageDialog(frame, "Passwords do not match.");
				}

				// create a new guest and print to string to a new file
				// Send user back to reservation system.
			}

		});
		btnNewButton.setBounds(293, 380, 161, 48);
		panel.add(btnNewButton);

		textField_5 = new JTextField();
		textField_5.setBounds(221, 90, 180, 20); // phone
		panel.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(221, 69, 85, 14);
		panel.add(lblPhoneNumber);

		textField_6 = new JTextField();
		textField_6.setBounds(221, 150, 180, 20); // street
		panel.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblAddress = new JLabel("Street Address");
		lblAddress.setBounds(221, 125, 105, 14);
		panel.add(lblAddress);

		textField_7 = new JTextField();
		textField_7.setBounds(220, 210, 181, 20); // state
		panel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblState = new JLabel("City/State");
		lblState.setBounds(221, 191, 100, 14);
		panel.add(lblState);

		textField_8 = new JTextField();
		textField_8.setBounds(221, 270, 180, 20); // zip
		panel.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(221, 245, 85, 14);
		panel.add(lblZipCode);

		// Code below is a repeat of user email.

		/**
		 * textField_9 = new JTextField(); textField_9.setBounds(221, 330, 180,
		 * 20); panel.add(textField_9); textField_9.setColumns(10);
		 * 
		 * 
		 * JLabel lblEmail_Address = new JLabel("Email Address");
		 * lblEmail_Address.setBounds(221, 305, 85, 14);
		 * panel.add(lblEmail_Address);
		 **/

		textField = new JTextField();
		textField.setBounds(20, 90, 180, 20); // email
		panel.add(textField);
		textField.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(20, 270, 180, 20); // first name
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(20, 330, 180, 20); // last name
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(20, 66, 113, 20);
		panel.add(lblEmailAddress);

		JLabel lblPassword = new JLabel("Password (7 characters or more)");
		lblPassword.setBounds(20, 125, 213, 14);
		panel.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(20, 191, 113, 14);
		panel.add(lblConfirmPassword);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(20, 245, 65, 14);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(20, 305, 65, 14);
		panel.add(lblLastName);

		passwordField = new JPasswordField();
		passwordField.setBounds(20, 150, 180, 20);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(20, 210, 180, 20);
		panel.add(passwordField_1);
	}

	private void saveGuest(String newGuest) {
		File file = new File("UserInformation.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter("UserInformation.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(newGuest);
				bw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter("UserInformation.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(newGuest);
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}