public class Jugador{
	private Carta [] manoJugador;
	private int contadorCartasRestantes;

	//Metodo que da las primeras 5 cartas del mazo al jugador.
	public void cartasIniciales(Mazo mazoJugador){
		manoJugador = new Carta [88];

		for (int i = 0; i < 5; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			manoJugador [i] = cartaJugador;

		}

	}

	//Imprime las cartas que tiene el jugador
	public void imprimirJugador(){
		int contador = 0;
			while (manoJugador[contador] != null) {
        		System.out.println("" + (contador+1) + ". " + manoJugador[contador].imprimir2());
        		contador++;
			}
		}



	//Metodo que se usa para verificar si un jugador se queda sin cartas.
	public boolean verificarVictoria(Carta [] manoJugador){
		

		for (Carta carta : manoJugador){
			if(carta != null){
				return false;
			}
		}

		return true;
	}


	//Este metodo se utiliza para borrar las cartas de la mano del jugador una vez sean jugadas.
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


	public int getTamanioMano (){
		int indice = 0;
		while(manoJugador[indice]!= null){
			indice++;
		}

		return indice;
	}


	public void coma(Mazo mazoJugador, int cantidadPorComer){
		for (int i = 0; i < cantidadPorComer ; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			int tamanio = getTamanioMano();
			if(tamanio < manoJugador.length){
				manoJugador [ tamanio ] = cartaJugador;

			}
			
		}
	}


	public void coma3(Mazo mazoJugador){
		for (int i = 0; i < 3; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			int tamanio = getTamanioMano();
			manoJugador [ tamanio ] = cartaJugador;
		}
	}


	public Carta [] getMano(){
		return manoJugador;
	}
}

