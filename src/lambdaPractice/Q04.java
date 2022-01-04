package lambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q04 {
    //        3) "Ali", "John", "Ali", "Alexander", "Taylor", "Ali", "Jackson" öğelerini içeren bir Dize listesi oluşturun
    //        4) "J" ile baslayin olan öğeleri almayın
    //        5) Farklı öğeleri seçin
    //        6)Karakter sayısına göre doğal sıraya koyun
    //        7) Tüm öğeleri büyük harfe dönüştürün
    //        8) Konsoldaki öğeleri yazdırın
    //        9)Fonksiyonel Programlama'yı kullanın
    //        */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("John");
        list.add("Ali");
        list.add("Alexander");
        list.add("Taylor");
        list.add("Ali");
        list.add("Jackson");

        // "J" ile baslayin olan öğeleri almayın
        list.stream().filter(t->!t.startsWith("J")).forEach(System.out::println);

        // Farklı öğeleri seçin
        System.out.println();
        list.stream().distinct().forEach(System.out::println);

        // Karakter sayısına göre doğal sıraya koyun
        System.out.println();
        list.stream().sorted(Comparator.comparing(t->t.length())).forEach(System.out::println);

        // Tüm öğeleri büyük harfe dönüştürün
        System.out.println();
        list.stream().map(t->t.toUpperCase()).forEach(System.out::println);

    }

}
