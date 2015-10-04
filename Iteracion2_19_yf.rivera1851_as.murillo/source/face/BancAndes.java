package face;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.UsuarioValue;
import Logic.ConsultaDAO;

public class BancAndes {
	
	
	private ConsultaDAO dao;

	private static BancAndes instancia;
	
	public static BancAndes darInstancia( )
    {
        if( instancia == null )
        {
            instancia = new BancAndes( );
        }
        return instancia;
    }
	
	
	private BancAndes()
	{
		dao = new ConsultaDAO();
	}
	
	public void agregarUsuario(String email,String nombre, String direccion,String telefono, int cedula,String nacionalidad, String ciudad, String departamento,int codigoP, String rol) throws SQLException
	{
		dao.agregarUsuario(email, nombre, direccion, telefono, cedula, nacionalidad, ciudad, departamento, codigoP, rol);
	}
	
	public void agregarOficina(double P_ID,String NOMBRE,String DIRECCION,String TELEFONO, double IDPUNTO) throws SQLException
	{
		dao.agregarOficina(P_ID, NOMBRE, DIRECCION, TELEFONO, IDPUNTO);
	}
	
	public void agregarPuntoA(double P_ID,String TIPO,String UBICACION) throws SQLException
	{
		dao.agregarPuntoA(P_ID, TIPO, UBICACION);
	}
	
	public void agregarCuenta(double P_ID,double BALANCE,double SALDO,double LIMITERETIRO,String TIPOCUENTA,double IDOPERACION,double IDMONEDA,String CLIENTE) throws SQLException
	{
		dao.agregarCuenta(P_ID, BALANCE, SALDO, LIMITERETIRO, TIPOCUENTA, IDOPERACION, IDMONEDA, CLIENTE);
	}
	public void updateCuenta(double P_ID,double BALANCE,double SALDO,double LIMITERETIRO,String TIPOCUENTA,double IDOPERACION,double IDMONEDA,String CLIENTE) throws SQLException
	{
		dao.updateCuenta(P_ID, BALANCE, SALDO, LIMITERETIRO, TIPOCUENTA, IDOPERACION, IDMONEDA, CLIENTE);
	}
	public void agregarOperacion(double P_ID,int CANTIDAD,double BALANCEACTUAL,Date FECHA,String ESTADO,String HORA, double idCuenta) throws SQLException
	{
		dao.agregarOperacion(P_ID, CANTIDAD, BALANCEACTUAL, FECHA, ESTADO, HORA, idCuenta);
	}
	public void cerrarCuenta(double P_ID) throws SQLException
	{
		dao.cerrarCuenta(P_ID);
	}
	public void agregarPrestamo(double P_ID, double INTERES, double MONTO,String TIPOPRESTAMO, int NUMEROCUOTAS,int DIADEPAGO, double VALORCUOTA, String ESTADO) throws SQLException
	{
		
		dao.agregarPrestamo(P_ID, INTERES, MONTO, TIPOPRESTAMO, NUMEROCUOTAS,DIADEPAGO, VALORCUOTA, ESTADO);
	}
	public void updateOperacion(double P_ID,double CANTIDAD,double BALANCEACTUAL,Date FECHA,String ESTADO,String HORA) throws SQLException
	{
		dao.updateOperacion(P_ID, CANTIDAD, BALANCEACTUAL, FECHA, ESTADO, HORA);
	}
	public void cerrarPrestamo(double P_ID) throws SQLException
	{
		dao.cerrarPrestamo(P_ID);
	}
	public ArrayList consultarCuenta(String select,String filtro, String dato, String ordenamiento) throws SQLException
	{
		return dao.consultarCuenta(select, filtro, dato, ordenamiento);
	}
	public ArrayList consultarCliente(String select,String filtro, String dato, String ordenamiento) throws SQLException
	{
		return dao.consultarCliente(select, filtro, dato, ordenamiento);
	}
	public ArrayList consultarClientes() throws SQLException
	{
		return dao.consultarClientes();
	}
	public ArrayList consultarCuentas() throws SQLException
	{
		return dao.consultarCuentas();
	}
	
	public static void main(String[] args) throws SQLException {
		
		BancAndes nueva = new BancAndes().darInstancia();
		
		ArrayList clientes = nueva.consultarClientes();
		
		nueva.agregarOficina(11, "NOMBRE", "DIRECCION", "TELEFONO", 2);
		nueva.agregarUsuario("email", "nombre", "direccion", "telefono", 987, "nacionalidad", 
				"ciudad", "departamento", 11111,"l");
		
		System.out.println("yeah");
		
		
	}
	
}
