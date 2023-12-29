
import java.util.ArrayList;

public class Kiko {
    private static Kiko unicaInstancia;
    private double bateria;
    private ArrayList<Elemento> elementos;
    
    private Kiko(double bateria) {
        this.bateria = bateria;
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

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }

    public double getPorcentaje() {
        return bateria;
    }
}