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
			while(manoJugador[contador] != null){
				manoJugador[contador].imprimir();
				contador++;
			}
		}



	//Metodo que se usa para verificar si un jugador se queda sin cartas.
	public boolean verificarVictoria(Carta [] manoJugador){
		boolean winOrLose = false;

		contadorCartasRestantes = 0;
		for (int i = 0; i< manoJugador.length; i++){
			if(manoJugador[i] != null){
				contadorCartasRestantes ++;
			}
		}

		if(contadorCartasRestantes == 0){
			winOrLose = true;
		}

		return winOrLose;
	}


	//Este metodo se utiliza para borrar las cartas de la mano del jugador una vez sean jugadas.
	public Carta descartarCartas(int indice){
		
			Carta descartada = manoJugador[indice];
			manoJugador[indice] = null;

			for(int i = indice; i < contadorCartasRestantes - 1; i++){

				manoJugador[i] = manoJugador [i+1];
			}

			manoJugador[contadorCartasRestantes - 1] = null;
			contadorCartasRestantes --;

			return descartada;
	}


	public int getTamanioMano (){
		int indice = 0;
		while(manoJugador[indice]!= null){
			indice++;
		}

		return indice - 1;
	}


	public void coma2(Mazo mazoJugador){
		for (int i = 0; i < 2; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			int tamanio = getTamanioMano();
			manoJugador [ tamanio + 1 ] = cartaJugador;
		}
	}


	public void coma3(Mazo mazoJugador){
		for (int i = 0; i < 3; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
			int tamanio = getTamanioMano();
			manoJugador [ tamanio + 1 ] = cartaJugador;
		}
	}


	public Carta [] getMano(){
		return manoJugador;
	}
}

