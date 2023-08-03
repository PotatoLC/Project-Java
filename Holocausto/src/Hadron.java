public class Hadron extends Personaje{
    
    private boolean visible = true;

    public Hadron(){
        super.setTipoObj(ObjetoJuego.HADRON);
    }

    public boolean cambioVisibilidad(){
        if (this.visible) this.visible = false;
        else this.visible = true;
        return this.visible;
    }

    public Hadron(Hadron hadron) {
        super.setTipoObj(ObjetoJuego.HADRON);
        this.setPos(hadron.getPos());
        this.setLetraMapa(hadron.getLetraMapa());
    }
}
