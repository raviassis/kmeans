package kmeans;

import java.util.*;
import java.util.stream.Collectors;

public class Kmeans {
    private final int iteracoes;
    private List<Centroide> centroides;
    private List<Elemento> elementos;
    private Map<Centroide, List<Elemento>> agrupamentos;

    public Kmeans(int qntCentroides, int iteracoes, List<Elemento> elementos) {
        this.elementos = elementos;
        this.iteracoes = iteracoes;
        var centroides = new ArrayList<Elemento>();
        int i = 0;
        var gerador = new Random();
        var max = elementos.size();
        while (i < qntCentroides) {
            var elem = elementos.get(gerador.nextInt(max));
            if (!centroides.contains(elem)) {
                centroides.add(elem);
                i++;
            }
        }
        this.centroides = centroides
                            .stream()
                            .map(e -> new Centroide(e.getParametros()))
                            .collect(Collectors.toList());
    }

    public void run() {
        for (int i = 0; i < iteracoes; i++) {
            // iniciar
            var agrupamentos = new HashMap<Centroide, List<Elemento>>();
            for (var centroide : this.centroides) {
                agrupamentos.put(centroide, new ArrayList<>());
            }

            // agrupar
            for (var elem: this.elementos) {
                var map = new TreeMap<Double, Centroide>();
                for (var centroide: this.centroides) {
                    double value = elem.distancia(centroide.getElemento());
                    map.put(value, centroide);
                }
                var centroide = map.firstEntry().getValue();
                agrupamentos.get(centroide).add(elem);
            }

            // recalcular centroides
            for (var entry: agrupamentos.entrySet()) {
                var elementos = entry.getValue();
                var centroide = entry.getKey();
                centroide.setParametros(Elemento.calcularMedia(elementos));
            }
            
            this.agrupamentos = agrupamentos;

        }
    }

    public Map<Centroide, List<Elemento>> getAgrupamentos() {
        return agrupamentos;
    }
}
