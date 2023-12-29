public class BuscadorOR extends Buscador {
    private Buscador b1, b2;

    public BuscadorOR(Buscador b1, Buscador b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    @Override
    public boolean cumple(Elemento e) {
        return b1.cumple(e) || b2.cumple(e);
    }
}