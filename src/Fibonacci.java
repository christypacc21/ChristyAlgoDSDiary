// ?? ho chi not correct woo Edward

public class Fibonacci {

//    static int count = 0;

    public static int fibonacci(int num) {
        if (num < 0) {
            System.out.println("invalid input!");
            return 0;
        } else if (num < 2) {
            return num;
        } else {
//            count++;
//            for (int i = 0; i < count; i++) {
//                System.out.print("-");
//            }
//            System.out.println(num);
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    static int max = Integer.MAX_VALUE;
//    System.out.print(max);
    static int[] caching = new int[max];

    public static int fi2(int num) {
        if (num < 0) {
            System.out.println("invalid input!");
            return 0;
        } else if (num < 2) {
            return num;
        } else {
            if (caching[num] == 0) {
                caching[num] = fi2(num - 1) + fi2( num - 2);
            }
            return caching[num];
        }
    }

    public static void main(String[] args) {
        System.out.print(fibonacci(5));
        System.out.print(fi2(5));
//        System.out.println('asdfasdf'=='asdfsdf');
    }
}
