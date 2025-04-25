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

	public Carta(String color){
		this.numero = -1;
		this.color = color;
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

	/*public void imprimir(){
		System.out.println( getNumero() + " " + color);
	} ESTO ESTA COMENTADO PARA IMPRIMIR LAS LISTAS MAS BONITAS PARA EL USUARIO
		*/

	public void imprimir(){
		System.out.print("[" + getNumero() + " " + color + "]");
	}

	
	//Compara una carta con otra. Verifica que el numero de una carta o el color sea igual para devolver true.
	public boolean comparar(Carta a){
		boolean resultado = false;

		if(this.numero == a.getNumero() || this.color.equals(a.getcolor())){
			resultado = true;
		}
		return resultado;
	}

	
	
}