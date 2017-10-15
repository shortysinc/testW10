package testW10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HelpWindow {

	private JFrame frmHelp;
	private JTextField HelpField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWindow window = new HelpWindow();
					window.frmHelp.setVisible(true);
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
		frmHelp = new JFrame();
		frmHelp.setTitle("Help?");
		frmHelp.setIconImage(Toolkit.getDefaultToolkit().getImage(HelpWindow.class.getResource("/testW10/CGP.png")));
		frmHelp.setResizable(false);
		frmHelp.setBounds(100, 100, 450, 229);
		frmHelp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHelp.getContentPane().setLayout(null);
		
		HelpField = new JTextField();
		HelpField.setHorizontalAlignment(SwingConstants.CENTER);
		HelpField.setEditable(false);
		HelpField.setBounds(10, 11, 424, 139);
		frmHelp.getContentPane().add(HelpField);
		HelpField.setColumns(10);
		
		JButton CloseButton = new JButton("Close");
		CloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		CloseButton.setBounds(10, 162, 424, 23);
		frmHelp.getContentPane().add(CloseButton);
	}

}
