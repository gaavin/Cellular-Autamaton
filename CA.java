import java.util.*;
import java.util.stream.Collectors;

public class CA {

    private static String intToBinaryString(int value) {
        String binary = Integer.toBinaryString(value);
        while(binary.length() !=8){
            binary = "0"+binary;
        }
        return binary;
    }

    private static boolean bool(int i) {
        boolean value = true;
        if (i == 0){
            value = false;
        }
        return value;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        List<Integer> rule =
                Arrays.stream(intToBinaryString(Integer.parseInt(args[1])).split("")).map(Integer::parseInt).collect(Collectors.toList());

        int numCells = 2 * n;

        boolean[] cells = new boolean[numCells];      // cellular automaton at time t
        boolean[] old   = new boolean[numCells];      // cellular automaton at time t-1
        cells[numCells/2] = true;

        for (int t = 1; t < n; t++) {

            // draw current row
            for (int i = 0; i < numCells; i++) {
                if(cells[i]) System.out.print("*");
                else         System.out.print(" ");
            }
            System.out.println("");

            // save current row
            for (int i = 0; i < numCells; i++) {
                old[i] = cells[i];
            }

            for (int i = 1; i < numCells - 1; i++) {
                if (old[i - 1] & old[i] & old[i + 1]) {
                    cells[i] = bool(rule.get(0));
                }

                if (old[i - 1] & old[i] & !old[i + 1]) {
                    cells[i] = bool(rule.get(1));
                }

                if (old[i - 1] & !old[i] & old[i + 1]) {
                    cells[i] = bool(rule.get(2));
                }

                if (old[i - 1] & !old[i] & !old[i + 1]) {
                    cells[i] = bool(rule.get(3));
                }

                if (!old[i - 1] & old[i] & old[i + 1]) {
                    cells[i] = bool(rule.get(4));
                }

                if (!old[i - 1] & old[i] & !old[i + 1]) {
                    cells[i] = bool(rule.get(5));
                }
                if (!old[i - 1] & !old[i] & old[i + 1]) {
                    cells[i] = bool(rule.get(6));
                }

                if (!old[i - 1] & !old[i] & !old[i + 1]) {
                    cells[i] = bool(rule.get(7));
                }
            }
        }
    }
}