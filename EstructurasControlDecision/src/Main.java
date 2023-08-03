
public class Main {

	public static void main(String[] args) {
		//Estructura de repeticion
		for (int i = 12; i<=30; i=i+2) {
			System.out.print(i+", ");
		}
		System.out.println("");
		
		
		//Estructuras Control
		
		for(int i = 10; i<=24; i=i+2) {
			
			if (i >= 18) {
				System.out.println(i + " Tiene mas de 18 años");
			} else if (i>=16) {
				System.out.println(i + " Tiene mas de 16 años");
			} else {
				System.out.println(i + " Tiene menos de 16 años");
			}
		}	
	}
}