import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import utilidades.Leer;

public class Principal {

	/**
	 * introducirListaIphone, va leyendo la lista de Iphones y va llenando
	 * un ArrayList
	 * @param listaIphone ArrayList para llenar con los datos
	 */
	static void introducirListaIphone(ArrayList<Iphone> listaIphone) {
		String nombreModelo;
		int lanzamiento;
		int almacenamiento;
		int precio;

		Iphone iphone;

		System.out.println("\n ------------------------------------- \n" + " Introdución de datos de Iphones \n"
				+ " ------------------------------------- \n" + " para terminar escribe noiphone \n"
				+ " ------------------------------------- \n");

		nombreModelo = Leer.pedirCadena("Introduce el modelo");

		while (!nombreModelo.equals("noiphone")) {
			// Pedir todos los datos del modelo
			lanzamiento = Leer.pedirEntero("Introduce año de lanzamiento: ");
			almacenamiento = Leer.pedirEntero("Introduce la capacidad de almacenamiento: ");
			precio = Leer.pedirEntero("Introduce el precio del dispositivo: ");

			// crear el objeto con el constructor
			iphone = new Iphone(nombreModelo, lanzamiento, almacenamiento, precio);
			// lo almacenamos en la lista de objetos.
			listaIphone.add(iphone);

			// Empezamos la lectura del siguiente objeto.
			nombreModelo = Leer.pedirCadena("Siguiente unidad. noiphone para terminar. \nIntroduce el modelo: ");
		}
	}

	/**
	 * mostrarListaIphone, recorre la lista de Iphones y la muestra en 
	 * pantalla
	 * @param listaIphone ArryList para mostrar
	 */
	static void mostrarListaIphone(ArrayList<Iphone> listaIphone) {
		for (Iphone iphone : listaIphone) {
			System.out.println(iphone);
		}
		System.out.println("Ya no hay más Iphones");
	}

	
	/**
	 * escribirFicheroListaIphone permite escribir la lista de objetos Iphone
	 * en un fichero
	 * @param listaIphone es la lista de tipo ArrayList a escribir
	 * @param fichero es el nombre del fichero a escribir
	 * @throws IOException
	 */
	static void escribirFicheroListaIphone(ArrayList<Iphone> listaIphone, String fichero) throws IOException {

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new BufferedOutputStream((new FileOutputStream(fichero))));
			for (Iphone iphone : listaIphone) {
				oos.writeObject(iphone);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (oos != null) {
				System.out.println("Fichero grabado con exito. Cerrando ...");
				oos.close();
			}
		}
	}

	/**
	 * leerFicheroListaIphone lee el fichero que le pasamos y devuelve una ArrayList con los objetos 
	 * leidos
	 * @param fichero es el nombre del archivo a leer
	 * @return el ArrayList con el contenido de los objetos
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	static ArrayList<Iphone> leerFicheroListaIphone(String fichero) throws ClassNotFoundException, IOException {
		ArrayList<Iphone> listaIphone = new ArrayList<Iphone>();

		ObjectInputStream ois = null;
		Iphone iphone;

		try {
			ois = new ObjectInputStream(new BufferedInputStream((new FileInputStream(fichero))));

			while (true) {
				iphone = (Iphone) ois.readObject();
				listaIphone.add(iphone);
			}
		} catch (EOFException ex) {
			// hemos llegado al final del fichero
			System.out.println("Lectura completa");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (ois != null) {
				System.out.println("Cerrando ...");
				ois.close();
			}
		}

		return listaIphone;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Defino el array donde voy a guardar los datos
		ArrayList<Iphone> listaIphone = new ArrayList<Iphone>();
		int opcion;

		/* Opciones para el menu */
		String[] menu = { "Salir", "Introducir lista Iphones", "Mostrar lista Iphones",
				"Escribir a Fichero lista Iphones", "Leer de Fichero lista de Ipnones y mostrar" };
		/* Prepara el MENU */
		do {
			System.out.println("\t====");
			System.out.println("\tMENU");
			System.out.println("\t====");
			opcion = Leer.pedirEntero(menu);

			switch (opcion) {
			case 1:
				// Introducir la lista de Iphones
				Principal.introducirListaIphone(listaIphone);
				break;
			case 2:
				// Mostrar la lista de Iphones en Pantalla
				Principal.mostrarListaIphone(listaIphone);
				break;
			case 3:
				// Escribir el fichero de objetos de Iphones
				Principal.escribirFicheroListaIphone(listaIphone, "ficheroIphones.dat");
				break;
			case 4:
				// Lee el fichero a un ArrayList de Iphones y lo muestra en pantalla
				ArrayList<Iphone> listaLecturaIphone;

				listaLecturaIphone = Principal.leerFicheroListaIphone("ficheroIphones.dat");
				Principal.mostrarListaIphone(listaLecturaIphone);
				break;
			}
		} while (opcion != 0);

	}
}
