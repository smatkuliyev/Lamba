package lambdaPractice;

import java.util.ArrayList;
import java.util.List;

public class Q06 {
    //Fonksiyonel Programlama ile [12, 9, 13, 4, 6, 2, 4, 12, 15] listesindeki tüm tek sayıları yazdırın
    //6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
    //Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(9);
        list.add(13);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(12);
        list.add(15);
        //Fonksiyonel Programlama ile [12, 9, 13, 4, 6, 2, 4, 12, 15] listesindeki tüm tek sayıları yazdırın
        list.stream().filter(t->t%2==1).forEach(System.out::println);
        System.out.println("        ***          ");

        //6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
        list.stream().filter(t->t<16&&t>14).map(t->t*t).forEach(System.out::println);
        System.out.println("        ***          ");

        //Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
        System.out.println(list.stream().filter(t -> t % 2 == 1).mapToDouble(Math::sqrt).sum());


    }
}
