package PsJ;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.*;
import java.awt.*;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("unused")
public class FirstWindow {

	private JFrame MainWindow;
	private JTextField enterMachine;
	private JTextField txtUser;
	private JTextArea infoExecution;
	final String ayuda="Este Script nos permite realizar un perfil remoto de W10.\n 1. Ejecutar como adm. \n 2. Introducir IP. \n 3. Introducir iniciales de usuario.";
	
	private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN =
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	
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
		pattern = Pattern.compile(IPADDRESS_PATTERN);
		initialize();
	}
	
	private void initializePS() {
		String command = "powershell.exe Set-ExecutionPolicy Unrestricted CurrentUser -Force";
		try {		
			Process powerShellProcess = Runtime.getRuntime().exec(command);
			powerShellProcess.getOutputStream().close();
			System.out.println("Execution Policy Updated!");
		}
		catch (Exception e){
			
		}
	}
	
	private boolean existePath (Path pathFolder) {
		return Files.exists(pathFolder);
	}
	
	public boolean ipAndUser(final String ip, final String user){
		  matcher = pattern.matcher(ip);
		  if(matcher.matches() && !user.equals("")) {
			  return true;
		  }
		  else {
			  return false;
		  }
	}

	
	


	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		MainWindow = new JFrame();
		MainWindow.setTitle("Perfil W10");
		MainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstWindow.class.getResource("/PsJ/CGP.png")));
		MainWindow.setResizable(false);
		MainWindow.setName("Perfil W10");
		MainWindow.setBounds(100, 100, 762, 133);
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.getContentPane().setLayout(null);
		this.initializePS();
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
				//JOptionPane.showMessageDialog(null,"Send button not active");
				try {
					String ip=enterMachine.getText();
					String user= txtUser.getText();
					System.out.println(user);
					Path path = null;
					
					/**
					 * Aquí compruebo si el formato de la ipv4 es correcto o si no lo es y de si
					 * el usuario es correcto o no lo es. Como premisa, tomamos que el usuario no es vacío.
					 */
					if (ipAndUser(ip, user)) {
						infoExecution.setText("La ip introducida y el usuario con correctos"+"\n");
						path= Paths.get("C:\\Security\\"+user);
					}
					else {
						infoExecution.setText("Ip o user incorrectos. Inténtelo de nuevo"+"\n");
					}
					
					/*-------------------------------------------------------------------------------------*/
					if(existePath(path)) {
						String command = "powershell Rename-Item -path " + path.toString() + " -NewName "+ path.toString()+".old" + " -force ";
						Process powerShellProcess = Runtime.getRuntime().exec(command);
						powerShellProcess.getOutputStream().close();
					}
					else {
						infoExecution.append("La ruta "+ path.toString() +" no existe");
					
					}
					
					//String command = "Rename-Item -path \"\\\\"+ip+"\\c$\\users\\"+user+"\" -NewName \"\\\\$userip\\c$\\users\\$userperf.old\" -force ";
					//Process powerShellProcess = Runtime.getRuntime().exec(command);
					//powerShellProcess.getOutputStream().close();
					/*
					String line,newline = "";
					BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
					while ((line = stdout.readLine()) != null) {
						newline=newline+"\n"+line;
					}
					JOptionPane.showMessageDialog(null, newline.toString());
					stdout.close();
					*/
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		/*----------------------------------------------*/
		JButton CancelButton = new JButton("Cancel");
		CancelButton.setBounds(223, 67, 89, 23);
		MainWindow.getContentPane().add(CancelButton);
		CancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //test
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
		infoExecution = new JTextArea();
		infoExecution.setEditable(false);
		infoExecution.setBounds(423, 11, 322, 79);
		MainWindow.getContentPane().add(infoExecution);
		infoExecution.setColumns(10);
		
	}
}
