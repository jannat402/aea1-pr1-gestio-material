package prt1;
/**
 * Classe que representa un material dins l'inventari.
 * <p>
 * Conté informació com l'identificador, nom, descripció, categoria i quantitat disponible.
 * Permet augmentar o disminuir la quantitat disponible de material.
 * </p>
 * 
 * @author Jannat
 */
public class Material {
	private String id;
	private String nombre;
	private String descripcion;
	private Categoria categoria;
	private int cantidadDisponible;

	 /**
     * Constructor de la classe Material.
     * 
     * @param id identificador únic del material
     * @param nombre nom del material
     * @param descripcion descripció del material
     * @param categoria categoria a la qual pertany
     * @param cantidadDisponible quantitat inicial disponible
     */
	public Material(String id, String nombre, String descripcion, Categoria categoria, int cantidadDisponible) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.cantidadDisponible = cantidadDisponible;
	}

    /** @return identificador del material */
	public String getId() {
		return id;
	}
    
	/** @return nom del material */
	public String getNombre() {
		return nombre;
	}
	
	/** @return descripció del material */
	public String getDescripcion() {
		return descripcion;
	}
	
    /** @return categoria del material */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
    * Augmenta la quantitat disponible.
    * @param unidades nombre d'unitats a afegir (ha de ser > 0)
    */
	public void aumentarCantidad(int unidades) {                          
		if (unidades > 0) { // si el nuemor de uninades es mas grande que 0 se añadira
			this.cantidadDisponible += unidades;
		}
	}
	
	 /**
     * Disminueix la quantitat disponible.
     * @param unidades nombre d'unitats a retirar
     * @return true si s'ha pogut disminuir, false si no hi havia prou unitats
     */
	public boolean disminuirCantidad(int unidades) {
		if (unidades > 0 && unidades <= cantidadDisponible) {// si el numero es menor a 0 y ademas es mas pequeño o igual a la cantidad disponible
			// se restara
			this.cantidadDisponible -= unidades;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Material [id:" + id + ", nombre:" + nombre + ", descripcion:" + descripcion + ", categoria:" + categoria.getNombre()
				+ ", cantidadDisponible:" + cantidadDisponible + "]";
	}

	
	



}
