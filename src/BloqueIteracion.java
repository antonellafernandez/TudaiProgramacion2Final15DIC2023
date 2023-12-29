public class BloqueIteracion extends Bloque {
    private int iterador;

    public BloqueIteracion(double umbral, int iterador) {
        super(umbral);
        this.iterador = iterador;
    }

    public void setIterador(int iterador) {
        this.iterador = iterador;
    }

    public int getIterador() {
        return this.iterador;
    }

    @Override
    public double getTiempoEjecucion() {
        return super.getTiempoEjecucion() + this.umbral * Kiko.getInstance().getPorcentaje() / 100;
    }

    @Override
    public Elemento getCopiaRestringida(Buscador b) {
        ArrayList<Elemento> copiaElementos = new ArrayList<Elemento>();

        for (Elemento e : this.elems) {
            Elemento eCopia = e.getCopiaRestringida(b);

            if (eCopia != null) {
                copiaElementos.add(eCopia);
            }
        }

        if (!copiaElementos.isEmpty()) {
            BloqueIteracion copia = this.getCopia();

            for (Elemento e : copiaElementos) {
                copia.addElemento(e);
            }

            return copia;
        }

        return null;
    }

    public BloqueIteracion getCopia() {
        return new BloqueIteracion(this.umbral, this.iterador);
    }

    @Override
    public ArrayList<String> getComandos() {
        ArrayList<String> salida = new ArrayList<String>();

        for (Elemento e : this.elems) {
            for (int i = 0; i < this.iterador; i++) {
                salida.addAll(e.getComandos());
            }
        }

        return salida;
    }
}