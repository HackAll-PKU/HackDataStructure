package ICollection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import static org.junit.Assert.*;

/**
 * Created by ChenLetian on 16/4/12.
 */
public class MyListTest {

    public MyList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new MyList<Integer>();
        for (Integer i = 10; i > 0; i--) {
            list.add(i);
        }
    }

    @Test
    public void testAddAndContains() throws Exception {
        for (Integer i = 10; i > 0; i--) {
            list.add(i);
        }
        Assert.assertEquals(list.contains(1), true);
    }

    @Test
    public void testRemoveAndContains() throws Exception {
        list.remove(5);
        Assert.assertNotEquals(list.contains(5), true);
    }

    @Test
    public void testToArray() throws Exception {
        Object[] array = list.toArray();
        Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10}, array);
    }

    @Test
    public void testClearAndSize() throws Exception {
        list.clear();
        Assert.assertEquals(list.size(), 0);
    }

}