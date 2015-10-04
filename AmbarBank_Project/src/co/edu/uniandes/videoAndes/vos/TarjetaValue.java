package co.edu.uniandes.videoAndes.vos;

import java.sql.Date;

public class TarjetaValue {
	
private int numeroTarjeta;

private Date fechaEx;

private String clave;

private String nombreDueno;

private String nombreBanco;

public int getNumeroTarjeta() {
	return numeroTarjeta;
}

public void setNumeroTarjeta(int numeroTarjeta) {
	this.numeroTarjeta = numeroTarjeta;
}

public Date getFechaEx() {
	return fechaEx;
}

public void setFechaEx(Date fechaEx) {
	this.fechaEx = fechaEx;
}

public String getClave() {
	return clave;
}

public void setClave(String clave) {
	this.clave = clave;
}

public String getNombreDueno() {
	return nombreDueno;
}

public void setNombreDueno(String nombreDueno) {
	this.nombreDueno = nombreDueno;
}

public String getNombreBanco() {
	return nombreBanco;
}

public void setNombreBanco(String nombreBanco) {
	this.nombreBanco = nombreBanco;
}








}
