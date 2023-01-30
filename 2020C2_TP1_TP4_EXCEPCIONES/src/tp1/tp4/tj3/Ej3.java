package tp1.tp4.tj3;

import java.time.Year;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ej3 {
	public static Scanner input = new Scanner(System.in);
	public static LectorEnteros lector = new LectorEnteros(input);
	final static String SI = "S";
	final static String NO = "N";
	
	public static void main(String[] args) {
		
		final RangoDeEnteros RANGO_ANIO_NACIMIENTO = new RangoDeEnteros(1900, 2022);
		final int ANIO_ACTUAL = Year.now().getValue();
	
		
		String mensajeSalida = "La persona %s y %s %d años";
		
		int nacimiento = 0;
		int fallecimiento = -1;
		int edad = 0;
		String vive = "";
		
		nacimiento = pedir("Ingrese la fecha de nacimiento: ", RANGO_ANIO_NACIMIENTO);
		
		final RangoDeEnteros RANGO_ANIO_FALLECIMIENTO = new RangoDeEnteros(nacimiento, 2022);
		
		vive = pedir("¿La persona se encuentra viva? S/N: ");
		boolean estaVivo = vive.equals(SI);
		
		if(!estaVivo ) {
			fallecimiento = pedir("Ingrese la fecha de fallecmiento: ", RANGO_ANIO_FALLECIMIENTO);
		}
		
		edad = estaVivo ? ANIO_ACTUAL - nacimiento : fallecimiento - nacimiento;
		
		System.out.println(estaVivo ? 
				String.format(mensajeSalida,"vive", "tiene", edad) : 
					String.format(mensajeSalida, "no vive", "falleció a los", edad));
		
		
		input.close();
	}
	
	public static String pedir(String mensaje) {
		String valorIngresado = "";
		
		do {
			try {
				System.out.print(mensaje);
				valorIngresado = input.nextLine();
			} catch (NoSuchElementException e) {
				System.out.println(e);
			}
		} while( !valorIngresado.equals(SI) && !valorIngresado.equals(NO));
		
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
