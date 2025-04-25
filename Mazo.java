public class Mazo{
	//Atributos
	private Carta [] cartas;
	private int cartasRestantes;

	//Constructor de Mazo
	public Mazo(){
		cartas = new Carta [88];
		int contador = 0;

		//Pone las cartas especiales por separado

		for (int tipo = 0; tipo <4; tipo++){
			for (int i = 0; i <4; i++){

				CartaEspecial cartaE = new CartaEspecial(tipo);
				String stringEspecial = cartaE.asignarTipoEspecial(tipo);

				Carta especial = new Carta(stringEspecial);
				cartas [contador] = especial;
				contador++;
			}
		}

		//Pone las cartas normales
		for(int color = 0; color <4 ; color++){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j<2; j++){
					Carta carta = new Carta(i, obtenerColor(color));
					cartas [contador] = carta;
					contador++;
				}
			}
		}

		cartasRestantes = 88;

		revolver();
	}

	//Asigna los colores dependiendo del indice 
	private String obtenerColor(int i){
		String color = "";
		switch(i){
		case 0:
			color = "Rojo";
			break;
		case 1:
			color = "Verde";
			break;
		case 2:
			color = "Azul";
			break;
		case 3:
			color = "Naranja";
			break;
		}
		return color;
	}


	//Revuelve el mazo aleatoriamente
	public void revolver(){
		for(int i = 0 ; i < cartas.length ;i++){
			// Voy a intercambiar i con algo aleatorio
			int aleatorio = (int)(Math.random() * 88); //[0,1[
			Carta temp = cartas[i];
			cartas[i] = cartas[aleatorio];
			cartas[aleatorio] = temp;
		}
	}

	//Imprime el mazo, utilizando el imprimir dentro de la clase Carta.
	public void imprimir(){
		for(int i = 0 ; i < cartasRestantes; i++){
			if(cartas[i]!= null){
				cartas[i].imprimir();
			}
		}
	}


	//Agarra la primera carta del array. Luego va moviendo todas las cartas a la izquierda, hasta que la ultima queda null
	public Carta repartirCartas(int indice){
		
			Carta repartida = cartas[indice];

			for(int i = 0; i < cartasRestantes - 1; i++){

				cartas[i] = cartas [i+1];
			}

			cartas[cartasRestantes - 1] = null;
			cartasRestantes --;

			return repartida;
	}


}