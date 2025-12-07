package prt1;

import java.time.LocalDate;
import java.util.List;
/**
 * Classe de servei que conté la lògica de negoci de l'inventari.
 * <p>
 * Gestiona l'alta de materials, la creació de préstecs i la devolució.
 * </p>
 * 
 * @author Jannat
 */
public class InventariService {
	private InventariRepository repositorio;

    /**
     * Constructor de la classe InventariService.
     * @param repositorio repositori a utilitzar
     */
	public InventariService(InventariRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	/**
     * Registra un nou material.
     */
	public void registrarNuevoMaterial(String id, String nombre, String descripcion, Categoria categoria, int cantidadInicial) {
		Material material = new Material(id,nombre,descripcion, categoria,cantidadInicial);
		repositorio.afegirMaterial(material);
	}
	
	/**
	 * Busca un material pel seu identificador.
	 * <p>
	 * Aquest mètode crida al repositori intern per obtenir el material.
	 * </p>
	 * 
	 * @param id identificador del material
	 * @return el material si existeix, null en cas contrari
	 */
	public Material obtenirMaterialPerId(String id) {
	    return repositorio.buscarMaterialPorId(id);
	}
	
	/**
     * Registra un préstec d'un material.
     */
	public boolean ferPrestec(String idPrestec, String idMaterial, String prestatari,
			int quantitat, LocalDate dataInici, int diesDurada) {

		Material material = repositorio.buscarMaterialPorId(idMaterial);
		if (material == null) {
			return false;
		}

		boolean reduit = material.disminuirCantidad(quantitat);
		if (!reduit) {
			return false;
		}

		LocalDate dataFiPrevista = dataInici.plusDays(diesDurada);
		Prestec prestec = new Prestec(idPrestec, material, prestatari,quantitat, dataInici, dataFiPrevista, reduit);
		repositorio.afegirPrestec(prestec);
		return true;
	}
	
	 /**
     * Marca un préstec com retornat.
     */
	public boolean retornarPrestec(String idPrestec) {
		Prestec prestec = repositorio.buscraPrestamoPorId(idPrestec);
		if (prestec == null) {
			return false;
		}

		if (prestec.isDevuelto()) {
			return false;
		}

		Material material = prestec.getMaterial();
		material.aumentarCantidad(prestec.getCantidad());
		prestec.marcarComoDevuelto();;
		return true;
	}
	
	/** @return llista de materials */
	public List<Material> llistarMaterials() {
		return repositorio.obtenerTodosLosMateriales();
	}

	   /** @return llista de préstecs */
	public List<Prestec> llistarPrestecs() {
		return repositorio.obtenerTodosLosPrestamos();


	}

}
