//ESTO ES SOLO UNA CLASE PARA HACER PRUEBAS
public class PruebaCarta{
	public static void main (String [] args){
		Juego juego = new Juego();
		//Jugador mano = new Jugador();
		//Mazo mazo = new Mazo();
		
		//mazo.imprimir();	

		Carta carta1 = new Carta(3, "Verde");
        Carta carta2 = new Carta(3, "Rojo");    // Mismo número, distinto color
        Carta carta3 = new Carta(5, "Verde");   // Mismo color, distinto número
        Carta carta4 = new Carta(5, "Azul");    // Diferente número y color

        System.out.println("carta1 vs carta2 (mismo número): " + carta1.comparar(carta2)); // true
        System.out.println("carta1 vs carta3 (mismo color): " + carta1.comparar(carta3));  // true
        System.out.println("carta1 vs carta4 (diferente todo): " + carta1.comparar(carta4)); // false



		juego.empezarJuegoPVP();

		//System.out.println("\nCartas Jugador -  - - - - - - -  -- ");
		//mano.cartasIniciales(mazo);
		//mano.imprimirJugador();

		//System.out.println("\nMazo restante -  - - - - - - -  -- ");
		//mazo.imprimir();	

		//GUI.limpiarPantalla();


		//GUI.menuPrincipal();



		//int aleatorio = (int)(Math.random() * 52); //[0,1[
		//System.out.println(aleatorio);
	}

}