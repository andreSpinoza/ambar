package co.edu.uniandes.videoAndes.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


import co.edu.uniandes.videoAndes.vos.BancoValue;

/**
 * Clase ConsultaDAO, encargada de hacer las consultas bsicas para el cliente
 */
public class ConsultaBancoDAO {

	//----------------------------------------------------
	//Constantes
	//----------------------------------------------------
	/**
	 * ruta donde se encuentra el archivo de conexin.
	 */
	private static final String ARCHIVO_CONEXION = "./WebContent/conexion.properties";
	
	/**
	 * nombre de la tabla Bancos
	 */
	private static final String tablaBanco = "Bancos";
	
	
	/**
	 * nombre de la columna titulo_original en la tabla Bancos.
	 */
	private static final String tipoBanco = "tipo_Banco";
	
	/**
	 * nombre de la columna anyo en la tabla Bancos.
	 */
	private static final String idOp = "idoperacion";
	

	//----------------------------------------------------
	//Consultas
	//----------------------------------------------------
	
	/**
	 * Consulta que devuelve isan, titulo, y ao de los Bancos en orden alfabetico
	 */
	private static final String consultaBancosDefault="SELECT *, FROM "+tablaBanco;
	

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
	 * clave de conexin a la base de datos.
	 */
	private String clave;
	
	/**
	 * URL al cual se debe conectar para acceder a la base de datos.
	 */
	private String cadenaConexion;
	
	/**
	 * constructor de la clase. No inicializa ningun atributo.
	 */
	public ConsultaBancoDAO() 
	{		
		
	}
	
	// -------------------------------------------------
    // Mtodos
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
			File arch = new File(path+ARCHIVO_CONEXION);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream( arch );

	        prop.load( in );
	        in.close( );
     
			cadenaConexion = prop.getProperty("jdbc:oracle:thin:@fn3.oracle.virtual.uniandes.edu.co:1521:prod");	// El url, el usuario y passwd deben estar en un archivo de propiedades.
												// url: "jdbc:oracle:thin:@chie.uniandes.edu.co:1521:chie10";
			usuario = prop.getProperty("ISIS2304321520");	// "s2501aXX";
			clave = prop.getProperty("PRuvpD2dTrxd");	// "c2501XX";
			final String driver = prop.getProperty("oracle.jdbc.driver.OracleDriver");
			Class.forName(driver);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Mtodo que se encarga de crear la conexin con el Driver Manager
	 * a partir de los parametros recibidos.
	 * @param url direccion url de la base de datos a la cual se desea conectar
	 * @param usuario nombre del usuario que se va a conectar a la base de datos
	 * @param clave clave de acceso a la base de datos
	 * @throws SQLException si ocurre un error generando la conexin con la base de datos.
	 */
    private void establecerConexion(String url, String usuario, String clave) throws SQLException
    {
    	try
        {
			conexion = DriverManager.getConnection(url,usuario,clave);
        }
        catch( SQLException exception )
        {
            throw new SQLException( "ERROR: ConsultaDAO obteniendo una conexin." );
        }
    }
    
    /**
 	 *Cierra la conexin activa a la base de datos. Adems, con=null.
     * @param con objeto de conexin a la base de datos
     * @throws SistemaCinesException Si se presentan errores de conexin
     */
    public void closeConnection(Connection connection) throws Exception {        
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			throw new Exception("ERROR: ConsultaDAO: closeConnection() = cerrando una conexin.");
		}
    } 
    
    // ---------------------------------------------------
    // Mtodos asociados a los casos de uso: Consulta
    // ---------------------------------------------------
    
    /**
     * Mtodo que se encarga de realizar la consulta en la base de datos
     * y retorna un ArrayList de elementos tipo BancosValue.
     * @return ArrayList lista que contiene elementos tipo BancosValue.
     * La lista contiene los Bancos ordenados alfabeticamente
     * @throws Exception se lanza una excepcin si ocurre un error en
     * la conexin o en la consulta. 
     */
    public ArrayList<BancoValue> darBancosDefault() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	ArrayList<BancoValue> Bancos = new ArrayList<BancoValue>();
		BancoValue vidValue = new BancoValue();
    	
		try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement(consultaBancosDefault);
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				String tipo= rs.getString(tipoBanco);
				int idOperacion = rs.getInt(idOp);
				
				vidValue.setNombre(tipo);
				vidValue.setIdBanco(idOperacion);
				
				Bancos.add(vidValue);
				vidValue = new BancoValue();
							
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(consultaBancosDefault);
			throw new Exception("ERROR = ConsultaBancoDAO: loadRowsBy(..) Agregando parametros y executando el statement!!!");
		}finally 
		{
			if (prepStmt != null) 
			{
				try {
					prepStmt.close();
				} catch (SQLException exception) {
					
					throw new Exception("ERROR: ConsultaBancoDAO: loadRow() =  cerrando una conexion.");
				}
			}
			closeConnection(conexion);
		}		
		return Bancos;
    }
    
}
