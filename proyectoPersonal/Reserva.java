package proyectoPersonal;

public class Reserva {
	//Variables 
		private Usuario usuario;
		private Pista pista;
		private String fecha;
		private String hora;

		//Método constructor
		public Reserva(Usuario usuario, Pista pista , String fecha, String hora) throws Exception {
			super();
			this.usuario = usuario;
			this.pista = pista;
			this.fecha = fecha;
			this.hora = hora;

		}
	
		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Pista getPista() {
			return pista;
		}

		public void setPista(Pista pista) {
			this.pista = pista;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getHora() {
			return hora;
		}

		public void setHora(String hora) {
			this.hora = hora;
		}

		@Override
		public String toString() {
			return "Reserva [usuario=" + usuario + ", pista=" + pista + ", fecha=" + fecha + ", hora=" + hora + "]";
		}
}

