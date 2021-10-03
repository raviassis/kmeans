import kmeans.Elemento;

import java.util.List;

/**
 * Exemplo de implementação da interface Elemento
 */
public class Medicao implements Elemento {
    private List<Double> parametros;

    public Medicao(List<Double> parametros) {
        this.parametros = parametros;
    }

    @Override
    public List<Double> getParametros() {
        return this.parametros;
    }

    @Override
    public Elemento clone() {
        return new Medicao(this.parametros);
    }

    @Override
    public double distancia(Elemento elemento) {
        var params2 = elemento.getParametros();
        var somatorio = 0.0;
        for(int i = 0; i < this.parametros.size() && i < params2.size(); i++) {
            var v1 = this.parametros.get(i);
            var v2 = params2.get(i);
            somatorio += Math.pow(v2 - v1, 2);
        }
        return Math.sqrt(somatorio);
    }
}
