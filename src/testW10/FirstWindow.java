package testW10;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class FirstWindow {

	private JFrame MainWindow;
	private JTextField enterMachine;
	private JTextField txtUser;
	private JTextField infoExecution;
	final String ayuda="Este Script nos permite realizar un perfil remoto de W10.\n 1. Ejecutar como adm. \n 2. Introducir IP. \n 3. Introducir iniciales de usuario.";
	//ufffffffffff
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
					window.MainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public FirstWindow() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		MainWindow = new JFrame();
		MainWindow.setTitle("Perfil W10");
		MainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstWindow.class.getResource("/testW10/CGP.png")));
		MainWindow.setResizable(false);
		MainWindow.setName("Perfil W10");
		MainWindow.setBounds(100, 100, 762, 133);
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.getContentPane().setLayout(null);
		/*----------------------------------------------*/
		enterMachine = new JTextField();
		enterMachine.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                enterMachine.setText("");
            }
        });
		enterMachine.setText("Please, enter a valid IP...");
		enterMachine.setBounds(121, 11, 285, 20);
		MainWindow.getContentPane().add(enterMachine);
		enterMachine.setColumns(10);
		
		/*----------------------------------------------*/
		JLabel IPLabel = new JLabel("IP/MACHINE NAME: ");
		IPLabel.setFont(new Font("Tahoma", Font.BOLD, 9));
		IPLabel.setBounds(10, 14, 113, 14);
		MainWindow.getContentPane().add(IPLabel);
		/*----------------------------------------------*/
		JLabel UserLabel = new JLabel("User:  ");
		UserLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		UserLabel.setBounds(10, 39, 46, 14);
		MainWindow.getContentPane().add(UserLabel);
		/*----------------------------------------------*/
		txtUser = new JTextField();
		txtUser.setText("User...");
		txtUser.setBounds(121, 36, 285, 20);
		MainWindow.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		txtUser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtUser.setText("");
            }
        });
		/*----------------------------------------------*/
		JButton SendButton = new JButton("Send");
		SendButton.setBounds(121, 67, 89, 23);
		MainWindow.getContentPane().add(SendButton);
		
		SendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Send button not active"); 
			}
		});
		/*----------------------------------------------*/
		JButton CancelButton = new JButton("Cancel");
		CancelButton.setBounds(223, 67, 89, 23);
		MainWindow.getContentPane().add(CancelButton);
		CancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/*----------------------------------------------*/
		JButton HelpButton = new JButton("Help?");
		HelpButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		HelpButton.setBounds(322, 67, 84, 23);
		MainWindow.getContentPane().add(HelpButton);
		HelpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null,ayuda); 
			}
		});
		/*----------------------------------------------*/
		infoExecution = new JTextField();
		infoExecution.setEditable(false);
		infoExecution.setBounds(423, 11, 322, 79);
		MainWindow.getContentPane().add(infoExecution);
		infoExecution.setColumns(10);
		
	}
}
