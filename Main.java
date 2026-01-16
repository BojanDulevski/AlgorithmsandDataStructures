
import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int[] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int getTotalRevenue() {
        int sum = 0;
        for (int r : revenues) sum += r;
        return sum;
    }

    @Override
    public String toString() {

        return String.format("Q%d:%3d  sales%3d", quarterNo, numOfSales, getTotalRevenue());
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales[] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public String getName() {
        return name;
    }

    public int totalSales() {
        int sum = 0;
        for (QuarterlySales q : quarters) {
            sum += q.getTotalRevenue();
        }
        return sum;
    }

    @Override
    public String toString() {

        return String.format("%s   %3d   %3d   %3d   %3d   %3d",
                name,
                quarters[0].getTotalRevenue(),
                quarters[1].getTotalRevenue(),
                quarters[2].getTotalRevenue(),
                quarters[3].getTotalRevenue(),
                totalSales());
    }
}

public class  {

    public static SalesPerson salesChampion(SalesPerson[] arr) {
        SalesPerson best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].totalSales() > best.totalSales()) {
                best = arr[i];
            }
        }
        return best;
    }

    public static void table(SalesPerson[] arr) {
        System.out.println("SP   1   2   3   4   Total");
        for (SalesPerson sp : arr) {
            System.out.println(sp);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine(); // clear buffer

        SalesPerson[] arr = new SalesPerson[n];

        for (int i = 0; i < n; i++) {

            String name = input.nextLine();
            QuarterlySales[] quarters = new QuarterlySales[4];

            for (int q = 0; q < 4; q++) {

                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];

                for (int s = 0; s < numOfSales; s++) {
                    revenues[s] = input.nextInt();
                }

                quarters[q] = new QuarterlySales(numOfSales, revenues, q + 1);
            }

            input.nextLine(); // clear buffer
            arr[i] = new SalesPerson(name, quarters);
        }

        table(arr);
        System.out.println();
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());
    }
}
