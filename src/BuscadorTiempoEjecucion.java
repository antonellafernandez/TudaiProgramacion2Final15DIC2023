public class BuscadorTiempoEjecucion extends Buscador {
    private double tiempoEjecucionBuscado;

    public BuscadorTiempoEjecucion(double tiempoEjecucionBuscado) {
        this.tiempoEjecucionBuscado = tiempoEjecucionBuscado;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getTiempoEjecucion() <= this.tiempoEjecucionBuscado;
    }
}