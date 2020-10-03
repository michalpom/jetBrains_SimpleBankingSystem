import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, n, k;

        a = scanner.nextInt();
        b = scanner.nextInt();
        n = scanner.nextInt();
        k = scanner.nextInt();

        int[] arr = new int[n];
        int X=0; //wanted seed
        int N = Integer.MAX_VALUE; //wanted value

        for (int i = a; i <= b; i++) {
            Random random = new Random(i);

            for (int j = 0; j < n; j++) {
                arr[j] = random.nextInt(k);
            }
            int localMax = getMax(arr); //max value in the array with i seed
            if (localMax<N){
                N=localMax;
                X=i; //saving seed with local min value
            }
        }

        System.out.println(X);
        System.out.println(N);

    }

    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}