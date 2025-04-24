public class Jugador{
	private Carta [] manoJugador;

	public void cartasIniciales(){
		manoJugador = new Carta [88];
		Mazo mazoJugador = new Mazo();

		for (int i = 0; i < 5; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(i);
			manoJugador [i] = cartaJugador;

		}


	}

	public void imprimirJugador(){
		int contador = 0;
			while(manoJugador[contador] != null){
				manoJugador[contador].imprimir();
				contador++;
			}
		}
	}

