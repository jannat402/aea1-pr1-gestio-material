package prt1;

import java.time.LocalDate;
/**
 * Classe que representa un préstec de material.
 * <p>
 * Conté informació sobre el material prestat, el prestatari, la quantitat,
 * les dates d'inici i devolució, i si ja ha estat retornat.
 * </p>
 * 
 * @author Jannat
 */
public class Prestec {
	private String id;
    private Material material;
    private String prestatario; // nombre del profesor o usuario
    private int cantidad;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolu;
    private boolean devuelto;

    /**
     * Constructor de la classe Prestec.
     * <p>
     * Per defecte, el préstec es crea amb {@code devuelto = false}.
     * </p>
     * 
     * @param id identificador del préstec
     * @param material material prestat
     * @param prestatario nom de l'usuari o professor que rep el préstec
     * @param cantidad quantitat de material prestat
     * @param fechaInicio data d'inici del préstec
     * @param fechaDevolu data prevista de devolució
     */
    public Prestec(String id, Material material, String prestatario, int cantidad, LocalDate fechaInicio,LocalDate fechaDevolu, boolean devuelto) {
		super();
		this.id = id;
		this.material = material;
		this.prestatario = prestatario;
		this.cantidad = cantidad;
		this.fechaInicio = fechaInicio;
		this.fechaDevolu = fechaDevolu;
		this.devuelto = false;
	}

    /** @return identificador del préstec */
	public String getId() {
		return id;
	}
	
    /** @return material prestat */
	public Material getMaterial() {
		return material;
	}

    /** @return nom del prestatari */
	public String getPrestatario() {
		return prestatario;
	}

    /** @return quantitat de material prestat */
	public int getCantidad() {
		return cantidad;
	}

    /** @return data d'inici del préstec */
	public LocalDate getDataInici() {
		return fechaInicio;
	}

    /** @return data prevista de devolució */
	public LocalDate getFechaDevolu() {
		return fechaDevolu;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

    /** @return true si el préstec ja ha estat retornat */
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
