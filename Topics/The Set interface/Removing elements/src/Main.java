import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        List<String> strList = new ArrayList<>(List.of(str.split(" ")));
        List<Integer> intList = strList.stream().map((s) -> Integer.valueOf(s)).collect(Collectors.toList());
        Set<Integer> intSet = new HashSet<>(intList);
        return intSet;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        List<Integer> filteredList = set.stream().filter(num -> num <= 10).collect(Collectors.toList());
        Set<Integer> filteredSet = new HashSet<>(filteredList);
        return filteredSet;
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        set = SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}
//
//    You are probably most familiar with HTTP and HTTPS protocols, but there are others;
//<login> and <password> are prefixes that transmit authentication data for some protocols, if necessary;
//<host> is the domain name or IP address where the site is located.
// Domain is the name of the site, IP is its address in a network;
//<port> is required for connection within the specified host. The official port for HTTP connections is 80, and the alternative is 8080,
// but it is possible to use any other ports too. The default setting for HTTPS is 443;
//<path> indicates the exact address of a particular file or page within a domain;
//<request parameters> are parameters transmitted to the server. Depending on request parameters, the site may slightly change its display. For example,
// it is possible to sort the items of a list in a different order;
//<anchor> allows you to connect to a specific part of a web page or document.