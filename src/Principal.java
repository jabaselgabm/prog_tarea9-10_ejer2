import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import utilidades.Leer;

public class Principal {
	
	static void leerListaIphone (ArrayList<Iphone> listaIphone) {
		String nombreModelo;
		int lanzamiento;
		int almacenamiento;
		int precio;
		
		Iphone iphone;
		
		System.out.println(
	    "\n ------------------------------------- \n"
	    + " Introdución de datos de Iphones \n"
	    + " ------------------------------------- \n"
	    + " para terminar escribe noiphone \n"
	    + " ------------------------------------- \n");
		
		nombreModelo = Leer.pedirCadena("Introduce el modelo");
		
		while (!nombreModelo.equals("noiphone")) {
			// Pedir todos los datos del modelo
			lanzamiento = Leer.pedirEntero("Introduce año de lanzamiento: ");
			almacenamiento = Leer.pedirEntero("Introduce la capacidad de almacenamiento: ");
			precio = Leer.pedirEntero("Introduce el precio del dispositivo: ");
			
			// crear el objeto con el constructor
			iphone = new Iphone (nombreModelo, lanzamiento, almacenamiento, precio);
			// lo almacenamos en la lista de objetos.
			listaIphone.add(iphone);
			
			// Empezamos la lectura del siguiente objeto.
			nombreModelo = Leer.pedirCadena("Introduce el modelo: ");
		}
	}

	static void escribirListaIphone (ArrayList<Iphone> listaIphone) {
		for (Iphone iphone: listaIphone) {
			System.out.println(iphone);
		}
	}
	
	static void escribirFicheroListaIphone (ArrayList<Iphone> listaIphone, String fichero) throws IOException {
		FileOutputStream fs = null;
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichero));
				for (Iphone iphone : listaIphone) {
					oos.writeObject(iphone);
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				if (oos != null) {
					oos.close();
				}
			}
		}
	
	static ArrayList<Iphone> leerFicheroListaIphone (String fichero) throws ClassNotFoundException{
		ArrayList<Iphone> listaIphone = new ArrayList<Iphone> ();
		FileInputStream fi = null;
		ObjectInputStream ois = null;
		Iphone iphone;
		
		try {
			ois = new ObjectInputStream (new FileInputStream (fichero));
			
			
			while (true) {
				iphone = (Iphone) ois.readObject();
				listaIphone.add(iphone);
			}
		} catch (EOFException ex) {
			// hemos llegado al final del fichero
			System.out.println("Lectura completa");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return listaIphone;
	}
		
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Defino el array donde voy a guardar los datos
		ArrayList<Iphone> listaIphone = new ArrayList<Iphone>();
		
		// Leo la lista de iphones
		//Principal.leerListaIphone(listaIphone);

		// La muestro en pantalla
		//Principal.escribirListaIphone(listaIphone);
		
		// Escribir en fichero
		//Principal.escribirFicheroListaIphone(listaIphone, "ficheroIphones.dat");
		
		ArrayList <Iphone> listaLecturaIphone;
		
		listaLecturaIphone = Principal.leerFicheroListaIphone("ficheroIphones.dat");
		Principal.escribirListaIphone(listaLecturaIphone);

	}

}
