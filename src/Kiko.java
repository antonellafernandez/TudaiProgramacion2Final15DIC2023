
import java.util.ArrayList;

public class Kiko {
    private static Kiko unicaInstancia;
    private double bateriaInicial, bateriaActual;
    private ArrayList<Elemento> elementos;
    
    private Kiko(double bateriaInicial) {
        this.bateriaInicial = bateriaInicial;
        this.bateriaActual = bateriaInicial;
        this.elementos = new ArrayList<Elemento>();
    }
    
    public static Kiko getInstance() {
        if (unicaInstancia == null) {
            unicaInstancia = new Kiko(100);
        }
        
        return unicaInstancia;
    }
    
    public void addElemento(Elemento e) {
        this.elementos.add(e);
    }

    public double getBateriaInicial() {
        return bateriaInicial;
    }

    public void setBateriaInicial(double bateriaInicial) {
        this.bateriaInicial = bateriaInicial;
    }
    
    public double getPorcentaje() {
        return this.bateriaActual * 100 / this.bateriaInicial;
    }
}