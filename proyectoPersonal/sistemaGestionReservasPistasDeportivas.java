package proyectoPersonal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class sistemaGestionReservasPistasDeportivas {
	//Variables globales Scanner/Arraylist.
	static Scanner in = new Scanner(System.in);	
	static ArrayList<Usuario> Usuarios= new ArrayList<Usuario>();
	static ArrayList<Pista> Pistas= new ArrayList<Pista>();
	static ArrayList<Reserva> Reservas= new ArrayList<Reserva>();
	public static void main(String[] args) throws Exception {

		int opcion;

		do {
			mostrarMenu();
			System.out.println("Introduce una opcion:");
			opcion= in.nextInt();
			in.nextLine();//Vaciamos el buffer

			switch (opcion) {
			case 1:
				//Iniciar Sesion
				break;
			case 2:
				registrarUsuario();
				break;
			case 3:
				añadirPista(); 
				break;
			case 4:
				reservarPista();
				break;
			case 5:
				cancelarReservas(); 
				break;
			case 6:
				verPistas();
				break;
			case 7:	
				verReservas();
				break;
			case 8:	
				verUsuarios();
				break;
			case 0:
				System.out.println("Hasta la próxima!");
				break;
			default:
				System.out.println("Introduce una opción válida.");
				break;
			}
		} while (opcion!=0);
	}


	public static void mostrarMenu() {
		System.out.println("BIENVENIDO A LA GESTION DE RESERVAS DE PISTAS DEPORTIVAS MAHYAOUI S.L");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("1.Iniciar Sesion.");
		System.out.println("2.Registrar Usuario.");
		System.out.println("3.Añadir pista");
		System.out.println("4.Reservar pista:");
		System.out.println("5.Cancelar reserva.");
		System.out.println("6.Ver Pistas.");
		System.out.println("7.Ver reservas.");
		System.out.println("8.Ver Usuarios.");
		System.out.println("0.Salir.");
	}

	public static void registrarUsuario() throws Exception {

		try {
			System.out.println("Dime el nombre:");
			String nombre= in.nextLine();
			System.out.println("Dime el email:");
			String email= in.nextLine();
			System.out.println("Dime el telefono:");
			String telefono= in.nextLine();
			System.out.println("Dime la contraseña:");
			String contraseña = in.nextLine();

			Usuarios.add(new Usuario(nombre, email, telefono, contraseña));
			System.out.println("Usuario registrado correctamente.");
		}

		catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}




	}

	public static void verUsuarios() {
		if (Usuarios.isEmpty()) {
			System.out.println("No hay usuarios registrados.");
		}else {
			for (Usuario u : Usuarios) {
				System.out.println(u);
			}
		}
	}


	public static void añadirPista() throws Exception {
		System.out.println("Dime el nombre de la pista:");
		String nombrePista= in.nextLine();
		System.out.println("Dime el tipo de pista:");
		String tipoPista= in.nextLine();
		System.out.println("Dime el precio de la pista:");
		double precioPista= in.nextDouble();
		Pistas.add(new Pista(nombrePista, tipoPista, precioPista));
		System.out.println("Pista añadida correctamente.");


	}

	public static void verPistas() {

		for (Pista pista : Pistas) {
			{		
				System.out.println(pista.toString());
			}
		}


	}

	public static void reservarPista() throws Exception {

		System.out.println("Dime el usuario que hace la reserva:");
		String nombreUsuario = in.nextLine();

		Usuario usuario= null;
		boolean usuarioEncontrado= false;

		for (Usuario u : Usuarios) {
			if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
				usuarioEncontrado= true;
				usuario= u;
				break;

			}
		}

		if (usuario== null) {
			System.out.println("No se ha encontrado el usuario");
			return;
		}

		boolean pistaEncontrada= false;
		Pista pista= null;

		System.out.println("Tipo de pista que quieres reservar:");
		String tipoPista= in.nextLine();

		for (Pista p : Pistas) {
			if (p.getTipo().equalsIgnoreCase(tipoPista)) {
				pistaEncontrada= true;
				pista= p;
				break;
			}
		}
		if (pista== null) {
			System.out.println("No se ha encontrado esa pista.");
			return;
		}

		System.out.println("Dime la fecha");
		String fecha= in.nextLine();
		System.out.println("Dime la hora de reserva");
		String hora= in.nextLine();
		System.out.println("Dime el precio:");
		double precio= in.nextDouble();

		Reservas.add(new Reserva(usuario, pista, fecha, hora));
		System.out.println("Reserva realizada con éxito.");
	}

	//Este método se encargar simplemente de visualizar las reservas hechas previamente.
	public static void verReservas() {
		boolean encontrado= false;
		for (Reserva r : Reservas) {
			System.out.println(r.toString());
			encontrado= true;
		}
		if (!encontrado) {
			System.out.println("No existen reservas.");
		}
	}


	public static void cancelarReservas() {
		Iterator<Reserva> it = Reservas.iterator();
		//Pedimos al usuario los datos de la reserva.
		System.out.println("Dime el usuario de la reserva::");
		String usuario= in.nextLine();


		boolean encontrado= false;
		for (Reserva r : Reservas) {
			if (r.getUsuario().getNombre().equalsIgnoreCase(usuario)) {
				encontrado = true;
				break;
			}
		}
		if (encontrado) {

			while (it.hasNext()){
				Reserva r= it.next();
				if (r.getUsuario().getNombre().equalsIgnoreCase(usuario)){
					it.remove();
					System.out.println("Reserva eliminada");
					break;

				}
			}
		}else {
			System.out.println("No se encontro ninguna resreva de ese usuario.");
		}



	}

}



