public class BuscadorNOT extends Buscador {
    private Buscador b;

    public BuscadorNOT(Buscador b) {
        this.b = b;
    }

    @Override
    public boolean cumple(Elemento e) {
        return !b.cumple(e);
    }
}