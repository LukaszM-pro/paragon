package space;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

class PlanszaKwadratTest {
/*
    @Test
    void getSasiedziKwadratTest() {
        Plansza plansza2D = new PlanszaKwadrat(5,5);
        Assert.assertEquals(3,plansza2D.getSasiedziFunkcja.apply(plansza2D.getPole(0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza2D.getPole(1,1),
                plansza2D.getPole(1,0),
                plansza2D.getPole(0,1)
        ), plansza2D.getSasiedziFunkcja.apply(plansza2D.getPole(0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
        Assert.assertEquals(3,plansza2D.getSasiedziFunkcja.apply(plansza2D.getPole(0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza2D.getPole(1,0),
                plansza2D.getPole(0,1),
                plansza2D.getPole(1,1)
        ), plansza2D.getSasiedziFunkcja.apply(plansza2D.getPole(0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
        Plansza plansza3D = new PlanszaKwadrat(5);
//        System.out.print(plansza3D.getSasiedziKwadratRuch(plansza3D.getPole(0,0,0)));
        Assert.assertEquals(7,plansza3D.getSasiedziFunkcja.apply(plansza3D.getPole(0,0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza3D.getPole(0,1,1),
                plansza3D.getPole(1,1,1),
                plansza3D.getPole(1,1,0),
                plansza3D.getPole(1,0,1),
                plansza3D.getPole(1,0,0),
                plansza3D.getPole(0,1,0),
                plansza3D.getPole(0,0,1)
        ),plansza3D.getSasiedziFunkcja.apply(plansza3D.getPole(0,0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
//        System.out.print(plansza3D.getSasiedziKwadratStrzal(plansza3D.getPole(0,0,0)));
        Assert.assertEquals(7,plansza3D.getSasiedziFunkcja.apply(plansza3D.getPole(0,0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza3D.getPole(1,0,0),
                plansza3D.getPole(0,1,0),
                plansza3D.getPole(1,1,0),
                plansza3D.getPole(1,0,1),
                plansza3D.getPole(0,1,1),
                plansza3D.getPole(1,1,1),
                plansza3D.getPole(0,0,1)
        ),plansza3D.getSasiedziFunkcja.apply(plansza3D.getPole(0,0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));

        PlanszaKwadrat plansza2Dk = new PlanszaKwadrat(5,5);
        Assert.assertEquals(2,plansza2Dk.getSasiedziKwadratRuchFunkcja.apply(plansza2Dk.getPole(0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza2Dk.getPole(1,0),
                plansza2Dk.getPole(0,1)
        ), plansza2Dk.getSasiedziKwadratRuchFunkcja.apply(plansza2Dk.getPole(0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
        Assert.assertEquals(3,plansza2Dk.getSasiedziKwadratStrzalFunkcja.apply(plansza2Dk.getPole(0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza2Dk.getPole(1,0),
                plansza2Dk.getPole(0,1),
                plansza2Dk.getPole(1,1)
        ), plansza2Dk.getSasiedziKwadratStrzalFunkcja.apply(plansza2Dk.getPole(0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
        PlanszaKwadrat plansza3Dk = new PlanszaKwadrat(5);
//        System.out.print(plansza3D.getSasiedziKwadratRuch(plansza3D.getPole(0,0,0)));
        Assert.assertEquals(3,plansza3Dk.getSasiedziKwadratRuchFunkcja.apply(plansza3Dk.getPole(0,0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza3Dk.getPole(1,0,0),
                plansza3Dk.getPole(0,1,0),
                plansza3Dk.getPole(0,0,1)
        ),plansza3Dk.getSasiedziKwadratRuchFunkcja.apply(plansza3Dk.getPole(0,0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
//        System.out.print(plansza3D.getSasiedziKwadratStrzal(plansza3D.getPole(0,0,0)));
        Assert.assertEquals(7,plansza3Dk.getSasiedziKwadratStrzalFunkcja.apply(plansza3Dk.getPole(0,0,0),new LinkedList<>()).size());
        Assert.assertEquals(Set.of(
                plansza3Dk.getPole(1,0,0),
                plansza3Dk.getPole(0,1,0),
                plansza3Dk.getPole(1,1,0),
                plansza3Dk.getPole(1,0,1),
                plansza3Dk.getPole(0,1,1),
                plansza3Dk.getPole(1,1,1),
                plansza3Dk.getPole(0,0,1)
        ),plansza3Dk.getSasiedziKwadratStrzalFunkcja.apply(plansza3Dk.getPole(0,0,0),new LinkedList<>()).stream().collect(Collectors.toSet()));
    }
    /**/
}