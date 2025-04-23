public class CartaEspecial{

	private int numeroE;

	private String convertirNumero(){
		String numeroString = "";
		switch(numeroE){
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
				numeroString += numeroE;
		}
		return numeroString;
	}

	public CartaEspecial(int numero){
		if(numero >= 9 && numero <=12){
			this.numeroE = numero;
		}
		
	}

	public void imprimirEspecial(){
		System.out.println( convertirNumero() + " " );
	}
}