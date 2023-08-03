
import java.util.Scanner;

public class Main {
     
    public static void main(String[] args) {  
        int obj = 0;
        int extr = 0;
        int vic = 0;
        Scanner in = new Scanner(System.in);
        String colAzul = "\u001B[34m";
        String colRojo = "\u001B[31m";
        String colAma = "\u001B[33m";
        String colReset = "\u001B[0m";


        // PUERTAS
        Posicion pIn = new Posicion(0, Juego.lanzarDado(1, Habitacion.ALTO-1));
        Posicion pOut = new Posicion(Juego.lanzarDado(1, Habitacion.ANCHO-1), Habitacion.ALTO-1);
        ObjetoJuego puertaIn = new ObjetoJuego();
        puertaIn.setPos(pIn);
        puertaIn.setLetraMapa(" ");
        puertaIn.setTipoObj(ObjetoJuego.PUERTA_IN);
        ObjetoJuego puertaOut = new ObjetoJuego();
        puertaOut.setPos(pOut);
        puertaOut.setLetraMapa(" ");
        puertaOut.setTipoObj(ObjetoJuego.PUERTA_OUT);

        // JUGADOR
        Posicion pInJ = new Posicion(pIn.getPosX(), pIn.getPosY());
        Jugador jugador = new Jugador();
        jugador.setPos(pInJ);
        jugador.setLetraMapa(colAzul + 'J' + colReset);
        jugador.setTipoObj(ObjetoJuego.JUGADOR);

        // HADRON
        /*Hadron hadron = new Hadron();
        Posicion pH = Juego.posAle();
        hadron.setPos(pH);
        hadron.setLetraMapa( colRojo + "O" + colReset);
        hadron.setTipoObj(ObjetoJuego.HADRON); */ 
        
        // LLAVE
        ObjetoJuego pieza = new ObjetoJuego();
        Posicion pPieza = Juego.posAle();
        pieza.setPos(pPieza);
        pieza.setLetraMapa(colAma + "P" + colReset);
        pieza.setTipoObj(ObjetoJuego.PIEZA);

       /* // OBJ OCULTO
        ObjetoJuego objOcul = new ObjetoJuego();
        Posicion pObjOcul = Juego.posAle();
        objOcul.setPos(pObjOcul);
        objOcul.setLetraMapa(colRojo + "O" + colReset);
        objOcul.setTipoObj(ObjetoJuego.OBJETO);*/

        // HABITACION Y ELEMENTOS
        Habitacion h1 = new Habitacion();
        
        h1.setObjetoJ(jugador);
        h1.setObjetoJ(puertaIn);
        h1.setObjetoJ(puertaOut);
        int NumHadrones = Juego.lanzarDado(5, 14);
        int NumBonus = Juego.lanzarDado(1, 5);
    
        for (int i = 0; i < NumHadrones; i++){
            Hadron hadron = new Hadron();
            Posicion pH = Juego.posAle();
            hadron.setPos(pH);
            hadron.setLetraMapa( colRojo + "O" + colReset);
            hadron.setTipoObj(ObjetoJuego.HADRON);
            h1.setObjetoJ(new Hadron(hadron));   
        }

        for (int i = 0; i < NumBonus; i++) {
            ObjetoJuego objOcul = new ObjetoJuego();
            Posicion pObjOcul = Juego.posAle();
            objOcul.setPos(pObjOcul);
            objOcul.setLetraMapa(colRojo + "O" + colReset);
            objOcul.setTipoObj(ObjetoJuego.OBJETO);
            h1.setObjetoJ(new ObjetoJuego(objOcul));

        }
        h1.setObjetoJ(pieza);
        

        // BUCLE JUEGO
        int resp = -1;
        resp = Juego.Menu(false);
        while (resp != Juego.SALIR_JUEGO) {
            switch(resp) {
                case Juego.SALIR_JUEGO:
                    break;

                case Juego.REGLAS:
                    Juego.MostarReglas();
                    break; 

                case Juego.LANZAR_DADO:
                    Juego.pintarHabitacion(h1);
                    int dadoLanz = Juego.lanzarDado(1,7) + extr;
                    int numColumnas = 0;
                    int numFilas = 0;

                    System.out.println("");
                    System.out.printf("\n[MOVIMIENTO COLUMNAS X] ¿Cuántas columnas quieres moverte? Tienes %d movimientos ---->  ", dadoLanz);
                    numColumnas = in.nextInt();
                    while (Math.abs(numColumnas) > dadoLanz) {
                        System.out.println("No tienes movimientos suficientes brother :(");
                        System.out.printf("\n[MOVIMIENTO COLUMNAS X] ¿Cuántas columnas quieres moverte? Tienes %d movimientos ---->  ", dadoLanz);
                        numColumnas = in.nextInt();
                    }
                    jugador.movX(numColumnas);

                    int newDado = dadoLanz - Math.abs(numColumnas);
                    System.out.printf("\n[MOVIMIENTO FILAS Y] ¿Cuántas filas quieres moverte? Tienes %d movimientos ---------->  ", newDado);
                    numFilas = in.nextInt();
                    while (Math.abs(numFilas) > newDado) {
                        System.out.println("No tienes movimientos suficientes brother :(");
                        System.out.printf("\n[MOVIMIENTO FILAS Y] ¿Cuántas filas quieres moverte? Tienes %d movimientos ---------->  ", newDado);
                        numFilas = in.nextInt();
                    }
                    jugador.movY(numFilas);

                    Juego.limpiarConsola();
                    Juego.pintarHabitacion(h1);
                    obj = h1.hayObjSinJ(jugador.getPos());
                    break;
                
                case Juego.MOSTAR_VIDAS:
                    System.out.printf("\n\nTe quedan %d puntos de vida\n\n\n", jugador.getVida());
                    break;

                case Juego.NUM_VIC:
                    System.out.printf("\n\nLlevas un total de %d partidas ganadas\n\n", vic);
                    break;                
            }

            if (obj > 0) {
				if(h1.getObjetoJ(obj).getTipoObj()==ObjetoJuego.HADRON) {
                    resp = Juego.explotaH(jugador);
                                       
				} 
                else if(h1.getObjetoJ(obj).getTipoObj() == ObjetoJuego.PIEZA) {
					jugador.setPiezaHab();
				}
				else if(h1.getObjetoJ(obj).getTipoObj() == ObjetoJuego.PUERTA_OUT) {
					resp = Juego.SALIR_JUEGO;
                    Juego.limpiarConsola();
                    System.out.println("Felicidades, has superado este juego");
                    vic ++;
                    //Habitacion h2 = new Habitacion();
                    //Juego.pintarHabitacion(h2);
                } else if (h1.getObjetoJ(obj).getTipoObj() == ObjetoJuego.OBJETO) {
                    System.out.println("\n\nFelicidades, has recogido un objeto, veamos que es: ");
                    int VidaExtra = 1;
                    int PuntosExtras = 2;
                    int bonus = Juego.lanzarDado(1, 3);
                    if (bonus == VidaExtra) {
                        int vidas = Jugador.VIDA_INICIAL + 1;
                        System.out.printf("Has ganado una vida extra, ahora tienes %d vidas\n\n", vidas);
                    } else if (bonus == PuntosExtras) {
                        System.out.println("Obtienes 1 punto extra en todas tus jugadas siguientes :D\n\n");
                        extr ++;
                    }
                } 
				h1.eliminarObjJ(obj);
				obj = -1;
            }         
            
        resp = Juego.Menu(false);

        if(jugador.getVida() <= 0 ) {
            System.out.println("Te has quedado sin vidas");
            resp = Juego.SALIR_JUEGO;
        }

        }
    }
}