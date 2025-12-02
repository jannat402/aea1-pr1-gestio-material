package prt1;

public class Material {
	private String id;
	private String nombre;
	private String descripcion;
	private Categoria categoria;
	private int cantidadDisponible;


	// constructor
	public Material(String id, String nombre, String descripcion, Categoria categoria, int cantidadDisponible) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.cantidadDisponible = cantidadDisponible;
	}

	// getters 
	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	// funcion que ira sumando cuantas uninades disponibles tengo
	public void aumentarCantidad(int unidades) {                          
		if (unidades > 0) { // si el nuemor de uninades es mas grande que 0 se añadira
			this.cantidadDisponible += unidades;
		}
	}
	
	// funcion que ira restando el numero de uninades no disponibles 
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
