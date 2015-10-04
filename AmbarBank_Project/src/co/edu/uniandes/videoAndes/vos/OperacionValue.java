package co.edu.uniandes.videoAndes.vos;

import java.sql.Date;

public class OperacionValue {
	
	private double idOperacion;
	
	private double cantidad;
	
	private double balanceActual;
	
	private Date fecha;
	
	private boolean done;
	
	private String estado;
	
	private String hora;

	public double getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(double idOperacion) {
		this.idOperacion = idOperacion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getBalanceActual() {
		return balanceActual;
	}

	public void setBalanceActual(double balanceActual) {
		this.balanceActual = balanceActual;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	

}
