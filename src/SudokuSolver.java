public class SudokuSolver {
    public boolean solve(SudokuGrid grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid.getCell(row, col) == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(grid, row, col, num)) {
                            grid.setCell(row, col, num);
                            if (solve(grid)) return true;
                            grid.setCell(row, col, 0); // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(SudokuGrid grid, int row, int col, int num) {
        // Vérifie la ligne et la colonne
        for (int i = 0; i < 9; i++) {
            if (grid.getCell(row, i) == num || grid.getCell(i, col) == num) return false;
        }
        // Vérifie la sous-grille 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.getCell(startRow + i, startCol + j) == num) return false;
            }
        }
        return true;
    }
}