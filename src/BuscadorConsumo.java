public class BuscadorConsumo extends Buscador {
    private double consumoBuscado;

    public BuscadorConsumo(double consumoBuscado) {
        this.consumoBuscado = consumoBuscado;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getConsumo() <= this.consumoBuscado;
    }
}