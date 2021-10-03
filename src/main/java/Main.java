import kmeans.Elemento;
import kmeans.Kmeans;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int qntCentroides = 2;
        int iteracoes = 100;
        List<Elemento> elementos = Arrays.asList(
                new Medicao(Arrays.asList(0.0, 5.0)),
                new Medicao(Arrays.asList(16.0, 18.0)),
                new Medicao(Arrays.asList(12.0, 27.0)),
                new Medicao(Arrays.asList(20.0, 30.0)),
                new Medicao(Arrays.asList(10.0, 7.0)),
                new Medicao(Arrays.asList(13.0, 1.0)),
                new Medicao(Arrays.asList(2.0, 18.0)),
                new Medicao(Arrays.asList(25.0, 9.0)),
                new Medicao(Arrays.asList(10.0, 3.0)),
                new Medicao(Arrays.asList(1.0, 2.0))
        );

        var kmeans = new Kmeans(qntCentroides, iteracoes, elementos);
        kmeans.run();
        System.out.println("End");
    }
}
