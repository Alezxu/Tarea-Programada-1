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
		System.out.println( getNumero() + " " + color);
	}
	
}