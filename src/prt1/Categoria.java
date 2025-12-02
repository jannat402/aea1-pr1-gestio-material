package prt1;

public class Categoria {
	private String id;
	private String nombre;
	private String descripcion;


	// constructor
	public Categoria(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [id:" + id + ", nombre:" + nombre + ", descripcion:" + descripcion + "]";
	}
	

}
