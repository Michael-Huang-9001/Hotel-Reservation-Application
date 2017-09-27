import java.awt.EventQueue;

/**
 * The starting frame class.
 */
public class Index {
	public static void main(String... args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page1 window = new Login_Page1();
					window.activate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}