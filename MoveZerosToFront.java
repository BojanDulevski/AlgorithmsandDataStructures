
import java.util.*;

public class MoveZerosToFront {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int[] result = moveZerosToFront(arr);

        System.out.println("Transformiranata niza e:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] moveZerosToFront(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int index = n - 1;


        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                res[index] = arr[i];
                index--;
            }
        }

        return res;
    }
}
