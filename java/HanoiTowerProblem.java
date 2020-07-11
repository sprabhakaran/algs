import java.util.Arrays;
import java.util.Stack;

public class HanoiTowerProblem {
    static Stack<Integer> A = new Stack<Integer>() {
        {
            add(3);
            add(2);
            add(1);
        }
    },
            B = new Stack<>(),
            C = new Stack<>();

    public static void main(String[] args) {
        solveHanoi1(A.size(), A, C, B);
        solveHanoi(3, 'A', 'C', 'B');
    }

    static int cnt = 0;

    private static void solveHanoi1(int disk, Stack<Integer> from, Stack<Integer> to, Stack<Integer> aux) {
        if (cnt++ > 10) {
//            return;
        }
        printTower("- ");
        if (disk == 1) {
            return;
        }
        to.add(from.pop());
        solveHanoi1(disk - 1, from, aux, to);
        printTower("(1)");
        aux.add(from.pop());
        printTower("(2)");
        solveHanoi1(disk - 1, aux, to, from);
    }

    private static void solveHanoi(int diskId, char from, char to, char aux) {
//        System.out.println("- " + diskId + "  from : " + from + " to: " + to + "  aux : " + aux);
        if (diskId == 1) {
            System.out.println("disk 1 is moved " + from + " to " + to);
            return;
        }
        solveHanoi(diskId - 1, from, aux, to);

        System.out.println("disk " + diskId + " is moved " + from + " to " + to);
        solveHanoi(diskId - 1, aux, to, from);
    }

    static void printTower(String s) {
        System.out.print(s);
        printTower(A, "A");
        printTower(B, "B");
        printTower(C,  "C");
        System.out.println();
    }

    static void printTower(Stack s, String v) {
        System.out.print(v + ": [");
        for (int i = s.size() - 1; i >= 0; i--) {
            System.out.print(" " + s.get(i) + " ");
        }
        System.out.print("], ");
    }

    private static void printTower1() {
        StringBuilder sb = new StringBuilder();
        int towerCnt = 3;

        String[][] matrix = new String[4][12];

        for (String[] arr : matrix) {
            Arrays.fill(arr, " - ");
        }

        for (String[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

        for (int t = 0; t < towerCnt; t++) {

            for (int i = 0; i < 3; i++) {
                for (int s = 0; s < 3 - i; s++) {
                    sb.append("  ");
                }
                for (int j = 0; j <= i; j++) {
                    sb.append(" || ");
                }
                sb.append("\n");
            }
        }
//        return sb.toString();
//        System.out.println(sb.toString());
    }

}