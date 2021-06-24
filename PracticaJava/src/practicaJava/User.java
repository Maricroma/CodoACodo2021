package practicaJava;

import java.util.ArrayList;

public class User {

	private String name, lastName, hobbie, editor, operativeSystem, age;
	
	public User(String name, String lastName, String hobbie, String editor, String operativeSystem, String age) {
		this.name = name;
		this.lastName = lastName;
		this.hobbie = hobbie;
		this.editor = editor;
		this.operativeSystem = operativeSystem;
		this.age = age;
	}

	public User(ArrayList<String> datosUsuario) {
		name = datosUsuario.get(0);
		lastName = datosUsuario.get(1);
		hobbie = datosUsuario.get(2);
		editor = datosUsuario.get(3);
		operativeSystem = datosUsuario.get(4);
		age = datosUsuario.get(5);
	}

	@Override
	public String toString() {
		return "Nombre: " + name + "\nApellido: " + lastName + "\nHobbie: " + hobbie + "\nEditor preferido: " + editor
				+ "\nSistema operativo: " + operativeSystem + "\nEdad: " + age + " años";
	}
	
	

}
