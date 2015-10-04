package co.edu.uniandes.videoAndes.dao;

import java.io.File;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import co.edu.uniandes.videoAndes.vos.UsuarioValue;

/**
 * Clase ConsultaDAO, encargada de hacer las consultas basicas para el cliente
 */
public class ConsultaUsuarioDAO {

	//----------------------------------------------------
	//Constantes
	//----------------------------------------------------
	/**
	 * ruta donde se encuentra el archivo de conexion.
	 */
	private static final String ARCHIVO_CONEXION = "/../conexion.properties";
	
	/**
	 * nombre de la tabla videos
	 */
	private static final String tablaUsuario = "usuarios";
	
	
	/**
	 * nombre de la columna nombre_usuario en la tabla Usuarios
	 */
	private static final String nombreUsuario = "nombre_usuario";
	
	/**
	 * nombre de la columna tipo en la tabla Usuarios
	 */
	private static final String postal = "postal";
	

	//----------------------------------------------------
	//Consultas
	//----------------------------------------------------
	
	/**
	 * Consulta que devuelve isan, titulo, y aao de los videos en orden alfabetico
	 */
	private static final String consultaUsuariosDefault="SELECT *, FROM "+tablaUsuario;
	

	//----------------------------------------------------
	//Atributos
	//----------------------------------------------------
	/**
	 * conexion con la base de datos
	 */
	public Connection conexion;
	
	/**
	 * nombre del usuario para conectarse a la base de datos.
	 */
	private String usuario;
	
	/**
	 * clave de conexion a la base de datos.
	 */
	private String clave;
	
	/**
	 * URL al cual se debe conectar para acceder a la base de datos.
	 */
	private String cadenaConexion;
	
	/**
	 * constructor de la clase. No inicializa ningun atributo.
	 */
	public ConsultaUsuarioDAO() 
	{		
		
	}
	
	// -------------------------------------------------
    // Motodos
    // -------------------------------------------------

	/**
	 * obtiene ls datos necesarios para establecer una conexion
	 * Los datos se obtienen a partir de un archivo properties.
	 * @param path ruta donde se encuentra el archivo properties.
	 */
	public void inicializar(String path)
	{
		try
		{
			File arch= new File(path+ARCHIVO_CONEXION);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream( arch );

	        prop.load( in );
	        in.close( );
	        

			cadenaConexion = prop.getProperty("url");	// El url, el usuario y passwd deben estar en un archivo de propiedades.
												// url: "jdbc:oracle:thin:@chie.uniandes.edu.co:1521:chie10";
			usuario = prop.getProperty("usuario");	// "ISIS2304321520";
			clave = prop.getProperty("clave");	// "PRuvpD2dTrxd";
			final String driver = prop.getProperty("driver");
			Class.forName(driver);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Motodo que se encarga de crear la conexion con el Driver Manager
	 * a partir de los parametros recibidos.
	 * @param url direccion url de la base de datos a la cual se desea conectar
	 * @param usuario nombre del usuario que se va a conectar a la base de datos
	 * @param clave clave de acceso a la base de datos
	 * @throws SQLException si ocurre un error generando la conexion con la base de datos.
	 */
    private void establecerConexion(String url, String usuario, String clave) throws SQLException
    {
    	try
        {
			conexion = DriverManager.getConnection(url,usuario,clave);
        }
        catch( SQLException exception )
        {
            throw new SQLException( "ERROR: ConsultaDAO obteniendo una conexion." );
        }
    }
    
    /**
 	 *Cierra la conexion activa a la base de datos. Ademos, con=null.
     * @param con objeto de conexion a la base de datos
     * @throws SistemaCinesException Si se presentan errores de conexion
     */
    public void closeConnection(Connection connection) throws Exception {        
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			throw new Exception("ERROR: ConsultaDAO: closeConnection() = cerrando una conexion.");
		}
    } 
    
    // ---------------------------------------------------
    // Motodos asociados a los casos de uso: Consulta
    // ---------------------------------------------------
    
    /**
     * Motodo que se encarga de realizar la consulta en la base de datos
     * y retorna un ArrayList de elementos tipo VideosValue.
     * @return ArrayList lista que contiene elementos tipo VideosValue.
     * La lista contiene los videos ordenados alfabeticamente
     * @throws Exception se lanza una excepcion si ocurre un error en
     * la conexion o en la consulta. 
     */
    public ArrayList<UsuarioValue> darUsuariosDefault() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	ArrayList<UsuarioValue> us = new ArrayList<UsuarioValue>();
    	UsuarioValue usValue = new UsuarioValue();
    	
		try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement(consultaUsuariosDefault);
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				String nombreUs = rs.getString(nombreUsuario);
				int postalUS = rs.getInt(postal);
				
				usValue.setNombre(nombreUs);
				usValue.setPostal(postalUS);	
			
				us.add(usValue);
				usValue = new UsuarioValue();
							
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(consultaUsuariosDefault);
			throw new Exception("ERROR = ConsultaDAO: loadRowsBy(..) Agregando parametros y executando el statement!!!");
		}finally 
		{
			if (prepStmt != null) 
			{
				try {
					prepStmt.close();
				} catch (SQLException exception) {
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexion.");
				}
			}
			closeConnection(conexion);
		}		
		return us;
    }
    
}
