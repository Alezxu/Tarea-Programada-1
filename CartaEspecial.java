public class CartaEspecial{

	private int numeroE;

	public String asignarTipoEspecial(int numeroE){
		String tipoCartaE = "";
		switch(numeroE){
			case 0:
				tipoCartaE = "Coma 2";
			break;
			case 1:
				tipoCartaE = "Coma 3";
			break;
			case 2:
				tipoCartaE = "Cancelar";
			break;
			case 3:
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