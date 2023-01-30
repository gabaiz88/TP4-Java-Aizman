package tp1.tp4.ej2;


public class Alumno extends Persona{
	
	private String nombreCompleto;
	private int anioNacimiento;
	private int dni;
	private int legajo;
	
	public Alumno(boolean estaVivo, String nombreCompleto, int anioNacimiento, int dni) {
		super(estaVivo);
		setNombreCompleto(nombreCompleto);
		setAnioNacimiento(anioNacimiento);
		setDni(dni);
		setLegajo(dni);
	}
	
	
	private void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	private void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}


	private void setDni(int dni) {
		this.dni = dni;
	}


	private void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	@Override
	public String toString() {
		return "Alumno [nombreCompleto=" + nombreCompleto + ", anioNacimiento=" + anioNacimiento + ", dni=" + dni
				+ ", legajo=" + legajo + "]";
	}
	

}
