public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) return false;
                for (int j1 = j + 1 ; j1 < sudoku.length; j1++) {
                    if (sudoku[i][j] == sudoku[i][j1])
                        return false;
                }
            }
        }

        for (int j = 0; j < sudoku.length; j++) {
            for (int i = 0; i < sudoku.length; i++) {
                for (int i1 = i + 1 ; i1 < sudoku.length; i1++) {
                    if (sudoku[i][j] == sudoku[i1][j])
                        return false;
                }
            }
        }

        for (int k = 0; k < sudoku.length * 3; k += 3) {
            int a = (k / 9)*3, b = k % 9;
            for (int i = 0; i < sudoku.length; i++) {
                for (int i1 = i + 1; i1 < sudoku.length; i1++) {
                    if (sudoku[a + (i / 3)][b + (i % 3)] == sudoku[a + (i1 / 3)][b + (i1 % 3)])
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(check(sudoku));
        
        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;
        System.out.println(check(sudoku));

        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;
        
        sudoku[4][4] = 0;
        System.out.println(check(sudoku));

    }
}