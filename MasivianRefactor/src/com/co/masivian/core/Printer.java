/**
 * 
 */
package com.co.masivian.core;

import com.co.masivian.util.PrinterConstantes;

/**
 * @author erick
 *
 */
public class Printer {
	/* Declaracion de variables necesarias para la ejecucion del programa **/
	int P[] = new int[PrinterConstantes.getM() + 1];
	int C;
	int J = 1;
	int K = 1;
	boolean JPRIME;
	int N = 0;
	int MULT[] = new int[PrinterConstantes.getOrdmax() + 1];
	int ord = PrinterConstantes.getOrd();
	int square = PrinterConstantes.getSquare();
	int pageNumber = PrinterConstantes.getPagenumber();
	int pageOffSet = PrinterConstantes.getPageoffset();
	int muestra = PrinterConstantes.getM();
	int rowOffSet = PrinterConstantes.getRowoffset();
	int constanteCC = PrinterConstantes.getCc();

	/*
	 * Se crea metodo que dispara la ejecucion de la clase que optimiza la ejecucion
	 * de la misma y evita la programacion spaguetti
	 */
	public void calcularPrinter() {
		P[1] = 2;
		while (K < muestra) {
			do {
				J += 2;
				if (J == square) {
					ord++;
					square = P[ord] * P[ord];
					MULT[ord - 1] = J;
				}
				N = 2;
				JPRIME = true;
				while (N < ord && JPRIME) {
					while (MULT[N] < J)
						MULT[N] += P[N] + P[N];
					if (MULT[N] == J) {
						JPRIME = false;
					}
					N++;
				}
			} while (!JPRIME);
			K++;
			P[K] = J;
		}
		while (pageOffSet <= muestra) {
			System.out.print("The First ");
			System.out.print(Integer.toString(muestra));
			System.out.print(" Prime Numbers === Page ");
			System.out.print(Integer.toString(pageNumber));
			System.out.println("\n");
			for (rowOffSet = pageOffSet; rowOffSet <= (pageOffSet + PrinterConstantes.getRr() - 1); rowOffSet++) {
				for (C = 0; C <= constanteCC - 1; C++)
					if (rowOffSet + C * PrinterConstantes.getRr() <= muestra)
						System.out.printf("%10d", P[rowOffSet + C * PrinterConstantes.getRr()]);
				System.out.println();
			}
			System.out.println("\f");
			pageNumber++;
			pageOffSet += PrinterConstantes.getRr() * constanteCC;
		}
	}
}