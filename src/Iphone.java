import java.io.Serializable;

public class Iphone implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreModelo;
	private int lanzamiento;
	private int almacenamiento;
	private int precio;

	public Iphone (String nombreModelo, int lanzamiento, int almacenamiento, int precio) {
		this.nombreModelo=nombreModelo;
		this.lanzamiento=lanzamiento;
		this.almacenamiento=almacenamiento;
		this.precio=precio;
	}
	
	public String toString(){
		return "Modelo iPhone: "+nombreModelo+ ", lanzado en el año:"+lanzamiento+", con almacenamiento de "+almacenamiento+" (GB) y un precio de:"+precio;
	}
}