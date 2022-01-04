package lambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Lutfullah");
        list.add("Emine");
        list.add("Emine");
        list.add("Yusuf");
        list.add("Seyfullah");
        list.add("Hakan");
        //Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
        list.stream().distinct().sorted().forEach(t -> System.out.print(t + "="+t.length()+" "));

        //Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
        System.out.println();
        System.out.println("            *****            ");
        list.stream().distinct().sorted(Comparator.comparing(t->t.length())).forEach(t -> System.out.println(t));

        //Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
        System.out.println();
        System.out.println("            *****            ");
        list.stream().distinct().sorted(Comparator.comparing(t ->t.charAt(t.length()-1))).forEach(t -> System.out.println(t));

        //Konsoldaki farklı öğeleri ters sırada yazdırın.
        System.out.println();
        System.out.println("            *****            ");
        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t+" "));

        //Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
        System.out.println();
        System.out.println("            *****            ");
        list.stream().filter(t->t.length()<7).distinct().sorted(Comparator.reverseOrder()).map(t ->t.toUpperCase()).forEach(System.out::println);

    }
}
