
//! \class Clase CartaEspecial 
/*! 
 * Clase que crea las Cartas Especiales, con sus valores especificos, se crean por aparte porque no tienen un color ni numero como tal
 */


public class CartaEspecial{

	private int numeroE; /*!< Numero que tendra la carta */

	/*! \brief Retorna el tipo de Carta que se crea
	 * \param int numero de indice 
	 * \return String tipo de Carta especial
	 */
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

	/*! \brief Constructor de clase
	 * Asigna el indice de la carta 
	 * \param int numero de indice 
	 */
	public CartaEspecial(int numero){
		if(numero >= 0 && numero <=3){
			this.numeroE = numero;
		}
		
	}

	
	}
