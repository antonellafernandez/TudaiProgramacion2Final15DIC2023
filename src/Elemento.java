import java.util.ArrayList;

public interface Elemento {
    double getTiempoEjecucion();
    double getConsumo();
    Elemento getCopiaRestringida(Buscador b);
    ArrayList<String> getComandos();
}