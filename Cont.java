package Advacedexceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Cont {
	public static void main(String[] args) {
		/*Crear un programa que lea un archivo de texto llamado log.txt línea por línea. 
		 * El programa debe contar cuántas veces aparece la palabra "ERROR" y
		 * cuántas veces aparece la palabra "WARNING". 
		 * Al finalizar, debe mostrar el conteo total por consola. 
		 * Si el archivo no existe, debe capturar la excepción y mostrar un mensaje amigable.
		 */
		
		String r = "log.txt";
		int contError = 0;
		int contWarning = 0;
		
		try(BufferedReader bf = new BufferedReader(new FileReader(r))) {
			String l;
			
			while((l = bf.readLine()) !=null) {

				String ig = l.toLowerCase();
				
				if(ig.contains("error")) {
					contError++;
				}
				
				if(ig.contains("warning")) {
					contWarning++;
				}
			}
			
			System.out.println("Error aparece " + contError + " veces y warning " + contWarning + " veces" );
			
		}catch(IOException Error) {
			System.out.println("El archivo especificado no existe");
		}
		
		
	}
}
