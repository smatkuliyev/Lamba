package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("mehmetx","emre","nilgun","yildiz","kader","emine","islam","islam","emre","wabizzuddin"));

        alfBuyukTekrarsiz(list);

        System.out.println();
        karakterTersSiraTekrarsiz(list);

        System.out.println();
        karSayisiKcktenBykEl(list);

        System.out.println();
        sonHarfTersSirala(list);

        System.out.println();
        ciftKareTekrarsizSira(list);

        System.out.println();
        harfSayisi7Kontrol(list);

        System.out.println();
        wBaslaKontrol(list);


        System.out.println();
        xBitirKontrol(list);

        System.out.println();
        karSayiSirala(list);

        System.out.println();
        karSayiSirala2(list);

        System.out.println();
        sonHarfSiralaILkHaric(list);

    }

    // List elemanlarini alfabatik buyuk harf sirasiyla ve tekrarsiz yazdiriniz
    public static void alfBuyukTekrarsiz(List<String> list) {
        list.
                stream().                           // akisa girdi
        //      map(t->t.toUpperCase()).            // buyuk harf yapildi
                map(String::toUpperCase).           // buyuk harf yapildi
                sorted().                           // alfabetik sirala
                distinct().                         // tekrarsiz olsun dedik
                forEach(t-> System.out.print(t + " "));
        //      forEach(System.out::println);       // yazdirildi
    }

    // List elemanlarinin character sayisini ters sirali olarak tekrarsiz yazdiralim

    public static void karakterTersSiraTekrarsiz(List<String> list) {
        list.
                stream().
                map(t ->t.length()).                    // character sayisana update edildi
                sorted(Comparator.reverseOrder()).      // ters sira
                distinct().                             // tekrarsiz
                forEach(Lambda01::printEl);             // yazdirildi
    }

    // List elemanlarini character sayisina gore kucukten buyuge yazdiriniz.

    public static void karSayisiKcktenBykEl(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(t->t.length())).
         //     distinct().
                forEach(t-> System.out.print(t + " "));
    }

    // list elemanlarini son harfine gore ters sirali yazdiriniz
    public static void sonHarfTersSirala(List<String> list){
        list.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                sorted(Comparator.reverseOrder()).
                forEach(t-> System.out.print(t + " "));
    }

    //Cift sayili elemanlarin karelerini hesaplayan, tekrarsiz buyukten kucuge dogru yaziniz.
    public static void ciftKareTekrarsizSira(List<String> list){
        list.
                stream().
                map(t -> t.length()*t.length()).
                filter(Lambda01::ciftBul).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(Lambda01::printEl);
    }

    // List elemanlarinin karakter sayisinin 7 ve 7den az olmaz durumunu kontrol ediniz
    public static void harfSayisi7Kontrol(List<String> list){
    //    boolean kontrol = list.
    //            stream().
    //            allMatch(t -> t.length() <= 7);
    //  //  System.out.println(kontrol);
    //    if (kontrol){
    //        System.out.println("List elemanlari 7 harften buyuk");
    //    } else {
    //        System.out.println("List elemanlari 7 harften buyuk degiil");
    //    }
        System.out.println(list.
                stream().
                allMatch(t -> t.length() <= 7) ?"List elemanlari 7 harften buyuk degil" : "List elemanlari 7 harften buyuk" );
    }

    // List elemanlarinin "W" ile baslamasini kontrol ediniz
    public static void wBaslaKontrol(List<String> list){
     //   list.stream().map(t->t.toString().startsWith("w")).forEach(System.out::println);
        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan" : "w ile baslamiyor");
    }


    // List elemanlarinin "x" ile bitme kontrol ediniz
    public static void xBitirKontrol(List<String> list){
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile bitiyor" : "x ile bitmiyor");
        //  anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //  allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //  noneMatch() --> hic bir eleman sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

    // Karakter sayisi en buyuk elemani yazdiriniz
    public static void karSayiSirala(List<String> list){
        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                findFirst());           // ilk elemani bulur
    }

    // Karakter sayisi en buyuk elemani yazdiriniz
    public static void karSayiSirala2(List<String> list){
        Stream<String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                limit(1);                // ilk elemani alir, kac yazarsak o kadar eleman ile sinirlandirir
        System.out.println(Arrays.toString(sonIsim.toArray()));
    }

    // List elemanlarini son harfine gore siralayip ilk eleman haric kalan elemanlari yazdiriniz
    public static void sonHarfSiralaILkHaric(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
         //     sorted(Comparator.reverseOrder()).
                skip(1).                                // akistan çıkan elemanlarin 1. elemani atlar, kac yazarsak o kadar eleman atlar
                forEach(t-> System.out.print(t + " "));
    }



}
