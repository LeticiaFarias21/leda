package quickSelect.test;

import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSelectTest {
    public QuickSelect<Integer> quickSelect;

    @BeforeEach
    void setUp() {
        quickSelect = new QuickSelect<Integer>();
    }

    /**
     * teste menor 1 menor
     */
    @Test
    void test01() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable menor = quickSelect.quickSelect(array, 1);
        Comparable expected= new Integer(4);
        Assert.assertEquals(expected, menor);
    }
    /**
     * teste menor 2 menor
     */
    @Test
    void test02() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable menor = quickSelect.quickSelect(array, 2);
        Comparable expected= new Integer(6);
        Assert.assertEquals(expected, menor);
    }
    /**
     * teste menor 3 menor
     */
    @Test
    void test03() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable menor = quickSelect.quickSelect(array, 3);
        Comparable expected= new Integer(8);
        Assert.assertEquals(expected, menor);
    }
}
