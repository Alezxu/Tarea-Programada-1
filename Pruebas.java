public class Pruebas {

    public static void main(String[] args) {
        System.out.println("=== PRUEBAS SIMPLES DEL JUEGO DE CARTAS ===\n");

        pruebaCarta();
        pruebaCartaEspecial();
        pruebaMazo();
        pruebaJugador();
        pruebaJuegoBasico();

        System.out.println("\n=== FIN DE PRUEBAS ===");
    }

    public static void pruebaCarta() {
        System.out.println("\n> Prueba de clase Carta:");

        Carta carta1 = new Carta(3, "Rojo");
        Carta carta2 = new Carta(3, "Verde");
        Carta carta3 = new Carta(7, "Rojo");

        System.out.println("Carta 1: " + carta1.imprimir2());
        System.out.println("Carta 2: " + carta2.imprimir2());
        System.out.println("Carta 3: " + carta3.imprimir2());

        System.out.println("¿Carta 1 y Carta 2 son compatibles (mismo número)? " + carta1.comparar(carta2));
        System.out.println("¿Carta 1 y Carta 3 son compatibles (mismo color)? " + carta1.comparar(carta3));
    }

    public static void pruebaCartaEspecial() {
        System.out.println("\nPruebas de clase CartaEspecial:");

        Carta especial = new Carta(-3, "Coma 3");
        System.out.println("Carta especial: " + especial.imprimir2());
        System.out.println("Es carta especial? " + especial.esCartaEspecial());

        Carta normal = new Carta(5, "Azul");
        System.out.println("Carta normal: " + normal.imprimir2());
        System.out.println("Es carta especial? " + normal.esCartaEspecial());

        CartaEspecial ce = new CartaEspecial(2);
        System.out.println("Tipo de carta especial (2): " + ce.asignarTipoEspecial(2));
    }

    public static void pruebaMazo() {
        System.out.println("\nPrueba de clase Mazo:");

        Mazo mazo = new Mazo();
        System.out.println("Cartas en el mazo (después de crear):" + mazo.getCartasRestantes());
        

        Carta primera = mazo.repartirCartas(0);
        System.out.println("\nPrimera carta repartida: " + primera.imprimir2());

        System.out.println("Mazo después de repartir una carta:" + mazo.getCartasRestantes());

    }

    public static void pruebaJugador() {
        System.out.println("\nPrueba de clase Jugador:");

        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador();
        jugador.cartasIniciales(mazo);

        System.out.println("Cartas iniciales del jugador:");
        jugador.imprimirJugador();

        jugador.coma(mazo, 2);
        System.out.println("\nCartas después de comer 2:");
        jugador.imprimirJugador();

        jugador.descartarCartas(0);
        System.out.println("\nCartas después de descartar la primera:");
        jugador.imprimirJugador();

        System.out.println("¿Jugador ganó (mano vacía)? " + jugador.verificarVictoria(jugador.getMano()));
    }

    public static void pruebaJuegoBasico() {
        System.out.println("\nPrueba básica del Juego:");

        Juego juego = new Juego();
        juego.cartaInicial(); // poner una carta inicial

        System.out.print("Carta inicial en juego: ");
        juego.imprimirCartaEnJuego();

    }
}