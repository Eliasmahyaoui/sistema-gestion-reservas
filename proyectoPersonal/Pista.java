package proyectoPersonal;

public class Pista {
	//Variables 
	private String nombre;
	private String tipo; // Tenis, padel, Futbol.(Supongo que en el tipo tiene que ser un arraylist, nose...)
	private double precioHora;



	//Método constructor
	public Pista(String nombre, String tipo, double precioHora) throws Exception {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precioHora = precioHora;

		//Excepciones 
		if (tipo.equalsIgnoreCase("Tenis") || tipo.equalsIgnoreCase("Padel")|| tipo.equalsIgnoreCase("Futbol")) {
			this.tipo= tipo;
		}else {
			throw new Exception("ERROR: Tipo no identificado.");
		}
	}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}

	@Override
	public String toString() {
		return "Pista [nombre=" + nombre + ", tipo=" + tipo + ", precioHora=" + precioHora + "]";
	}

}
