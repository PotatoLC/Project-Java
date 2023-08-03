
public class Main {

	public static void main(String[] args) {
		// Personal Data
		String name = "Ricky";
		String surname = "Rubio";
		float height = 167.2f;
		int age = 34;
		
		
		//Team Data
		short jersey = 13;
		String team = "Cavaliers";
		
		
		//Temp 21-21
		float points = 14.3f;
		boolean injury = true; 
		float assist = 12.2f;
		
		
		//Pantalla
		System.out.println("-----------Datos Peronales----------");
		System.out.println("Nombre del jugador "+name+ " "+surname);
		System.out.println("Edad del jugador: "+age);
		System.out.println("Altura del jugador (cm) "+ height);
		System.out.println("");
		System.out.println("------------Datos Equipo------------");
		System.out.println("Dorsal: "+jersey);
		System.out.println("Equipo:" +team);
		System.out.println("");
		System.out.println("------------Estadisticas------------");
		System.out.println("Puntos: "+points);
		System.out.println("¿Lesiones?: "+injury);
		System.out.println("Asistencias: "+assist);
		
	}

}
