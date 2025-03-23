import java.io.IOException; 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuGrid grid = new SudokuGrid();
        Scanner scanner = new Scanner(System.in);

        try {
            if (args.length > 0) {
                grid.loadFromFile(args[0]);
            } else {
                grid.loadFromUserInput(scanner);
            }
            System.out.println("Grille initiale :");
            grid.display();

            SudokuSolver solver = new SudokuSolver();
            if (solver.solve(grid)) {
                System.out.println("\nGrille résolue :");
                grid.display();
            } else {
                System.out.println("Aucune solution trouvée.");
            }
        } catch (IOException e) {
            System.err.println("Erreur de fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Format de grille invalide.");
        } finally {
            scanner.close();
        }
    }
}