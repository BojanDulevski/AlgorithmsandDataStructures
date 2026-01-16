import java.util.*;

public class KolokviumNo1part2 {
    static class Machine {
        int setup;
        int calibration;

        Machine(int setup, int calibration) {
            this.setup = setup;
            this.calibration = calibration;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Machine> machines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int c = sc.nextInt();
            machines.add(new Machine(s, c));
        }


        machines.sort((a, b) -> Integer.compare(b.calibration, a.calibration));

        int currentDay = 0;
        int result = 0;

        for (Machine m : machines) {
            currentDay += m.setup;
            result = Math.max(result, currentDay + m.calibration);
        }

        System.out.println(result);
    }
}
