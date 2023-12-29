public class ComandoSimple implements Elemento {
    private String comando;
    private double tiempoEjecucion, consumo;

    public ComandoSimple(String comando, double tiempoEjecucion, double consumo) {
        this.comando = comando;
        this.tiempoEjecucion = tiempoEjecucion;
        this.consumo = consumo;
    }

    public void setTiempoEjecucion(double tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Override
    public double getTiempoEjecucion() {
        return this.tiempoEjecucion;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public double getConsumo() {
        return this.consumo;
    }

    @Override
    public Elemento getCopiaRestringida(Buscador b) {
        if (b.cumple(this)) {
            Elemento copia = new ComandoSimple(this.comando, this.tiempoEjecucion, this.consumo);
            return copia;
        }

        return null;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    @Override
    public ArrayList<String> getComandos() {
        ArrayList<String> salida = new ArrayList<String>();
        salida.add(this.comando);

        return salida;
    }
}