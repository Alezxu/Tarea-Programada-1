/*

Carta
- numero
- color
+ setNumero()
+ setcolor()
+ getNumero()
+ getcolor()
+ imprimir()
*/

/*  0..8 -> cartas normales (numeros)
9 -> coma 2 
10-> coma 3 
11 -> cancelar 
12 -> buscar
*/

public class Carta{

	private int numero;
	private String color;

	private String convertirNumero(){
		String numeroString = "";
		switch(numero){
			case 9:
				numeroString = "Coma 2";
			break;
			case 10:
				numeroString = "Coma 3";
			break;
			case 11:
				numeroString = "Cancelar";
			break;
			case 12:
				numeroString = "Buscar Carta";
			break;
			default:
				numeroString += numero;
		}
		return numeroString;
	}

	// Constructor de clase
	// Primer metodo que se ejecuta cuando se genera una instancia
	public Carta(){
		numero = 6;
		color = "Rojo";
	}


	public Carta(int numero, String color){
		if(numero >= 0 && numero <=12){
			this.numero = numero;
		}
		this.color = color;
	}

	public CartaEspecial(int numero){
		if(numero >= 0 && numero <=12){
			this.numero = numero;
		}

	public void setNumero(int numero){
		if(numero >= 0 && numero < 13){
			this.numero = numero;	
		}
	}

	public void setcolor(String color){
		this.color = color;
	}

	public int getNumero(){
		return this.numero;
	}

	public String getcolor(){
		return this.color;
	}

	public void imprimir(){
		System.out.println( convertirNumero() + " " + color);
	}
	
}