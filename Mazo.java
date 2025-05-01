//! \class Clase Mazo del mazo de cartas
/*! 
 * Clase que crea los mazos para almacenar las cartas del juego
 */


public class Mazo{
	//Atributos
	private Carta [] cartas;  /*!< Array de Cartas */
	private int cartasRestantes; /*!< Contador de las cartas restantes */

	/*! \brief Constructor por omision
	 * 
	 * Primero se agregan las cartas especiales por separado, y luego las cartas regulares.
	 * 
	 * Al final se devuelve el mazo revuelto.
	 * 
	 */

	public Mazo(){
		cartas = new Carta [88];
		int contador = 0;

		//Pone las cartas especiales por separado

		for (int tipo = 2; tipo < 6; tipo++){
			for (int i = 0; i <4; i++){

				CartaEspecial cartaE = new CartaEspecial(tipo);
				String stringEspecial = cartaE.asignarTipoEspecial(tipo);

				Carta especial = new Carta(tipo *-1 , stringEspecial);
				cartas [contador] = especial;
				contador++;
			}
		}

		//Pone las cartas normales
		for(int color = 0; color <4 ; color++){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j<2; j++){
					Carta carta = new Carta(i, obtenerColor(color));
					cartas [contador] = carta;
					contador++;
				}
			}
		}

		cartasRestantes = 88;

		revolver();
	}

	/*! \brief Se devuelve el color a la carta dependiendo del indice.
	 * \param int el indice con el que se seleccionara el color
	 * \return String color de la carta
	 */

	//Asigna los colores dependiendo del indice 
	private String obtenerColor(int i){
		String color = "";
		switch(i){
		case 0:
			color = "Rojo";
			break;
		case 1:
			color = "Verde";
			break;
		case 2:
			color = "Azul";
			break;
		case 3:
			color = "Naranja";
			break;
		}
		return color;
	}



	/*!\brief Metodo que revuelve el mazo, utiliza un indice random y se van moviendo las cartas.
	 * 
	 */
	//Revuelve el mazo aleatoriamente
	public void revolver(){
		for(int i = 0 ; i < cartas.length ;i++){
			// Voy a intercambiar i con algo aleatorio
			int aleatorio = (int)(Math.random() * 88); //[0,1[
			Carta temp = cartas[i];
			cartas[i] = cartas[aleatorio];
			cartas[aleatorio] = temp;
		}
	}


	/*! \brief Metodo que imprime un mazo, utilizando el imprimir dentro de Carta.
	 */
	//Imprime el mazo, utilizando el imprimir dentro de la clase Carta.
	public void imprimir(){
		for(int i = 0 ; i < cartasRestantes; i++){
			if(cartas[i]!= null){
				cartas[i].imprimir();
			}
		}
	}

	/*! \brief Agarra la primera carta del array. Luego va moviendo todas las cartas a la izquierda, hasta que la ultima queda null, Devuelve la Carta Repartida
	 * 
	 * \param int utiliza un indice por el usuario para buscar la carta.
	 * \return Carta carta repartida
	 */
	
	public Carta repartirCartas(int indice){
		
			Carta repartida = cartas[indice];

			for(int i = 0; i < cartasRestantes - 1; i++){

				cartas[i] = cartas [i+1];
			}

			cartas[cartasRestantes - 1] = null;
			cartasRestantes --;

			return repartida;
	}

	/*!\brief Retorna las cartas que quedan en el mazo
	 * \return int cartas restantes.
	 */
	
	public int getCartasRestantes(){
		return cartasRestantes;
	}

}