
//! \class Clase Jugador 
/*! 
 * Clase que crea los jugadores y realiza ciertas valoraciones
 */

public class Jugador{
	private Carta [] manoJugador; /*!< Mazo que tiene el jugador */
	private int contadorCartasRestantes; /*!< Contador de cuantas cartas quedan en el mazo */


 	/*! \brief Metodo que da las primeras 5 cartas del mazo al jugador.
 	 * \param Mazo recibe un mazo del juego.
 	 */
	
	public void cartasIniciales(Mazo mazoJugador){
		manoJugador = new Carta [88];

		for (int i = 0; i < 5; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			manoJugador [i] = cartaJugador;

		}

	}


	/*! \brief Imprime las cartas que tiene el jugador
	 */
	
	public void imprimirJugador(){
		int contador = 0;
			while (manoJugador[contador] != null) {
        		System.out.println("" + (contador+1) + ". " + manoJugador[contador].imprimir2());
        		contador++;
			}
		}



	/*! \brief Metodo que se usa para verificar si un jugador se queda sin cartas.
	 * Realiza un por cada Carta en carta verifique si es igual a las cartas en manoJugador
	 * 
	 * \param Carta [] recibe el mazo del jugador 
	 * 
	 * /return boolean devuelve false si encuentra una carta != null, true en caso contrario.
	 */
	public boolean verificarVictoria(Carta [] manoJugador){
		

		for (Carta carta : manoJugador){
			if(carta != null){
				return false;
			}
		}

		return true;
	}


	/*! \brief Este metodo se utiliza para borrar las cartas de la mano del jugador una vez sean jugadas.
	 * 
	 * \param int indice de la carta que va a ser descartada
	 * \return Carta devuelve la carta que se va a jugar
	 */
	public Carta descartarCartas(int indice) {
		int tamanio = getTamanioMano();
	    if (indice < 0 || indice >= tamanio) {
	        return null;  
	    }

	    Carta descartada = manoJugador[indice];

	    // Mover las cartas hacia la izquierda
	    for (int i = indice; i < tamanio - 1; i++) {
	        manoJugador[i] = manoJugador[i + 1];
	    }

	    // La última carta queda null
	    manoJugador[tamanio - 1] = null;

	    return descartada;
	}

	/*! \brief Devuelve el tamanio de la mano del jugador
	 * 
	 * \return int indice 
	 */
	public int getTamanioMano (){
		int indice = 0;
		while(manoJugador[indice]!= null){
			indice++;
		}

		return indice;
	}


	/*! \brief Se utiliza para hacer que el jugador coma cartas del mazo restante
	 * \param Mazo mano del jugador 
	 * \param int cantidad de cartas que se van a comer 
	 */
	public void coma(Mazo mazoJugador, int cantidadPorComer){
		for (int i = 0; i < cantidadPorComer ; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			int tamanio = getTamanioMano();
			if(tamanio < manoJugador.length){
				manoJugador [ tamanio ] = cartaJugador;

			}
			
		}
	}


	/*! \brief Devuelve la mano del jugador 
	 */
	public Carta [] getMano(){
		return manoJugador;
	}
}

