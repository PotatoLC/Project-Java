
public class ObjetoJuego {

    final static int JUGADOR = 0;
    final static int HADRON = 1;
    final static int PIEZA = 2;
    final static int OBJETO = 3;
    final static int PUERTA_IN = 4;
    final static int PUERTA_OUT = 5;

    private String nombre;
    private Posicion pos;
    private String letraMapa = " ";
    private int tipoObj = -1;

    public ObjetoJuego() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPos(){
        return pos;
    }

    public void setPos(Posicion pos) {
        this.pos = pos;
    }

    public String getLetraMapa() {
        return letraMapa;
    }

    public void setLetraMapa(String letraMapa) {
        this.letraMapa = letraMapa;
    }

    public int getTipoObj() {
        return tipoObj;
    }

    public void setTipoObj(int tipoObj) {
        this.tipoObj = tipoObj;
    }

    public ObjetoJuego(ObjetoJuego objetoOculto) {
    this.nombre = objetoOculto.getNombre();
    this.pos = objetoOculto.getPos();
    this.letraMapa = objetoOculto.getLetraMapa();
    this.tipoObj = objetoOculto.getTipoObj();
    }
}
