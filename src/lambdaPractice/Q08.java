package lambdaPractice;

import java.util.stream.IntStream;

public class Q08 {
    // 7 ile bolunebilen ilk 10 tamsayinin toplamini ekrana yazdiriniz.
    public static void main(String[] args) {

        System.out.println(IntStream.iterate(7, t -> t + 7).limit(10).sum());


    }
}
