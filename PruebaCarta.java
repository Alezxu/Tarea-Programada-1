public class PruebaCarta{
	public static void main (String [] args){

		Mazo mazo = new Mazo();
		mazo.imprimir();	

		System.out.println("Fin de la impresion -  - - - - - - -  -- ");

		mazo.revolver();
		mazo.imprimir();

		//int aleatorio = (int)(Math.random() * 52); //[0,1[
		//System.out.println(aleatorio);
	}

}