package PsJ;

import java.nio.file.Path;

import javax.swing.JOptionPane;

public class Functions {
	
	private String ip;
	private String user;
	private Path path;
	
	/**
	 * @author Jorge R.
	 */
	public Functions(String ip, String user) {
		this.ip=ip;
		this.user=user;
	}
	
	public Functions() {
	
	
	}
	
	public Functions(String ip, String user, Path path) {
		this.ip=ip;
		this.user=user;
		this.setPath(path);
	}
	
	public void RenameItemPS(String ip, String user) {
		String commandRemote = "powershell Rename-Item -path \"\\\\"+ip+"\\c$\\users\\"+user+"\" -NewName \"\\\\"+ip+"\\c$\\users\\"+user+".old\" -force";
		//System.out.println(commandRemote);
		//String command = "powershell Rename-Item -path " + path.toString() + " -NewName "+ path.toString()+".old" + " -force ";
		try {
			Process powerShellProcess = Runtime.getRuntime().exec(commandRemote);
			powerShellProcess.getOutputStream().close();
			//infoExecution.append("Se ha renombrado el perfil de usuario: "+user+" a "+user+".old"+"\n");
			FirstWindow fsFirstWindow = new FirstWindow();
			fsFirstWindow.setinfoExecution("Se ha renombrado el perfil de usuario: "+user+" a "+user+".old"+"\n");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ha Habido un fallo al renombrar la carpeta: "+ user);
			e.getStackTrace();
		}
	}
	
	public void deleteProfile(String ip, String user) {
		//String commandRemote = "powershell \"Get-WmiObject -ComputerName "+ip+" -Class Win32_Userprofile | where {($_.localpath -eq \"c:\\Users\\"+user+"\")}| Remove-WmiObject\"";
		String commandRemote = "powershell -file /PsJ/PerfilW10.ps1+"+ip+" "+user;
		System.out.println(commandRemote);
		//String command = "powershell Rename-Item -path " + path.toString() + " -NewName "+ path.toString()+".old" + " -force ";
		try {
			Process powerShellProcess = Runtime.getRuntime().exec(commandRemote);
			powerShellProcess.getOutputStream().close();
			FirstWindow fsFirstWindow = new FirstWindow();
			fsFirstWindow.setinfoExecution("Se ha borrado el perfil del usuario "+user+".");
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ha Habido un fallo al borrar el perfil del usuario "+ user);
			e.getStackTrace();
		}
	}
	
	public void newItem(String ip, String user) {
		//String commandRemote = "powershell \"Get-WmiObject -ComputerName "+ip+" -Class Win32_Userprofile | where {($_.localpath -eq \"c:\\Users\\"+user+"\")}| Remove-WmiObject\"";
		String commandRemote = "powershell new-Item \"\\\\"+ip+"\\c$\\users\\"+user+"\" -type Directory";
		System.out.println(commandRemote);
		//String command = "powershell Rename-Item -path " + path.toString() + " -NewName "+ path.toString()+".old" + " -force ";
		//New-Item C:\Security\pepe -Type Directory
		try {
			Process powerShellProcess = Runtime.getRuntime().exec(commandRemote);
			powerShellProcess.getOutputStream().close();
			FirstWindow fsFirstWindow = new FirstWindow();
			fsFirstWindow.setinfoExecution("Se ha creado otra carpeta del usuario "+user+".");
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ha Habido un fallo al borrar el perfil del usuario "+ user);
			e.getStackTrace();
		}
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(Path path) {
		this.path = path;
	}

	

}
