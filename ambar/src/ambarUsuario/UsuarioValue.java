package ambarUsuario;

//Los usuarios son identificados de manera única en el sistema
//mediante su dirección electrónica y existe la restricción
//de que un usuario no puede registrarse con más de una dirección electrónica.

/**
 * Clase Usuario, que representa un Value Object para un usuario
 */
public class UsuarioValue {

	/**
	 * Atributos del usuario
	 */
	private String tipoCedula;
	
	private String nombre;
	
	private String nacionalidad;
	
	private String email;
	
	private String direccion;
	
	private int telefono;
	
	private String ciudad;
	
	private String departamento;
	
	private int postal;
	
	private String rol;
	
	/**
	 * Constructor de la clase. No inicializa ningun atributo.
	 */
	public UsuarioValue()
	{
		
	}

	/**
	 * retorna el isan (identificador universal) del video
	 * @return isan 
	 */
	public String getTipoCedula() {
		return tipoCedula;
	}

	/**
	 * Modifica el isan de un video
	 * @param isan el nuevo isan del video. isan != null
	 */
	public void setTipoCedula(String tipoCedula) {
		this.tipoCedula = tipoCedula;
	}

	/**
	 * retorna el titulo original del video
	 * @return tituloOriginal
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el titulo original del video
	 * @param tituloOriginal el nuevo titulo del video. isan != null
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * retorna el aao de lanzamiento del video
	 * @return anyo
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	/**
	 * Modifica el aao de lanzamiento del video
	 * @param anyo el nuevo aao de lanzamiento. anyo > 0;
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * retorna la duracian en minutos del video
	 * @return duracion
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Modifica la duracian en minutos del video
	 * @param duracion la nueva duracian del video. duracion >= 0
	 */
	public void setEmail(String  email) {
		this. email = email;
	}

	/**
	 * retorna la clasificacian del video
	 * @return clasificacion
	 */
	public String getDireccion() 
	{
		return direccion;
	}

	/**
	 * Modifica la clasificacian de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * retorna la descripcian de clasificacian del video
	 * @return descripcionClasificacion
	 */
	public int getTelefono() {
		return telefono;
	}
	
	/**
	 * Modifica la clasificacian de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * retorna la descripcian de clasificacian del video
	 * @return descripcionClasificacion
	 */
	public int getCiudad() {
		return telefono;
	}
	
	/**
	 * Modifica la clasificacian de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}
	
	
	/**
	 * retorna la descripcian de clasificacian del video
	 * @return descripcionClasificacion
	 */
	public String getDepertamento() {
		return departamento;
	}
	
	/**
	 * Modifica la clasificacian de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setDepertamento(String depertamento)
	{
		this.departamento = depertamento;
	}
	/**
	 * retorna la descripcian de clasificacian del video
	 * @return descripcionClasificacion
	 */
	
	public int getPostal() {
		return postal;
	}
	
	/**
	 * Modifica la clasificacian de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setPostal(int postal)
	{
		this.postal = postal;
	}
	
	public String getRol() {
		return rol;
	}
	
	/**
	 * Modifica la clasificacian de un video
	 * @param clasificacion la nueva clasificacion del video. clasificacion != null
	 */
	public void setRol(String rol)
	{
		this.rol = rol;
	}
		
	

}
