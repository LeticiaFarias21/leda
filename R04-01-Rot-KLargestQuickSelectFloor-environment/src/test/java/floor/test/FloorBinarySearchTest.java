package floor.test;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problems.FloorBinarySearchImpl;

class FloorBinarySearchTest {


    public FloorBinarySearchImpl floorBinarySearch;

    @BeforeEach
    void setUp() {
        floorBinarySearch = new FloorBinarySearchImpl();
    }

    /**
     * Valor está presente no array e é o floor
     */
    @Test
    void test01() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        Assert.assertEquals(6, floorBinarySearch.floor(array, 6).intValue());
    }

    /**
     * Valor não está presente no array mas há um floor
     */
    @Test
    void test02() {
        Integer[] array = new Integer[]{-7, 18, 19, 2, 0, 4};
        Assert.assertEquals(4, floorBinarySearch.floor(array, 17).intValue());
    }

    /**
     * Valor não está presente no array e não há um floor
     */

    @Test
    void test03() {
        Integer[] array = new Integer[]{-7, 18, 19, 22};
        Assert.assertNull(floorBinarySearch.floor(array, -9));
    }

    /**
     * Array nulo
     */

    @Test
    void test04() {
        Assert.assertNull(floorBinarySearch.floor(null, 2));
    }

    /**
     * Array vazio
     */
    @Test
    void test05() {
        Integer[] array = new Integer[]{};
        Assert.assertNull(floorBinarySearch.floor(array, 2));
    }

    /**
     * Array de 1 elemento, x ausente e floor presente
     */
    @Test
    void test06() {
        Integer[] array = new Integer[]{6};
        Assert.assertEquals(6, floorBinarySearch.floor(array, 7).intValue());
    }

    /**
     * Array de 1 elemento, x presente
     */
    @Test
    void test07() {
        Integer[] array = new Integer[]{7};
        Assert.assertEquals(7, floorBinarySearch.floor(array, 7).intValue());
    }

    /**
     * Array de 1 elemento, x e floor ausentes
     */
    @Test
    void test08() {
        Integer[] array = new Integer[]{8};
        Assert.assertNull(floorBinarySearch.floor(array, 7));
    }

    /**
     * X presente e na extremidade direita
     */
    @Test
    void test09() {
        Integer[] array = new Integer[]{-1, 14, 22, -9, 18, 1024, 215};
        Assert.assertEquals(1024, floorBinarySearch.floor(array, 1024).intValue());
    }

    /**
     * Floor presente e na extremidade direita
     */
    @Test
    void test10() {
        Integer[] array = new Integer[]{-1, 14, 22, -9, 18, 1024, 215};
        Assert.assertEquals(1024, floorBinarySearch.floor(array, 1025).intValue());
    }

    /**
     * X presente e na extremidade esquerda
     */
    @Test
    void test11() {
        Integer[] array = new Integer[]{9, 16, 3, 1024, -127};
        Assert.assertEquals(-127, floorBinarySearch.floor(array, -127).intValue());
    }

    /**
     * Floor presente e na extremidade esquerda
     */
    @Test
    void test12() {
        Integer[] array = new Integer[]{9, 16, 3, 1024, -128};
        Assert.assertEquals(-128, floorBinarySearch.floor(array, -127).intValue());
    }


    /**
     * Floor presente e no meio
     */
    @Test
    void test13() {
        Integer[] array = new Integer[]{12, 26, 1048, 1026, 17};
        Assert.assertEquals(26, floorBinarySearch.floor(array, 28).intValue());
    }




}
