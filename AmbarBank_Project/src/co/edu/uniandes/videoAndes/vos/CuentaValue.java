package co.edu.uniandes.videoAndes.vos;

public class CuentaValue extends UsuarioValue {
	
private double idCuenta;

private double idCliente;

private double balance;

private double saldo;

private double limiteRetiro;

private String tipoCuenta;

public double getIdCuenta() {
	return idCuenta;
}

public void setIdCuenta(double idCuenta) {
	this.idCuenta = idCuenta;
}

public double getIdCliente() {
	return idCliente;
}

public void setIdCliente(double idCliente) {
	this.idCliente = idCliente;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public double getSaldo() {
	return saldo;
}

public void setSaldo(double saldo) {
	this.saldo = saldo;
}

public double getLimiteRetiro() {
	return limiteRetiro;
}

public void setLimiteRetiro(double limiteRetiro) {
	this.limiteRetiro = limiteRetiro;
}

public String getTipoCuenta() {
	return tipoCuenta;
}

public void setTipoCuenta(String tipoCuenta) {
	this.tipoCuenta = tipoCuenta;
}


	
	

}
