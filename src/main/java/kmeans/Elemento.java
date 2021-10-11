package kmeans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Elemento {

    static List<Double> calcularMedia(List<Elemento> elementos) {
        var somatorio = new ArrayList<Double>();
        for(var elem : elementos) {
            for (int i = 0; i < elem.getParametros().size(); i++) {
                var value = elem.getParametros().get(i);
                if (i < somatorio.size()) {
                    somatorio.set(i, somatorio.get(i) + value);
                } else {
                    somatorio.add(value);
                }
            }
        }

        return somatorio.stream()
                .map(s -> s.doubleValue() / elementos.size())
                .collect(Collectors.toList());
    }

    List<Double> getParametros();
    Elemento clone();

    /**
     * Distancia euclidiana entre elementos
     * @param elemento
     * @return distancia entre os elementos
     */
    double distancia(Elemento elemento);
}
