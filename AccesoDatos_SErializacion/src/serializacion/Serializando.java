package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializando {
	public static void main(String[] args) {
		
		Administrador jefe = new Administrador("Juan", 80000, 2005, 12,15);
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		
		try {
			
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("/home/roger/Escritorio/share.dat"));
			
			escribiendo_fichero.writeObject(personal);
			
			escribiendo_fichero.close();
			
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("/home/roger/Escritorio/share.dat"));
			
			Empleado[] personal_recuperado = (Empleado[]) recuperando_fichero.readObject(); 
			
			recuperando_fichero.close();
			
			for (Empleado e : personal_recuperado) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
