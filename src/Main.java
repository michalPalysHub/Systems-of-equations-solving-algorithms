import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ///////////// MATRICES /////////////////

        // matrix A
        Matrix matrix_A = new Matrix(3, 3);

        matrix_A.matrix[0][0] = 10;
        matrix_A.matrix[0][1] = -7;
        matrix_A.matrix[0][2] = 0;

        matrix_A.matrix[1][0] = -3;
        matrix_A.matrix[1][1] = 2;
        matrix_A.matrix[1][2] = 6;

        matrix_A.matrix[2][0] = 5;
        matrix_A.matrix[2][1] = -1;
        matrix_A.matrix[2][2] = 5;


        // matrix B
        Matrix matrix_B = new Matrix(3, 1);
        matrix_B.matrix[0][0] = 6;
        matrix_B.matrix[1][0] = 4;
        matrix_B.matrix[2][0] = 3;


        ///////////// EXAMPLES /////////////////

        System.out.println("\nMatrix A:");
        matrix_A.print();
        System.out.println("\nMatrix B:");
        matrix_B.print();


        System.out.println("\n-------------------------");
        System.out.println("Choose the algorithm to solve the system of equations:");
        System.out.println("\ta) Gaussian Elimination");
        System.out.println("\tb) LU Decomposition");
        System.out.println("\tc) Gauss-Seidel method");

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        switch(a){
            case "a":
                try {
                    SolvingAlgorithms.GaussianElimination(matrix_A, matrix_B);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            case "b":
                try {
                    SolvingAlgorithms.LUdecomposition(matrix_A, matrix_B);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            case "c":
                try {
                    SolvingAlgorithms.GaussSeidel(matrix_A, matrix_B);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + a);
        }
    }
}
