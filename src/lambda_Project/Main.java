package lambda_Project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Ogrenci> ogListesi = new ArrayList<>();

    public static void main(String[] args) {

        ogrenciListesi();
        notaGoreSirala(2,5);
        System.out.println();
        yasaGoreTersSirala();
        System.out.println();
        yasaVeCinsiyeteGore(26,"erkek");
        System.out.println();
        isimGoreSirala();
        System.out.println();
        soysimGoreSirala("Can");
        System.out.println();
        ortHesapla();



    }

    private static void ortHesapla() {
        double toplam = ogListesi.stream().mapToDouble(Ogrenci::getDiplomaNotu).reduce(0, Double::sum);
        System.out.println(toplam/ogListesi.size());
    }

    private static void soysimGoreSirala(String soyisim) {
        ogListesi.stream().filter(t -> t.getSoyad().equalsIgnoreCase(soyisim)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void isimGoreSirala() {
        ogListesi.stream().sorted(Comparator.comparing(Ogrenci::getAd)).forEach(System.out::println);
    }

    private static void yasaVeCinsiyeteGore(int yas, String cinsiyet) {
        ogListesi.
                stream().
                filter(t->t.getYas()<yas).
                filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).
                sorted(Comparator.comparing(Ogrenci::getYas)).
                forEach(System.out::println);
    }

    private static void yasaGoreTersSirala() {
        ogListesi.
                stream().
                sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
                forEach(System.out::println);

    }

    private static void notaGoreSirala(int alt, int ust) {
        ogListesi.stream().
                sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
                skip(alt -1).
                limit(ust-alt+1).
                forEach(System.out::println);
    }

    private static void ogrenciListesi() {
        ogListesi.add(new Ogrenci("Ahmet","Can",30,95.5,"erkek"));
        ogListesi.add(new Ogrenci("Ahmet","Yarba",25,90,"erkek"));
        ogListesi.add(new Ogrenci("Ayse","Can",21,82.5,"kadin"));
        ogListesi.add(new Ogrenci("Merve","Aslan",30,98.8,"kadin"));
        ogListesi.add(new Ogrenci("Veli","Han",80,35.5,"erkek"));
        ogListesi.add(new Ogrenci("Funda","funda",24,99.2,"kadin"));

    }

}
