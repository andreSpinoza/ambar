/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VideosValue.java,v 1.0 
 * Universidad de los Andes (Bogot - Colombia)
 * Departamento de Ingeniera de Sistemas y Computacin 
 *
 * Ejercicio: VideoAndes
 * Autor: Juan Diego Toro - 10-Feb-2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.videoAndes.vos;

/**
 * Clase VideosValue, que representa un Value Object para un video
 */
public class VideosValue 
{
	/**
	 * Identificador universal del video
	 */
	private String isan;
	
	/**
	 * titulo original del video
	 */
	private String tituloOriginal;
	
	/**
	 * ao de lanzamiento
	 */
	private int anyo;
	
	/**
	 * duracion en minutos
	 */
	private int duracion;
	
	/**
	 * clasificacion del video
	 */
	private String clasificacion;
	
	/**
	 * descripcion de la clasificacion
	 */
	private String descripcionClasificacion;
	
	/**
	 * Constructor de la clase. No inicializa ningun atributo.
	 */
	public VideosValue()
	{
		
	}

	/**
	 * retorna el isan (identificador universal) del video
	 * @return isan 
	 */
	public String getIsan() {
		return isan;
	}

	/**
	 * Modifica el isan de un video
	 * @param isan el nuevo isan del video. isan != null
	 */
	public void setIsan(String isan) {
		this.isan = isan;
	}

	/**
	 * retorna el titulo original del video
	 * @return tituloOriginal
	 */
	public String getTituloOriginal() {
		return tituloOriginal;
	}

	/**
	 * Modifica el titulo original del video
	 * @param tituloOriginal el nuevo titulo del video. isan != null
	 */
	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	/**
	 * retorna el ao de lanzamiento del video
	 * @return anyo
	 */
	public int getAnyo() {
		return anyo;
	}
	
	/**
	 * Modifica el ao de lanzamiento del video
	 * @param anyo el nuevo ao de lanzamiento. anyo > 0;
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	/**
	 * retorna la duracin en minutos del video
	 * @return duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * Modifica la duracin en minutos del video
	 * @param duracion la nueva duracin del video. duracion >= 0
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * retorna la clasificacin del video
	 * @return clasificacion
	 */
	public String getClasificacion() 
	{
		return clasificacion;
	}

	/**
	 * Modifica la clasificacin de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * retorna la descripcin de clasificacin del video
	 * @return descripcionClasificacion
	 */
	public String getDescripcionClasificacion() {
		return descripcionClasificacion;
	}

	/**
	 * Modifica la descripcin de la clasificacin de un video
	 * @param descripcionClasificacion la nueva descripcin de la 
	 * clasificacin del video. descripcionClasificacin != null
	 */
	public void setDescripcionClasificacion(String descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}
	
	

}
