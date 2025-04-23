public class PruebaCarta{
	
	public static void main (String [] args){
		Carta carta1 = new Carta();
		carta1.setNumero(7);
		carta1.setcolor("azul");
		carta1.imprimir();

		Carta carta2 = new Carta();
		carta2.setNumero(4);
		carta2.setcolor("verde");
		carta2.imprimir();

		Carta carta3 = new Carta(0, "rojo");
		carta3.imprimir();

		CartaEspecial carta4 = new CartaEspecial(9);
		carta4.imprimirEspecial();

		CartaEspecial carta5 = new CartaEspecial(10);
		carta5.imprimirEspecial();
		
		CartaEspecial carta6 = new CartaEspecial(11);
		carta6.imprimirEspecial();
		
		CartaEspecial carta7 = new CartaEspecial(12);
		carta7.imprimirEspecial();

		CartaEspecial carta8 = new CartaEspecial(13);
		carta8.imprimirEspecial();
		
		CartaEspecial carta9 = new CartaEspecial(8);
		carta9.imprimirEspecial();

	}
}