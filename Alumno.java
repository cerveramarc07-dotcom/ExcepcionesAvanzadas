package Advacedexceptions;

public class Alumno {
	private String nombre;
	private double nota1, nota2, nota3;
	
	public Alumno(String nombre, double nota1, double nota2, double nota3) {
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