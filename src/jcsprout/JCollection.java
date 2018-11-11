package jcsprout;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author created by glinlf
 * @date 2018/11/7
 * @remark
 */
public class JCollection {


    @Test
    public void testArrayList() {
        List list = new ArrayList();
        list.add(1);
        System.out.println(list);
    }

    @Test
    public void testLinkList() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);

        System.out.println(list.get(0));

        for (Object i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void testHashMap() {

        Map map = new HashMap();
        map.put("key", "value");
        map.put("key", "newValue");

        System.out.println(map.get("key"));

        // 循环遍历

        Iterator<Map.Entry<String, Object>> entryIterator = map.entrySet().iterator();

        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            System.out.println("key:" + next.getKey() + ", value:" + next.getValue());
        }
    }
}
