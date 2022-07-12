import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> wordCounter = new TreeMap<>();
        for (String str : strings) {
            if (!wordCounter.containsKey(str)) {
                wordCounter.put(str, 1);
            } else {
                wordCounter.put(str, wordCounter.get(str) + 1);
            }
        }
        return wordCounter;
    }

    public static void printMap(Map<String, Integer> map) {
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}