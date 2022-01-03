package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
	/*
	   1) Lambda01 "Functional Programming"
	      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	   ve hatasiz code yazma acilarindan cok faydalidir.
	   4) Lambda01 sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullan?lmaz.
	      Lambda01 kullanmak hatasiz code kullanmaktir.
	*/
	public static void main(String[] args) {
		
		List<Integer> list = new  ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,65,42)); 
		printElStructured(list);
		
		System.out.println();
		System.out.println("	***			");
		printFunctional(list);
		
		System.out.println();
		System.out.println("	***			");
		printFunctional1(list);
		
		System.out.println();
		System.out.println("	***			");
		printCiftElStructured(list);
		
		System.out.println();
		System.out.println("	***			");
		printCiftFunctional1(list);
				
		System.out.println();
		System.out.println("	***			");
		printCiftFunctional2(list);
		
		System.out.println();
		System.out.println("	***			");
		printCiftAltmisKucuk(list);
		
		System.out.println();
		System.out.println("	***			");
		printTekYirmiBucuk(list);
		
		System.out.println();
		System.out.println("	***			");
		printCiftKareAl1(list);
		
		System.out.println();
		System.out.println("	***			");
		kupBirFazlaTekFunction(list);
		
		System.out.println();
		System.out.println("	***			");
		ciftKareKokAl(list);
		
		System.out.println();
		System.out.println("	***			");
		enBuyukYazdir(list);
		
		System.out.println();
		System.out.println("	***			");
		enKucukYazdir(list);
		
		
		
	}
	// structured programming ile list elemanlarinin tamimini yazdiriniz
	
	public static void printElStructured(List<Integer> list) {		
		for (Integer w : list) {
			System.out.print(w + " ");
		}
	}
	// Functional programming ile list elemanlarinin tamimini yazdiriniz
	public static void printFunctional(List<Integer> list) {
		list.stream().forEach(t->System.out.print(t+" ")); 				// Lambda01 expression
		// stream() : datalari yukaridan asagiya akis sekline getirir
		// forEach(): datanin parametresine gore her bir elemani isler
		// t-> : Lambda01 operatoru
		// Lambda01 expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir.
		
	} 
	
	// METHOD Reference : kendi create ettigimiz veya java'dan aldigimiz method ile
	// ClassName::MethodName	ez--ber--le !!!
	
	public static void printEl(int t) {// refere edilecek method create edildi
		System.out.print(t+" ");
	}
	
	public static void printFunctional1(List<Integer> list) {
		list.stream().forEach(Lambda01::printEl); 			// iste bu Lambda01
	}
	
	// structured programming ile list elemanlarinin cift olanlarinin yazdiriniz
	public static void printCiftElStructured(List<Integer> list) {		
		for (Integer w : list) {
			if (w%2==0) {
				System.out.print(w + " ");				
			}
		}
	}
	// Functional programming ile list elemanlarinin cift olanlarinin yazdiriniz
	public static void printCiftFunctional1(List<Integer> list) {
		list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
		// filter() : akis icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}
	
	public static void printCiftFunctional2(List<Integer> list) {
		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl); 		// iki tane method refere 
		// filter() : akis icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}
	
	public static boolean ciftBul(int i) {//refere edilecek tohum method creat edildi
		return i%2==0;		
	}
	
	// Functional programming ile list elemanlarinin cift olanlarinin 60dan kucuk olanlari yazdiriniz
	public static void printCiftAltmisKucuk(List<Integer> list) {
		list.stream().filter(t->t%2==0 && t<60).forEach(Lambda01::printEl); 			// filter(t->t%2==0).filter(t->t<60)
	}
	
	// Functional programming ile list elemanlarinin tek olanlarinin veya 20dan buyuk olanlari yazdiriniz
	
	public static void printTekYirmiBucuk(List<Integer> list) {
		list.stream().filter(t->t%2!=0 || t>20).forEach(Lambda01::printEl); 			
	}
	
	// Functional programming ile list elemanlarinin cift olanlarinin karelerini yazdiriniz
	public static void printCiftKareAl1(List<Integer> list) {
		list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl); 			
	}
	
	// Functional programming ile list elemanlarinin tek olanlarinin kuplerininin bir fazlasini yazdiriniz
	
	public static void kupBirFazlaTekFunction(List<Integer> list) {
		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);		
	}
	
	// Functional programming ile list elemanlarinin cift olanlarinin karekoklerini yazdiriniz
	public static void ciftKareKokAl(List<Integer> list) {
		list.
		stream().
		filter(Lambda01::ciftBul).
		map(Math::sqrt).
		forEach(t->System.out.println(t+" " ));	
	}
	
	//list'in en buyuk elemanini yazdiriniz
	public static void enBuyukYazdir(List<Integer> list) {
		Optional<Integer> maxEl = list.stream().reduce(Math::max);
		System.out.println(maxEl);
	}
	// reduce --> azaltmak... bir cok data'yi tek bir data'ya(min,max,toplamak,carpmak...) cevirmek icin kullanilir.
	public static void enKucukYazdir(List<Integer> list) {
		Optional<Integer> minEl = list.stream().reduce(Math::min);
		System.out.println(minEl);
	}
	
}

