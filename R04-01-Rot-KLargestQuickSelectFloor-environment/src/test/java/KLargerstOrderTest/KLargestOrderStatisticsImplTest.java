package KLargerstOrderTest;

import orderStatistic.KLargestOrderStatisticsImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KLargestOrderStatisticsImplTest {

    public KLargestOrderStatisticsImpl<Integer> kLargestOrderStatistics;

    @BeforeEach
    void setUp() {
        kLargestOrderStatistics = new KLargestOrderStatisticsImpl<Integer>();
    }


    @Test
    void testOrdem() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable<Integer> orderStatistics = kLargestOrderStatistics.orderStatistics(array, 1);
        Comparable<Integer> expected = new Integer(4);
        Assert.assertEquals(expected, orderStatistics);
    }

    @Test
    void testOrdem2() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable<Integer> orderStatistics = kLargestOrderStatistics.orderStatistics(array, 2);
        Comparable<Integer> expected = new Integer(6);
        Assert.assertEquals(expected, orderStatistics);
    }

    @Test
    void test01() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable[] arrayKLargest = kLargestOrderStatistics.getKLargest(array, 3);
        Comparable[] expectedArray = new Integer[]{8, 9, 12};
        Assert.assertArrayEquals(expectedArray, arrayKLargest);
    }

    @Test
    void test02() {
        Integer[] array = new Integer[]{4, 8, 6, 9, 12, 1};
        Comparable[] arrayKLargest = kLargestOrderStatistics.getKLargest(array, 10);
        Comparable[] expectedArray = new Comparable[]{};
        Assert.assertArrayEquals(expectedArray, arrayKLargest);

    }

    @Test
    void test03() {
        Integer[] array = new Integer[]{4, 8, 6, 9, 12, 1};
        Comparable[] expectedArray = new Comparable[]{};
        Assert.assertArrayEquals(expectedArray, kLargestOrderStatistics.getKLargest(array, 0));
    }
    @Test
    void test04() {
        Integer[] array = new Integer[]{4, 8, 6, 9, 12, 1};
        Comparable[] expectedArray = new Comparable[]{};
        Assert.assertArrayEquals(expectedArray, kLargestOrderStatistics.getKLargest(array, -2));
    }

    @Test
    void test05() {
        Integer[] array = new Integer[]{};
        Comparable[] expectedArray = new Comparable[]{};
        Assert.assertArrayEquals(expectedArray, kLargestOrderStatistics.getKLargest(array, 1));
    }

    @Test
    void test06() {
        Integer[] array = new Integer[]{6, 6, 6, 6, 6};
        Comparable[] expectedArray = new Comparable[]{6, 6, 6};
        Assert.assertArrayEquals(expectedArray, kLargestOrderStatistics.getKLargest(array, 3));
    }

    @Test
    void test07() {
        Integer[] array = new Integer[]{7};
        Comparable[] expectedArray = new Comparable[]{7};
        Assert.assertArrayEquals(expectedArray, kLargestOrderStatistics.getKLargest(array, 1));
    }
}
