Ejercicio 2
En este ejercicio vas a practicar con las clases ObjectInputStream y
ObjectOutputStream. Para ello vamos a partir de la clase Iphone (ya definida,
puedes copiar el código). En dicha clase los objetos serán serializables porque
implementa el interfaz Serializable. Recuerda que un objeto serializable es el que
puede ser transformado en bytes y almacenado en un fichero para posteriormente
poder ser leído para “reconstruir” el objeto original.
import java.io.Serializable;
public class Iphone implements Serializable{
private static final long serialVersionUID = 1L;
private String nombreModelo;
private int lanzamiento;
private int almacenamiento;
private int precio;
public IPhone(String nombreModelo, int lanzamiento, int almacenamiento, int
precio){
this.nombreModelo=nombreModelo;
this.lanzamiento=lanzamiento;
this.almacenamiento=almacenamiento;
this.precio=precio;
}
public String toString(){
return "Modelo iPhone: "+nombreModelo+", lanzado en el año:
"+lanzamiento+", con almacenamiento de "+almacenamiento+" (GB) y un precio de:
"+precio;
}
}

2.1 - En primer lugar, pediremos al usuario que nos de los datos de todos los
modelos iPhone que conozca (nombre de modelo, año de lanzamiento, capacidad
de almacenamiento y precio para cada uno) y los guardaremos en una estructura
del tipo ArrayList (convenientemente definida).
Una vez que tenemos completa dicha estructura, la recorreremos para guardar en
el fichero “ficheroIphones.dat” los objetos de la misma, utilizando para ello de forma
adecuada la clase ObjectOutputStream.
2.2 - En este apartado vamos a “leer” el fichero que creamos en el apartado anterior,
“ficheroIphones.dat”, utilizando la clase ObjectInputStream. Así vamos a
comprobar que efectivamente logramos guardar de forma adecuada la información
de los iPhones gracias a que utilizamos objetos serializables.

3 - Para que todo salga correctamente debemos repetir el proceso, pero a la inversa.
Leeremos del fichero los objetos de la clase Iphone y los guardaremos en una
estructura ArrayList. Después recorremos esta lista para mostrar los datos de
cada iPhone por la pantalla.