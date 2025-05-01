

//! \class Clase Carta de Uno y medio
/*! 
 * Clase que crea las Cartas, con sus valores especificos.
 */

public class Carta{

	private int numero;  /*!< Numero que tendra la carta */
	private String color;  /*!< Color de la carta */
	


	/*! \brief Constructor por omision
	 */
	// Constructor de clase
	// Primer metodo que se ejecuta cuando se genera una instancia
	public Carta(){
		numero = 6;
		color = "Rojo";
	}

	/*! \brief Constructor sobrecargado
	 * 
	 * Se utiliza para asignarle el numero y color a la carta
	 * \param int numero de la carta.
	 * \param String color de la carta 
	 */
	public Carta(int numero, String color){
		//if(numero >= 0 && numero <=12){
			this.numero = numero;
		//}
		this.color = color;
	}

	/*! \brief Le asigna un numero a la carta
	 * 
	 * \param int numero de la carta.
	 */

	public void setNumero(int numero){
		if(numero >= 0 && numero < 13){
			this.numero = numero;	
		}
	}

	/*! \brief Le asigna color a la carta
	 * 
	 * \param String color de la carta.
	 */

	public void setcolor(String color){
		this.color = color;
	}


	/*! \brief Devuelve el numero de la carta
	 * \return int numero de la carta
	 */

	public int getNumero(){
		return this.numero;
	}

	/*! \brief Devuelve el color de la carta
	 * \return color de la carta 
	 */

	public String getcolor(){
		return this.color;
	}

	/*! \brief imprime las cartas
	 */

	public void imprimir(){
		System.out.print("[" + getNumero() + " " + color + "]");
	}

	/*! \brief imprime las cartas
	 */
	public String imprimir2(){
		String impresion = "[" + getNumero() + " " + color + "]";
		return impresion;
	}

	/*! \brief Compara una carta con otra. Verifica que el numero de una carta o el color sea igual para devolver true.
	 * 
	 * \param Carta carta que sera comparada
	 * \return boolean devuelve si la carta es igual o no
	 */
	
	public boolean comparar(Carta a){
		boolean resultado = false;

		if(this.numero == a.getNumero() || this.color.equals(a.getcolor())){
			resultado = true;
		}
		return resultado;
	}



	/*! \brief Verifica si la carta es especial por medio del numero.
	 * 
	 * \return devuelve true si la carta es especial
	 */
	public boolean esCartaEspecial(){
		boolean resultado = false;

		if(this.numero <= -2 && this.numero >= -5){
			resultado = true;
		}

		return resultado;

	}
}

	
	
