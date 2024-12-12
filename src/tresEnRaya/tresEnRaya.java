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

// Determino quien empieza
		boolean jugarDeNuevo = true;
		while (jugarDeNuevo) {
			String turno = rand.nextBoolean() ? jugador1 : jugador2;
			System.out.println(" ");
			System.out.println(turno + " comienza primero. ");

			// Creo el tablero y lo muestro
			boolean juegoTerminado = false;
			char[] tablero = { '_', '_', '_', '_', '_', '_', '_', '_', '_' };

			while (!juegoTerminado) {
				System.out.println(" ");
				System.out.println("Tablero actual:");
				for (int i = 0; i < 9; i++) {
					System.out.print(" " + tablero[i] + " ");
					if (i % 3 == 2)
						System.out.println();
				}

				// Pido que se inicie un turno
				System.out.println(" ");
				System.out.println(turno + ", introduce tu posición (1-9): ");
				int posicion = s.nextInt() - 1;

				// Hago que si la posicion no esta en el tablero salte un mensaje de error
				if (posicion < 0 || posicion >= 9 || tablero[posicion] != '_') {
					System.out.println("Movimiento inválido, intenta de nuevo.\n");
					continue;
				}

				tablero[posicion] = turno.equals(jugador1) ? 'X' : 'O';

				// Verifico si hay una linia ganadora en la ronda
				if ((tablero[0] != '_' && tablero[0] == tablero[1] && tablero[1] == tablero[2])
						|| (tablero[3] != '_' && tablero[3] == tablero[4] && tablero[4] == tablero[5])
						|| (tablero[6] != '_' && tablero[6] == tablero[7] && tablero[7] == tablero[8])
						|| (tablero[0] != '_' && tablero[0] == tablero[3] && tablero[3] == tablero[6])
						|| (tablero[1] != '_' && tablero[1] == tablero[4] && tablero[4] == tablero[7])
						|| (tablero[2] != '_' && tablero[2] == tablero[5] && tablero[5] == tablero[8])
						|| (tablero[0] != '_' && tablero[0] == tablero[4] && tablero[4] == tablero[8])
						|| (tablero[2] != '_' && tablero[2] == tablero[4] && tablero[4] == tablero[6])) {
					juegoTerminado = true;
					System.out.println("\n¡" + turno + " ha ganado!\n");

					// Determino si el tablero esta lleno para el empate
				} else {
					boolean tableroLleno = true;
					for (char c : tablero) {
						if (c == '_') {
							tableroLleno = false;
							break;
						}
					}

					if (tableroLleno) {
						System.out.println("Es un empate! :)");
						juegoTerminado = true;
					} else {
						turno = turno.equals(jugador1) ? jugador2 : jugador1;
					}
				}
			}

			// Pregunto si quiere volver a jugar

			System.out.println("¿Quieren jugar otra vez? (sí/no): ");
			jugarDeNuevo = s.next().equalsIgnoreCase("sí");
			s.nextLine();
		}
		System.out.println("Gracias por jugar!");
		s.close();

	}

}
