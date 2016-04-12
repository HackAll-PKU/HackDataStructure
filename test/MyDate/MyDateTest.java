package MyDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ChenLetian on 16/4/12.
 */
public class MyDateTest {

    MyDate date;

    @Before
    public void setUp() throws Exception {
        date = new MyDate(2016, 4, 12);
    }

    @Test
    public void testAdd() throws Exception {
        date.add(5);
        Assert.assertEquals(new MyDate(2016,4,17), date);
    }

    @Test
    public void testGetOffset() throws Exception {
        Assert.assertEquals(new MyDate(2016,4,15), date.getOffset(3));
    }

    @Test
    public void testGetWeek() throws Exception {
        Assert.assertEquals(2, date.getWeek());
    }
}