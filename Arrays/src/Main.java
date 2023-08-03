import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String nombres[] = {"Juan", "Paco", "Kike", "Nate", "Chucho", ""};
		//System.out.println(nombres[0]);
		float califs [] = 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que nombre quieres agregar?");
		String nombreFinal = sc.nextLine();
		nombres[nombres.length-1] = nombreFinal;
				
		
		for (int i = 0; i<nombres.length; i++) {
			System.out.println(nombres[i]);
	
		}
	}

}
