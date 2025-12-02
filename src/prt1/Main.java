package prt1;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// Crear repositorio y servicio
		InventariRepository repo = new InventariRepository();
		InventariService service = new InventariService(repo);

		// Crear categorías
		Categoria portatils = new Categoria("C1", "Portátiles", "Ordenadores portátiles");
		Categoria impresoras = new Categoria("C2", "Impresoras", "Impresoras láser y tinta");

		// Registrar materiales
		service.registrarNuevoMaterial("M1", "Dell XPS", "Portátil de gama alta", portatils, 10);
		service.registrarNuevoMaterial("M2", "HP LaserJet", "Impresora láser", impresoras, 5);

		// Listar materiales
		System.out.println("=== Materials disponibles ===");
		for (Material m : service.llistarMaterials()) {
			System.out.println(m);
		}

		// Registrar un préstamo
		System.out.println("\n=== Registrar préstec ===");
		boolean prestecOk = service.ferPrestec("P1", "M1", "Professor Joan", 2, LocalDate.now(), 7);
		System.out.println("Préstec creat? " + prestecOk);

		// Listar préstamos
		System.out.println("\n=== Préstecs registrats ===");
		for (Prestec p : service.llistarPrestecs()) {
			System.out.println(p);
		}

		// Retornar préstamo
		System.out.println("\n=== Retornar préstec ===");
		boolean retornOk = service.retornarPrestec("P1");
		System.out.println("Préstec retornat? " + retornOk);

		// Listar materiales después de devolución
		System.out.println("\n=== Materials després de retorn ===");
		for (Material m : service.llistarMaterials()) {
			System.out.println(m);
		}
	}
}


