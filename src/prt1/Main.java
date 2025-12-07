package prt1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Classe principal del projecte Inventari.
 * <p>
 * Aquesta classe implementa un menú interactiu en consola que permet a l'usuari:
 * <ul>
 *   <li>Afegir nous materials</li>
 *   <li>Registrar préstecs</li>
 *   <li>Retornar préstecs</li>
 *   <li>Buscar materials per ID</li>
 *   <li>Llistar tots els materials</li>
 *   <li>Llistar tots els préstecs</li>
 * </ul>
 * </p>
 * 
 * @author Jannat
 */
public class Main {

    /**
     * Punt d'entrada del programa.
     * <p>
     * Inicialitza el repositori i el servei d'inventari, i mostra un menú
     * interactiu per gestionar materials i préstecs.
     * </p>
     * 
     * @param args arguments de la línia de comandes (no utilitzats)
     */
    public static void main(String[] args) {
        InventariRepository repo = new InventariRepository();
        InventariService service = new InventariService(repo);
        Scanner sc = new Scanner(System.in);

        int opcio;
        do {
            System.out.println("\n=== MENÚ INVENTARI ===");
            System.out.println("1. Afegir material");
            System.out.println("2. Fer préstec");
            System.out.println("3. Retornar préstec");
            System.out.println("4. Buscar material per ID");
            System.out.println("5. Llistar materials");
            System.out.println("6. Llistar préstecs");
            System.out.println("0. Sortir");
            System.out.print("Escull una opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {
                /**
                 * Opció 1: Afegir un nou material a l'inventari.
                 * Demana a l'usuari les dades necessàries (ID, nom, descripció, categoria, quantitat).
                 */
                case 1:
                    System.out.print("ID del material: ");
                    String id = sc.nextLine();
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Descripció: ");
                    String desc = sc.nextLine();
                    System.out.print("Categoria: ");
                    String catNom = sc.nextLine();
                    Categoria cat = new Categoria("C-" + id, catNom, desc);
                    System.out.print("Quantitat inicial: ");
                    int quant = Integer.parseInt(sc.nextLine());
                    service.registrarNuevoMaterial(id, nom, desc, cat, quant);
                    break;

                /**
                 * Opció 2: Registrar un préstec.
                 * Demana ID del préstec, ID del material, prestatari, quantitat i durada.
                 */
                case 2:
                    System.out.print("ID préstec: ");
                    String idPrestec = sc.nextLine();
                    System.out.print("ID material: ");
                    String idMat = sc.nextLine();
                    System.out.print("Prestatari: ");
                    String prestatari = sc.nextLine();
                    System.out.print("Quantitat: ");
                    int q = Integer.parseInt(sc.nextLine());
                    System.out.print("Dies de durada: ");
                    int dies = Integer.parseInt(sc.nextLine());
                    boolean creat = service.ferPrestec(idPrestec, idMat, prestatari, q, LocalDate.now(), dies);
                    System.out.println("Préstec creat? " + creat);
                    break;

                /**
                 * Opció 3: Retornar un préstec existent.
                 * Demana l'ID del préstec i marca'l com retornat si és vàlid.
                 */
                case 3:
                    System.out.print("ID préstec a retornar: ");
                    String idRetorn = sc.nextLine();
                    boolean retornat = service.retornarPrestec(idRetorn);
                    System.out.println("Préstec retornat? " + retornat);
                    break;

                /**
                 * Opció 4: Buscar un material per ID.
                 * Mostra les dades del material si existeix.
                 */
                case 4:
                    System.out.print("ID del material a buscar: ");
                    String idBuscar = sc.nextLine();
                    Material m = service.obtenirMaterialPerId(idBuscar);
                    if (m != null) {
                        System.out.println("Material trobat: " + m);
                    } else {
                        System.out.println("No existeix cap material amb ID " + idBuscar);
                    }
                    break;

                /**
                 * Opció 5: Llistar tots els materials disponibles.
                 */
                case 5:
                    System.out.println("=== Materials ===");
                    for (Material mat : service.llistarMaterials()) {
                        System.out.println(mat);
                    }
                    break;

                /**
                 * Opció 6: Llistar tots els préstecs registrats.
                 */
                case 6:
                    System.out.println("=== Préstecs ===");
                    for (Prestec p : service.llistarPrestecs()) {
                        System.out.println(p);
                    }
                    break;

                /**
                 * Opció 0: Sortir del programa.
                 */
                case 0:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 0);

        sc.close();
    }
}
