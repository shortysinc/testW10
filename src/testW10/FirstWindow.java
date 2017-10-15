package testW10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import javax.swing.JLabel;
import java.awt.Font;

public class FirstWindow {

	private JFrame frame;
	private JTextField enterMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
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
	public FirstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setName("testW10");
		frame.setBounds(100, 100, 477, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		enterMachine = new JTextField();
		enterMachine.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                enterMachine.setText("");
            }
        });
		enterMachine.setText("Please, enter a valid IP...");
		enterMachine.setBounds(121, 11, 330, 20);
		frame.getContentPane().add(enterMachine);
		enterMachine.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("IP/MACHINE NAME: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel.setBounds(10, 14, 113, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
