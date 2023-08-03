
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {
    final static int SALIR_JUEGO = 0;
    final static int REGLAS = 1;
    final static int LANZAR_DADO = 2;
    final static int MOSTAR_VIDAS = 3;
    final static int NUM_VIC = 4;
    
    static Posicion[] posiciones = new Posicion[20];
    static int numPos = 0;  

    public Juego() {

    }

    public static void pintarHabitacion(Habitacion h) {
        System.out.println("\n\n");
        for(int fil = -1; fil < Habitacion.ALTO; fil++){
            for(int col = 0; col <= Habitacion.ANCHO; col++){
                Posicion posicionAct = new Posicion(col, fil);
                int posObj = h.hayObj(posicionAct);
                if (posObj != -1) {
                    ObjetoJuego objJ = h.getObjetoJ(posObj);
                    if (objJ.getTipoObj() == ObjetoJuego.PUERTA_OUT) 
                        if (((Jugador)h.getObjetoJ(0)).getPiezaHab()) {
                            System.out.print(objJ.getLetraMapa());
                        } else {
                                if (col == 0 || col == Habitacion.ANCHO-1) System.out.print("|");  //Pintamos pared izquierda y derecha
                                if (fil == 0 || fil == Habitacion.ALTO-1) System.out.print("=");  //Pintamos pared arriba y abajo   
                            
                        } 
                        else System.out.print(objJ.getLetraMapa());
                }
                else if (fil == -1 && col!= Habitacion.ANCHO) {
                    if (col > 9) System.out.print(col%10);
                    else System.out.print(col);
                }
                else if (col == Habitacion.ANCHO && fil != -1) {
                    System.out.print(fil);
                } else if (col == 0 || col == Habitacion.ANCHO-1) {
                    System.out.print("|");  // Paredes izq y der
                } else if (fil == 0 || fil == Habitacion.ALTO-1) {
                    System.out.print("=");   // Pared primer y ultima fila
                } else {
                    System.out.print(" ");  // Mapa
                } if (col == Habitacion.ANCHO) {
                    System.out.println();  //Siguiente linea
                }
            }        
        }  
    }  
        
    public static int Menu(boolean error) {
        String colorVerde = "\u001B[32m";
        String resetColor = "\u001B[0m";
        Scanner in = new Scanner(System.in);
        if (error) {
            System.out.println("\nIntroduce una opción valida [0,1,2,3,4]");
        }
        System.out.println(colorVerde + "\n\n--------------- HOLOCAUSTO (HADRON) ---------------");
        System.out.println("[0] ------> SALIR DEL JUEGO");
        System.out.println("[1] ------> REGLAS");
        System.out.println("[2] ------> LANZAR DADO");
        System.out.println("[3] ------> MOSTRAR VIDAS");
        System.out.println("[4] ------> NUMERO DE VICTORIAS");
        System.out.println("---------------------------------------------------" + resetColor);
        int resp = in.nextInt();
        while(resp>4) {
            resp = Menu(true); 
        } return resp;
    }

    public static void resolverObj(ObjetoJuego obj) {
        System.out.println("--------------    OBJETO    --------------");
        System.out.println(obj.getClass().getName());
        System.out.println("------------------------------------------");
    }

    public static int explotaH(Jugador jugador) {
        String colorRojo = "\u001B[31m";
        String resetColor = "\u001B[0m";
        int muerte = -1;
        System.out.println(colorRojo + "\n\n-----------      HADRON      -----------");
        System.out.println("¡HAS CHOCADO CONTRA UN HADRÓN!");
        jugador.setVida(jugador.getVida() - 1);
        int vidaPerdida = Jugador.VIDA_INICIAL - jugador.getVida();

        if (jugador.getVida() <= 0) {
            //System.out.println("¡Suerte, podemos continuar!");
            System.out.println(" ---->   ESTAS MUERTO BROTHER :(   <----");
            System.out.println("-------------------------------------" + resetColor);
            muerte = Juego.SALIR_JUEGO;
        } //else System.out.println("¡Suerte, podemos continuar!");
         //System.out.println(" ---->   ESTAS MUERTO BROTHER :(   <----");
        //System.out.println("----------------------------------------- \n\n" + resetColor);
        return muerte;
        
    }

    public static int lanzarDado(int inicio, int limite) {
        int dado = ThreadLocalRandom.current().nextInt(inicio, limite);
        return dado;
    }

    public static Posicion posAle() {
        int posX = ThreadLocalRandom.current().nextInt(2, Habitacion.ANCHO-2);
        int posY = ThreadLocalRandom.current().nextInt(2, Habitacion.ALTO-2);
        Posicion posTemp = new Posicion(posX, posY);
        
        if (numPos > 0) {
            for (int i=0; i < numPos; i++) {
                if (posTemp.esIg(posiciones[i])) {
                    posX = ThreadLocalRandom.current().nextInt(2, Habitacion.ANCHO-2);
                    posY = ThreadLocalRandom.current().nextInt(2, Habitacion.ALTO-2);
                    posTemp.setPosX(posX);
                    posTemp.setPosY(posY);
                    i = 0;
                }
            }
        }
        posiciones[numPos] = posTemp;
        numPos++;
        return posiciones[numPos-1];
    }

    public static void MostarReglas() {

        String colorCyan = "\u001B[36m";
        System.out.println(colorCyan + "\n\n------------------------------------------------------------------- REGLAS ------------------------------------------------------------------- \n");
        System.out.println("1. Objetivo -------> El objetivo del juego es salir de la habitación.");
        System.out.println("2. Preparación ----> Antes de comenzar, asegúrate de tener la pueza especial, la llave, oculta en la habitación");
        System.out.println("3. Movimientos ----> Para avanzar en el juego, debes tirar los dados. El número obtenido en los dados determinará la cantidad de movimientos");
        System.out.println("                     que puedes hacer en cada turno");
        System.out.println("4. Pieza especial -> No puedes salir de la habitación sin antes haber encontrado la llave. Busca la llave en la habitación mientras te mueves");
        System.out.println("5. Objetos --------> Durante el juego, encontrarás diferentes objetos en la habitación. Al interactuar con ellos, se mostrará un mensaje");
        System.out.println("                     indicando si son buenos o malos");
        System.out.println("6. Objetos buenos -> Si encuentras un objeto bueno, recibirás un beneficio o una ventaja que te ayudará en tu búsqueda.");
        System.out.println("7. Hadron ---------> Si encuentras un objeto malo, se mostrará un mensaje indicando que has chocado contra un hadrón y has perdido una vida.");
        System.out.println("                     Ten en cuenta que tienes un número limitado de vidas.");
        System.out.println("8. Salida ---------> Una vez que hayas encontrado la llave, dirígete a la puerta de salida y úsala para abrirla y salir de la habitación");
        System.out.println("9. Fin del juego --> El juego termina cuando logras salir de la habitación o cuando pierdes todas tus vidas");
        System.out.println("10. Ganador -------> Si logras salir de la habitación con la llave antes de quedarte sin vidas, serás el ganador del juego. Si pierdes ");
        System.out.println("                     todas tus vidas, habrás perdido. \n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- \n\n");
    }

    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}