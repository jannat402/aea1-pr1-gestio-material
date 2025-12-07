package prt1;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que actua com a repositori de dades.
 * <p>
 * Emmagatzema els materials i els préstecs en llistes internes.
 * </p>
 * 
 * @author Jannat
 */
public class InventariRepository {
	private List<Material> materiales;
    private List<Prestec> prestamos;
    
    /** Constructor que inicialitza les llistes buides. */
    public InventariRepository() {
        this.materiales = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }
    
    /**
     * Afegeix un material al repositori.
     * @param material material a afegir
     */
    public void afegirMaterial(Material material) {
        materiales.add(material);
        System.out.println("Material añadido correctamente.");
    }
    
    /**
     * Busca un material pel seu identificador.
     * @param id identificador del material
     * @return el material si existeix, null en cas contrari
     */
    public Material buscarMaterialPorId(String id) {
       for (Material m : materiales) {
    	   if(m.getId().equals(id)) {
    		   return m;
    	   }
       }
       return null;
    }
    
    /** @return llista de tots els materials */
    public List<Material> obtenerTodosLosMateriales() {
        return materiales;
    }
    
    /**
     * Afegeix un préstec al repositori.
     * @param prestec préstec a afegir
     */
    public void afegirPrestec(Prestec prestec) {
        prestamos.add(prestec);
        System.out.println("Prestamo añadido correctamente.");

    }
    
    /** @return llista de tots els préstecs */
    public List<Prestec> obtenerTodosLosPrestamos() {
        return prestamos;
    }
    
    /**
     * Busca un préstec pel seu identificador.
     * @param id identificador del préstec
     * @return el préstec si existeix, null en cas contrari
     */
    public Prestec buscraPrestamoPorId(String id) {
    	for (Prestec p : prestamos) {
     	   if(p.getId().equals(id)) {
     		   return p;
     	   }
        }
        return null;
    }

}
