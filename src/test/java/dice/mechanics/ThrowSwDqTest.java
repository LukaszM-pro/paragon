package dice.mechanics;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;


class ThrowSwDqTest {

//    @Test
//    void getIloscSlabychKosciTest() {
//        Assert.assertEquals(0, new ThrowSwDq().getIloscSlabychKosci(3,3));
//        Assert.assertEquals(1, new ThrowSwDq().getIloscSlabychKosci(4,3));
//        Assert.assertEquals(1, new ThrowSwDq().getIloscSlabychKosci(3,4));
//        Assert.assertEquals(2, new ThrowSwDq().getIloscSlabychKosci(5,3));
//        Assert.assertEquals(2, new ThrowSwDq().getIloscSlabychKosci(3,5));
//        Assert.assertEquals(3, new ThrowSwDq().getIloscSlabychKosci(6,3));
//        Assert.assertEquals(4, new ThrowSwDq().getIloscSlabychKosci(3,7));
//    }

//    @Test
//    void getIloscMocnychKosciTest() {
//        Assert.assertEquals(0, new ThrowSwDq().getIloscMocnychKosci(0,3));
//        Assert.assertEquals(1, new ThrowSwDq().getIloscMocnychKosci(1,3));
//        Assert.assertEquals(2, new ThrowSwDq().getIloscMocnychKosci(2,3));
//        Assert.assertEquals(3, new ThrowSwDq().getIloscMocnychKosci(3,3));
//        Assert.assertNotEquals(4, new ThrowSwDq().getIloscMocnychKosci(4,3));
//    }

    @Test
    void getResultDQTest() {
//        System.out.println(new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,1, 1));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
        Assert.assertTrue(0 <= new ThrowSwDq().getResultDQ(3,3,0,3,0, 0));
    }

    @Test
    void rndTest() {
        double[] arr = new double[20];
        for(int i = 1; i <= 20; i++) {
            for(int j = 1; j <= 20; j++) {
                int i_ = i;
                int j_ = j;
                IntSummaryStatistics stats = IntStream.generate(() -> ThrowSwDq.rnd(i_,j_)).limit(1/*000_000*/).summaryStatistics();
                arr[j-1] = stats.getAverage();
            }
//            System.out.println(Arrays.toString(arr));
        }

    }
}