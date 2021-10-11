import kmeans.Centroide;
import kmeans.Elemento;
import kmeans.Kmeans;

import java.util.Arrays;
import java.util.List;

public class KmeansToStringConverter {
    public static final String convert(Kmeans kmeans) {
        return kmeans.getAgrupamentos()
                .entrySet()
                .stream()
                .map((entry) -> {
                    var centroideString = KmeansToStringConverter.convert(entry.getKey());
                    var elementsString = KmeansToStringConverter.convert(entry.getValue());
                    return centroideString + "\n" + elementsString;
                })
                .reduce((s1, s2) -> s1 + "\n" + s2)
                .orElse("");
    }

    private static String convert(List<Elemento> elementos) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Elementos%n"));
        for (var e: elementos) {
            builder.append(String.format("%s%n", Arrays.toString(e.getParametros().toArray())));
        }
        return builder.toString();
    }

    private static String convert(Centroide c) {
        return String.format("Centroide %s", Arrays.toString(c.getParametros().toArray()));
    }
}
