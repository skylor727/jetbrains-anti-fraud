import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int setSize = Integer.parseInt(sc.nextLine());
        Set<String> dictionarySet = new HashSet<>();
        for (int i = 0; i < setSize; i++) {
            String toAdd = sc.nextLine().toLowerCase();
            dictionarySet.add(toAdd);
        }
        Set<String> linesSet = new HashSet<>();
        int lines = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lines; i++) {
            String toAdd = sc.nextLine().toLowerCase();
            linesSet.add(toAdd);
        }
        List<String> arrList = new ArrayList<>(linesSet);
        Set<String> erroneousWords = new HashSet<>();
        List<String> arrList2 = new ArrayList<>();
        for (String s : arrList) {
            for (String x : s.split(" ")) {
                arrList2.add(x);
            }
        }
        for (String s : arrList2) {
            if (!dictionarySet.contains(s)) {
                erroneousWords.add(s);
            }
        }
        for (String s : erroneousWords) {
            System.out.println(s);
        }
    }
}