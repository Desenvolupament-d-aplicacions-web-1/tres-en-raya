package tresEnRaya;

import java.util.Scanner;
import java.util.Random;

public class tresEnRaya {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	// Creo el scanner y el Random
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	
	// Pido los nombres de los dos jugadores
	System.out.print("(X) - Nombre del Jugador 1: ");
    String jugador1 = s.nextLine();
    System.out.print("(O) - Nombre del Jugador 2: ");
    String jugador2 = s.nextLine();

}

}
