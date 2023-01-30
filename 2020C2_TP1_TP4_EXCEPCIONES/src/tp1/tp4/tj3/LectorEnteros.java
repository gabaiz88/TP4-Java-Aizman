package tp1.tp4.tj3;

import java.util.Scanner;

public class LectorEnteros {
	private static final String MENSAJE_ERROR_SCANNER_NULL = "Debe recibirse un Scanner.";
	private static final String MENSAJE_CARGA_ENTERO = "Ingrese un numero entero cualquiera";
	private static final String MENSAJE_FUERA_DE_RANGO = "El valor ingresado esta fuera del rango aceptable. Debe estar entre %d y %d";
	private static final String MENSAJE_ERROR_ENTERO = "El valor ingresado es inválido. Ingrese un numero entero";

	private Scanner scanner;

	private int cargar(String mensaje) {
		System.out.println(mensaje);
		return Integer.parseInt(scanner.nextLine());
	}
	public LectorEnteros(Scanner scanner) throws IllegalArgumentException{
		if(scanner == null) {
			throw new IllegalArgumentException(MENSAJE_ERROR_SCANNER_NULL);
		}
		this.scanner = scanner;
	}

	public int pedir(String mensaje) {
		int numero = 0;
		boolean esValido = false;
		while (!esValido) {
			try {
				numero = cargar(mensaje);
				esValido = true;
			} catch (NumberFormatException e) {
				System.out.println(MENSAJE_ERROR_ENTERO);
			}
		}
		return numero;
	}

	public int pedir(String mensaje, int limiteA, int limiteB) throws IllegalArgumentException{
		int num = pedir(mensaje);
		if(num < limiteA || num > limiteB) {
			throw new IllegalArgumentException(String.format(MENSAJE_FUERA_DE_RANGO, limiteA, limiteB));
		}
		return num;
	}

	public int pedir(String mensaje, RangoDeEnteros rangoValido) throws IllegalArgumentException{
		return this.pedir(mensaje,rangoValido.getLimiteInferior(),rangoValido.getLimiteSuperior() );
	}
	
}
