package practicaJava;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		User nuevoUsuario = new User(pedirDatos());
		System.out.println(nuevoUsuario.toString());

	}
	
	public static ArrayList pedirDatos() {
		ArrayList<String> datosUsuario = new ArrayList();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese su nombre: ");
		String name = sc.nextLine();
		datosUsuario.add(name);
		System.out.println("Ingrese su apellido: ");
		String lastName = sc.nextLine();
		datosUsuario.add(lastName);
		System.out.println("Ingrese su hobbie: ");
		String hobbie = sc.nextLine();
		datosUsuario.add(hobbie);
		System.out.println("Ingrese su editor de código preferido: ");
		String editor = sc.nextLine();
		datosUsuario.add(editor);
		System.out.println("Ingrese su sistema operativo: ");
		String operativeSystem = sc.nextLine();
		datosUsuario.add(operativeSystem);
		System.out.println("Ingrese su edad: ");
		String age = sc.nextLine();
		datosUsuario.add(age);
		return datosUsuario;
	}

}
