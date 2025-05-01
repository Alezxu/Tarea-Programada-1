import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;

//! \class Clase Juego
/*! 
 * Clase que crea el juego y hace todo el control
 */
public class Juego{
	private Carta mazoEnJuego []; /*!< Mazo que estara en juego */
	private Jugador player1; /*!< Jugador #1 */
	private Jugador player2;/*!<  Jugador #2*/
	private Jugador computadora;/*!< Jugador NPC*/
	private Mazo mazoRestante;/*!< Mazo que va quedando despues de agarrar cartas */
	int cartasEnJuego;/*!< Numero de las cartas que han sido jugadas */
	Scanner input = new Scanner(System.in);/*!< Se crea el scanner*/
	private int comaMaximo = 0;/*!< Variable que dice cual es el Coma mas alto jugado  */
	private int cantidadComer = 0;/*!< Cantidad de Cartas por comer acumuladas */

	/*! \brief Constructor por omision 
	 */
	public Juego(){
		mazoRestante = new Mazo();
		player1 = new Jugador();
		player2 = new Jugador();
		mazoEnJuego = new Carta [88];
		cartasEnJuego = 0;
		computadora = new Jugador();

	}

	/*! \brief Metodo para empezar un juego entre 2 jugadores.
	 * 
	 * Primero se resetean todas las variables. Luego se reparten las 5 cartas iniciales a cada jugador. Se pone la carta inicial en la mesa y se empieza el bucle del juego.
	 * 
	 * 
	 * Se pasa verificando si alguno de los dos jugadores gano para salirse del while.
	 * 
	 * 
	 */
	public void empezarJuegoPVP(){

		mazoRestante = new Mazo();
		player1 = new Jugador();
		player2 = new Jugador();
		mazoEnJuego = new Carta [88];
		cartasEnJuego = 0;
		computadora = new Jugador();
		cantidadComer = 0;
		comaMaximo = 0;


		//Se reparten las cartas iniciales a cada jugador 
		player1.cartasIniciales(mazoRestante);
		player2.cartasIniciales(mazoRestante);

		//Se pone la carta inicial en la mesa
		cartaInicial();
		boolean bandera = true;

		
		//While que da la logica al juego, se pasa verificando si alguno de los dos jugadores se queda sin cartas, si esto pasa se acaba el juego.
		while(true){
			

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

		
		}
		
		
	}


	/*! \brief  Metodo para empezar un juego entre un jugador y un NPC.
	 * 
	 * Primero se resetean todas las variables. Luego se reparten las 5 cartas iniciales a cada jugador. Se pone la carta inicial en la mesa y se empieza el bucle del juego.
	 * 
	 * 
	 * Se pasa verificando si alguno de los dos jugadores gano para salirse del while.
	 * 
	 */
	public void empezarJuegoPVE(){

		mazoRestante = new Mazo();
		player1 = new Jugador();
		player2 = new Jugador();
		mazoEnJuego = new Carta [88];
		cartasEnJuego = 0;
		computadora = new Jugador();
		cantidadComer = 0;
		comaMaximo = 0;


		
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


	/*! \brief Se asigna la carta inicial con la que se empezara el juego. 
	 * 
	 * Se verifica que no se pueda empezar con una carta especial, por medio del numero.
	 */
	public void cartaInicial(){
		Carta cartaI = mazoRestante.repartirCartas(0);
		while(cartaI.getNumero() <= -2 && cartaI.getNumero() >= -5){
			mazoRestante.revolver();  

			cartaI = mazoRestante.repartirCartas(0);
		}

		mazoEnJuego[0] = cartaI;

		cartasEnJuego++;
	}



	/*! \brief Metodo para imprimir el mazo jugado, esto se va a usar para el buscar carta
	 * 
	 */
	public void imprimirMazoEnJuego(){
		int contador = 0;
			while(mazoEnJuego[contador] != null){
				System.out.println((contador + 1) + "." + mazoEnJuego[contador].imprimir2());
				contador++;
			}
		}


	 /*! \brief Metodo principal para jugar, se recibe un jugador como parametro, para organizar los turnos. 
	  * 
	  * 
	  * Se pasa verificando si el jugador puede ganar. Ademas de que si hay cartas para comer, en dado caso se ve si el jugador puede responder o no.
	  * 
	  * Tambien se verifica si el jugador tiene alguna carta valida. Si tiene carta valida se le obliga a ponerla para que no pierda el turno.
	  * 
	  * En caso de no tener carta valida no se le permite elegir ninguna carta, y come una automaticamente, perdiendo el turno.
	  * 
	  * \param Jugador jugador que esta jugando 
	  * \param Jugador jugador que esta esperando
	  * 
	  * \return boolean devuelve true si el jugador actual se queda sin cartas.
	  */

	public boolean cardPlay(Jugador playerActual , Jugador playerRival){
 		try {
 
 			Carta [] manoJugador = playerActual.getMano();
 			int opcion;
 			boolean cartaValida = false;
 			boolean jugoCarta = false;
 			
 			//Se verifica si puede ganar
 			if(playerActual.verificarVictoria(playerActual.getMano())){
 				return true;
 			}
 				
 				//Se verifica que no hayan cartas por comer 
 				if(cantidadComer > 0){
 					boolean tieneCome = false;
 					
 					//Se verifica que tenga una carta de come para responder
 					for(int i = 0; i < playerActual.getTamanioMano(); i++){
 						if(manoJugador[i] != null && manoJugador[i].esCartaEspecial()){
 							if (manoJugador[i].getNumero() == comaMaximo){
 									tieneCome = true;
 							}
 						}
 					}
 
 					//En caso de que no la tenga come las cartas respectivas 
 					if(!tieneCome){
 						playerActual.coma(mazoRestante, cantidadComer);
 						cantidadComer = 0;
 						comaMaximo = 0;
 						System.out.println("\n\n**COMIO**");
 						playerActual.imprimirJugador();
 						GUI.pausa();
 						return false;
 					}
 
 
 				}	

 				//Verifica que tenga cartas validas para jugar.
 				for (int i = 0; i < playerActual.getTamanioMano(); i++) {
    				if (manoJugador[i] != null &&
       					(manoJugador[i].comparar(getCartaEnJuego()) || manoJugador[i].esCartaEspecial() || getCartaEnJuego().esCartaEspecial())) {
        					jugoCarta = true;
        					break;
    			}
			}

			//En caso de no tener se come una carta y se rompe el metodo
			if(!jugoCarta) {
				System.out.println("\nNo tiene cartas válidas... \nComiendo carta...");
    			GUI.pausa();
    			playerActual.coma(mazoRestante, 1);
   			 	System.out.println("Se acaba su turno...");
    			return false;
			
				}
 	
 				
 				//Interaccion con el usuario 
                System.out.println("\nElija una carta: ");
 				opcion = input.nextInt() - 1;
 				input.nextLine();


 				//Bucle que lo obliga a poner la carta valida que tenga 
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

                 //Si la carta en juego es especial se puede jugar cualquier cosa
                 if(getCartaEnJuego().esCartaEspecial()){
 
                 	if(getIndiceCartaEnJuego() < 89){
                 		mazoEnJuego[getIndiceCartaEnJuego() + 1] = manoJugador[opcion];
                 		playerActual.descartarCartas(opcion);
                 		jugoCarta = true;
                 		cartasEnJuego ++;
 
                 	}
 
                 }
 
 				//Verifica que use una carta especial o una carta con el mismo color o numero 
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
 					
 					//Se descartan las cartas
                 	if(getIndiceCartaEnJuego() < 89){
                 		mazoEnJuego[getIndiceCartaEnJuego() + 1] = manoJugador[opcion];
                 		playerActual.descartarCartas(opcion);
                 		jugoCarta = true;
                 		cartasEnJuego ++;

                 	}
 
 
 
                 }  
 

 				
                 else if(!jugoCarta){
 
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

	

 /*! \brief Metodo principal para jugar, se recibe un jugador como parametro, para organizar los turnos. 
	  * 
	  * 
	  * Se pasa verificando si hay cartas para comer, en dado caso se ve si el jugador puede responder o no.
	  * 
	  * Tambien se verifica si el jugador tiene alguna carta valida. Si tiene carta valida se le obliga a ponerla para que no pierda el turno.
	  * 
	  * En caso de no tener carta valida no se le permite elegir ninguna carta, y come una automaticamente, perdiendo el turno.
	  * 
	  * \param Jugador jugador NPC
	  * 
	  * 
	  */
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

	 /*! \brief Devuelve el indice del mazo de la ultima carta que se puso, el siguiente espacio sera null.
	  * 
	  * \return int devuelve el indice del mazo donde esta la ultima carta.
	  */
	public int getIndiceCartaEnJuego(){
		int indice = 0;
		while(mazoEnJuego[indice]!= null){
			indice++;
		}

		return indice - 1;

	}


	/*! \brief Devuelve la carta que esta en juego 
	 * 
	 * 
	 * \return devuelve la ultima carta jugada, la carta en juego.
	 */
	public Carta getCartaEnJuego(){
		int indice = 0;
		while(mazoEnJuego[indice]!= null){
			indice++;
		}

		return mazoEnJuego[indice -1];

	}


	 /*! \brief imprime la carta que esta en juego para que el usuario la vea.
	  */
	public void imprimirCartaEnJuego(){
		Carta actual = mazoEnJuego[getIndiceCartaEnJuego()];
		actual.imprimir();
	}
	 /*! \brief metodo que se usa en la carta Cancelar
	  * 
	  * Quita la cantidad por comer
	  */
	public void cancelarComa (){
		Carta cartaEnJuego = getCartaEnJuego();
		if (cartaEnJuego.getNumero() == -2 || cartaEnJuego.getNumero() == -3){
			cantidadComer = 0;
		}

	}

	 /*! \brief Agarra una Carta de las cartas en juego
	  * 
	  * \param int indice de la carta
	  */
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


	 /*! \brief Se utiliza para la carta Buscar, se elige una carta del mazo ya jugado.
	  * 
	  * \param Jugador el jugador que activa la carta.
	  */
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


 	 /*! \brief Mismo funcionamiento que el buscar carta pero para el NPC
 	  * 
 	  * Utiliza math.random para elegir una carta al azar del mazo ya jugado
 	  *
 	  * \param Jugador NPC
 	  */

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