import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class Login_Page1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private Scanner in;
	private String email;
	private String pass;
	private String inputEmail;
	private String inputPassword;
	private String user;
	private StringBuilder userInfo = new StringBuilder();
	private ArrayList<String> infoArray = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page1 window = new Login_Page1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This is the starting point of the application. When the log in screen is
	 * created, it will try to read from a file. If no file is found then the
	 * user is forced to create an account. You must create an account in order
	 * to reach the main menu.
	 */
	public Login_Page1() {
		initialize();
		try {
			File file = new File("UserInformation.txt");
			if (file.exists()) {
				in = new Scanner(new File("UserInformation.txt"));

				loadGuestInformation();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Used to return to the log in screen from whatever frame.
	 */
	public void signUpInit() {
		initialize();
		Login_Page1 window = new Login_Page1();
		window.frame.setVisible(true);
	}
	
	public void activate() {
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. Logging in will send the user to
	 * ReservationSystem.java. This RS is just the main menu.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login ");
		lblLogin.setBounds(200, 26, 114, 27);
		frame.getContentPane().add(lblLogin);

		textField = new JTextField();
		textField.setBounds(133, 96, 191, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblUsername = new JLabel("Email");
		lblUsername.setBounds(47, 96, 70, 20);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(47, 127, 70, 20);
		frame.getContentPane().add(lblPassword);

		// Login button. Click to move to the next screen.
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(133, 158, 70, 38);
		frame.getContentPane().add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// if password == password2 and email and they match up with
				// database, then log in.
				if (verificationTest() == true) {
					JOptionPane.showMessageDialog(frame, "Logging in..");
					frame.dispose();
					ReservationSystem rSystem = new ReservationSystem(user);
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid information.");
				}
			}
		});

		// Password area. Taken as string to be compared to file.
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 127, 191, 20);
		frame.getContentPane().add(passwordField);

		// Should be omitted.
		JButton btnForgotPassword = new JButton("forgot password?");
		btnForgotPassword.setSize(50, 50);
		btnForgotPassword.setBounds(233, 158, 140, 27);
		frame.getContentPane().add(btnForgotPassword);

		btnForgotPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = JOptionPane.showInputDialog(frame,
						"Enter your email. We will send you a password reset.", null);
			}
		});

		// Takes the user to a new screen to put in new information.
		JButton btnSignup = new JButton("Sign-Up");
		btnSignup.setBounds(233, 182, 140, 27);
		frame.getContentPane().add(btnSignup);
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SignUp_Page sPage = new SignUp_Page();
			}
		});
	}

	/**
	 * Get email and password from guest information.
	 */
	public void loadGuestInformation() {
		int i = 1;

		while (in.hasNextLine()) {
			if (i == 1) {
				user = in.nextLine();
				infoArray.add(user);
				i++;
			}
			if (i == 2) {
				email = in.nextLine();
				infoArray.add(email);
				i++;
			} else if (i == 3) {
				pass = in.nextLine();
				infoArray.add(pass);
				i++;
			} else if (i == 8) {
				in.nextLine();
				i = 1;
			} else {
				in.nextLine();
				i++;
			}
		}
	}

	/**
	 * A validation method for user info for log in.
	 * 
	 * @return if validation succeeded.
	 */
	public boolean verificationTest() {
		boolean vTest = false;
		for (int i = 0; i < infoArray.size(); i += 3) {
			if (infoArray.get(i + 1).toLowerCase().trim().equals(textField.getText().toLowerCase().trim())
					&& infoArray.get(i + 2).trim().equals(HuffmanTree.huff(passwordField.getText().trim()))) {
				user = infoArray.get(i);
				vTest = true;
			}
		}
		return vTest;
	}

}