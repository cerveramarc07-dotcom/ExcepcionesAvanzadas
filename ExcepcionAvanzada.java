package Advacedexceptions;

import java.util.Scanner;

public class ExcepcionAvanzada {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el tamaño del array");
		int tam = sc.nextInt();
		int[] num = new int[tam];
		
		for(int i =0; i<num.length; i++) {
			System.out.println("Introduzca el numero " + (i+1) + " numero");
			num[i] = sc.nextInt();
		}
		
		/*try {
			System.out.println(num[2]);
			System.out.println((num[1]/0));
		}catch(ArrayIndexOutOfBoundsException Error){
			System.out.println("Indice fuera de rango" );
		}catch(ArithmeticException Error) {
			System.out.println("No se puede dividir un numero entre cero");
		}
		*/
		/*try {
			System.out.println(num[5]);
			System.out.println((num[2]/0));
		}catch(ArrayIndexOutOfBoundsException | ArithmeticException Error) {
			System.out.println("No se puede dividir entre 0 o el indice esta fuera del rango");
		}
		*/
		String txt = null;
		try {
			System.out.println(txt.length());
		}catch(NullPointerException Error) {
			System.out.println("La variable es null");
		}
		
		
		
	}

}
