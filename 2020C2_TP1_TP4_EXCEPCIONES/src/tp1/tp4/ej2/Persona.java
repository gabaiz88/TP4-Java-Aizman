package tp1.tp4.ej2;

public abstract class Persona {
	
	private boolean estaVivo;
	
	
	public Persona(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	public boolean vive() {
		return isEstaVivo();
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}	
	
}
