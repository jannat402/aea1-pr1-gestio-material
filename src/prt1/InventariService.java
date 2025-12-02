package prt1;

import java.time.LocalDate;
import java.util.List;

public class InventariService {
	private InventariRepository repositorio;

	//constructor
	public InventariService(InventariRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	public void registrarNuevoMaterial(String id, String nombre, String descripcion, Categoria categoria, int cantidadInicial) {
		Material material = new Material(id,nombre,descripcion, categoria,cantidadInicial);
		repositorio.afegirMaterial(material);
	}

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
		Prestec prestec = new Prestec(idPrestec, material, prestatari,quantitat, dataInici, dataFiPrevista);
		repositorio.afegirPrestec(prestec);
		return true;
	}

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


	public List<Material> llistarMaterials() {
		return repositorio.obtenerTodosLosMateriales();
	}


	public List<Prestec> llistarPrestecs() {
		return repositorio.obtenerTodosLosPrestamos();


	}

}
