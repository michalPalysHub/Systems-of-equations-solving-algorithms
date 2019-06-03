
public class Matrix {
    double[][] matrix;
    private int n, m;

    public Matrix(double[][] matrix){
        this.matrix = matrix;
    }

    Matrix(int row, int col){
        this.n = row;
        this.m = col;
        this.matrix = new double[n][];
        for (int i = 0; i < n; i++) matrix[i] = new double[m];
    }

    void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
