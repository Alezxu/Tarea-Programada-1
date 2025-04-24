public class Jugador{
	private Carta [] manoJugador;

	public void cartasIniciales(Mazo mazoJugador){
		manoJugador = new Carta [88];

		for (int i = 0; i < 5; i++){
			Carta cartaJugador = mazoJugador.repartirCartas(0);
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

