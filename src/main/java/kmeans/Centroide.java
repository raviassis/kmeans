package kmeans;

import java.util.List;

public class Centroide {
    private List<Double> parametros;

    Centroide(List<Double> parametros) {
        this.parametros = parametros;
    }

    public List<Double> getParametros() {
        return parametros;
    }

    void setParametros(List<Double> parametros) {
        this.parametros = parametros;
    }

    Elemento getElemento() {
        var c = this;
        return new Elemento() {
            @Override
            public List<Double> getParametros() {
                return parametros;
            }

            @Override
            public Elemento clone() {
                return c.getElemento();
            }

            @Override
            public double distancia(Elemento elemento) {
                return elemento.distancia(c.getElemento());
            }
        };
    }
}
