package tp1.tp4.ej2;

import java.util.NoSuchElementException;
import java.util.Scanner;

import tp1.tp4.tj3.LectorEnteros;
import tp1.tp4.tj3.RangoDeEnteros;

public class Ej2 {
	
	static Scanner input = new Scanner(System.in);
	public static LectorEnteros lector = new LectorEnteros(input);
	
	public static void main(String[] args) {
		
		
		final RangoDeEnteros RANGO_NRO_DOCUMENTO = new RangoDeEnteros(1000000, 99999999);
		final RangoDeEnteros RANGO_ANIO_NACIMIENTO = new RangoDeEnteros(1900, 2022);
		
		String mensajeSalida = "Ingrese el %s :";
		
		Alumno 	alumno = new Alumno(Boolean.TRUE,
						pedir(String.format(mensajeSalida, "nombre")),
						pedir(String.format(mensajeSalida, "año de nacimiento"),RANGO_ANIO_NACIMIENTO),
						pedir(String.format(mensajeSalida, "dni"),RANGO_NRO_DOCUMENTO));
		
		input.close();
		System.out.println(alumno.toString());

		if (alumno.vive()) {
			System.out.println("La persona vive");
		} else {
			System.out.println("La persona no vive");
		}
		
	}
	
	public static String pedir(String mensaje) {
		String valorIngresado = "";
		boolean esValido = false;
		while (!esValido) {
			try {
				System.out.print(mensaje);
				valorIngresado = input.nextLine();
				esValido = true;
			} catch (NoSuchElementException e) {
				System.out.println(e);
			}
		}
		return valorIngresado;
	}
	
	public static int pedir(String mensaje, RangoDeEnteros rango) {
		int numero = 0;
		boolean esValido = false;
		while (!esValido) {
			try {
				numero = lector.pedir(mensaje, rango);
				esValido = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return numero;
	}
	
}

