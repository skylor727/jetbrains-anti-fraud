import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        List<T> set1AsArr = new ArrayList<>(set1);
        boolean set2IncludesSet1 = true;
        for (T x : set1AsArr) {
            if (!set2.contains(x)) {
                set2IncludesSet1 = false;
            }
        }
        return set2IncludesSet1 && (!Objects.equals(set1, set2)) ? true : false;
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set1 = readStringSet(scanner);
        Set<String> set2 = readStringSet(scanner);

        System.out.println(isStrictSuperset(set1, set2));
    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}