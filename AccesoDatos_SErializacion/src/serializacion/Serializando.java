package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializando {
	public static void main(String[] args) {

		// Instanciamos la clase Administrador y le damos valores
		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);

		// creamos un array de Empleados y añadimos Jefe(que extiende de Empleados) y
		// añadimos 2 empleados mas
		Empleado[] personal = new Empleado[3];

		personal[0] = jefe;

		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);

		try {
			// creamos un flujo OutputStream para trasladar el/los objeto/os a otro lado
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(
					new FileOutputStream("/home/roger/Escritorio/share.dat"));
			
			//al flujo le pasamos el array y lo escribe en la ruta indicada
			escribiendo_fichero.writeObject(personal);
			
			//cerramos el flujo
			escribiendo_fichero.close();

			//Para recuperar dichos objetos creamos un flujo InputStream y le indicamos la ruta donde estan los objetos
			ObjectInputStream recuperando_fichero = new ObjectInputStream(
					new FileInputStream("/home/roger/Escritorio/share.dat"));
			
			//el metodo readObject te devuelve un Object. O casteamos para transformarlo en un array de Empleados o creamos un array de Object
			Empleado[] personal_recuperado = (Empleado[]) recuperando_fichero.readObject();
			
			//cerramos el flujo
			recuperando_fichero.close();
			
			//creamos un for que recorra el array de Empleados, lo guardamos en un objeto Epleado y asi recuperamos el objeto.
			for (Empleado e : personal_recuperado) {
				System.out.println(e);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
