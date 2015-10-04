package co.edu.uniandes.videoAndes.fachada;

import java.util.ArrayList;


import co.edu.uniandes.videoAndes.dao.ConsultaPuntoAttDAO;
import co.edu.uniandes.videoAndes.vos.PuntoAttValue;

/**
 * Clase AmbarPuntoAtt, que representa la fachada de comunicacin entre
 * la interfaz y la conexin con la base de datos. Atiende todas
 * las solicitudes.
 */
public class AmbarPuntoAtt {


	/**
	 * Conexin con la clase que maneja la base de datos
	 */
	private ConsultaPuntoAttDAO dao;
	

    
    // -----------------------------------------------------------------
    // Singleton
    // -----------------------------------------------------------------


    /**
     * Instancia inica de la clase
     */
    private static AmbarPuntoAtt instancia;
    
    /**
     * Devuelve la instancia nica de la clase
     * @return Instancia nica de la clase
     */
    public static AmbarPuntoAtt darInstancia( )
    {
        if( instancia == null )
        {
            instancia = new AmbarPuntoAtt( );
        }
        return instancia;
    }
	
	/**
	 * contructor de la clase. Inicializa el atributo dao.
	 */
	private AmbarPuntoAtt()
	{
		dao = new ConsultaPuntoAttDAO();
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
	 * mtodo que retorna los videos en orden alfabtico.
	 * invoca al DAO para obtener los resultados.
	 * @return ArrayList lista con los videos ordenados alfabeticamente.
	 * @throws Exception pasa la excepcin generada por el DAO
	 */
	public ArrayList<PuntoAttValue> darPuntoAttsDefault() throws Exception
	{
	    return dao.darPuntoAttsDefault();
	}
	
}


