package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {

        TechPro trGunduz = new TechPro("yaz","TR Gunduz",97,124);
        TechPro engGunduz = new TechPro("kis","ENG Gunduz",95,131);
        TechPro trGece = new TechPro("bahar","TR Gece",98,143);
        TechPro engGece = new TechPro("sonbahar","ENG Gece",93,151);

        List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));
        // bu class'da return type calisacagiz
        System.out.println(batchOrt92Byk(list));
        System.out.println("    ***     ");
        System.out.println(batchOgrc100Kck(list));
        System.out.println("    ***     ");
        System.out.println(batchbaharVarmi(list));
        System.out.println("    ***     ");
        System.out.println(orgcSayiBykKck(list));
        System.out.println("    ***     ");
        System.out.println(batchOrtIlkUcYaz(list));
        System.out.println("    ***     ");
        System.out.println(batchOgrcSayiEnazIkinciYaz(list));
        System.out.println("    ***     ");
        System.out.println(batchOrt95BykOgrcSayi(list));
        System.out.println("    ***     ");
        System.out.println(batchOrt95BykOgrcSayi1(list));
        System.out.println("    ***     ");
        System.out.println(ogrc130BykBatchOrt(list));
        System.out.println("    ***     ");
        System.out.println(gunduzBatchSayis(list));
        System.out.println("    ***     ");
        System.out.println(bykOgrc130EnBykOrt(list));
        System.out.println("    ***     ");
        System.out.println(kckOgrc150EnKckOrt(list));


    }
    // task 01 - batch ort'larinin 92 den buyuk oldg kontrol eden pr create ediniz
    public static boolean batchOrt92Byk(List<TechPro> list ){
      // boolean sonuc =  list.
        return list.
                stream().
                allMatch(t -> t.getBatchOrt() > 92); // akistaki her eleman batchOrt e gore kontrol edildi
      //  return sonuc;
    }

    // task 02 - ogrc sayilarinin hic birinin 110 dan az olmadigini kontrol eden method yaziniz
    public static boolean batchOgrc100Kck(List<TechPro> list ) {
        return list.
                stream().
                noneMatch(t->t.getOgrcSayisi()<110);
         //     allMatch(t->t.getOgrcSayisi()>=110);
    }

    // task 03 - batch'lerde her hangi birinde "bahar" olup olmadigini kontrol eden method yaziniz
    public static boolean batchbaharVarmi(List<TechPro> list ){
        return list.
                stream().
                anyMatch(t->t.getBatch().equalsIgnoreCase("bahar"));
    }

    // task 04 - batch'lerin ogrc sayilarina gore buyukten kucuge gore siralayan method yaziniz
    public static List<TechPro> orgcSayiBykKck (List<TechPro> list ) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).
                        reversed()).
                 collect(Collectors.toList());      // collect de toplanan elemanlari list'e cevirir
    }

    // task 05 - batch'leri batchOrt gore buyukten kucuge gore siralayip ilk 3u yazdiriniz
    public static List<TechPro> batchOrtIlkUcYaz (List<TechPro> list ){
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
                limit(3).
                collect(Collectors.toList());
    }

    // task 06 - batch'leri ogrc sayisi en az olan 2. batch'i yazdiriniz
    public static List<TechPro> batchOgrcSayiEnazIkinciYaz (List<TechPro> list ){
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());
    }

    // task 07 - batch ort 95 den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz
    public static int batchOrt95BykOgrcSayi (List<TechPro> list ){
       return list.
               stream().
               filter(t->t.getBatchOrt()>95).
               map(t->t.getOgrcSayisi()).
               reduce(0, Integer::sum);
       //      reduce(0,(t,u)->t+u);//ogrc sayisi toplandi
    }

    public static int batchOrt95BykOgrcSayi1 (List<TechPro> list ){
        return list.
                stream().
                filter(t->t.getBatchOrt()>95).
                mapToInt(t->t.getOgrcSayisi()).      // mapToInt() --> Type'ne gore int return ederki sum() calisir,
                sum();                               // reduce gerek kalmaza, daha kisa ve hizli olur
    }

    // task 08 - ogrc sayisi 130 dan buyuk olan batch'lerin batch ortalamasini yazdiriniz
    public static OptionalDouble ogrc130BykBatchOrt (List<TechPro> list ){
        return list.
                stream().
                filter(t->t.getOgrcSayisi()>130).
                mapToDouble(t->t.getBatchOrt()).average();

    }

        //task 09-->gunduz batch'lerinin sayisini  yazdiriniz.
    public static int /*List<TechPro>*/ gunduzBatchSayis(List<TechPro> list ){
        return (int) list.
                stream().
                filter(t->t.getBatchName().contains("Gunduz")).count();
         //      collect(Collectors.toList());
         //     size();
    }

        //task 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ort'unu bulunuz
    public static OptionalInt /*Optional<TechPro>*/ bykOgrc130EnBykOrt(List<TechPro> list ){
        return list.
                stream().
                filter(t->t.getOgrcSayisi()>130).
        //        sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
        //       findFirst();
                mapToInt(TechPro::getBatchOrt).
                        max();

    }

        //task 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ort'unu bulunuz.
        public static int /* Optional<TechPro>*/ kckOgrc150EnKckOrt(List<TechPro> list ){
            return list.
                    stream().
                    filter(t->t.getOgrcSayisi()<150).
            //        sorted(Comparator.comparing(TechPro::getBatchOrt)).
            //        findFirst();
                    mapToInt(TechPro::getBatchOrt).
                    min().
                    getAsInt();     //getAsInt()-->cıktıyı int type olarak return eder

        }


}
