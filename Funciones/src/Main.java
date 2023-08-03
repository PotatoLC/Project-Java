
public class Main {
	
	// Funcion precio total
	public static void PrecioTotal(float PrecioUd, int uds) {
		//variables
		float precioT;
		
		System.out.println("--- Funcion de caclculo de precio total de un producto ---");
		System.out.println("");
		
		precioT = PrecioUd*uds;
		System.out.println("El precio total es igual a " + precioT);
		
	}
	
	public static void main(String[] args) {
		PrecioTotal(25.5f, 8);
		
	}
}
