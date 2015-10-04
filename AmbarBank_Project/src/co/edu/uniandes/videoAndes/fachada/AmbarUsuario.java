package co.edu.uniandes.videoAndes.fachada;

import java.util.ArrayList;


import co.edu.uniandes.videoAndes.vos.UsuarioValue;
import co.edu.uniandes.videoAndes.dao.ConsultaUsuarioDAO;

/**
 * Clase AmbarUsuario, que representa la fachada de comunicacin entre
 * la interfaz y la conexin con la base de datos. Atiende todas
 * las solicitudes.
 */
public class AmbarUsuario
{
	/**
	 * Conexin con la clase que maneja la base de datos
	 */
	private ConsultaUsuarioDAO dao;
	

    
    // -----------------------------------------------------------------
    // Singleton
    // -----------------------------------------------------------------


    /**
     * Instancia inica de la clase
     */
    private static AmbarUsuario instancia;
    
    /**
     * Devuelve la instancia nica de la clase
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
		dao = new ConsultaUsuarioDAO();
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
    // Mtodos asociados a los casos de uso: Consulta
    // ---------------------------------------------------
    
	/**
	 * mtodo que retorna los Usuario en orden alfabtico.
	 * invoca al DAO para obtener los resultados.
	 * @return ArrayList lista con los Usuario ordenados alfabeticamente.
	 * @throws Exception pasa la excepcin generada por el DAO
	 */
	public ArrayList<UsuarioValue> darUsuariosDefault() throws Exception
	{
	    return dao.darUsuariosDefault();
	}
	
}
