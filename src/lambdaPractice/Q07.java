package lambdaPractice;

import java.util.ArrayList;
import java.util.List;

public class Q07 {
    //String isimlerden olusan bir list olusturnuz
    //List'deki isimlerden "a" ve "n" icerenlerin harf sayilarinin toplamini ekrana yazdiriniz
    //List'deki isimlerden ilk harfi son harfinden alfabetik olarak onde olan isimleri ekrana yazdirin
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("John");
        list.add("Ali");
        list.add("Alexander");
        list.add("Taylor");
        list.add("Ali");
        list.add("Jackson");

        System.out.println(list.stream().filter(t -> t.contains("n") || t.contains("a")).mapToInt(t -> t.length()).sum());
        System.out.println("        *****        ");

        list.stream().filter(t-> t.charAt(0) < t.charAt(t.length()-1)).distinct().forEach(System.out::println);


    }
}
