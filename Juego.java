import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;


public class Juego{
	private Carta mazoEnJuego [];
	private Jugador player1;
	private Jugador player2;
	private Jugador computadora;
	private Mazo mazoRestante;
	int cartasEnJuego;
	//GUI GUI = new GUI();
	Scanner input = new Scanner(System.in);
	private int comaMaximo = 0;
	private int cantidadComer = 0;

	//Constructor
	public Juego(){
		mazoRestante = new Mazo();
		player1 = new Jugador();
		player2 = new Jugador();
		mazoEnJuego = new Carta [88];
		cartasEnJuego = 0;
		computadora = new Jugador();

	}

	//Metodo para empezar un juego entre 2 jugadores
	public void empezarJuegoPVP(){

		mazoRestante = new Mazo();
		player1 = new Jugador();
		player2 = new Jugador();
		mazoEnJuego = new Carta [88];
		cartasEnJuego = 0;
		computadora = new Jugador();
		cantidadComer = 0;
		comaMaximo = 0;


		

		//System.out.println("MAZO INICIAL\n"); ESTO ES PARA PRUEBAS
		//mazoRestante.imprimir();

		//Se reparten las cartas iniciales a cada jugador 
		player1.cartasIniciales(mazoRestante);
		player2.cartasIniciales(mazoRestante);

		//Se pone la carta inicial en la mesa
		cartaInicial();
		boolean bandera = true;

		
		//ESTO ES DE PRUEBA
		//System.out.println("\n\nCartas JUGADOR 1");
		//player1.imprimirJugador();
		//System.out.println("\n\nCARTAS JUGADOR 2");
		//player2.imprimirJugador();

		//While que da la logica al juego, se pasa verificando si alguno de los dos jugadores se queda sin cartas, si esto pasa se acaba el juego.
		while(true){
			

			//if(cardPlay (player1, player2)){
				
			//}

			//else if (cardPlay(player2, player1)){

				//bandera = false;
			//}

			System.out.println("\n\nCARTA EN JUEGO");
			imprimirCartaEnJuego();

			System.out.println("\n**TURNO PLAYER 1**");

			System.out.println("\n\nCartas JUGADOR 1");
			player1.imprimirJugador();



			if(cardPlay (player1, player2) || player1.verificarVictoria(player1.getMano())){
				GUI.limpiarPantalla();
				System.out.println("***HA GANADO EL JUGADOR 1***");
				break;
			}

			//cardPlay(player1 , player2);
			//GUI.limpiarPantalla();
			else{

				GUI.limpiarPantalla();
			}
			

			System.out.println("\n\nCARTA EN JUEGO");
			imprimirCartaEnJuego();
			System.out.println("\n**TURNO PLAYER 2**");
			System.out.println("\n\nCartas JUGADOR 2");

			player2.imprimirJugador();

			if (cardPlay(player2, player1) || player2.verificarVictoria(player2.getMano())){
				System.out.println("HA GANADO EL JUGADOR 2");
				break;
			}


			else{ 
				GUI.limpiarPantalla();
			}

			//cardPlay(player2, player1);

			//imprimirMazoEnJuego();




		}
		
		/*TODO DESPUES DE AQUI ES PURAS PRUEBAS 
		System.out.println("\nCARTAS DESCARTADAS 1");
		player1.descartarCartas(0).imprimir(); 

		System.out.println("\n\nCartas JUGADOR 1");
		player1.imprimirJugador();


		System.out.println("\nCARTAS DESCARTADAS 2");
		player2.descartarCartas(4).imprimir();
		System.out.println("\n\nCARTAS JUGADOR 2");
		player2.imprimirJugador();

		//System.out.println("MAZO RESTANTE\n");
		//mazoRestante.imprimir();

		

		//System.out.println("cartasEnJuego: " + cartasEnJuego);



		//System.out.println("MAZO RESTANTE\n");
		//mazoRestante.imprimir();
		*/
	}

	public void empezarJuegoPVE(){

		

		//Se reparten las cartas iniciales al jugador y a la computadora
		player1.cartasIniciales(mazoRestante);
		computadora.cartasIniciales(mazoRestante);

		//Se pone la carta inicial en la mesa
		cartaInicial();

		
		//While que da la logica al juego, se pasa verificando si alguno de los dos jugadores se queda sin cartas, si esto pasa se acaba el juego.
		while(!(player1.verificarVictoria(player1.getMano())) && !(computadora.verificarVictoria(computadora.getMano()))){
			
			GUI.limpiarPantalla();
			System.out.println("\n\nCARTA EN JUEGO");
			imprimirCartaEnJuego();

			System.out.println("\n\n**TURNO PLAYER**");

			System.out.println("\n\nCartas BOT");
			computadora.imprimirJugador();

			System.out.println("\n\nCartas JUGADOR");
			player1.imprimirJugador();

			cardPlay(player1 , computadora);

			
 			GUI.limpiarPantalla();
			System.out.println("\n\nCARTA EN JUEGO");
			imprimirCartaEnJuego();

			System.out.println("\n**TURNO BOT**");

			System.out.println("\n\nCartas JUGADOR");
			player1.imprimirJugador();

			System.out.println("\n\nCartas BOT");
			computadora.imprimirJugador();

			cardPlayBot(computadora);



		}


		System.out.println("GANO!");
		
	}


	//Se asigna la carta inicial con la que se empezara el juego. Se verifica que no se pueda empezar con una carta especial, por medio del numero '-1'.
	public void cartaInicial(){
		Carta cartaI = mazoRestante.repartirCartas(0);
		while(cartaI.getNumero() <= -2 && cartaI.getNumero() >= -5){
			mazoRestante.revolver();  

			cartaI = mazoRestante.repartirCartas(0);
		}

		mazoEnJuego[0] = cartaI;

		cartasEnJuego++;
	}


	//Metodo para imprimir el mazo jugado, esto se va a usar para el buscar carta
	public void imprimirMazoEnJuego(){
		int contador = 0;
			while(mazoEnJuego[contador] != null){
				System.out.println((contador + 1) + "." + mazoEnJuego[contador].imprimir2());
				contador++;
			}
		}


	//Metodo principal para jugar, se recibe un jugador como parametro, para organizar los turnos. 

	public boolean cardPlay(Jugador playerActual , Jugador playerRival){
 		try {
 
 			Carta [] manoJugador = playerActual.getMano();
 			int opcion;
 			boolean cartaValida = false;
 			boolean jugoCarta = false;
 			

 			if(playerActual.verificarVictoria(playerActual.getMano())){
 				return true;
 			}
 
 				if(cantidadComer > 0){
 					boolean tieneCome = false;
 
 					for(int i = 0; i < playerActual.getTamanioMano(); i++){
 						if(manoJugador[i] != null && manoJugador[i].esCartaEspecial()){
 							if (manoJugador[i].getNumero() == comaMaximo){
 									tieneCome = true;
 							}
 						}
 					}
 
 
 					if(!tieneCome){
 						playerActual.coma(mazoRestante, cantidadComer);
 						cantidadComer = 0;
 						comaMaximo = 0;
 						System.out.println("\nCOMIO");
 						System.out.println("\n\nCartas JUGADOR XX");
 						playerActual.imprimirJugador();
 						GUI.pausa();
 						return false;
 					}
 
 
 				}

 				for (int i = 0; i < playerActual.getTamanioMano(); i++) {
    				if (manoJugador[i] != null &&
       					(manoJugador[i].comparar(getCartaEnJuego()) || manoJugador[i].esCartaEspecial() || getCartaEnJuego().esCartaEspecial())) {
        					jugoCarta = true;
        					break;
    			}
			}


			if(!jugoCarta) {
				System.out.println("\nNo tiene cartas válidas... \nComiendo carta...");
    			GUI.pausa();
    			playerActual.coma(mazoRestante, 1);
   			 	System.out.println("Se acaba su turno...");
    			return false;
			
				}
 
 
                System.out.println("\nElija una carta: ");
 				opcion = input.nextInt() - 1;
 				input.nextLine();
 
                 while(!cartaValida){
 
 
 					if(opcion >= 0 && opcion < playerActual.getTamanioMano()){
 						if(manoJugador[opcion].comparar(getCartaEnJuego()) || manoJugador[opcion].esCartaEspecial() || getCartaEnJuego().esCartaEspecial()){
 							cartaValida = true;
 						}
 
 						else {
 							System.out.println("\nError, seleccione una carta valida...\n");
 							GUI.pausa();
 
 							System.out.println("\nElija una carta: ");
 							opcion = input.nextInt() - 1;
 							input.nextLine();
 						}
 
 
 					} else {
 						System.out.println("\nError, seleccione una carta valida...\n");
 						GUI.pausa();
 						
 
 						System.out.println("\nElija una carta: ");
 						opcion = input.nextInt() - 1;
 						input.nextLine();
 					}
 
                 }
 
                 if(getCartaEnJuego().esCartaEspecial()){
 
                 	if(getIndiceCartaEnJuego() < 89){
                 		mazoEnJuego[getIndiceCartaEnJuego() + 1] = manoJugador[opcion];
                 		playerActual.descartarCartas(opcion);
                 		jugoCarta = true;
                 		cartasEnJuego ++;
 
                 	}
 
                 }
 
 
                 else if(manoJugador[opcion].comparar(getCartaEnJuego()) || manoJugador[opcion].esCartaEspecial()){
 
 
 
                 	if(manoJugador[opcion].esCartaEspecial()){
                 		switch(manoJugador[opcion].getNumero()){
 
                 		case -2:
                 			comaMaximo = -2;
                 			cantidadComer +=2;
 						break;
 
 						case -3:
 							comaMaximo = -3;
 							cantidadComer += 3;
 						break;
 
 
 						case -4:
 							cancelarComa(); // Cancela la cadena de comer si está activa
        					break;
 
 
 						case -5:
 							buscarCarta(playerActual); // Permite al jugador tomar una carta de la pila
       						break;
 
                 		}
 
                 	}
 
                 	if(getIndiceCartaEnJuego() < 89){
                 		mazoEnJuego[getIndiceCartaEnJuego() + 1] = manoJugador[opcion];
                 		playerActual.descartarCartas(opcion);
                 		jugoCarta = true;
                 		cartasEnJuego ++;

                 	}
 
 
 
 
 
                 }  
 
 
 
 
                 else if(!jugoCarta){//if (!(manoJugador[opcion].comparar(getCartaEnJuego())) || !(manoJugador[opcion].esCartaEspecial())){
 
                 	System.out.println("\nNo tiene cartas validas... \nComiendo carta...");
                 	GUI.pausa();
                 	playerActual.coma(mazoRestante, 1);
                 	System.out.println("Se acaba su turno...");
                 }
 
 
 
 			} catch(InputMismatchException e){
                 System.err.println("Opcion Incorrecta.");
                 GUI.pausa();
                 GUI.limpiarPantalla();
 
     		} catch(ArrayIndexOutOfBoundsException | NullPointerException e){
     			System.err.println("Opcion Incorrecta.");                
                 GUI.pausa();
                 GUI.limpiarPantalla();
     		}

     		return false;
 	}

	


	public void cardPlayBot(Jugador player) {
    try {
        System.out.println("\nEl bot está eligiendo una carta...");
        GUI.pausa();

        Carta[] manoJugador = player.getMano();
        int tamanio = player.getTamanioMano();
        boolean jugoCarta = false;

        
        if (cantidadComer > 0) {
            boolean tieneCome = false;

            for (int i = 0; i < tamanio; i++) {
                if (manoJugador[i] != null && manoJugador[i].esCartaEspecial()) {
                    if (manoJugador[i].getNumero() == comaMaximo) {
                        tieneCome = true;
                        break;
                    }
                }
            }

            if (!tieneCome) {
                player.coma(mazoRestante, cantidadComer);
                cantidadComer = 0;
                comaMaximo = 0;
                System.out.println("BOT COMIO " + cantidadComer + " CARTAS.");
                return;
            }
        }

        for (int i = 0; i < tamanio; i++) {
            Carta carta = manoJugador[i];

            if (carta != null && (carta.comparar(getCartaEnJuego()) || carta.esCartaEspecial() || getCartaEnJuego().esCartaEspecial())) {

                // Aplica el efecto de la carta especial si es necesario
                if (carta.esCartaEspecial()) {
                    switch (carta.getNumero()) {
                        case -2:
                            comaMaximo = -2;
                            cantidadComer += 2;
                            break;
                        case -3:
                            comaMaximo = -3;
                            cantidadComer += 3;
                            break;
                        case -4:
                            cancelarComa();
                            break;
                        case -5:
                            buscarCartaBot(player);
                            break;
                    }
                }

                if (getIndiceCartaEnJuego() < 89) {
                    mazoEnJuego[getIndiceCartaEnJuego() + 1] = carta;
                    player.descartarCartas(i);
                    cartasEnJuego++;
                    System.out.println("BOT JUGO: " + carta);
                    jugoCarta = true;
                    break;
                }
            }
        }

        // Si no pudo jugar ninguna carta válida
        if (!jugoCarta) {
            System.out.println("BOT NO TIENE CARTAS VALIDAS. COMIENDO UNA CARTA...");
            GUI.pausa();
            player.coma(mazoRestante, 1);
        }

    } catch (Exception e) {
        System.err.println("Error en la jugada del bot: " + e.getMessage());
        GUI.pausa();
        GUI.limpiarPantalla();
    }
}

	//Devuelve el indice del mazo de la ultima carta que se puso, el siguiente espacio sera null.
	public int getIndiceCartaEnJuego(){
		int indice = 0;
		while(mazoEnJuego[indice]!= null){
			indice++;
		}

		return indice - 1;

	}


	//Devuelve la carta que esta en juego 
	public Carta getCartaEnJuego(){
		int indice = 0;
		while(mazoEnJuego[indice]!= null){
			indice++;
		}

		return mazoEnJuego[indice -1];

	}


	//imprime la carta que esta en juego para que el usuario la vea.
	public void imprimirCartaEnJuego(){
		Carta actual = mazoEnJuego[getIndiceCartaEnJuego()];
		actual.imprimir();
	}

	public void cancelarComa (){
		Carta cartaEnJuego = getCartaEnJuego();
		if (cartaEnJuego.getNumero() == -2 || cartaEnJuego.getNumero() == -3){
			cantidadComer = 0;
		}

	}


	private Carta tomarCartaPila(int indice) {
	    if (indice < 0 || indice >= cartasEnJuego || mazoEnJuego[indice] == null) {
	        return null;
	    }

		
	    Carta cartaTomada = mazoEnJuego[indice];

	    for (int i = indice; i < cartasEnJuego - 1; i++) {
	        mazoEnJuego[i] = mazoEnJuego[i + 1];
	    }

	    cartasEnJuego--;
	    mazoEnJuego[cartasEnJuego] = null;
	    

	    return cartaTomada;
	}



	public void buscarCarta(Jugador jugador) {
     	imprimirMazoEnJuego();
 
 	    System.out.println("\nElija una carta de la pila para agregar a su mano: ");
 	    int opcion = input.nextInt() - 1;
 	    input.nextLine();  
 	    
 	    Carta cartaBuscada = tomarCartaPila(opcion);  
 
 	    if (cartaBuscada != null) {
 	        int tamanioMano = jugador.getTamanioMano();
 	        Carta[] mano = jugador.getMano();
 
 	        if (tamanioMano < mano.length) {
 	            mano[tamanioMano] = cartaBuscada;
 	            System.out.println("\nCarta agregada a tu mano correctamente");
 	        } 
 	        else {
 	            System.out.println("\nNo puedes agregar más cartas a tu mano");
 	        }
 	    } 
 	    else {
 	        System.out.println("\nCarta no válida o fuera de la pila");
     	}
 	}

 	public void buscarCartaBot(Jugador jugador) {
     	imprimirMazoEnJuego();
 
 	    System.out.println("\nElija una carta de la pila para agregar a su mano: ");
 	    int min = 0; 
 	    int rango = ((cartasEnJuego - 1) - min) + 1;
 	    int opcion = (int)((rango * Math.random()) + min);
 	      
 	    
 	    Carta cartaBuscada = tomarCartaPila(opcion);  
 
 	    if (cartaBuscada != null) {
 	        int tamanioMano = jugador.getTamanioMano();
 	        Carta[] mano = jugador.getMano();
 
 	        if (tamanioMano < mano.length) {
 	            mano[tamanioMano] = cartaBuscada;
 	            System.out.println("\nCarta agregada a la mano correctamente");
 	        } 
 	        else {
 	            System.out.println("\nNo se puede agregar más cartas a la mano");
 	        }
 	    } 
 	    else {
 	        System.out.println("\nCarta no válida o fuera de la pila");
     	}
 	}
 }