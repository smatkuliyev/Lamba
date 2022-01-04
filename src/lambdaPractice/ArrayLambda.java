package lambdaPractice;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayLambda {
    public static void main(String[] args) {
        /*
        kullanıcıdan aldıgınız bir array'in en buyuk ve en kucuk elemanlarının farkını hesaplayınız
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("arrayiniz icin eleman sayisi belirleyin:");
        int arrBoyutu = scan.nextInt();

        int arr[] = new int[arrBoyutu];

        for (int i = 0; i < arrBoyutu; i++) {
            System.out.println("Arrayin " + (i + 1) + ". elemanini giriniz");
            arr[i] = scan.nextInt();
        }
     // System.out.println(Arrays.stream(arr).
     //         sorted().
     //         filter(t -> t < arr[1] || t > arr[arr.length - 2]).
     //         reduce((t, u) -> t - u));
        OptionalInt max =  Arrays.stream(arr).max();
        OptionalInt min = Arrays.stream(arr).min();
        System.out.println(max.getAsInt() - min.getAsInt());

    }
}
