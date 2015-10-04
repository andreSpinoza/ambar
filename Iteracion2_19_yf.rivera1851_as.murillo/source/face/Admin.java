package face;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Logic.ConsultaDAO;
import vos.EmpleadoValue;
import vos.UsuarioValue;


public class Admin {
	
	
	
	private static final String ADMIN = "administrador";
	
	
	
	private ConsultaDAO dao;
	
	
	private static Admin instanciaAdmin;
	
	public static Admin darInstancia( )
    {
        if( instanciaAdmin == null )
        {
            instanciaAdmin = new Admin( );
        }
        return instanciaAdmin;
    }
	
	
	
	private Admin()
	{
		dao = new ConsultaDAO();
	}
	
	
	public void agregarUsuario(String email,String nombre, String direccion,String telefono, double cedula,String nacionalidad, String ciudad, String departamento,int codigoP, String rol) throws SQLException
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
	public void agregarPrestamo(double P_ID,double INTERES,double MONTO,String TIPOPRESTAMO, int NUMEROCUOTAS,int DIADEPAGO, double VALORCUOTA, String ESTADO) throws SQLException
	{
		dao.agregarPrestamo(P_ID, INTERES, MONTO, TIPOPRESTAMO,NUMEROCUOTAS,DIADEPAGO,VALORCUOTA,ESTADO );
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
	
	
	
	public boolean esAdmin(String login, String password, String rol) throws SQLException
	{
		boolean res = false;
		
		ArrayList h = dao.BuscarUsuario(rol);
		ArrayList j = dao.BuscarEmpleado(rol);
		
		EmpleadoValue temp = new EmpleadoValue();
		
		if (h.get(0) != null && j.get(0) != null)
		{
		 temp = (EmpleadoValue) j.get(0);
		
		}
		
		String actual = temp.getLogin();
		String actualP = temp.getPassword();
		String cargo = temp.getCargo();
		
		
		if(actual.equals(login) && actualP.equals(password) && cargo.equals(ADMIN))
		{
			
			res = true;
			
		}
			
		
		
		
		
		return res;
	}
	
	
	
	

}
