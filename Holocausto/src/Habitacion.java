
public class Habitacion {
	
	public static final int ANCHO = 30;
	public static final int ALTO = 10; 

	private Posicion puertaEntrada;
	private Posicion puertaSalida;

	private ObjetoJuego[] objetosJ = new ObjetoJuego[20];
	private int numObjetos = 0;

	private Personaje j;

	public Habitacion() {

	}

	public Habitacion(Posicion puertaIn, Posicion puertaOut, Personaje j) {
		this.puertaEntrada = puertaIn;
		this.puertaSalida = puertaOut;
		this.j = j;
		this.j.setPos(this.puertaEntrada);
	}

	public void setObjetoJ(ObjetoJuego obj) {
		objetosJ[numObjetos] = obj;
		numObjetos++;
	}

	public ObjetoJuego getObjetoJ(int objPos) {
		return objetosJ[objPos];
	}

	public void eliminarObjJ(int objPos) {
		int posObjetos = 0;
		for (int i = 0; i < numObjetos; i++) {
			if (objPos != i) {
				objetosJ[posObjetos] = objetosJ[i];
				posObjetos ++;
			}
		}
		numObjetos --;
	}

	public int hayObj(Posicion p) {
		for (int i = 0; i < numObjetos; i++) {
			ObjetoJuego obj = objetosJ[i];
			Posicion objPosicion = obj.getPos();
			if (p.esIg(objPosicion)) return i;
		}
		return -1;
	}

	public int hayObjSinJ(Posicion p) {
		for (int i = 1; i < numObjetos; i++) {
			ObjetoJuego obj = objetosJ[i];
			Posicion objPosicion = obj.getPos();
			if (p.esIg(objPosicion))  return i;
		}
		return -1;
	}

	public void setPersonaje(Personaje p){

	}

	public void setJugador(Jugador j) {
		this.j = j;
	}

	public Posicion getpuertaEntrada() {
		return puertaEntrada;
	}

	public void setPuertaEntrada(Posicion puertaEntrada) {
		this.puertaEntrada = puertaEntrada;
	}

	public Posicion getPuertaSalida() {
		return puertaSalida;
	}	

	public void setPuertaSalida(Posicion puertaSalida) {
		this.puertaSalida = puertaSalida;
	}

	public boolean esPuerta(Posicion p) {
		if (p.esIg(puertaEntrada) || p.esIg(puertaSalida)) return true;
		return false;
	}

	public boolean esJugador(Posicion p) {
		if (p.esIg(j.getPos())) return true;
		return false;
	}
}