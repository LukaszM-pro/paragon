package space;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class PlanszaHexTest {

    @Test
    void getSasiedziHexTest() {
        Plansza<Hex> plansza = new PlanszaHex(5,10,15);
        Assert.assertEquals(3,plansza.getSasiedzi(plansza.getPole(0,0,0), new LinkedList<>()).size());
        List listaOczekiwana = new ArrayList(List.of(
                plansza.getPole(0,0,1),
                plansza.getPole(0,1,0),
                plansza.getPole(1,0,0)
        ));
        listaOczekiwana.sort(Comparator.naturalOrder());
        List listaOtrzymana = plansza.getSasiedzi(plansza.getPole(0,0,0), new LinkedList<>());
        listaOtrzymana.sort(Comparator.naturalOrder());
        Assert.assertEquals(listaOczekiwana, listaOtrzymana);
        Assert.assertEquals(12,plansza.getSasiedzi(plansza.getPole(2,2,2), new LinkedList<>()).size());
        Set zbiorOczekiwany = new TreeSet(Set.of(
                plansza.getPole(3,1,2),
                plansza.getPole(3,2,2),
                plansza.getPole(2,3,2),
                plansza.getPole(1,2,2),
                plansza.getPole(1,3,2),
                plansza.getPole(2,1,2),
                plansza.getPole(3,2,1),
                plansza.getPole(2,2,3),
                plansza.getPole(1,2,3),
                plansza.getPole(2,2,1),
                plansza.getPole(2,3,1),
                plansza.getPole(2,1,3)
        ));
        Set zbiorOtrzymany = plansza.getSasiedziFunkcja.apply(plansza.getPole(2,2,2), new LinkedList<>()).stream().collect(Collectors.toCollection(TreeSet::new));
        Assert.assertEquals(zbiorOczekiwany, zbiorOtrzymany);
        plansza = new PlanszaHex(9,6);
        Assert.assertEquals(2,plansza.getSasiedziFunkcja.apply(plansza.getPole(0,0,0), new LinkedList<>()).size());
        listaOczekiwana = new ArrayList(List.of(
                plansza.getPole(0,1),
                plansza.getPole(1,0)
        ));
        listaOczekiwana.sort(Comparator.naturalOrder());
        listaOtrzymana = plansza.getSasiedziFunkcja.apply(plansza.getPole(0,0), new LinkedList<>());
        listaOtrzymana.sort(Comparator.naturalOrder());
        Assert.assertEquals(listaOczekiwana, listaOtrzymana);
        Assert.assertEquals(6,plansza.getSasiedziFunkcja.apply(plansza.getPole(1,1), new LinkedList<>()).size());
        zbiorOczekiwany = new HashSet(Set.of(
                plansza.getPole(2,0),
                plansza.getPole(2,1),
                plansza.getPole(1,2),
                plansza.getPole(0,1),
                plansza.getPole(0,2),
                plansza.getPole(1,0)
        ));
        zbiorOtrzymany = plansza.getSasiedziFunkcja.apply(plansza.getPole(1,1), new LinkedList<>()).stream().collect(Collectors.toSet());
        Assert.assertEquals(zbiorOczekiwany, zbiorOtrzymany);
    }

    @Test
    void getOtoczenieHexTest() {
        Plansza<Hex> plansza = new PlanszaHex(3,3);
//        System.out.print(plansza.getMapaByXYZ());
        Assert.assertEquals(0, plansza.getOtoczenie(plansza.getPole(0,0),-1).size());
        Assert.assertEquals(0, plansza.getOtoczenie(plansza.getPole(0,0),0).size());
        Assert.assertEquals(2, plansza.getOtoczenie(plansza.getPole(0,0),1).size());
        Assert.assertEquals(5, plansza.getOtoczenie(plansza.getPole(0,0),2).size());
        Assert.assertEquals(7, plansza.getOtoczenie(plansza.getPole(0,0),3).size());
        Assert.assertEquals(8, plansza.getOtoczenie(plansza.getPole(0,0),4).size());
        Assert.assertEquals(8, plansza.getOtoczenie(plansza.getPole(0,0),5).size());
        Assert.assertEquals(6, plansza.getOtoczenie(plansza.getPole(1,1),1).size());
        plansza = new PlanszaHex(3);
        Assert.assertEquals(0, plansza.getOtoczenie(plansza.getPole(0,0, 0),-1).size());
        Assert.assertEquals(0, plansza.getOtoczenie(plansza.getPole(0,0, 0),0).size());
        Assert.assertEquals(3, plansza.getOtoczenie(plansza.getPole(0,0, 0),1).size());
        Assert.assertEquals(9, plansza.getOtoczenie(plansza.getPole(0,0, 0),2).size());
        Assert.assertEquals(16, plansza.getOtoczenie(plansza.getPole(0,0, 0),3).size());
        Assert.assertEquals(22, plansza.getOtoczenie(plansza.getPole(0,0, 0),4).size());
        Assert.assertEquals(25, plansza.getOtoczenie(plansza.getPole(0,0, 0),5).size());
        Assert.assertEquals(26, plansza.getOtoczenie(plansza.getPole(0,0, 0),6).size());
        Assert.assertEquals(26, plansza.getOtoczenie(plansza.getPole(0,0, 0),7).size());
        Assert.assertEquals(12, plansza.getOtoczenie(plansza.getPole(1,1, 1),1).size());
        Assert.assertEquals(24, plansza.getOtoczenie(plansza.getPole(1,1, 1),2).size());
        Assert.assertEquals(26, plansza.getOtoczenie(plansza.getPole(1,1, 1),3).size());
        plansza = new PlanszaHex(19);
        Assert.assertEquals(12, plansza.getOtoczenie(plansza.getPole(9,9, 9),1).size());
        Assert.assertEquals(54, plansza.getOtoczenie(plansza.getPole(9,9, 9),2).size());
        Assert.assertEquals(146, plansza.getOtoczenie(plansza.getPole(9,9, 9),3).size());
        Assert.assertEquals(308, plansza.getOtoczenie(plansza.getPole(9,9, 9),4).size());
        Assert.assertEquals(560, plansza.getOtoczenie(plansza.getPole(9,9, 9),5).size());
        Assert.assertEquals(922, plansza.getOtoczenie(plansza.getPole(9,9, 9),6).size());
        Assert.assertEquals(1414, plansza.getOtoczenie(plansza.getPole(9,9, 9),7).size());
    }
/**/
    @Test
    void getNajblizszySasiadHexTest() {
        Plansza<Hex> plansza = new PlanszaHex(3,3);
        Pole p = plansza.getNajblizszySasiad(plansza.getPole(0,0),plansza.getPole(2,2), new LinkedList<>());
        Assert.assertEquals(plansza.getPole(1,0), plansza.getNajblizszySasiad(plansza.getPole(0,0),plansza.getPole(2,0)));
        Assert.assertTrue(plansza.getPole(0,1).equals(p) || plansza.getPole(1,0).equals(p));
        Assert.assertEquals(plansza.getPole(0,1), plansza.getNajblizszySasiad(plansza.getPole(0,0),plansza.getPole(0,2)));
        p = plansza.getNajblizszySasiad(plansza.getPole(0,2),plansza.getPole(2,0), new LinkedList<>());
        Hex h = plansza.getNajblizszySasiad(plansza.getPole(0,2),plansza.getPole(2,0), new LinkedList<>());
        Assert.assertEquals(p,h);
        plansza = new PlanszaHex(3);
        p = plansza.getNajblizszySasiad(plansza.getPole(0,0,0),plansza.getPole(2,2,2), new LinkedList<>());
        Assert.assertTrue(plansza.getPole(0,1,0).equals(p) || plansza.getPole(1,0,0).equals(p) || plansza.getPole(0,0,1).equals(p));
    }

    @Test
    void getOdlegloscTest(){
        Plansza<Hex> plansza= new PlanszaHex(100);
        double odleglosc;
        double delta = 0.000000000000001;
        Hex s, m;
        s = plansza.getPole(0,0,0);
        m = plansza.getPole(0,0,0);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(0.0,odleglosc,delta);
//        System.out.println(odleglosc);
        m = plansza.getPole(1,0,0);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(1.0,odleglosc,delta);
//        System.out.println(odleglosc);
        m = plansza.getPole(0,1,0);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(1.0,odleglosc,delta);
//        System.out.println(odleglosc);
        m = plansza.getPole(0,0,1);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(1.0,odleglosc,delta);
//        System.out.println(odleglosc);
        m = plansza.getPole(99,99,99);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(230.5,odleglosc,0.1);
        Assert.assertTrue(odleglosc > 230 && odleglosc < 231);
        s = plansza.getPole(50,50,0);
        m = plansza.getPole(0,0,50);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(66.0,odleglosc,1.0);
        s = plansza.getPole(1,0,0);
        m = plansza.getPole(0,1,0);
        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m);
        Assert.assertEquals(1.0,odleglosc,delta);
//        plansza = new PlanszaHex(1000,1000,3);
//        s = plansza.getPole(0,0,0);
//        m = plansza.getPole(999,999,2);
//        odleglosc = plansza.getOdlegloscFunkcja.apply(s,m)/2;
//        Assert.assertEquals(803.5,odleglosc,0.5);
//        Assert.assertTrue(odleglosc > 803 && odleglosc < 804);
    }

    @Test
    void getSciezkaHexTest() {
        Plansza<Hex> plansza = new PlanszaHex(3,3);
        List<Hex> sciezka1 = plansza.getSciezka(plansza.getPole(0, 0), plansza.getPole(2, 0));
        Assert.assertEquals(2, sciezka1.size());
        List<Hex> sciezka2 = plansza.getSciezka(plansza.getPole(0, 0), plansza.getPole(0, 2));
        Assert.assertEquals(2, sciezka2.size());
        List<Hex> sciezka3 = plansza.getSciezka(plansza.getPole(0, 0), plansza.getPole(2, 2));
        Assert.assertTrue(
                sciezka3.equals(List.of(plansza.getPole(1,0),plansza.getPole(1,1),plansza.getPole(2,1),plansza.getPole(2,2))) ||
                        sciezka3.equals(List.of(plansza.getPole(1,0),plansza.getPole(1,1),plansza.getPole(1,2),plansza.getPole(2,2))) ||
                        sciezka3.equals(List.of(plansza.getPole(0,1),plansza.getPole(1,1),plansza.getPole(2,1),plansza.getPole(2,2))) ||
                        sciezka3.equals(List.of(plansza.getPole(0,1),plansza.getPole(1,1),plansza.getPole(1,2),plansza.getPole(2,2)))
        );
        Assert.assertEquals(4, sciezka3.size());
        List<Hex> sciezka4 = plansza.getSciezka(plansza.getPole(2, 0), plansza.getPole(0, 2));
        Assert.assertEquals(List.of(plansza.getPole(1,1),plansza.getPole(0,2)),sciezka4);
        Assert.assertEquals(2, sciezka4.size());
        List<Hex> sciezka5 = plansza.getSciezka(plansza.getPole(0, 2), plansza.getPole(2, 0));
        Assert.assertEquals(2, sciezka5.size());
        List<Hex> sciezka6 = plansza.getSciezka(plansza.getPole(0, 0), plansza.getPole(1, 1));
        Assert.assertEquals(2, sciezka6.size());

        Plansza<Hex> plansza1 = new PlanszaHex(3);
        List<Hex> sciezka10 = plansza1.getSciezka(plansza1.getPole(0, 0,0), plansza1.getPole(2, 2,2));
        Assert.assertEquals(6, sciezka10.size());
        List<Hex> sciezka20 = plansza1.getSciezka(plansza1.getPole(0, 0,0), plansza1.getPole(0, 2,0));
        Assert.assertEquals(2, sciezka20.size());
        List<Hex> sciezka30 = plansza1.getSciezka(plansza1.getPole(0, 0,0), plansza1.getPole(2, 2,0));
        Assert.assertEquals(4, sciezka30.size());
        List<Hex> sciezka40 = plansza1.getSciezka(plansza1.getPole(2, 0,0), plansza1.getPole(0, 2,0));
        Assert.assertEquals(2, sciezka40.size());
        List<Hex> sciezka50 = plansza1.getSciezka(plansza1.getPole(0, 2,0), plansza1.getPole(2, 0,0));
        Assert.assertEquals(2, sciezka50.size());
    }
/**/
}