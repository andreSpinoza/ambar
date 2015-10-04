package Logic;
import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vos.EmpleadoValue;
import vos.UsuarioValue;

public class ConsultaDAO {
	
	
	
	private static Connection con;
		
		private String usuario;
		
		private String clave;
		
		public ConsultaDAO() {
			
		}
		
		public void conexionBancAndes()
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = null;
			try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@fn3.oracle.virtual.uniandes.edu.co:1521:prod","ISIS2304321520","PRuvpD2dTrxd");
			}
			catch (SQLException i)
			{
			i.printStackTrace();
			}
			}
		
		private void establecerCon (String url, String usuario, String clave) throws SQLException
	    {
	    	try
	        {
				con = DriverManager.getConnection(url,usuario,clave);
	        }
	        catch( SQLException exception )
	        {
	            throw new SQLException( "ERROR" );
	        }
	    }
		
		public void closeCon () throws Exception
		{
			if (con != null)
			{
				try{ 
				con.close();
				con = null;
				}catch (SQLException exception) {
					throw new Exception("ERROR");
				}
			}
		}
		
		public void closeConnection(Connection connection) throws Exception {        
			try {
				connection.close();
				connection = null;
			} catch (SQLException exception) {
				throw new Exception("ERROR");
			}
	    } 
		
		
		public void agregarUsuario(String email,String nombre, String direccion,String telefono, double cedula,String nacionalidad, String ciudad, String departamento,int codigoP, String rol) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into USUARIO values('"+email+"','"+nombre+"','"+direccion+"','"+telefono+"','"+cedula+"','"+nacionalidad+"','"+ciudad+"','"+departamento+"','"+codigoP+"','"+rol+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void agregarOficina(double P_ID,String NOMBRE,String DIRECCION,String TELEFONO, double IDPUNTO) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into oficina values('"+P_ID+"','"+NOMBRE+"','"+DIRECCION+"','"+TELEFONO+"','"+IDPUNTO+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void agregarPuntoA(double P_ID,String TIPO,String UBICACION) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into PUNTODEATENCION values('"+P_ID+"','"+TIPO+"','"+UBICACION+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void agregarCuenta(double P_ID,double BALANCE,double SALDO,double LIMITERETIRO,String TIPOCUENTA,double IDOPERACION,double IDMONEDA,String CLIENTE) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into cuenta values('"+P_ID+"','"+BALANCE+"','"+SALDO+"','"+LIMITERETIRO+"','"+TIPOCUENTA+"','"+IDOPERACION+"','"+IDMONEDA+"','"+CLIENTE+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void updateCuenta(double P_ID,double BALANCE,double SALDO,double LIMITERETIRO,String TIPOCUENTA,double IDOPERACION,double IDMONEDA,String CLIENTE) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update cuenta set balance = '"+BALANCE+"', SALDO = '"+SALDO+"', LIMITERETIRO = '"+LIMITERETIRO+"',TIPOCUENTA = '"+TIPOCUENTA+"',IDOPERACION = '"+IDOPERACION+"', IDMONEDA = '"+IDMONEDA+"' ,CLIENTE = '"+CLIENTE+"' where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void agregarOperacion(double P_ID,int CANTIDAD,double BALANCEACTUAL,Date FECHA,String ESTADO,String HORA, double idCuenta) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into operacion values('"+P_ID+"','"+CANTIDAD+"','"+BALANCEACTUAL+"','"+FECHA+"','"+ESTADO+"','"+HORA+"','"+idCuenta+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void cerrarCuenta(double P_ID) throws SQLException
		{
			
			String cerrada = "CERRADA";
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update cuenta set TIPOCUENTA = '"+cerrada+"'where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void agregarPrestamo(double P_ID, double INTERES, double MONTO,String TIPOPRESTAMO, int NUMEROCUOTAS,int DIADEPAGO, double VALORCUOTA, String ESTADO) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into prestamo values('"+P_ID+"','"+INTERES+"','"+MONTO+"','"+TIPOPRESTAMO+"','"+NUMEROCUOTAS+"','"+DIADEPAGO+"','"+VALORCUOTA+"','"+ESTADO+"',)";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void updateOperacion(double P_ID,double CANTIDAD,double BALANCEACTUAL,Date FECHA,String ESTADO,String HORA) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update operacion set cantidad = '"+CANTIDAD+"', balanceactual = '"+BALANCEACTUAL+"', fecha = '"+FECHA+"',estado = '"+ESTADO+"',hora = '"+HORA+"' where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		public void cerrarPrestamo(double P_ID) throws SQLException
		{
			
			String cerrado = "CERRADO";
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update prestamo set ESTADO = '"+cerrado+"'where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		
		
		public ArrayList consultarCuenta(String select,String filtro, String dato, String ordenamiento) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select '"+select+"' from cuenta where  '"+filtro+"' =  '"+dato+"' group by '"+select+"' order by '"+ordenamiento+"'" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		
		public ArrayList consultarCliente(String select,String filtro, String dato, String ordenamiento) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select '"+select+"' from cliente where  '"+filtro+"' =  '"+dato+"' group by '"+select+"' order by '"+ordenamiento+"'" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		
		public ArrayList consultarClientes() throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from cliente" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
			
			
		
		public ArrayList consultarCuentas() throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from cuenta" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		
		
		public ArrayList BuscarUsuario(String rol) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from usuario where P_ID = '"+rol+"' " ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
			
			while(rs.next())
			{
			
				UsuarioValue nuevo = new UsuarioValue();
				nuevo.setEmail(rs.getString(0));
				nuevo.setNombre(rs.getString(1));
				nuevo.setDireccion(rs.getString(2));
				nuevo.setTelefono(rs.getString(3));
				nuevo.setCedula(rs.getDouble(4));
				nuevo.setNacionalidad(rs.getString(5));
				nuevo.setCiudad(rs.getString(6));
				nuevo.setDepartamento(rs.getString(7));
				nuevo.setCodigoPostal(rs.getString(8));
				nuevo.setRol(rs.getString(9));
				
				
				respuesta.add(nuevo);
				
				
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		public ArrayList BuscarEmpleado(String rol) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from empleado where idusuario = '"+rol+"' " ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
			
			while(rs.next())
			{
			
				EmpleadoValue nuevo = new EmpleadoValue();
				nuevo.setIdEmpleado(rs.getDouble(0));
				nuevo.setLogin(rs.getString(1));
				nuevo.setPassword(rs.getString(2));
				nuevo.setCargo(rs.getString(3));
				nuevo.setIdoficina(rs.getDouble(4));
				nuevo.setIdusuario(rs.getDouble(5));
				
				
				respuesta.add(nuevo);
				
				
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		public static void main(String[] args) throws SQLException {
			
			ConsultaDAO nueva = new ConsultaDAO();
			
			ArrayList pepe = nueva.consultarCuentas();
			
			System.out.println(pepe);
			
			nueva.agregarOficina(13, "prueba","prueba desde eclipse", "1234", 11);
			
			nueva.agregarUsuario("email", "nombre", "direccion", "telefono", 987, "nacionalidad", 
					"ciudad", "departamento", 1,"admin");
			
		}
		
		}
