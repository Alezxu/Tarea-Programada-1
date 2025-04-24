public class PruebaCarta{
	public static void main (String [] args){
		Jugador mano = new Jugador();
		Mazo mazo = new Mazo();
		
		mazo.imprimir();	




		System.out.println("\nCartas Jugador -  - - - - - - -  -- ");
		mano.cartasIniciales(mazo);
		mano.imprimirJugador();

		System.out.println("\nMazo restante -  - - - - - - -  -- ");
		mazo.imprimir();	

		//GUI.limpiarPantalla();


		//GUI.menuPrincipal();



		//int aleatorio = (int)(Math.random() * 52); //[0,1[
		//System.out.println(aleatorio);
	}

}