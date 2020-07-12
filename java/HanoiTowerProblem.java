import java.util.Stack;

public class HanoiTowerProblem {

    static Stack<Integer> A = new Stack<Integer>() {
        {
//            add(5);
//            add(4);
            add(3);
            add(2);
            add(1);
        }
    },
            B = new Stack<>(),
            C = new Stack<>();

    static int DISKS = A.size();

    public static void main(String[] args) {
        printTower();
        solveHanoi(A.size(), A, B, C);
    }

    private static void solveHanoi(int disk, Stack<Integer> from, Stack<Integer> to, Stack<Integer> aux) {
        if (disk > 0) {
            solveHanoi(disk - 1, from, aux, to);
            aux.push(from.pop());
            printTower();
            solveHanoi(disk - 1, to, from, aux);
        }

    }

    static int printCnt = 0;
    static void printTower() {
        char[][] m1 = constructMatrix(A);
        char[][] m2 = constructMatrix(B);
        char[][] m3 = constructMatrix(C);
        char[][] con1 = converge(m1, m2, m3);
        System.out.println(++printCnt);
        printMatrix(con1);
        System.out.println();
    }

    static char[][] converge(char[][] m1, char[][] m2, char[][] m3) {
        int m1C = m1[0].length;
        int m2C = m2[0].length;
        int m3C = m3[0].length;
        char[][] newM = new char[m1.length][m1C + m2C + m3C];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                newM[i][j] = m1[i][j];
            }
        }

        int startPos = m1C;

        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                newM[i][j + startPos] = m2[i][j];
            }
        }

        startPos = startPos + m2C;

        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {
                newM[i][j + startPos] = m3[i][j];
            }
        }

        return newM;
    }

    static char[][] constructMatrix(Stack<Integer> stack) {
        int DS = (DISKS) + ((DISKS) - 1);
        char[][] matrix = new char[DISKS][DS];

        Stack<Integer> AA = (Stack<Integer>) stack.clone();

        int startRow = DISKS - AA.size();

        for (int i = 0; i < matrix.length; i++) {
            if (i < startRow) {
                continue;
            }
            int diskCnt = AA.pop();
            int inc = diskCnt == 1 ? 1 : 2;
            int reach = 0;
            for (int j = DISKS - diskCnt; j < DS; j = j + inc) {
                matrix[i][j] = '|';
                if (++reach == diskCnt) {
                    break;
                }
            }
        }
        return matrix;
    }

    static void printMatrix(char[][] matrix) {
        int split = DISKS + DISKS - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % split == 0) {
                    System.out.print("\t");
                }
                Character c = matrix[i][j];
                if (c == '\0') {
                    c = ' ';
                }
                if (c == '|') {
                    c = '*';
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

/*

1
	    *
	  *   *
	*   *   *

2

	  *   *
	*   *   * 	          	    *

3


	*   *   * 	  *   *   	    *

4

	          	    *
	*   *   * 	  *   *

5

	          	    *
	          	  *   *   	*   *   *

6


	    *     	  *   *   	*   *   *

7

	          	          	  *   *
	    *     	          	*   *   *

8
	          	          	    *
	          	          	  *   *
	          	          	*   *   * 

 */