import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Example {
    public static void main(String[] args) {
        Map<Integer, List<String>> allWorlds = new TreeMap<>();
        List list = new ArrayList();
        list.add("SDasdasdas");
        allWorlds.put(1, list);
    }
}
