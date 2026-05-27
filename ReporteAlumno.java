package Advacedexceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Alumnos {
	private String nombre;
	private double nota1, nota2, nota3;
	
	public Alumnos(String nombre, double nota1, double nota2, double nota3) {
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public String getNombre() {
		return nombre;
	}
	
	public double getMedia() {
		return (nota1 + nota2 + nota3) / 3.0;
	}
	
}

public class ReporteAlumno {
	
	public static void main(String[] args) {
		/*Tenemos un archivo llamado alumnos.csv donde cada línea contiene el 
		  nombre de un alumno y tres notas separadas por comas (ej: Ana,8,9,7).
		  El objetivo es:
		  Leer el archivo y, por cada línea, instanciar un objeto de la clase Alumno.
		  Calcular la nota media de cada alumno.
		  Escribir un nuevo archivo llamado reporte_final.txt que muestre el nombre del alumno y 
		  si está "Aprobado" (media >= 5) o "Suspendido" (media < 5).
		 */
		String ficheroIni = "alumnos.csv";
		String report = "reporte_final.txt";
		
		List<Alumnos> AlumnList = new ArrayList<>();
		
		
		 try(BufferedReader br = new BufferedReader( new FileReader(ficheroIni))){
			String l;
			while((l = br.readLine()) !=null) {
				System.out.println(l);
				String[] partes = l.split(",");
				if(partes.length == 4) {
					String nombre = partes[0] ;
					double nota1 = Double.parseDouble(partes[1]);
					double nota2 = Double.parseDouble(partes[2]);
					double nota3 = Double.parseDouble(partes[3]);
					AlumnList.add(new Alumnos(nombre,  nota1, nota2, nota3));
					
					
				}
			}
				
		}catch(IOException | NumberFormatException E) {
			System.out.println("Error procesando la entrada" + E.getMessage()); 
		}
		 
		try(BufferedWriter bw = new BufferedWriter( new FileWriter(report))){
			 bw.write("Reporte del rendimiento del estudiante \n");
			 for(Alumnos Alum:AlumnList) {
				 double media = Alum.getMedia();
				 System.out.println(Alum.getNombre() + Alum.getMedia());
				 String estado = (media >= 5.0) ? "Aprovado" : "Suspendido";
				 
				 bw.write(String.format("Alumno: %s | Media: %.2f | Estado: %s \n",Alum.getNombre(),media,estado));
				 
			 }
			
			 System.out.println("Se ha creado un reporte con exito " + report);
			 
		}catch(IOException E) {
			System.out.println(E.getMessage()); 
		}
		
	}	
}

	