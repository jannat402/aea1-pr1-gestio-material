/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaunidad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Classe principal que gestiona el menú d'operacions sobre un compte bancari.
 * <p>
 * Permet a l'usuari ingressar diners, retirar-los i consultar el saldo actual
 * mitjançant un menú interactiu en consola.
 * </p>
 * 
 * @author Jannat Rouias
 */
public class Main {
	/** Lector de dades des de consola */
	static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
    /** Missatge de finalització del programa */
	private static final String  FINALITZAREJECUCIO = "Finalizamos la ejecución";
    /** Missatge d'error per opcions incorrectes */
	private static final String ERROROPCIO = "Opción errónea";
	 
	/**
     * Mètode que mostra el menú i permet gestionar les operacions sobre el compte.
     * <p>
     * Les opcions disponibles són:
     * <ul>
     *   <li>1 - Ingressar</li>
     *   <li>2 - Retirar</li>
     *   <li>3 - Finalitzar</li>
     * </ul>
     * </p>
     * 
     * @param opcion opció inicial (0)
     */
	public static void gestionarCompte(int opcion) {
		double saldoActual;
		CCuenta comptePrincipal = new CCuenta("Juan López","1000-2365-85-123456789",2500,0);

		do{
			try {
				System.out.println("MENÚ DE OPERACIONES");
				System.out.println("-------------------");
				System.out.println("1 - Ingresar");
				System.out.println("2 - Retirar");
				System.out.println("3 - Finalizar");
				opcion=Integer.parseInt(dato.readLine());

				if(opcion==1){   
					System.out.println("¿Cuánto desea ingresar?: ");
					float ingresar=Integer.parseInt(dato.readLine());
					
					try {
						System.out.println("Ingreso en cuenta");
						comptePrincipal.ingresar(ingresar);
						
					} catch (Exception e){
						System.out.print("Fallo al ingresar");
					}
					
				}else if(opcion==2){
					System.out.println("¿Cuánto desea retirar?: ");
					float retirar=Integer.parseInt(dato.readLine());
					
					try {
						comptePrincipal.retirar(retirar);
						
					} catch (Exception e) {
						System.out.print("Fallo al retirar");
					}
					
				}else if(opcion==3){
					System.out.println(FINALITZAREJECUCIO);
				
				}else {
					System.err.println(ERROROPCIO);
				}
			} catch (IOException ex) {}
			
		}while (opcion!=3);
		
		saldoActual = comptePrincipal.getSaldo();
		System.out.println("El saldo actual es"+ saldoActual );
	}
	
	 /**
     * Punt d'entrada del programa.
     * <p>
     * Inicialitza l'opció a 0 i crida al mètode gestionarCompte(int opcion)}.
     * </p>
     */
	public static void main(String[] args) {
		int opcion=0;
		gestionarCompte(opcion);

		
	}            
}
