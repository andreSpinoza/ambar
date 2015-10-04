package co.edu.uniandes.videoAndes.dao;

import java.io.File;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import co.edu.uniandes.videoAndes.vos.OperacionValue;

/**
 * Clase ConsultaDAO, encargada de hacer las consultas basicas para el cliente
 */
public class ConsultaOperacionDAO {

	//----------------------------------------------------
	//Constantes
	//----------------------------------------------------
	/**
	 * ruta donde se encuentra el archivo de conexion.
	 */
	private static final String ARCHIVO_CONEXION = "/../conexion.properties";
	
	/**
	 * nombre de la tabla Operaciones
	 */
	private static final String tablaOperacion = "Operaciones";
	
	
	/**
	 * nombre de la columna nombre_Operacion en la tabla Operacions
	 */
	private static final String nombreOperacion = "nombre_Operacion";
	
	/**
	 * nombre de la columna tipo en la tabla Operacions
	 */
	private static final String cantidad = "cantidad";
	

	//----------------------------------------------------
	//Consultas
	//----------------------------------------------------
	
	/**
	 * Consulta que devuelve isan, titulo, y aao de los Operaciones en orden alfabetico
	 */
	private static final String consultaOperacionesDefault="SELECT *, FROM "+tablaOperacion;
	

	//----------------------------------------------------
	//Atributos
	//----------------------------------------------------
	/**
	 * conexion con la base de datos
	 */
	public Connection conexion;
	
	/**
	 * nombre del Operacion para conectarse a la base de datos.
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
	public ConsultaOperacionDAO() 
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
	        

			cadenaConexion = prop.getProperty("url");	// El url, el Operacion y passwd deben estar en un archivo de propiedades.
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
	 * @param Operacion nombre del Operacion que se va a conectar a la base de datos
	 * @param clave clave de acceso a la base de datos
	 * @throws SQLException si ocurre un error generando la conexion con la base de datos.
	 */
    private void establecerConexion(String url, String Operacion, String clave) throws SQLException
    {
    	try
        {
			conexion = DriverManager.getConnection(url,Operacion,clave);
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
     * y retorna un ArrayList de elementos tipo OperacionesValue.
     * @return ArrayList lista que contiene elementos tipo OperacionesValue.
     * La lista contiene los Operaciones ordenados alfabeticamente
     * @throws Exception se lanza una excepcion si ocurre un error en
     * la conexion o en la consulta. 
     */
    public ArrayList<OperacionValue> darOperacionesDefault() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	ArrayList<OperacionValue> Operaciones = new ArrayList<OperacionValue>();
    	OperacionValue usValue = new OperacionValue();
    	
		try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement(consultaOperacionesDefault);
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				String nombreUs = rs.getString(nombreOperacion);
				int cantidadUs = rs.getInt(cantidad);
				
				usValue.setEstado(nombreUs);
				usValue.setCantidad(cantidadUs);
			
				Operaciones.add(usValue);
				usValue = new OperacionValue();
							
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(consultaOperacionesDefault);
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
		return Operaciones;
    }
    
}
