import java.util.HashMap;
import java.util.Map;

public class SandBox {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Object s = map.get("1");
        System.out.println(s);
        if (s == null) {
            s = 0;
        }
        System.out.println(s);
    }
}
