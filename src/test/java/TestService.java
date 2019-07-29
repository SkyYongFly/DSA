import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skylaker2019@163.com
 * @version V1.0 2019/7/29 11:44 PM
 */
public class TestService {

    @Test
    public void testInteger(){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(2);
        map.put(1, 2);
        map.put(1, 2);

        System.out.println(map.size());

        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(2);
        map2.put(new Integer(1), 2);
        map2.put(new Integer(1), 2);

        System.out.println(map2.size());
    }
}
