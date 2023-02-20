import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Searcher {

    private static Map<String, String> result;

    public static void search(String userInput, int column) throws IOException {
        long start = System.currentTimeMillis();

        result = new TreeMap<>();
        int lineCounter = 0;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/airports.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens[column - 1]
                        .replaceAll("^\"|\"$", "")      // убираем ковычки из начала и конца строки
                        .toLowerCase()
                        .startsWith(userInput.toLowerCase())) {
                    result.put(tokens[column - 1], "[" + line + "]");
                    lineCounter++;
                }
            }
        }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        for (Map.Entry<String, String> entry: result.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
        System.out.println("Количество найденных строк: " + lineCounter);
        System.out.println("Время, затраченное на поиск: " + elapsed + " мс");
    }

}
