public class BloqueIteracion extends Bloque {
    private int iterador;
    private double extraPorcentaje;

    public BloqueIteracion(double umbral, int iterador, double extraPorcentaje) {
        super(umbral);
        this.iterador = iterador;
        this.extraPorcentaje;
    }

    public void setIterador(int iterador) {
        this.iterador = iterador;
    }

    public int getIterador() {
        return this.iterador;
    }

    public void setExtraPorcentaje(double extraPorcentaje) {
        this.extraPorcentaje = extraPorcentaje;
    }

    public double getExtraPorcentaje() {
        return this.extraPorcentaje;
    }

    @Override
    public double getTiempoEjecucion() {
        return super.getTiempoEjecucion() + this.getExtraProcentaje() * Kiko.getInstance().getPorcentaje() / 100;
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
            BloqueIteracion copia = this.instanciar();

            for (Elemento e : copiaElementos) {
                copia.addElemento(e);
            }

            return copia;
        }

        return null;
    }

    public BloqueIteracion instanciar() {
        return new BloqueIteracion(this.getUmbral(), this.getIterador(), this.getExtraPorcentaje());
    }

    @Override
    public ArrayList<String> getComandos() {
        ArrayList<String> salida = new ArrayList<String>();

        for (int i = 0; i < this.iterador; i++) {
            for (Elemento e : this.elems) {
                salida.addAll(e.getComandos());
            }
        }

        return salida;
    }
}