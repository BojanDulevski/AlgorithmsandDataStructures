import java.util.Scanner;

public class AutoBus {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        long N = input.nextLong();
        long M = input.nextLong();

        long min=Math.max(N,M)*100;

        long max= (N+M-1)*100;

        System.out.println(min);
        System.out.println(max);
    }
}
