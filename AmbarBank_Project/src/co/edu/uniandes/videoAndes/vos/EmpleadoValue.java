package co.edu.uniandes.videoAndes.vos;

public class EmpleadoValue extends UsuarioValue {
	
	
	private double idEmpleado;
	
	private String login;
	
	private String password;
	
	private String cargo;

	public double getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(double idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	

}
