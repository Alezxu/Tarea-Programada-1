public class CartaEspecial{

	private int numeroE;

	public String asignarTipoEspecial(int numeroE){
		String tipoCartaE = "";
		switch(numeroE){
			case 2:
				tipoCartaE = "Coma 2";
			break;
			case 3:
				tipoCartaE = "Coma 3";
			break;
			case 4:
				tipoCartaE = "Cancelar";
			break;
			case 5:
				tipoCartaE = "Buscar Carta";
			break;
			default:
				tipoCartaE += numeroE;
		}
		return tipoCartaE;
	}

	public CartaEspecial(int numero){
		if(numero >= 0 && numero <=3){
			this.numeroE = numero;
		}
		
	}

	//public void imprimirEspecial(){
		//System.out.println( convertirNumero() + " " );
	}
//}