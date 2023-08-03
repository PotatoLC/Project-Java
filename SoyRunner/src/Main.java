import java.util.Scanner;


public class Main {

public static int mostrarMenu(boolean error) {

	Scanner sc = new Scanner(System.in);
	if(error) System.out.println("Introduce unicamente un valor [0,1,2,3]");
	System.out.println("\t...:MENU:...\n");
	System.out.println("[0]\tFinalizar");
	System.out.println("[1]\tNuevo dato");
	System.out.println("[2]\tMostrar datos");
	System.out.println("[3]\tBorrar ultimo dato");
	System.out.println("-------------------------");
	System.out.println("Tu opcion [0,1,2,3]-> ");
	int rpt = sc.nextInt();
	while(rpt<0 || rpt>3) rpt = mostrarMenu(true);
	return rpt;
	}



public static void nuevoRegistro(float tmp[], float d[], String tag[], int ureg) {

	Scanner sc = new Scanner(System.in);
	System.out.println("[1]\t Introduzca una nueva etiqueta");
	String nueva_tag = sc.nextLine();
	tag[ureg] = nueva_tag;
	System.out.println("[1]\t Introduzca un nuevo tiempo(horas,min)");
	float nuevo = sc.nextFloat();
	tmp[ureg] = nuevo;
	System.out.println("[1]\t Introduzca una nueva distancia(km)");
	float nueva_dist = sc.nextFloat();
	d[ureg] = nueva_dist;
}


public static void mostrarRegistro(float tmp[], float d[], String tag[], int ureg) {

	System.out.println("\t...DATOS...\n");
	for(int i=0;i<ureg;i++) {
		System.out.println("Etiqueta["+i+"]\t"+tag[i]+"\tTiempo["+i+"]\t"+tmp[i]+"\tDistancia["+i+"]\t"+d[i]);
	}
	System.out.println("--------------------------");
}



public static void borrarRegistro(float tmp[], float d[], String tag[], int ureg) {

	Scanner sc = new Scanner(System.in);
	System.out.println("[3]\t Se borrara el ultimo registro");
	tmp[ureg] = 0.0f;
	d[ureg] = 0.0f;
	tag[ureg] = "";
}



public static void main(String[] args) {

	float dist[] = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
	float tiempo[] = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
	String tag[] = {"","","","","","","","","",""};
	int ureg = 0;
	int rpt = -1;
	rpt = mostrarMenu(false);
	while(rpt!=0) {
		switch(rpt) {
		case 1:
		nuevoRegistro(tiempo,dist,tag,ureg);
		ureg++;
		break;
		case 2:
		mostrarRegistro(tiempo,dist,tag,ureg);
		break;
		case 3:
		borrarRegistro(tiempo,dist,tag,ureg);
		ureg--;
	break;
	}
	rpt = mostrarMenu(false);
	}
}
}
