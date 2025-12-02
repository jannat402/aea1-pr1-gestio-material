package prt1;

import java.util.ArrayList;
import java.util.List;


public class InventariRepository {
	private List<Material> materiales;
    private List<Prestec> prestamos;

    public InventariRepository() {
        this.materiales = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void afegirMaterial(Material material) {
        materiales.add(material);
        System.out.println("Material añadido correctamente.");
    }

    public Material buscarMaterialPorId(String id) {
       for (Material m : materiales) {
    	   if(m.getId().equals(id)) {
    		   return m;
    	   }
       }
       return null;
    }

    public List<Material> obtenerTodosLosMateriales() {
        return materiales;
    }

    public void afegirPrestec(Prestec prestec) {
        prestamos.add(prestec);
        System.out.println("Prestamo añadido correctamente.");

    }

    public List<Prestec> obtenerTodosLosPrestamos() {
        return prestamos;
    }

    public Prestec buscraPrestamoPorId(String id) {
    	for (Prestec p : prestamos) {
     	   if(p.getId().equals(id)) {
     		   return p;
     	   }
        }
        return null;
    }

}
