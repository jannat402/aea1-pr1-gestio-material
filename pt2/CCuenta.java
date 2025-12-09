/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaunidad4;
/**
 * Classe que representa un Compte bancari.
 * <p>
 * Cada compte té un nom de titular, un número de compte, un saldo i un tipus d'interès.
 * Permet realitzar operacions bàsiques com ingressar i retirar diners.
 * </p>
 * @author Jannat Rouias
 */
public class CCuenta {
	// declaració de atributs 
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipoInteres;

	// declaració i inicialització de les variables d'error per als mètodes
	private static final String ERROR_INGRESAR = "No se puede ingresar una cantidad negativa";
	private static final String ERROR_CANTIDAD = "No se puede retirar una cantidad negativa";
	private static final String ERROR_SALDO = "No se hay suficiente saldo";

	/**
	 * Constructor buit.
	 * <p>
	 * Permet crear un compte sense inicialitzar-lo amb dades.
	 * </p>
	 */
	public CCuenta () {

	}

	/**
     * Constructor amb paràmetres.
     * 
     * @param nom nom del titular del compte
     * @param cuenta número de compte
     * @param saldo saldo inicial
     * @param tipoInteres tipus d'interès aplicat
     */
	public CCuenta (String nom, String cuenta, double saldo, double tipoInteres) {
		this.nombre =nom;
		this.cuenta=cuenta;
		this.saldo=saldo;
		this.tipoInteres=tipoInteres;
	}

	 /**
     * Obté el nom del titular del compte.
     * @return nom del titular
     */
	public String getNombre() {
		return nombre;
	}
	
	 /**
     * Assigna un nou nom al titular del compte.
     * @param nombre nou nom
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     * Obté el número de compte.
     * @return número de compte
     */
	public String getCuenta() {
		return cuenta;
	}
	
	/**
     * Assigna un nou número de compte.
     * @param cuenta nou número de compte
     */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

    /**
     * Obté el saldo actual del compte.
     * @return saldo actual
     */
	public double getSaldo() {
		return saldo;
	}
	
	 /**
     * Assigna un nou saldo al compte.
     * @param saldo nou saldo
     */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	 /**
     * Obté el tipus d'interès aplicat al compte.
     * @return tipus d'interès
     */
	public double getTipoInteres() {
		return tipoInteres;
	}
	
	/**
     * Assigna un nou tipus d'interès al compte.
     * @param tipoInteres nou tipus d'interès
     */
	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	/**
     * Ingressa una quantitat al compte.
     * 
     * @param cantidad quantitat a ingressar
     * @throws Exception si la quantitat és negativa
     */
	public void ingresar(double cantidad) throws Exception {
		if (cantidad < 0){
			throw new Exception(ERROR_INGRESAR);
		}
		setSaldo(saldo + cantidad);
	}
	
	/**
     * Retira una quantitat del compte.
     * 
     * @param cantidad quantitat a retirar
     * @throws Exception si la quantitat és negativa o si no hi ha prou saldo
     */
	public void retirar (double cantidad) throws Exception {
		if (cantidad < 0){
			throw new Exception (ERROR_CANTIDAD);
		}

		if (getSaldo() < cantidad){
			throw new Exception (ERROR_SALDO);
		}
		setSaldo(saldo - cantidad);
	}

}
