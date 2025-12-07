package prt1;
/**
 * Classe que representa una categoria de materials.
 * <p>
 * Cada categoria té un identificador, un nom i una descripció.
 * </p>
 * 
 * @author Jannat
 */
public class Categoria {
	private String id;
	private String nombre;
	private String descripcion;
	
	/**
     * Constructor de la classe Categoria.
     * 
     * @param id identificador de la categoria
     * @param nombre nom de la categoria
     * @param descripcion descripció de la categoria
     */
	public Categoria(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/** @return identificador de la categoria */
	public String getId() {
		return id;
	}
	
	/** @return nom de la categoria */
	public String getNombre() {
		return nombre;
	}
	
	/** @return descripció de la categoria */
	public String getDescripcion() {
		return descripcion;
	}

    /**
     * Actualitza la descripció de la categoria.
     * @param descripcion nova descripció
     */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [id:" + id + ", nombre:" + nombre + ", descripcion:" + descripcion + "]";
	}
	

}
