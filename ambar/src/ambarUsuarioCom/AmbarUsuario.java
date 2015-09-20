package ambarUsuarioCom;


import java.util.ArrayList;


import ambarDao.ConsultaDAO;
import ambarUsuario.UsuarioValue;

/**
 * Clase VideoAndes, que representa la fachada de comunicacin entre
 * la interfaz y la conexin con la base de datos. Atiende todas
 * las solicitudes.
 */
public class AmbarUsuario {


	/**
	 * Conexin con la clase que maneja la base de datos
	 */
	private ConsultaDAO dao;
	

    
    // -----------------------------------------------------------------
    // Singleton
    // -----------------------------------------------------------------

    /**
     * Instancia inica de la clase
     */
    private static AmbarUsuario instancia;
    
    /**
     * Devuelve la instancia inica de la clase
     * @return Instancia nica de la clase
     */
    public static AmbarUsuario darInstancia( )
    {
        if( instancia == null )
        {
            instancia = new AmbarUsuario( );
        }
        return instancia;
    }
	
	/**
	 * contructor de la clase. Inicializa el atributo dao.
	 */
	private AmbarUsuario()
	{
		dao = new ConsultaDAO();
	}
	
	/**
	 * inicializa el dao, dndole la ruta en donde debe encontrar
	 * el archivo properties.
	 * @param ruta ruta donde se encuentra el archivo properties
	 */
	public void inicializarRuta(String ruta)
	{
		dao.inicializar(ruta);
	}
	
    // ---------------------------------------------------
    // Metodos asociados a los casos de uso: Consulta
    // ---------------------------------------------------
    
	/**
	 * mtodo que retorna los videos en orden alfabtico.
	 * invoca al DAO para obtener los resultados.
	 * @return ArrayList lista con los videos ordenados alfabeticamente.
	 * @throws Exception pasa la excepcin generada por el DAO
	 */
	public ArrayList<UsuarioValue> darVideosDefault() throws Exception
	{
	    return dao.darVideosDefault();
	}
	
}
