public class BuscadorComando extends Buscador {
    private String comandoBuscado;

    public BuscadorComando(String comandoBuscado) {
        this.comandoBuscado = comandoBuscado;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getComandos().contains(this.comandoBuscado);
    }
}