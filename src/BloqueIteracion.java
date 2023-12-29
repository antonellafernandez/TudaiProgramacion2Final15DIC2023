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
    public Bloque instanciar() {
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