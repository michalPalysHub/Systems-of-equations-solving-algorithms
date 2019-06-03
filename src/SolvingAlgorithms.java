import java.util.Scanner;

public class SolvingAlgorithms {

    private static String exceptionMessage = null;

    private static boolean incorrectInput(Matrix matrix_A, Matrix matrix_B){
        if (matrix_A.matrix.length==0 || matrix_B.matrix.length==0){
            exceptionMessage = "Matrices cannot be empty!";
            return true;
        }
        for (int i = 0; i < matrix_A.matrix.length; i++){
            if (matrix_A.matrix[i].length != matrix_A.matrix.length){
                exceptionMessage = "The matrix A must be square!";
                return true;
            }
        }
        if (matrix_A.matrix.length != matrix_B.matrix.length){
            exceptionMessage = "Sizes for matrices A and B must equal respectively: [n x n], [n x 1]";
            return true;
        }
        for (int i = 0; i < matrix_A.matrix.length; i++){
            if (matrix_A.matrix[i][i] == 0){
                exceptionMessage = "Division by zero! - diagonal elements cannot equal 0.";
                return true;
            }
        }
        return false;
    }


    static void GaussianElimination(Matrix matrix_A, Matrix matrix_B){

        if (incorrectInput(matrix_A, matrix_B)){
            throw new IllegalArgumentException(exceptionMessage);
        }

        int iterations = 0;

        int n = matrix_A.matrix.length;
        double tmp;
        Matrix matrix_X = new Matrix(n, 1);

        for (int i = 0; i < n; i++) matrix_X.matrix[i][0] = 1;

        if (n == 1) matrix_X.matrix[0][0] = matrix_B.matrix[0][0] / matrix_A.matrix[0][0];
        else {
            for (int i = 0; i < n - 1; i++) {

                // Gaussian Elimination
                for (int j = i + 1; j < n; j++) {
                    if (matrix_A.matrix[j][i] != 0) {
                        tmp = matrix_A.matrix[j][i] / matrix_A.matrix[i][i];

                        for (int k = i; k < n; k++) {
                            matrix_A.matrix[j][k] -= tmp * matrix_A.matrix[i][k];
                        }
                        matrix_B.matrix[j][0] -= tmp * matrix_B.matrix[i][0];
                        iterations++;
                    }
                }
            }

            System.out.println("\nMatrix A after Gaussian Elimination:");
            matrix_A.print();

            // Actual solving
            for (int i = n - 1; i >= 0; i--){

                tmp = matrix_B.matrix[i][0];

                for (int j = n - 1; j >= i + 1; j--){
                    tmp -= matrix_A.matrix[i][j] * matrix_X.matrix[j][0];
                    iterations++;
                }

                matrix_X.matrix[i][0] = tmp / matrix_A.matrix[i][i];
            }
        }

        System.out.println("\nMatrix X:");
        matrix_X.print();
        System.out.println("\nIterations needed: " + iterations);
    }


    static void LUdecomposition(Matrix matrix_A, Matrix matrix_B){
        if (incorrectInput(matrix_A, matrix_B)){
            throw new IllegalArgumentException(exceptionMessage);
        }

        int n = matrix_A.matrix.length;
        int iterations = 0;
        Matrix matrix_L = new Matrix(n, n);
        Matrix matrix_U = new Matrix(n, n);
        Matrix matrix_Y = new Matrix(n, 1);
        Matrix matrix_X = new Matrix(n, 1);

        for (int i = 0; i < n; i++) {
            matrix_X.matrix[i][0] = 1;
            matrix_Y.matrix[i][0] = 1;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix_L.matrix[i][j] = 0;
                matrix_U.matrix[i][j] = 0;
            }
        }

        if (n == 1) matrix_X.matrix[0][0] = matrix_B.matrix[0][0] / matrix_A.matrix[0][0];
        else {
            // Doolittle algorithm

            for (int i = 0; i < n; i++){

                // Upper Triangular
                for (int j = 0; j < n; j++){

                    // summation of L(i, k) * U(k, j)
                   double s = 0;
                   for (int k = 0; k < i; k++){
                       s += matrix_L.matrix[i][k] * matrix_U.matrix[k][j];
                   }

                   matrix_U.matrix[i][j] = matrix_A.matrix[i][j] - s;
                   iterations++;
                }

                // Lower Triangular
                for (int j = i; j < n; j++){
                    if (i == j) matrix_L.matrix[i][i] = 1;
                    else {

                        // summation of L(j, k) * U(k, i)
                        double s = 0;

                        for (int k = 0; k < i; k++) {
                            s += matrix_L.matrix[j][k] * matrix_U.matrix[k][i];
                            iterations++;
                        }

                        matrix_L.matrix[j][i] = (matrix_A.matrix[j][i] - s) / matrix_U.matrix[i][i];
                    }
                }

            }
            System.out.println("\nLower matrix:");
            matrix_L.print();
            System.out.println("\nUpper matrix:");
            matrix_U.print();


            // Actual solving
            double tmp;

            // LY = B ==> Y using forward substitution
            for (int i = 0; i < n; i++){

                tmp = matrix_B.matrix[i][0];

                for (int j = 0; j < i; j++){
                    tmp -= matrix_L.matrix[i][j] * matrix_Y.matrix[j][0];
                    iterations++;
                }

                matrix_Y.matrix[i][0] = tmp / matrix_L.matrix[i][i];
            }

            System.out.println("\nL*Y = B ==> Y:");
            matrix_Y.print();


            // UX = Y ==> X using back substitution
            for (int i = n - 1; i >= 0; i--){

                tmp = matrix_Y.matrix[i][0];

                for (int j = n - 1; j >= i + 1; j--){
                    tmp -= matrix_U.matrix[i][j] * matrix_X.matrix[j][0];
                    iterations++;
                }

                matrix_X.matrix[i][0] = tmp / matrix_U.matrix[i][i];
            }

            System.out.println("\nU*X = Y ==> X:");
            matrix_X.print();
            System.out.println("\nIterations needed: " + iterations);
        }
    }

    private static boolean converges(Matrix matrix_A){
        for (int i = 0; i < matrix_A.matrix.length; i++){
            double diagonal = Math.abs(matrix_A.matrix[i][i]);
            double tmpSum = 0;
            for (int j = 0; j < matrix_A.matrix.length; j++){
                if (i != j) tmpSum += Math.abs(matrix_A.matrix[i][j]);
            }
            if (tmpSum >= diagonal) return false;
        }
        return true;
    }

    static void GaussJacobi(Matrix matrix_A, Matrix matrix_B){
        if (incorrectInput(matrix_A, matrix_B)){
            throw new IllegalArgumentException(exceptionMessage);
        }

        if (!converges(matrix_A)){
            System.err.println("The solution could not converge - matrix A is not diagonally dominant");
        }

        int iterations = 0;
        int n = matrix_A.matrix.length;
        Matrix matrix_X = new Matrix(n, 1);
        for (int i = 0; i < n; i++) matrix_X.matrix[i][0] = 0;

        int precision = 1000;

        for (int k = 0; k < precision; k++){
            for (int i = 0; i < n; i++){
                double x0 = 0;
                for (int j = 0; j < n; j++){
                    if (i != j) x0 += matrix_A.matrix[i][j] * matrix_X.matrix[j][0]; iterations++;
                }
                matrix_X.matrix[i][0] = (matrix_B.matrix[i][0] - x0) / matrix_A.matrix[i][i];
            }
        }

        System.out.println("\nMatrix X:");
        matrix_X.print();
        System.out.println("\nPrecision set: " + precision);
        System.out.println("\nIterations needed: " + iterations);
    }
}
