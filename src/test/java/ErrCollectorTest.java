import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.Is.is;

public class ErrCollectorTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testMethod() {
        collector.checkThat(1, is(1));
        collector.checkThat(true, is(true));
    }

//    @Test
//    public  void simpleTest() {
//        assertEquals(false, true);
//    }
}
