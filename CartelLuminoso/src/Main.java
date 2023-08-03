
public class Main {

	public static void main(String[] args) {
		int ancho = 5;
		int altura = 7;
		
		//PRIMERA LETRA L 
		//
		// *
		// *
		// *
		// *
		// *
		// *
		// *****
		
		for(int fila = 1; fila <= altura; fila ++) {
			//Bucle anidado 
			for(int columna = 1; columna<=ancho; columna++) {
				if((columna == 1) && (fila != 7)){ 
					System.out.print("*");
				} else if (fila == 7){
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//Letra E
		//
		//*****
		//*	
		//*
		//*****
		//*
		//*
		//*****
		//
		
		for(int fila = 1; fila<=altura; fila++) {
			for (int columna=1; columna <= ancho; columna++) {
				if (fila==1) {
					System.out.print("*");
				}else if ((fila==(altura/2)+1) && (columna<ancho)){
					System.out.print("*");
				}else if (columna ==1) {
					System.out.print("*");
				}else if (fila == altura) {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		System.out.println("");
		
	}
}