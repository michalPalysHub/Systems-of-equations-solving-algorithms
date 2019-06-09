import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ///////////// MATRICES /////////////////

        // matrix A
        Matrix matrix_A = new Matrix(10, 10);

        /*
        matrix_A.matrix[0][0] = 10;
        matrix_A.matrix[0][1] = 2;
        matrix_A.matrix[0][2] = 0;

        matrix_A.matrix[1][0] = -3;
        matrix_A.matrix[1][1] = 20;
        matrix_A.matrix[1][2] = 6;

        matrix_A.matrix[2][0] = 5;
        matrix_A.matrix[2][1] = -1;
        matrix_A.matrix[2][2] = 7;
        */

        // row 0
        matrix_A.matrix[0][0] = 100;
        matrix_A.matrix[0][1] = 4;
        matrix_A.matrix[0][2] = -6;
        matrix_A.matrix[0][3] = -5;
        matrix_A.matrix[0][4] = 10;
        matrix_A.matrix[0][5] = -11;
        matrix_A.matrix[0][6] = 13;
        matrix_A.matrix[0][7] = 12;
        matrix_A.matrix[0][8] = 12;
        matrix_A.matrix[0][9] = -5;

        // row 1
        matrix_A.matrix[1][0] =  20;
        matrix_A.matrix[1][1] = 120;
        matrix_A.matrix[1][2] = -3;
        matrix_A.matrix[1][3] = 17;
        matrix_A.matrix[1][4] = 19;
        matrix_A.matrix[1][5] = -5;
        matrix_A.matrix[1][6] = 0;
        matrix_A.matrix[1][7] = 6;
        matrix_A.matrix[1][8] = 4;
        matrix_A.matrix[1][9] = -10;

        // row 2
        matrix_A.matrix[2][0] = 10;
        matrix_A.matrix[2][1] = -11;
        matrix_A.matrix[2][2] = 80;
        matrix_A.matrix[2][3] = 2;
        matrix_A.matrix[2][4] = -3;
        matrix_A.matrix[2][5] = -3;
        matrix_A.matrix[2][6] = 4;
        matrix_A.matrix[2][7] = 5;
        matrix_A.matrix[2][8] = -7;
        matrix_A.matrix[2][9] = 12;

        // row 3
        matrix_A.matrix[3][0] = -4;
        matrix_A.matrix[3][1] = 4;
        matrix_A.matrix[3][2] = 5;
        matrix_A.matrix[3][3] = 60;
        matrix_A.matrix[3][4] = 6;
        matrix_A.matrix[3][5] = -7;
        matrix_A.matrix[3][6] = 9;
        matrix_A.matrix[3][7] = 9;
        matrix_A.matrix[3][8] = -2;
        matrix_A.matrix[3][9] = 3;

        // row 4
        matrix_A.matrix[4][0] = 14;
        matrix_A.matrix[4][1] = -2;
        matrix_A.matrix[4][2] = 7;
        matrix_A.matrix[4][3] = -1;
        matrix_A.matrix[4][4] = 130;
        matrix_A.matrix[4][5] = -2;
        matrix_A.matrix[4][6] = 19;
        matrix_A.matrix[4][7] = 17;
        matrix_A.matrix[4][8] = -4;
        matrix_A.matrix[4][9] = 5;

        // row 5
        matrix_A.matrix[5][0] = -1;
        matrix_A.matrix[5][1] = 5;
        matrix_A.matrix[5][2] = 17;
        matrix_A.matrix[5][3] = -2;
        matrix_A.matrix[5][4] = 6;
        matrix_A.matrix[5][5] = 110;
        matrix_A.matrix[5][6] = 7;
        matrix_A.matrix[5][7] = 11;
        matrix_A.matrix[5][8] = 14;
        matrix_A.matrix[5][9] = -2;

        // row 6
        matrix_A.matrix[6][0] = 8;
        matrix_A.matrix[6][1] = -7;
        matrix_A.matrix[6][2] = -10;
        matrix_A.matrix[6][3] = -2;
        matrix_A.matrix[6][4] = 1;
        matrix_A.matrix[6][5] = 3;
        matrix_A.matrix[6][6] = 96;
        matrix_A.matrix[6][7] = -4;
        matrix_A.matrix[6][8] = -10;
        matrix_A.matrix[6][9] = 17;

        // row 7
        matrix_A.matrix[7][0] = -11;
        matrix_A.matrix[7][1] = 9;
        matrix_A.matrix[7][2] = -2;
        matrix_A.matrix[7][3] = 4;
        matrix_A.matrix[7][4] = 4;
        matrix_A.matrix[7][5] = -10;
        matrix_A.matrix[7][6] = 3;
        matrix_A.matrix[7][7] = 117;
        matrix_A.matrix[7][8] = 9;
        matrix_A.matrix[7][9] = 1;

        // row 8
        matrix_A.matrix[8][0] = 7;
        matrix_A.matrix[8][1] = 6;
        matrix_A.matrix[8][2] = -6;
        matrix_A.matrix[8][3] = 5;
        matrix_A.matrix[8][4] = 11;
        matrix_A.matrix[8][5] = -2;
        matrix_A.matrix[8][6] = 4;
        matrix_A.matrix[8][7] = 5;
        matrix_A.matrix[8][8] = 99;
        matrix_A.matrix[8][9] = 7;

        // row 9
        matrix_A.matrix[9][0] = 1;
        matrix_A.matrix[9][1] = 19;
        matrix_A.matrix[9][2] = 2;
        matrix_A.matrix[9][3] = 7;
        matrix_A.matrix[9][4] = -7;
        matrix_A.matrix[9][5] = 6;
        matrix_A.matrix[9][6] = 19;
        matrix_A.matrix[9][7] = 20;
        matrix_A.matrix[9][8] = 1;
        matrix_A.matrix[9][9] = 150;


        // matrix B
        Matrix matrix_B = new Matrix(10, 1);
        /*
        matrix_B.matrix[0][0] = 6;
        matrix_B.matrix[1][0] = 4;
        matrix_B.matrix[2][0] = 3;
        */

        matrix_B.matrix[0][0] = 103;
        matrix_B.matrix[1][0] = -72;
        matrix_B.matrix[2][0] = 200.5;
        matrix_B.matrix[3][0] = 84.5;
        matrix_B.matrix[4][0] = 440.5;
        matrix_B.matrix[5][0] = 159.5;
        matrix_B.matrix[6][0] = 258;
        matrix_B.matrix[7][0] = -175.5;
        matrix_B.matrix[8][0] = 145.5;
        matrix_B.matrix[9][0] = 437;


        ///////////// EXAMPLES /////////////////

        System.out.println("\nMatrix A:");
        matrix_A.print();
        System.out.println("\nMatrix B:");
        matrix_B.print();


        System.out.println("\n-------------------------");
        System.out.println("Choose the algorithm to solve the system of equations:");
        System.out.println("\ta) Gaussian Elimination");
        System.out.println("\tb) LU Decomposition");
        System.out.println("\tc) Gauss-Jacobi's method");

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        switch(a){
            case "a":
                try {
                    double startTime = System.nanoTime();
                    SolvingAlgorithms.GaussianElimination(matrix_A, matrix_B);
                    double endTime = System.nanoTime();
                    System.out.println("\nSolution took " + (endTime-startTime)/1000000.0 + " ms");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            case "b":
                try {
                    long startTime = System.nanoTime();
                    SolvingAlgorithms.LUdecomposition(matrix_A, matrix_B);
                    long endTime = System.nanoTime();
                    System.out.println("\nSolution took " + (endTime-startTime)/1000000.0 + " ms");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            case "c":
                try {
                    long startTime = System.nanoTime();
                    SolvingAlgorithms.GaussJacobi(matrix_A, matrix_B);
                    long endTime = System.nanoTime();
                    System.out.println("\nSolution took " + (endTime-startTime)/1000000.0 + " ms");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + a);
        }
    }
}
