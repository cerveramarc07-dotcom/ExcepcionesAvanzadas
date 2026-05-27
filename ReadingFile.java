package Advacedexceptions;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ReadingFile {
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		
		String opcion = "";
		while(!opcion.equals("0")) {
			
		System.out.println("Dime el nombre del archivo");
		
		String nom = sc.nextLine();
		System.out.println("Que quieres hacer: 0:Salir, 1:crear, 2:escribir , 3:leer o 4:borrar "  );
		opcion = sc.nextLine();
		
	
		switch(opcion) {
		case "1":
			crearArchivoModerno(nom);
			break;
		case "2":
			System.out.println("Dime el texto que quieres escribir el archivo");
			String txt = sc.nextLine();
			escritor(nom, txt);
			break;
		case "3":
			lector(nom);
			break;
		case "4":
			borrar(nom);
			break;
			
		default: System.out.println("No has seleccionado ninguna opcion");
		}
		
		
	}
}
	
	public static void crearArchivoModerno(String nom) {
        Path ruta = Paths.get(nom + ".txt");
        
        try {
            Files.createFile(ruta);
            System.out.println("Archivo creado con éxito de forma moderna.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo o ya existía: " + e.getMessage());
        }
    }
	
	
	public static void escritor(String filename, String txt) {
		
		try {
			File obj = new File(filename + ".txt");
			if(obj.exists()) {
				FileWriter obj1 = new FileWriter(obj.getName());
				obj1.write(txt);
				System.out.println("Se a escrito en el fichero " + filename);
				obj1.close();
			}	
			
		}catch(IOException Error) {
			System.out.println("Hubo un problema al escribir en el fichero o no existe");
		}
	}
	
	public static String getName(String file) {
		File obj = new File(file + ".txt");
		if(obj.exists()) {
			return obj.getName(); 
		}else {
			return "El fichero no existe";
		}
	}
	
	
	
	public static void lector(String file) {
		
		File obj = new File(file + ".txt");
		try {
			Scanner lector= new Scanner(obj);
			while(lector.hasNextLine()) {
				String data = lector.nextLine();
				System.out.println(data);
			}
		}catch(Exception Error) {
			System.out.println("No se puede leer el archivo");
		}
	}
	
	public static void borrar(String file) {
		File obj = new File(file + ".txt");
		if(obj.exists()) {
			System.out.println("Se ha eliminado el fichero " + obj.getName());
			obj.delete();
		}else {
			System.out.println("No se a podido borrar el archivo");
		}
	}
	

	
}