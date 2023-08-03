import java.util.Random;
import java.util.Scanner;

/* ANOTACIONES DEL PROGRAMA:

 En la función RandomNum colocamos el número 6 como máximo, esto para que nos dé un valor aleatorio entre 0 a 5, el problema
 que surgue aqui es que el numero "0" no lo aceptamos como valido en los dados, por eso agregamos el "+1" y solucionamos el
 otro problema, que nos da solo valores de 0 a 5, ahora se convierte de 1 a 6, justo lo que necesitamos

Para cambiar el codigo del texto que sale en consola solo es buscar el codigo de color en Google, algo como "codigo color rojo java"
esto te devuelve un codigo que lo metí dentro de una variable tipo String para ponerla en mis resultados  
 */
 
public class Main {
     
    public static int RandomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(6) +1;
        return randomNum;
    }
 
    public static void Reglas() {
        String colorRojo = "\u001B[31m";
        String resetcolor = "\u001B[0m";
        System.out.println("\n\n" + colorRojo + "--------------------------------------------- REGLAS DEL JUEGO ---------------------------------------------");
        System.out.println("1 --> El juego se juega con dos dados y puede haber dos o más jugadores, en este caso es Usuario vs IA");
        System.out.println("2 --> Cada jugador tiene su turno para lanzar los dados tantas veces como quiera en un solo turno."); 
        System.out.println("      Después de cada lanzamiento, el jugador suma los puntos obtenidos en ese turno y puede decidir");
        System.out.println("      si quiere lanzar los dados nuevamente o si quiere terminar su turno y guardar los puntos acumulados.");
        System.out.println("3 --> Si en cualquier momento un jugador obtiene un uno en cualquiera de los dados que lanzó, su puntuación");
        System.out.println("      para ese turno se reduce a cero y pierde todos los puntos acumulados en ese turno. Luego, es el turno del");
        System.out.println("      siguiente jugador.");
        System.out.println("4 --> Si un jugador decide terminar su turno de forma segura antes de obtener un uno, suma los puntos acumulados");
        System.out.println("      en ese turno a su puntuación total y pasa el turno al siguiente jugador.");
        System.out.println("5 --> El primer jugador en alcanzar o superar los 100 puntos gana el juego.");
        System.out.println("----------------------------------------------------------------------------------------------------------------" + resetcolor);
    }

    public static int ShowMenuP(boolean error) {
        String colorVerde = "\u001B[32m";
        String resetColor = "\u001B[0m";
        Scanner sc = new Scanner(System.in);
        if (error) {
            System.out.println("\nIntroduce una opción valida [0,1,2]");
        }
        System.out.println("\n\n" + colorVerde + "----------------- MENU -----------------");
        System.out.println("0 -------> Salir");
        System.out.println("1 -------> Comenzar");
        System.out.println("2 -------> Reglas");
        System.out.println("----------------------------------------" + resetColor);
        int resp = sc.nextInt();
        while (resp>2) 
            resp=ShowMenuP(true);
        return resp;
    }
    
    public static String Pregunta(String pregunta) {
        Scanner sc = new Scanner(System.in);
        System.out.println(pregunta);
        String respuesta = sc.nextLine();
        return respuesta;
    }
    
    public static void JuegoP() {
        int respUser;
        int sumaParcialUser = 0;
        int sumaTotalUser = 0;
        boolean turnoTerminado = false;
        
        while (!turnoTerminado){
            respUser = RandomNum();
        
            if (respUser == 1) {
                System.out.println("Has obtenido un 1, eso suma 0 puntos esta ronda");
                sumaParcialUser = 0;
                turnoTerminado = true;
            } else {
                System.out.println("Has obtenido un: " + respUser);
                sumaParcialUser += respUser;

                String respAns = Pregunta("¿Quieres tirar de nuevo? [Y/N]");

                if (respAns.equals("Y")) {
                    sumaTotalUser += sumaParcialUser;
                } else {
                    System.out.println("\n Ok, siguiente turno");
                    sumaTotalUser += sumaParcialUser;
                    turnoTerminado = true;
                }
            }
        }
        System.out.println("Llevas un total de: " + sumaTotalUser);
    }
        
    public static void JuegoIA() {
        int respIA;
        int sumaTotalIA = 0;
        int sumaParcialIA = 0;
        boolean turnoTerminado = false;
        int maxScore = 20;

        while(!turnoTerminado){
            respIA = RandomNum();     
        
        if (respIA == 1) {
            System.out.println("La IA ha obtenido un 1, eso suma 0 puntos esta ronda");
            sumaParcialIA = 0;
            turnoTerminado = true;    
        } else {
            System.out.println("LA IA ha obtenido un: " + respIA);
            sumaParcialIA += respIA;
            
            if (sumaParcialIA >= 6 || sumaTotalIA + sumaParcialIA >= maxScore){
                System.out.println("La IA decide terminar su turno");
                sumaTotalIA += sumaParcialIA;
                turnoTerminado = true;
            }
        } 
    }
    System.out.println("La IA lleva un total de: " + sumaTotalIA);
    
    }
    
    public static int calcularSumaTotal(int sumaParcial){
        return sumaParcial;
    }

    public static void InicioJuego() {
        String colorAmarillo = "\033[33m";
        String resetcolor = "\u001B[0m";
        String colorAzul = "\u001B[34m";
        int maxScore = 20;

        System.out.println("\n\n" + colorAmarillo + "-------- Comienzo del juego --------" + resetcolor);
        System.out.println(String.format("El maximo de esta partida será %d puntos, el primero en llegar a esa cantidad gana", maxScore));
            
        int sumaTotalUser = 0;
        int sumaTotalIA= 0;    
    
        while (sumaTotalUser < maxScore && sumaTotalIA < maxScore) {
            System.out.println("\n" + colorAzul + "Turno del usuario" + resetcolor);
            JuegoP();
                        
            if (sumaTotalUser >= maxScore) {
                break;
            }

            System.out.println("\n" + colorAzul + "Turno de la IA" + resetcolor);
            JuegoIA();
        }


        if (sumaTotalUser >= maxScore) {
            System.out.println("El usuario ha ganado con un total de: " + sumaTotalUser);
        } else if (sumaTotalIA >= maxScore) {
            System.out.println("JAJAJJAJAJ, te ganó una IA, ganó con: " + sumaTotalIA);
        }
    }
    
    public static void main(String[] args) {
        int resp = -1;

        resp = ShowMenuP(false);
        while (resp != 0) {
            switch(resp) {
                case 0: 
                    break;    
                case 1:
                    InicioJuego();
                    break;
                case 2:
                    Reglas();
                    break;
            }
            resp = ShowMenuP(false);
        }
    }
}
