public class Jugador extends Personaje {
    
    final static int VIDA_INICIAL = 3;
    private int vida = VIDA_INICIAL;
    private boolean piezaHab = false;

    public Jugador() {
    
    }

    public int getVida() {
        return vida;
    }

    public static void VidaPer() {
        int vidaRest = VIDA_INICIAL-1;
        System.out.printf("Te quedan % puntos de vida", vidaRest);
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean getPiezaHab() {
        return piezaHab;
    }

    public void setPiezaHab() {
        this.piezaHab = true;
    }

}
