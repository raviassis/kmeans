package kmeans;

import java.util.List;

class Centroide {
    private List<Double> parametros;

    public Centroide(List<Double> parametros) {
        this.parametros = parametros;
    }

    public List<Double> getParametros() {
        return parametros;
    }

    public void setParametros(List<Double> parametros) {
        this.parametros = parametros;
    }

    public Elemento getElemento() {
        return new Elemento() {
            @Override
            public List<Double> getParametros() {
                return parametros;
            }

            @Override
            public Elemento clone() {
                return null;
            }

            @Override
            public double distancia(Elemento elemento) {
                return 0;
            }
        };
    }
}
