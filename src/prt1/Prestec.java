package prt1;

import java.time.LocalDate;

public class Prestec {
	private String id;
    private Material material;
    private String prestatario; // nombre del profesor o usuario
    private int cantidad;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolu;
    private boolean devuelto;
	
    // constructor 
    public Prestec(String id, Material material, String prestatario, int cantidad, LocalDate fechaInicio,LocalDate fechaDevolu) {
		super();
		this.id = id;
		this.material = material;
		this.prestatario = prestatario;
		this.cantidad = cantidad;
		this.fechaInicio = fechaInicio;
		this.fechaDevolu = fechaDevolu;
		this.devuelto = false;
	}

    //getters 
	public String getId() {
		return id;
	}

	public Material getMaterial() {
		return material;
	}

	public String getPrestatario() {
		return prestatario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public LocalDate getDataInici() {
		return fechaInicio;
	}

	public LocalDate getFechaDevolu() {
		return fechaDevolu;
	}

	public boolean isDevuelto() {
		return devuelto;
	}
	
	// metodo para poner que esta devuelto
	public void marcarComoDevuelto() {
		this.devuelto = true;
	}

	@Override
	public String toString() {
		return "Prestamo [id:" + id + ", material:" + material.getNombre() + ", prestatario:" + prestatario + ", cantidad:"
				+ cantidad + ", fechaInicio:" + fechaInicio + ", fechaDevolu:" + fechaDevolu + ", devuelto:" + devuelto
				+ "]";
	}

	
    
    
    
    

}
