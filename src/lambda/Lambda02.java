package lambda;

import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));

        ciftKareMax(list);
        System.out.println("    ***     ");

        toplaEl1(list);
        System.out.println("    ***     ");

        carpim(list);
        System.out.println("    ***     ");

        carpim2(list);
        System.out.println("    ***     ");

        kucukBul1(list);
        System.out.println("    ***     ");

        kucukBul2(list);
        System.out.println("    ***     ");

        kucukBul3(list);
        System.out.println("    ***     ");

        kucukBul4(list);
        System.out.println("    ***     ");

        onbestenBucukEnKuyukTekSayi(list);
        System.out.println("    ***     ");

        ciftKareKyucuktenBuuge(list);
        System.out.println("    ***     ");

        ciftKareBuyuktenKucuge(list);
        System.out.println("    ***     ");



    }

    // List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
    public static void ciftKareMax(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // Math::max yerine Integer::max kullanmamiz daha spesifik oldugu icin daha hizlidir.
        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
        //Optional class' sart kosuyor
        System.out.println(maxEl);
    }
    // List'teki tum elemanlarin toplamini yazdiriniz.
    // Lambda Expression..

    public static void toplaEl1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (t, u) -> t + u);
    /*  t her zaman ilk degerini atanan degerden (0) alir
         u her zaman degerini list.stream() den alir(akis)
         t ilk degerden sonraki degerleri islemden alir
    */
        System.out.println(toplam);
    }

    // List'teki tum elemanlarin toplamini yazdiriniz.
    // Method referance...
    public static void toplaEl2(List<Integer> list) {
        //  Optional<Integer> toplam = list.stream().reduce(Integer::sum);
        Optional<Integer> toplam = list.stream().reduce(Math::addExact);

    /*  t her zaman ilk degerini atanan degerden (0) alir
         u her zaman degerini list.stream() den alir(akis)
         t ilk degerden sonraki degerleri islemden alir
    */
        System.out.println(toplam);
    }

    // List'teki cift elemanlarin carpimini yazdiriniz.
    // Method referance...
    public static void carpim(List<Integer> list) {
        System.out.println(list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
    }

    // List'teki cift elemanlarin carpimini yazdiriniz.
    // Method referance...
    public static void carpim2(List<Integer> list) {
        Integer toplam = list.stream().filter(Lambda01::ciftBul).reduce(1, (t, u) -> t * u);
        System.out.println(toplam);
        Integer toplamP = list.stream().filter(Lambda01::ciftBul).reduce(-1, (t, u) -> t * u);
        System.out.println(toplamP);
    }

    // List'teki elemanlarin en kucugunu 4 farkli yontem ile yazdiriniz.
    public static void kucukBul1(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    public static void kucukBul2(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    public static int minBul(int x, int y) {
        return x < y ? x : y;
    }

    public static void kucukBul3(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }

    public static void kucukBul4(List<Integer> list) {
    //  Optional<Integer> min = list.stream().sorted().findFirst();

        Integer min = list.
                stream().
                reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);
        System.out.println(min);
    }
    // List'teki 15 den buyuk en kucuk tek sayiyi yazdiriniz
    public static void onbestenBucukEnKuyukTekSayi(List<Integer> list) {
        System.out.println(list.stream().filter(t -> t > 15).filter(t -> t % 2 != 0).reduce(Lambda02::minBul));
        //  System.out.println(list.
        //  stream().                               // akisa girdi
        //  filter(t -> t > 15 && t % 2 != 0).      // tek ve 15den buyuk sart saglandi
        //  reduce(Integer::min));                  // min deger reduce edildi
    }

    // List'in cift elemanlarinin karelerini kucukten buyuge yazdiriniz
    public static void ciftKareKyucuktenBuuge(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).map(t -> t * t).sorted().forEach(Lambda01::printEl);
    }

    // List'in tek elemanlarinin karelerini buyukten kucuge yazdiriniz
    public static void ciftKareBuyuktenKucuge(List<Integer> list) {
        list.
                stream().
                filter(t->t%2!=0).
                map(t -> t * t).
                sorted(Comparator.reverseOrder()).
                forEach(Lambda01::printEl);
    }


}
