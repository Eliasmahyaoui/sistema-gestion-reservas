package proyectoPersonal;

public class Usuario {
	//Variables 
		private String nombre;
		private String email;
		private String telefono;
		private String contraseña;


		//Metodo constructor
		public Usuario(String nombre, String email, String telefono, String contraseña) throws Exception {
			super();
			this.nombre = nombre;
			this.email = email;
			this.telefono = telefono;
			this.contraseña = contraseña;


			//Excepciones en el constructor sin  try catch! //Try cacth en los metodos.

			if (!email.contains("@")) {
				throw new Exception("El email debe contener un @.");
			}

			if (!email.contains(".")) {
				throw new Exception("El email debe de contener un punto.");

			}

			if (!telefono.matches("[0-9]{9}")) {
				throw new IllegalArgumentException("El telefono debe tener 9 digitos.");
			}

		}

		//Getters y Setters 
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}


		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}


		@Override
		public String toString() {
			return "Usuario [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", contraseña="
					+ contraseña + "]";
		}
}
