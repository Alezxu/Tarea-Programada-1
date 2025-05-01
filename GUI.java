
import java.util.Scanner;
import java.util.InputMismatchException;


public class GUI{

    public static void limpiarPantalla() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception ex){}
    }

    public static void pausa(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite ENTER para continuar...");
        input.nextLine();
    }

    public static void menuPrincipal(){
        Juego juego = new Juego();
        boolean bandera = true;
        boolean banderaVolver = true;
        Scanner input = new Scanner(System.in);
        while (bandera) {
        
            System.out.println("**UNO Y MEDIO**");
            System.out.println("1. Single Player");
            System.out.println("2. Multiplayer");
            System.out.println("3. Reglas");
            System.out.println("4. Salir");

            try{
                int opcion = input.nextInt();
                input.nextLine(); 
                
                if (opcion == 1) {
                    banderaVolver = true;
                    while(banderaVolver){
                        juego.empezarJuegoPVE();


                        boolean jugarOtra = volverAJugar();
                        if(!jugarOtra){
                            banderaVolver = false;
                        }

                   }

                } else if (opcion == 2) {
                    banderaVolver = true;
                    while(banderaVolver){
                        juego.empezarJuegoPVP();


                        boolean jugarOtra = volverAJugar();
                        if(!jugarOtra){
                            banderaVolver = false;
                        }

                   }

                    

                } else if (opcion == 3){
                    limpiarPantalla();
                    System.out.println("**REGLAS**\nEl objetivo del juego es ser el primer jugador en quedarse sin cartas en la mano.\n1. Se reparten 5 cartas a cada jugador .\n2. Cada jugador en orden debe descartar una carta de su mano, que coincida en color, numero o simbolo con la carta en juego.\n3. Si un jugador no tiene carta que coincida, debe robar una carta de la pila.\n4. Existen cartas especiales; Come 2, Come 3, Cancelar y Buscar. El funcionamineto es el siguiente:\n\nO- Las cartas especiales se pueden utilizar en cualquier momento\nO- Si un jugador utiliza un Come, el siguiente debera comer las cartas que se indiquen, si tiene un Come en su mano, podra utilizarlo, siempre y cuando no sea un Come menor al que esta en juego.\nO- La carta de Cancelar, cancela el tener que comer cartas.\nO- La carta Busca, permite al jugador buscar y elegir la carta que quiera dentro de la pila ya jugada. ");
                    pausa();
                    limpiarPantalla();
                } else if (opcion == 4) {
                    bandera = false;
                }else{
                    System.err.println("Opcion Incorrecta.");
                    pausa();
                    limpiarPantalla();
                }

        }   catch(InputMismatchException exception){
                System.err.println("Opcion Incorrecta.");
                input.nextLine();
                pausa();
                limpiarPantalla();
    }


}
}


    public static boolean volverAJugar(){
        Scanner input = new Scanner(System.in);
        try{
           
            System.out.println("Desea volver a jugar?\n 1: si | 0: no");
            int opcion = input.nextInt();
            input.nextLine(); 

            if(opcion == 1){
               return true;
            }


            if(opcion == 0){
                return false;
            }

            

        }  catch(InputMismatchException exception){
                System.err.println("Opcion Incorrecta.");
                input.nextLine();
                pausa();
                limpiarPantalla();

    } return false;
} 
}
