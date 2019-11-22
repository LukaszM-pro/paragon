package dice.mechanics;

import l5k.dice.mechanics.ThrowL5R;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

class ThrowL5RTest {

    @Test
    void throwL5kTest() {
        int v = 10;
        int k = 12;
//        int k = 10;
//        int z = 1;
//        int rz = 1;
        int m = 0;

//        for (int i = 0; i < v; i++) {
//            ThrowL5R.throwL5K(z,rz,0,k);
//        }


//        double[] a4 =
//        Map<Integer, Integer> m4 = Stream.generate(()->ThrowL5R.throwL5K(z,rz,0,k)).limit(v).collect(Collectors.groupingBy(Function.identity(), summingInt(e -> 1)));
//        m4.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).forEach(System.out::println);
//        System.out.println(m4);
        //        System.out.println(a4[0]);
//        System.out.println(a4[v/8]);
//        System.out.println(a4[v/4]);
//        System.out.println(a4[(v-2)/2]);
//        System.out.println(a4[v/2]);
//        System.out.println(a4[v*3/4]);
//        System.out.println(a4[v*7/8]);
//        System.out.println(a4[v-1]);
//        double[] a10 = DoubleStream.generate(()-> ThrowL5R.throwL5K(z,rz,m,k)).parallel().limit(v).sorted().toArray();
//        System.out.println(a10[0]);
//        System.out.println(a10[v/8]);
//        System.out.println(a10[v/4]);
//        System.out.println((a10[(v-2)/2] + a10[v/2]) / 2.0);
//        System.out.println(a10[v*3/4]);
//        System.out.println(a10[v*7/8]);
//        System.out.println(a10[v-1]);
//        System.out.println(ThrowL5R.throwL5K(1,1,0,12));
//        /*
        double[][] arr = new double[k][k];
        for (int z = 1; z <= k; z++) {
            for (int r = 1; r <= k; r++) {
                if (z <= r) {
                    int z_ = z;
                    int r_ = r;
//                    double[] a10 = DoubleStream.generate(()-> ThrowL5R.throwL5K(z_,r_,m,k)).parallel().limit(v).sorted().toArray();
                    arr[z-1][r-1] = DoubleStream.generate(()-> ThrowL5R.throwL5K(z_,r_,m,k)).parallel().limit(v).average().getAsDouble()
//                        (a10[(v-2)/2] + a10[v/2]) / 2.0
                    ;

                }
            }
//            System.out.println(Arrays.toString(arr[z-1]));
        }
        /**/
    }
//    @Test
//    void throwL5K1KrTest() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K1Kr();
//        }
//    }

//    @Test
//    void throwL5K1KwTest() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K1Kw();
//        }
//    }

//    @Test
//    void throwL5K1KrsTest1() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K1Krs1(5,10);
//        }
//    }

//    @Test
//    void throwL5K1KrsTest2() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K1Krs2(5,10);
//        }
//    }

//    @Test
//    void throwL5K1KraTest() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K1Kra(5,10);
//        }
//    }

//    @Test
//    void throwL5K1KwaTest() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K1Kwa(5,10);
//        }
//    }

//    @Test
//    void theThrowL5K1K2Test() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K10(5,10);
//        }
//    }

//    @Test
//    void theThrowL5K1K3Test() {
//        int r;
//        for (int i = 0; i < 10000000; i++) {
//            r = ThrowL5R.throwL5K10(5,10, 1);
//        }
//    }
}