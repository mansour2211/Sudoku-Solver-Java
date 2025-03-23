import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SudokuGrid {
    private int[][] grid;

    public SudokuGrid() {
        grid = new int[9][9];
    }

    // Charge la grille depuis un fichier
    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 9) {
                String[] values = line.trim().split(" ");
                for (int col = 0; col < 9; col++) {
                    grid[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
            if (row != 9) throw new IOException("Fichier invalide : 9 lignes requises.");
        }
    }

    // Saisie manuelle
    public void loadFromUserInput(Scanner scanner) {
        System.out.println("Entrez les 9 lignes de la grille (valeurs séparées par des espaces) :");
        for (int row = 0; row < 9; row++) {
            String[] values = scanner.nextLine().trim().split(" ");
            for (int col = 0; col < 9; col++) {
                grid[row][col] = Integer.parseInt(values[col]);
            }
        }
    }

    // Affiche la grille avec des caractères de boîte
    public void display() {
        System.out.println("┌─────────┬─────────┬─────────┐");
        for (int row = 0; row < 9; row++) {
            System.out.print("│");
            for (int col = 0; col < 9; col++) {
                String value = (grid[row][col] == 0) ? " " : String.valueOf(grid[row][col]);
                System.out.print(" " + value + " ");
                if ((col + 1) % 3 == 0) System.out.print("│");
            }
            System.out.println();
            if ((row + 1) % 3 == 0 && row != 8) {
                System.out.println("├─────────┼─────────┼─────────┤");
            }
        }
        System.out.println("└─────────┴─────────┴─────────┘");
    }

    // Getters/Setters
    public int getCell(int row, int col) { return grid[row][col]; }
    public void setCell(int row, int col, int value) { grid[row][col] = value; }
}