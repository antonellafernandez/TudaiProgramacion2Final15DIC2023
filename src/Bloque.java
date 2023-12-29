public class Bloque implements Elemento {
    private ArrayList<Elemento> elems;
    private double umbral;
    private static double extraFijo = 10;

    public Bloque(double umbral) {
        this.umbral = umbral;
        this.elems = new ArrayList<Elemento>();
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    public double getUmbral() {
        return this.umbral;
    }

    public void addElemento(Elemento e) {
        this.elems.add(e);
    }

    public static void setExtraFijo(double extra) {
        extraFijo = extra;
    }

    public static double getExtraFijo() {
        return extraFijo;
    }

    @Override
    public double getTiempoEjecucion() {
        double salida = 0;

        for (Elemento e : this.elems) {
            salida += e.getTiempoEjecucion();
        }

        return salida;
    }

    @Override
    public double getConsumo() {
        double salida = 0;

        for (Elemento e : this.elems) {
            salida += e.getTiempoEjecucion();
        }

        double extra = extraFijo;

        if (Kiko.getInstance().getPorcentaje() < this.umbral) {
            extra = extra * 2;
        }

        return salida + extra * this.getTiempoEjecucion();
    }

    @Override
    public Elemento getCopiaRestringida(Buscador b) {
        ArrayList<Elemento> copiaElementos = new ArrayList<Elemento>();

        for (Elemento e : this.elems) {
            Elemento eCopia = e.getCopiaRestringida(b);

            if (eCopia != null) {
                copiaElementos.add(eCopia);
            }
        }

        if (!copiaElementos.isEmpty()) {
            Bloque copia = this.instanciar();

            for (Elemento e : copiaElementos) {
                copia.addElemento(e);
            }

            return copia;
        }

        return null;
    }

    public Bloque instanciar() {
        return new Bloque(this.getUmbral());
    }

    @Override
    public ArrayList<String> getComandos() {
        ArrayList<String> salida = new ArrayList<String>();

        for (Elemento e : this.elems) {
            salida.addAll(e.getComandos());
        }

        return salida;
    }
}