package testW10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HelpWindow {

	private JFrame frame;
	private JTextField HelpField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWindow window = new HelpWindow();
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
	public HelpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		HelpField = new JTextField();
		HelpField.setHorizontalAlignment(SwingConstants.CENTER);
		HelpField.setEditable(false);
		HelpField.setBounds(10, 11, 424, 178);
		frame.getContentPane().add(HelpField);
		HelpField.setColumns(10);
	}

}
